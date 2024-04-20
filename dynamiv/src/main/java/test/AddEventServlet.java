package test;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/addeventServlet")
public class AddEventServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EventBean eb=new EventBean();
		
		eb.setEventname(request.getParameter("eventName"));
		eb.setEventdesc(request.getParameter("evtdiscription"));
		
		int k=new AddEventServletDAO().insert(eb);
		System.out.println(k);
		if(k>0) {
			request.setAttribute("msg","Event added succesfully..<br>");
			request.getRequestDispatcher("addevent.jsp").forward(request, response);
		}
	}
}