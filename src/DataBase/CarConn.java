package DataBase;

import Eneity.Car;
import Eneity.CarCareInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
 
 
public class CarConn {
                Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
                public CarConn()
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

                
   public Vector searchCarCare(String CarNumber){ // 通过用户名寻找密码
	   Vector<CarCareInfo> care =new Vector<CarCareInfo>();
        try {
           String sql="SELECT * FROM login.care where CarNumber='"+CarNumber+"';";
		   conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login?serverTimezone=UTC&&useSSL=false","root","981226");
		   System.out.println("链接成功");
           ps = conn.prepareStatement(sql);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   String CareDate = rs.getString("CareDate");
			   String Worker = rs.getString("Worker");
			   String Tester = rs.getString("Tester");
			   System.out.println("获取成功");
			   care.add(new CarCareInfo(CarNumber,CareDate,Worker,Tester));
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
                        Logger.getLogger(CarConn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  return null;
              }  
              
 
}
