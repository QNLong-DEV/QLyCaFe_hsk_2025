package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.connectiondb;
import controller.DanhSachChiTietDonHang;
import model.ChiTietDonHang;

public class ChiTietDonHangDAO {
	private Connection con = null;

	public boolean saveChiTietDonHang(ChiTietDonHang ct) {
		try {
			con = connectiondb.getConnection();

			String sql = "INSERT INTO ChiTietDonHang (MaDH ,MaNuoc, SoLuong, DonGia, ThanhTien) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, ct.getMaDH());
			pst.setString(2, ct.getMaNuoc());
			pst.setInt(3, ct.getSoLuong());
			pst.setDouble(4, ct.getDonGia());
			pst.setDouble(5, ct.getThanhTien());

			int rows = pst.executeUpdate();
			pst.close();
			System.out.println("\n Thêm dữ liệu chi tiết đơn hàng thành công \n");
			return rows > 0;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public DanhSachChiTietDonHang getChiTietDonHang(String madh) {
		DanhSachChiTietDonHang ds = new DanhSachChiTietDonHang();
		try {
			con = connectiondb.getConnection();

			String sql = "SELECT MaDH, MaNuoc, SoLuong, DonGia, ThanhTien FROM ChiTietDonHang WHERE MaDH = ?";
			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, madh);

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String maDH = rs.getString("MaDH");
				String maNuoc = rs.getString("MaNuoc");
				int soLuong = rs.getInt("SoLuong");
				double donGia = rs.getDouble("DonGia");
				double thanhTien = rs.getDouble("ThanhTien");
				ChiTietDonHang ct = new ChiTietDonHang(maDH, maNuoc, soLuong, donGia, thanhTien);
				ds.add(ct);
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
