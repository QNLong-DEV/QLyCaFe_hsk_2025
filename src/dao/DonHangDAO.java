package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;

import connection.connectiondb;
import controller.DanhSachChiTietDonHang;
import controller.DanhSachDonHang;
import model.DonHang;

public class DonHangDAO {

	private Connection con;

	public boolean saveDonHang(DonHang dh) {
		try {
			con = connectiondb.getConnection();

			String sql = "INSERT INTO DonHang (MaDH, MaKH, MaNV, LoaiKH, NgayDatHang, TongTien) VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, dh.getMaDH());
			pst.setString(2, dh.getMaKH());
			pst.setString(3, dh.getMaNV());
			pst.setString(4, dh.getLoaiKH());
			pst.setTimestamp(5, java.sql.Timestamp.valueOf(dh.getNgayDatHang()));
			;
			pst.setDouble(6, dh.getTongTien());
			int rows = pst.executeUpdate();
			pst.close();
			System.out.println("\n Thêm dữ liệu đơn hàng thành công \n");
			return rows > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public DanhSachDonHang getDonHang(String makh) {
		DanhSachDonHang ds = new DanhSachDonHang();
		try {
			con = connectiondb.getConnection();

			String sql = "SELECT MaDH, MaKH, MaNV, LoaiKH, NgayDatHang, TongTien FROM DonHang WHERE MaKH = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, makh);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String maDH = rs.getString("MaDH");
				String maKH = rs.getString("MaKH");
				String maNV = rs.getString("MaNV");
				String loaiKH = rs.getString("LoaiKH");
				LocalDateTime ngayDatHang = rs.getTimestamp("NgayDatHang").toLocalDateTime();
				double tongTien = rs.getDouble("TongTien");
				ChiTietDonHangDAO ctdao = new ChiTietDonHangDAO();
				DanhSachChiTietDonHang dsct = new DanhSachChiTietDonHang();
				dsct = ctdao.getChiTietDonHang(maDH);
				DonHang dh = new DonHang(maDH, maKH, maNV, loaiKH, ngayDatHang, dsct, dsct.tongTien(loaiKH));
				ds.themDH(dh);
			}
			rs.close();
			pst.close();
			return ds;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectiondb.closeConnection(con);
		}
		return null;
	}
}
