package test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/vieweventServlet")
public class vieweventServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        

		EventBean eb=new EventBean();
        
        try {
            ArrayList<EventBean> events = new EventDAO().getAllEvents();
            request.setAttribute("events", events);
           
            request.getRequestDispatcher("viewevent.jsp").forward(request, response);
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
        }
    }
}
