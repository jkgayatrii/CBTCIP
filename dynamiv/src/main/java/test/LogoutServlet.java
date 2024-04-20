package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		HttpSession hs=req.getSession(false);
		if(hs==null) {
			req.setAttribute("msg","session expored");
			
		}
		else {
			hs.removeAttribute("user");
			hs.removeAttribute("alist");
			hs.invalidate();
			req.setAttribute("msg","logged out succesfull..");
			
			
		}
		req.getRequestDispatcher("msg.jsp").forward(req, res);
		
	}

}
