package com.jiqa.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;

import org.springframework.web.multipart.MultipartFile;

public class UploadUtil {

	private String uploadImagePath = "http://52.66.158.140:8080/usr/local/apache-tomcat/webapps/CategoryImages";
	
    public void processRequest(MultipartFile multipart, String title) throws ServletException, IOException {

        String rootpath = uploadImagePath;
        String filename = "", msg = "";
        try {	
            if (multipart != null) {
                InputStream is = null;
                FileOutputStream fos = null;
//                String header = multipart.getHeader("content-disposition");
//                filename = getFileName(header);
                filename = multipart.getOriginalFilename();
                File fileToUpload = new File(rootpath + File.separator + title + File.separator + filename);
                if (!fileToUpload.getParentFile().exists()) {
                    fileToUpload.getParentFile().mkdirs();
                }

                if (fileToUpload.isFile()) {
                    msg = "file already exists";
                } else {
                    is = multipart.getInputStream();
                    fos = new FileOutputStream(fileToUpload);
                    byte[] buffer = new byte[4096];
                    int count = 0;
                    while ((count = is.read(buffer)) != -1) {
                        fos.write(buffer, 0, count);
                    }
                    fos.flush();
                    fos.close();
                }
            }
        } catch(Exception e) {
        	System.out.println("UploadImage: " + e);
        }
    }

    /*private String getFileName(String header) {
        String[] data = header.split(";");
        return data[2].substring(11, data[2].length() - 1);
    }*/
}

