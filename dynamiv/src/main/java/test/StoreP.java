/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * @author adrianadewunmi
 * Servlet for adding participant username and password to database
 */
@WebServlet("/StoreP")
@SuppressWarnings("serial")
public class StoreP extends HttpServlet {
    
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
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String participantsName = request.getParameter("Pname");
        String userName = request.getParameter("Pusername");
        String userPassword = request.getParameter("Ppassword");
        String confirmUserPassword = request.getParameter("Cpassword");
        String Address = request.getParameter("Adr");
        String mailId=request.getParameter("Mid");
        long phoneNumber = Long.parseLong(request.getParameter("Phno"));
        
        // EventlyDB, name of table plogindetails
        
        String a1 = userName;
        String a2 = userPassword;
        String a3 = confirmUserPassword;
        String a4 = participantsName;
        String a5= Address;
        String a6=mailId;
        long a7=phoneNumber;
        
        if(a1.isBlank() && a2.isBlank() && a3.isBlank() && a4.isBlank()){
            response.setContentType("text/html");  
            out.println("<script type=\"text/javascript\">");  
            out.println("alert('Please Enter Your Details!!!');");  
            out.println("</script>");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("Psignup.html");
            requestDispatcher.include(request, response);
        }else{
            if(a2.equals(a3)){
                try{
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    String conURL = "jdbc:oracle:thin:@localhost:1521:XE";
                    String dbusername = "system";
                    String dbuserpassword = "pace1234";
                    Connection con;
                    con = DriverManager.getConnection(conURL , dbusername, dbuserpassword);
                    Statement statement = con.createStatement();
                    String mysqlQuery = "insert into plogindetails values('"+a4+"','"+a1+"','"+a2+"','"+a5+"','"+a6+"','"+a7+"')";
                    statement.executeUpdate(mysqlQuery);
                    RequestDispatcher requestDispatcher;
                    requestDispatcher = request.getRequestDispatcher("Plogin.html");
                    requestDispatcher.forward(request, response);
                    con.close();
                }catch(ServletException | IOException | ClassNotFoundException | SQLException e){
                    System.out.println(e);
                }
            }else{
                response.setContentType("text/html");  
                out.println("<script type=\"text/javascript\">");  
                out.println("alert('Please Enter Password And Confirm Password As Same!!!');");  
                out.println("</script>");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("Psignup.html");
                requestDispatcher.include(request, response);
            }
            
        }
        
    }

}
