/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.servlets.admin;

import dpu.services.admin.ProfileServicesImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import properties.ReadFromPropertyFile;

/**
 *
 * @author sikka
 */
@MultipartConfig
@WebServlet(name = "UploadProfilePicServlet", urlPatterns = {"/UploadProfilePicServlet"})
public class UploadProfilePicServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String userId = request.getSession().getAttribute("userId").toString();
        String rootPath = ReadFromPropertyFile.filePath + File.separator + userId;
        String fileName = "", msg = "";
        try (PrintWriter out = response.getWriter()) {
            Part flImage = request.getPart("flProfileImage");//getting binary file form request
            if (flImage != null) {
                InputStream is = null;
                FileOutputStream fos = null;
                String header = flImage.getHeader("content-disposition");//fetching the string in whic all info regarding image is present
                fileName = getFileName(header);
                File flToUpload = new File(rootPath + File.separator + fileName); //setting the path of the file which has to be uploaded
                if (!flToUpload.getParentFile().exists())//checking the directory existence
                {
                    flToUpload.getParentFile().mkdirs();// creating required folders that don't exist
                }
                if (flToUpload.isFile()) //checking file existence in that folder
                {
                    msg = "File Alreadt Exists";
                } else {
                    is = flImage.getInputStream(); // getting input stream from part(image)
                    fos = new FileOutputStream(flToUpload);//setting file (in which image will be stored) into file output stream
                    byte[] buffer = new byte[4096];// 4 kb/sec
                    int count = 0;
                    while ((count = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, count);
                    }
                    fos.flush();
                    fos.close();
                    msg = new ProfileServicesImpl().updateProfileImage(fileName, userId);
                }
            }
            response.sendRedirect("Admin/ManageProfile.jsp?msg="+msg);
        } catch (Exception e) {
            System.out.println(e.toString());
            msg = e.toString();
        } finally {
        }
    }

    private String getFileName(String header) {
        System.out.println("Heder"+header);
        String[] data = header.split(";");
        return data[2].substring(11, data[2].length() - 1);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
