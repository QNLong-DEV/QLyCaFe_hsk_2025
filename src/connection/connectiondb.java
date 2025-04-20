package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectiondb {
	
	public static Connection getConnection() {
		Connection c = null;
		try {
			// Tải driver JDBC
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String url = "jdbc:sqlserver://LAPTOP-Q3GN8B9U:1433;databaseName=qlyCaFe;encrypt=true;trustServerCertificate=true;";
			String userName = "sa";
			String passWord = "sapassword";
			
			c = DriverManager.getConnection(url,userName,passWord);
			System.out.println("kết nối thành công");
		} catch (Exception e) {
			System.out.println("Không kết nối db");
		}
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}	
