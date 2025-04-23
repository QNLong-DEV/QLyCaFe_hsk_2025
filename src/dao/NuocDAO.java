package dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import connection.connectiondb;
import controller.DanhSachNuoc;
import model.Nuoc;

public class NuocDAO {
	private Connection con;
	private java.sql.Statement st;

	public DanhSachNuoc layDanhSachNuoc() {
		DanhSachNuoc ds = new DanhSachNuoc();
		try {
			con = connectiondb.getConnection();
			st = con.createStatement();
			String sql = "SELECT * FROM Nuoc";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String manuoc = rs.getString("MaNuoc");
				String tennuoc = rs.getString("TenNuoc");
				double gia = rs.getDouble("Gia");
				String loai = rs.getString("Loai");
				String img = rs.getString("Img");
				ds.addList(new Nuoc(manuoc, tennuoc, gia, loai, img));
			}
			rs.close();
			st.close();
			System.out.println("\n Lấy dữ liệu danh sách nước thành công \n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectiondb.closeConnection(con);
		}
		return ds;
	}
}
