package test;

import java.io.IOException;

import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/userlistServlet")
public class UserListServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException{
		
    UserBean eb=new UserBean();
        
        try {
        	ArrayList<UserBean> users=new ViewUserBeanDAO().getAllusers();
            req.setAttribute("user",users);
           
            req.getRequestDispatcher("viewUsers.jsp").forward(req, res);
        } 
        catch (Exception e) {
            // Handle database error
            e.printStackTrace();
        }
    }
}