package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import connection.connectiondb;
import model.DonHang;

public class DonHangDAO {

	private Connection con;

	public boolean saveDonHang(DonHang dh) {
		try {
			con = connectiondb.getConnection();

			String sql = "INSERT INTO DonHang (MaDH, MaKH, MaNV, LoaiKH, NgayDatHang, TongTien) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pst = con.prepareStatement(sql);
			
			pst.setString(1, dh.getMaDH());
			pst.setString(2, dh.getMaKH());
			pst.setString(3, dh.getMaNV());
			pst.setString(4, dh.getLoaiKH());
			pst.setTimestamp(5, java.sql.Timestamp.valueOf(dh.getNgayDatHang()));;
			pst.setDouble(6, dh.getTongTien());
			int rows = pst.executeUpdate(); 
			pst.close(); 
			System.out.println("\n Thêm dữ liệu đơn hàng thành công \n");
			return rows > 0;
		} catch (Exception e) {
			return false;
		}
	}
}
