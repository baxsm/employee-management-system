package baxsm;
import java.sql.*;
import javax.swing.*;

public class DatabaseConnection {
	
		public static Connection dbconn() {
			
			try{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ems","root","");
				return conn;
			}
			catch(Exception e1) {
				JOptionPane.showMessageDialog(null, e1);
				System.exit(1);
				return null;
			}
		}
		
}