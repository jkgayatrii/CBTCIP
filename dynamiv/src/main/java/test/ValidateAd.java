/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

/**
 * @author adrianadewunmi
 * Admin Login Validation Servlet
 * for administrator login
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@SuppressWarnings("serial")
@WebServlet("/ValidateAd")

public class ValidateAd extends HttpServlet {
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    		String uN=request.getParameter("admUname");
    		String pW=request.getParameter("AdmPws");
    		AdminBean ab=new AdminLoginDAO().login(uN,pW);
    		if(ab==null) {
    			/*response.setContentType("text/html");  
                printWriterOut.println("<script type=\"text/javascript\">");  
                printWriterOut.println("alert('Please Enter Valid Username & Password for Admin!!!');");  
                printWriterOut.println("</script>");
    			response.setContentType("text/html"); */
    			request.getRequestDispatcher("Alogin.html").include(request, response);    			
    		}
           else{
               
               request.getRequestDispatcher("AdminEvent.html").forward(request, response);;
                
            }
        }
    

}
