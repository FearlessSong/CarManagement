package DataBase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import Eneity.CarCareInfo;
import Eneity.Material;
 
 
public class MaterialConn {
                Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
                public MaterialConn()
          {
              System.out.println("OK");
                Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
	            // The newInstance() call is a work around for some
	            // broken Java implementations

	         Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("驱动加载成功");
	        } catch (Exception ex) {
	        	System.out.println("驱动加载失败");
	            // handle the error
	        }
		
		
	}

                //保养时间
   public Vector searchCare(String CarNumber){ 
	   Vector<Material> care =new Vector<Material>();
        try {
           String sql="SELECT * FROM login.material WHERE CarNumber='"+CarNumber+"';";
		   conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login?serverTimezone=UTC&&useSSL=false","root","981226");
		   System.out.println("链接成功");
           ps = conn.prepareStatement(sql);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   String CareNumber = rs.getString("CarNumber");
			   String Date = rs.getString("Date");
			   String Worker = rs.getString("Worker");
			   String Tester = rs.getString("Tester");
			   String Fee = rs.getString("Fee");
			   String Record = rs.getString("Record");
			   System.out.println("获取成功");
			   care.add(new Material(CareNumber, Date, Worker, Tester, Fee, Record));
           }
		   return care;
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("链接失败");
		}
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MaterialConn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  return null;
              }  
              
//小修时间
   public Vector searchDate(String CareDate){ 
	   Vector<Material> care =new Vector<Material>();
        try {
           String sql="SELECT * FROM login.material where Date='"+CareDate+" 00:00:00';";
		   conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login?serverTimezone=UTC&&useSSL=false","root","981226");
		   System.out.println("链接成功");
           ps = conn.prepareStatement(sql);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   String CarNumber = rs.getString("CarNumber");
			   String Date = rs.getString("Date");
			   String Worker = rs.getString("Worker");
			   String Tester = rs.getString("Tester");
			   String Fee = rs.getString("Fee");
			   String Record = rs.getString("Record");
			   System.out.println("获取成功");
			   care.add(new Material(CarNumber, Date, Worker, Tester, Fee, Record));
           }
		   return care;
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("链接失败");
		}
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DateConn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  return null;
              }  
}
