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
import Eneity.Fix;
 
 
public class DateConn {
                Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
                public DateConn()
          {
              System.out.println("OK");
                Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		 try {
	            // The newInstance() call is a work around for some
	            // broken Java implementations

	         Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("�������سɹ�");
	        } catch (Exception ex) {
	        	System.out.println("��������ʧ��");
	            // handle the error
	        }
		
		
	}

                //����ʱ��
   public Vector searchCare(String CareDate){ 
	   Vector<CarCareInfo> care =new Vector<CarCareInfo>();
        try {
           String sql="SELECT * FROM login.care where CareDate='"+CareDate+" 00:00:00';";
		   conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login?serverTimezone=UTC&&useSSL=false","root","981226");
		   System.out.println("���ӳɹ�");
           ps = conn.prepareStatement(sql);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   String CarNumber = rs.getString("CarNumber");
			   System.out.println(CareDate);
			   String Worker = rs.getString("Worker");
			   String Tester = rs.getString("Tester");
			   System.out.println("��ȡ�ɹ�");
			   care.add(new CarCareInfo(CarNumber,CareDate,Worker,Tester));
           }
		   return care;
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("����ʧ��");
		}
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DateConn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  return null;
              }  
              
//С��ʱ��
   public Vector searchFix(String FixDate){ // ͨ���û���Ѱ������
	   Vector<Fix> care =new Vector<Fix>();
        try {
        	String sql="SELECT * FROM login.fix where FixDate='"+FixDate+" 00:00:00';";
		   conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login?serverTimezone=UTC&&useSSL=false","root","981226");
		   System.out.println("���ӳɹ�");
           ps = conn.prepareStatement(sql);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   String CarNumber = rs.getString("CarNumber");
			   String Worker = rs.getString("Worker");
			   String Tester = rs.getString("Tester");
			   System.out.println("��ȡ�ɹ�");
			   care.add(new Fix(CarNumber,FixDate,Worker,Tester));
                   }
		   return care;
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		    System.out.println("����ʧ��");
		}
                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(FixConn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  return null;
              }  
              
   public static void main(String argc[]){
       DateConn conn= new DateConn();
       conn.searchFix("2018-02-17");
       System.out.println("添加成功");
     
  }
}
