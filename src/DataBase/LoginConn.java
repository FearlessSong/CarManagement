package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
 
public class LoginConn {
                Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
                public LoginConn()
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

                
                
              public String searchpassword(String sql){ // ͨ���û���Ѱ������
                  try {
                    
		    conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/login?serverTimezone=UTC&&useSSL=false","root","981226");
		   System.out.println("���ӳɹ�");
                    ps = conn.prepareStatement(sql);
		   rs = ps.executeQuery();
		   while(rs.next()) {
			   String name = rs.getString("password");
			   return name;
                   }
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
                        Logger.getLogger(LoginConn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  return null;
              }  
          
       
}
