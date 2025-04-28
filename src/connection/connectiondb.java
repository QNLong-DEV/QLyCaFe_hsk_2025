package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class connectiondb {

	public static Connection getConnection() {
		Connection c = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			String url = "jdbc:sqlserver://localhost:1433;databaseName=qlyCaFe;encrypt=true;trustServerCertificate=true;";
			String userName = "sa";
			String passWord = "sapassword";

			c = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Kết nối database thành công.");
		} catch (Exception e) {
			System.out.println("Không thể kết nối database!");
			e.printStackTrace(); 
		}
		return c;
	}

	public static void closeConnection(Connection c) {
		try {
			if (c != null && !c.isClosed()) {
				c.close();
				System.out.println("Đã đóng kết nối database.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
