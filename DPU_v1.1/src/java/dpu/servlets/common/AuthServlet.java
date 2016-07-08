/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dpu.servlets.common;

import dpu.beans.common.LoginBean;
import dpu.services.common.CommonServicesImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sikka
 */
@WebServlet(name = "AuthServlet", urlPatterns = {"/AuthServlet"})
public class AuthServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (request.getParameter("sbtnLogin") != null) {
            String username = request.getParameter("txtUsername");  
            String password = request.getParameter("txtPassword");
            CommonServicesImpl objServices = new CommonServicesImpl();
            LoginBean obj = objServices.authUser(username, password);
            if (obj != null) {
                if (obj.getUserStatus().equalsIgnoreCase("InActive")) {
                    response.sendRedirect("index.jsp?msg= Sorry, You are an inactive user");
                } else {
                    request.getRemoteAddr();
                    request.getSession().setAttribute("username", username);
                    request.getSession().setAttribute("userType", obj.getUserType());
                    request.getSession().setAttribute("userId", obj.getUserId() + "");
                    String type = obj.getUserType();
                    type = type.toLowerCase();
                    switch (type) {
                        case "admin":
                        case "employee":
                            response.sendRedirect("Admin/Homepage.jsp");
                            break;
                        case "dealer":
                            response.sendRedirect("Dealers/Homepage.jsp");
                            break;
                    }
                }
            } else {
                response.sendRedirect("index.jsp?msg=Invalid Username/Password");
            }
        }

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
