package test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ViewUserBeanDAO {
	

    public ArrayList<UserBean> getAllusers()  {
    	 ArrayList<UserBean> al = new ArrayList<>();
        try{
			Connection con=DBConnection.getCon();  
			PreparedStatement ps=con.prepareStatement("select * from  PLOGINDETAILS");
			ResultSet rs=ps.executeQuery();
            while(rs.next()) {
            	UserBean ub=new UserBean();
                ub.setName(rs.getString(1));
                ub.setUname(rs.getString(2));
                ub.setAddr(rs.getString(4));
                ub.setMailId(rs.getString(5));
                ub.setPhno(rs.getLong(6));
                al.add(ub);
            }
            }
        catch(Exception e){
        	e.printStackTrace();
        	
        }
        
        return al;
    }
}
