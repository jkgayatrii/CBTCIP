package test;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/viewvenueServlet")
public class ViewVenueServlet extends HttpServlet {
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        

		VenueBean vb=new VenueBean();

        
        try {
            ArrayList<VenueBean> venues = new ViewVenueDAO().getAllVenues();
            request.setAttribute("venues", venues);
           
            request.getRequestDispatcher("viewvenue.jsp").forward(request, response);
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
        }
    }
}
