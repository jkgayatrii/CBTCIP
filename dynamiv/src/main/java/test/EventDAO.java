package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EventDAO {
    public ArrayList<EventBean> getAllEvents() throws SQLException {
        ArrayList<EventBean> events = new ArrayList<>();
        try{
			Connection con=DBConnection.getCon();  
			PreparedStatement ps=con.prepareStatement("select * from addevent");
			ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()) {
                EventBean event = new EventBean();
                event.setEventname(resultSet.getString(1));
                event.setEventdesc(resultSet.getString(2));
                events.add(event);
            }}
        catch(Exception e){
        	e.printStackTrace();
        	
        }
        
        return events;
    }
}
