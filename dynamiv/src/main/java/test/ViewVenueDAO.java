package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewVenueDAO {
    public ArrayList<VenueBean> getAllVenues() throws SQLException {
    	ArrayList<VenueBean> venues= new ArrayList<>();
        try{
			Connection con=DBConnection.getCon();  
			PreparedStatement ps=con.prepareStatement("select * from addvenue");
			ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()) {
            	VenueBean venue=new VenueBean();
                venue.setVenuename(resultSet.getString(1));
                venue.setCost(resultSet.getLong(2));
                venue.setLocation(resultSet.getString(3));
                venue.setCapacity(resultSet.getLong(4));
                venue.setContact(resultSet.getLong(5));
                venues.add(venue);
            }}
        catch(Exception e){
        	e.printStackTrace();
        	
        }
        
        return venues;
    }
}
