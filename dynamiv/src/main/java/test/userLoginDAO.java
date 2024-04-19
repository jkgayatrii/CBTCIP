package test;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class userLoginDAO  {
	public UserBean ub=null;
	public UserBean login(String uname,String password) {
		
			try {
				Connection con=DBConnection.getCon();
				PreparedStatement ps=con.prepareStatement("select * from plogindetails where uname=? and password=?");
				ps.setString(1, uname);
				ps.setString(2, password);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					ub=new UserBean();
					ub.setName(rs.getString(1));
					ub.setUname(rs.getString(2));
					ub.setPw(rs.getString(3));
					ub.setAddr(rs.getString(4));
					ub.setMailId(rs.getString(5));
					ub.setPhno(rs.getLong(6));		
					
				}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			return ub;
		
	}
}
