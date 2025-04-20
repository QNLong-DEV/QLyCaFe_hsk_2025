package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.connectiondb;
import controller.DanhSachNhanVien;
import model.NhanVien;

public class NhanVienDAO {

	private Connection con;

	public DanhSachNhanVien layDanhSachNhanVien() {
		DanhSachNhanVien ds = new DanhSachNhanVien();
		try {
			con = connectiondb.getConnection();
			Statement stmt = con.createStatement();
			String sql = "SELECT * FROM NhanVien";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String maNV = rs.getString("MaNV");
				String tenNV = rs.getString("TenNV");
				String sdt = rs.getString("Sdt");
				String ngaySinh = rs.getString("Ngaysinh");
				String email = rs.getString("Email");
				String matKhau = rs.getString("matkhau");

				System.out.println(
						maNV + " | " + tenNV + " | " + sdt + " | " + ngaySinh + " | " + email + " | " + matKhau);
			}

			rs.close();
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectiondb.closeConnection(con);
		}
		return ds;
	}

	public NhanVien getNhanVienByEmailVaMatKhau(String sdt, String matKhau) {
		NhanVien nv = null;
		try (Connection c = connectiondb.getConnection()) {
			String sql = "SELECT * FROM NhanVien WHERE Sdt = ? AND matKhau = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, sdt);
			pst.setString(2, matKhau);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				nv = new NhanVien(rs.getString("MaNV"), rs.getString("TenNV"), rs.getString("Sdt"),
						rs.getDate("Ngaysinh").toLocalDate(), rs.getString("Email"), rs.getString("matkhau"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}
}
