package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.connectiondb;
import model.BaoCao;

public class BaoCaoDAO {

	private Connection con;

	public List<BaoCao> layDoanhThuTheoNgay() {
		List<BaoCao> list = new ArrayList<>();
		try {
			con = connectiondb.getConnection();
			String sql = "select Ngay, sum(TongDoanhThu) as DoanhThu, sum(TongSoDon) as TongSoDon from BaoCao group by Ngay order by Ngay";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String ngay = rs.getString("Ngay");
				double doanhThu = rs.getDouble("DoanhThu");
				int tongSoDon = rs.getInt("TongSoDon");

				list.add(new BaoCao(ngay, doanhThu, tongSoDon));
			}
			System.out.println("Lấy dữ liệu doanh thu theo ngày từ view BaoCao thành công");
			rs.close();
			pst.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connectiondb.closeConnection(con);
		}
		return list;
	}


	public List<BaoCao> layDoanhThuTheoThang() {
		List<BaoCao> list = new ArrayList<>();
		try {
			con = connectiondb.getConnection();
			String sql = "select Nam, Thang, sum(TongDoanhThu) as DoanhThu, sum(TongSoDon) as TongSoDon " + "from BaoCao group by Nam, Thang order by Nam, Thang";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				String thang = String.format("%02d/%d", rs.getInt("Thang"), rs.getInt("Nam"));
				double doanhThu = rs.getDouble("DoanhThu");
				int tongSoDon = rs.getInt("TongSoDon");
				list.add(new BaoCao(thang, doanhThu, tongSoDon));
			}
			
			System.out.println("Lấy dữ liệu doanh thu theo tháng từ view BaoCao thành công");
			rs.close();
			pst.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connectiondb.closeConnection(con);
		}
		return list;
	}


	public List<BaoCao> layDoanhThuTheoNam() {
		List<BaoCao> list = new ArrayList<>();
		try {
			con = connectiondb.getConnection();
			String sql = "select Nam, sum(TongDoanhThu) as DoanhThu, sum(TongSoDon) as TongSoDon " + "from BaoCao group by Nam order by Nam";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while(rs.next()) {
				String nam = rs.getString("Nam");
				double doanhThu = rs.getDouble("DoanhThu");
				int tongSoDon = rs.getInt("TongSoDon");
				list.add(new BaoCao(nam, doanhThu, tongSoDon));
			}
			
			System.out.println("Lấy dữ liệu doanh thu theo năm từ view BaoCao thành công");
			rs.close();
			pst.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			connectiondb.closeConnection(con);
		}
		return list;
	}
}
