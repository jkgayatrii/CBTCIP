package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class AddEventServletDAO{
	public int k=0;
	public int insert(EventBean eb) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into ADDEVENT values(?,?)");
			ps.setString(1,eb.getEventname());
			ps.setString(2, eb.getEventname());
		 k=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
