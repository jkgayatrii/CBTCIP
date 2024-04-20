package test;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/addvenueServlet")
@SuppressWarnings("serial")
public class AddVenueServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
		VenueBean vb=new VenueBean();
		vb.setVenuename(req.getParameter("venuename"));
		vb.setCost(Long.parseLong(req.getParameter("venuecost")));
		vb.setLocation(req.getParameter("loc"));
		vb.setCapacity(Long.parseLong(req.getParameter("capacity")));
		vb.setContact(Long.parseLong(req.getParameter("contact")));
		int k=new AddvenueDAO().insert(vb);
		if(k>0) {
			req.setAttribute("msg", "Successfully added venues..");
			req.getRequestDispatcher("addvenue.jsp").forward(req, res);
		}
		
		
	}
	
	
}
