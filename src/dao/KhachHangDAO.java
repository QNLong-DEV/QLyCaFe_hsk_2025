package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.github.weisj.jsvg.geometry.mesh.CoonPatch;

import connection.connectiondb;
import controller.DanhSachKhachHang;
import model.ChiTietDonHang;
import model.KhachHang;

public class KhachHangDAO {
	private Connection con;

	public DanhSachKhachHang getALLKhachHang() {
		DanhSachKhachHang ds = new DanhSachKhachHang();

		try {
			con = connectiondb.getConnection();

			Statement st = con.createStatement();
			String sql = "SELECT * FROM KhachHang";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				KhachHang kh = new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("Sdt"),
						rs.getString("LoaiKH"), rs.getDate("NgayDangKy").toLocalDate().atStartOfDay());
				ds.addList(kh);
			}
			rs.close();
			st.close();
			System.out.println("Lấy danh sách khách hàng thành công");
			return ds;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			connectiondb.closeConnection(con);
		}
		return null;
	}

	public boolean saveKH(KhachHang kh) {
		try {
			con = connectiondb.getConnection();

			String sql = "INSERT INTO KhachHang (MaKH ,TenKH, Sdt, LoaiKH, NgayDangKy) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, kh.getMaKH());
			pst.setString(2, kh.getTenKH());
			pst.setString(3, kh.getSdt());
			pst.setString(4, kh.getLoaiKH());
			pst.setTimestamp(5, java.sql.Timestamp.valueOf(kh.getNgayDangKy()));

			int rows = pst.executeUpdate();
			pst.close();
			System.out.println("\n Thêm dữ liệu khách hàng thành công \n");
			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			connectiondb.closeConnection(con);
		}
	}

	public int countKH() {
		try {
			con = connectiondb.getConnection();
			String sql = "SELECT COUNT(*) AS TongSoKhachHang FROM KhachHang";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			int result = 0;
			if (rs.next()) { // Di chuyển con trỏ đến dòng đầu tiên
				result = rs.getInt("TongSoKhachHang");
			}

			System.out.println("\n Đếm khách hàng thành công \n");
			rs.close();
			st.close();
			return result;

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		} finally {
			connectiondb.closeConnection(con);
		}
	}

	public KhachHang timTheoMaKH(String maKH) {

		try {
			con = connectiondb.getConnection();
			String sql = "SELECT * FROM KhachHang WHERE MaKH = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, maKH);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				KhachHang kh = new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("Sdt"),
						rs.getString("LoaiKH"), rs.getDate("NgayDangKy").toLocalDate().atStartOfDay());
				return kh;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectiondb.closeConnection(con);
		}

		return null;
	}

	public KhachHang timTheoSDT(String sdt) {

		try {
			con = connectiondb.getConnection();
			String sql = "SELECT * FROM KhachHang WHERE Sdt = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, sdt);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				KhachHang kh = new KhachHang(rs.getString("MaKH"), rs.getString("TenKH"), rs.getString("Sdt"),
						rs.getString("LoaiKH"), rs.getDate("NgayDangKy").toLocalDate().atStartOfDay());
				return kh;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connectiondb.closeConnection(con);
		}

		return null;
	}
	
}
