package DataBase;

import Eneity.Car;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
 
public class CarInforConn {
                Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
                public CarInforConn()
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

                
   public Car searchCar(String CarNumber){ // 通过用户名寻找密码
        try {
           String sql="SELECT * FROM login.car where ﻿CarNumber='"+CarNumber+"';";
		   conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login?serverTimezone=UTC&&useSSL=false","root","981226");
		   System.out.println("链接成功");
           ps = conn.prepareStatement(sql);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   String Company = rs.getString("Company");
			   String Route = rs.getString("Route");
			   int i=Integer.parseInt(Route);
			   String Type = rs.getString("Type");
			   String Engine = rs.getString("Engine");
			   String Box = rs.getString("Box");
			   String Brige = rs.getString("Brige");
			   System.out.println("获取成功");
			   return new Car(Company,i,Type,Engine,Box,Brige);
                   }
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
                        Logger.getLogger(CarInforConn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  return null;
              }  
              
              
              public String regist(String sql){
                  try {
                    
		    conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login?serverTimezone=UTC&&useSSL=false","root","981226");
		   System.out.println("链接成功");
                    ps = conn.prepareStatement(sql);
		   ps.executeUpdate();
		                    System.out.println("连接失败");
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("连接失败");
		}
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(CarInforConn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  return null;
              }

    /**
     *
     * @param args
     * @throws SQLException
     */
       
}
