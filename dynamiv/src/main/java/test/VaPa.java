package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userlogin")
@SuppressWarnings("serial")
public class VaPa extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    	HttpSession hs=req.getSession();
    	String username=req.getParameter("CustUser");
    	String pword=req.getParameter("custPW");
    	ArrayList<UserBean> al=new ViewUserBeanDAO().getAllusers();
        hs.setAttribute("alist", al);
    	boolean isAuthenticated = false;
    	Iterator<UserBean> iterator = al.iterator();
        while (iterator.hasNext()) {
            UserBean user = iterator.next();
            if(user.getUname().equalsIgnoreCase(username)) {
            	isAuthenticated=true;
            hs.setAttribute("user", user);
            }
            
            }
        

        if (isAuthenticated) {
            req.getRequestDispatcher("ParticipantEvent.jsp").forward(req, res);
        } else {
        	req.setAttribute("msg", "incorrect credentials...<br>");
        }
            req.getRequestDispatcher("msg.jsp").forward(req, res);

      
    		
    	
       
    }
    }