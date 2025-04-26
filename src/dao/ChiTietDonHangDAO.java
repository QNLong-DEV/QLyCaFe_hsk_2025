package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.connectiondb;
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
}
