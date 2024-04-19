package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CustBeanDAO {
	public int k=0;
	public int show(CustBean b,String username) {
		
			try {
				Connection con=DBConnection.getCon();
				PreparedStatement ps=con.prepareStatement("insert into CUSTEVTADD values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, username);
				ps.setString(2,b.getType());
				ps.setString(3, b.getLoc());
				ps.setLong(4,b.getCost());
				ps.setLong(5, b.getGuests());
				ps.setString(6,String.join(",", b.getEquip()));
				ps.setString(7, String.join(",", b.getFood()));
				ps.setString(8, b.getVeg());
				ps.setString(9, b.getLunch());
				ps.setString(10, b.getDinner());
				ps.setString(11, b.getLights());
				ps.setString(12, b.getFlowers());
				ps.setString(13, b.getSeats());
				ps.setString(14,  b.getEvtdate());
				 k=ps.executeUpdate();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	
			
	return k;
	}
}
