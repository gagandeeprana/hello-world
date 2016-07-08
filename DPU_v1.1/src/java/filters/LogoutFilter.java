/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SONY
 */
@WebFilter(filterName = "LogoutFilter", urlPatterns = {"/Admin/*", "/Dealers/*"})
public class LogoutFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse res=(HttpServletResponse)response;
        // set the properties of the browser so that it will not save the history of any web page
        res.setHeader("Cache-Control", "no-cache");
        res.setHeader("Cache-Control", "no-store");
        res.setHeader("Pragma", "no-cache");
        res.setDateHeader("Expires", 0);
        // We will check whether user is logged in or not.....HttpSession
        if(req.getSession().getAttribute("userId")!=null){
            chain.doFilter(request, response);
        }else{
            res.sendRedirect("../index.jsp");
        }
    }

    @Override
    public void destroy() {
        
    }

}
