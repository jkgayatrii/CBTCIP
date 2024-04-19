package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/payServlet")
public class payServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		String accNo=req.getParameter("card_number");
		String name=req.getParameter("card_holder_name");
		String date=req.getParameter("expiry_date");
		String cvv=req.getParameter("cvv");
		req.setAttribute("msg","Your Payment is being Processing..You will notifed to your number after Succesfull Payment");
		req.getRequestDispatcher("process.jsp").forward(req, res);
	}

}
