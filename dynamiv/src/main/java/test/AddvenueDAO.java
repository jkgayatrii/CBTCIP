package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddvenueDAO {
	public int k=0;
	public int insert(VenueBean vb) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into addvenue values(?,?,?,?,?)");
			
			
				ps.setString(1, vb.getVenuename());
				ps.setLong(2, vb.getCost());
				ps.setString(3,vb.getLocation());
				ps.setLong(4,vb.getCapacity());
				ps.setLong(5, vb.getContact());
				k=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}return k;

	}
}
