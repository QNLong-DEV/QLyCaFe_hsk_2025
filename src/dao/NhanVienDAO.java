package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
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
				LocalDate ngaySinh = rs.getDate("Ngaysinh").toLocalDate();
				String email = rs.getString("Email");
				String matKhau = rs.getString("matkhau");
				ds.addList(new NhanVien(maNV, tenNV, sdt, ngaySinh, email, matKhau));
			}
			System.out.println("Lấy danh sách nhân viên thành công\n");
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
			rs.close();
			pst.close();
			System.out.println("\n Đăng nhập thành công \n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}

	public NhanVien getNhanVienByMaNV(String MaNV) {
		NhanVien nv = null;
		try (Connection c = connectiondb.getConnection()) {
			String sql = "SELECT * FROM NhanVien WHERE MaNV = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, MaNV);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				nv = new NhanVien(rs.getString("MaNV"), rs.getString("TenNV"), rs.getString("Sdt"),
						rs.getDate("Ngaysinh").toLocalDate(), rs.getString("Email"), rs.getString("matkhau"));
			}
			rs.close();
			pst.close();
			System.out.println("\n Lấy dữ liệu nhân viên thành công \n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nv;
	}

	public boolean themNhanVienVaodb(NhanVien nv) {
		try (Connection c = connectiondb.getConnection()) {
			String sql = "INSERT INTO NhanVien (MaNV, TenNV, Sdt, Ngaysinh, Email, matKhau) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, nv.getMaNV());
			pst.setString(2, nv.getTenNV());
			pst.setString(3, nv.getSdt());
			pst.setDate(4, java.sql.Date.valueOf(nv.getNgaysinh()));
			pst.setString(5, nv.getEmail());
			pst.setString(6, nv.getMatkhau());
			int rows = pst.executeUpdate();
			pst.close();
			System.out.println("\n Thêm dữ liệu nhân viên thành công \n");
			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean xoaNhanVienKhoidb(String ma) {
		try (Connection c = connectiondb.getConnection()) {
			String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, ma);
			System.out.println("\n Xóa dữ liệu nhân viên thành công \n");
			return pst.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
