package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.connectiondb;
import controller.DanhSachDonHang;
import model.BaoCao;
import model.BaoCaoBestSeller;

public class BaoCaoDAO {

	private Connection con = null;

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
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectiondb.closeConnection(con);
		}
		return null;
	}

	public List<BaoCao> layDoanhThuTheoThang() {
		List<BaoCao> list = new ArrayList<>();
		try {
			con = connectiondb.getConnection();
			String sql = "select Nam, Thang, sum(TongDoanhThu) as DoanhThu, sum(TongSoDon) as TongSoDon "
					+ "from BaoCao group by Nam, Thang order by Nam, Thang";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String thang = String.format("%02d/%d", rs.getInt("Thang"), rs.getInt("Nam"));
				double doanhThu = rs.getDouble("DoanhThu");
				int tongSoDon = rs.getInt("TongSoDon");
				list.add(new BaoCao(thang, doanhThu, tongSoDon));
			}

			System.out.println("Lấy dữ liệu doanh thu theo tháng từ view BaoCao thành công");
			rs.close();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectiondb.closeConnection(con);
		}
		return list;
	}

	public List<BaoCao> layDoanhThuTheoNam() {
		List<BaoCao> list = new ArrayList<>();
		try {
			con = connectiondb.getConnection();
			String sql = "select Nam, sum(TongDoanhThu) as DoanhThu, sum(TongSoDon) as TongSoDon "
					+ "from BaoCao group by Nam order by Nam";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String nam = rs.getString("Nam");
				double doanhThu = rs.getDouble("DoanhThu");
				int tongSoDon = rs.getInt("TongSoDon");
				list.add(new BaoCao(nam, doanhThu, tongSoDon));
			}

			System.out.println("Lấy dữ liệu doanh thu theo năm từ view BaoCao thành công");
			rs.close();
			pst.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectiondb.closeConnection(con);
		}
		return list;
	}

	public BaoCaoBestSeller getBestseller(String itemselected) {
		BaoCaoBestSeller bc;
		String query = "SELECT TOP 1 " + "Nuoc.MaNuoc, " + "Nuoc.TenNuoc, " + "Nuoc.Gia, " + "Nuoc.Loai, "
				+ "SUM(ChiTietDonHang.SoLuong) AS TongSoLuongDat, " + "MONTH(DonHang.NgayDatHang) AS Thang, "
				+ "YEAR(DonHang.NgayDatHang) AS Nam " + "FROM ChiTietDonHang "
				+ "JOIN Nuoc ON ChiTietDonHang.MaNuoc = Nuoc.MaNuoc "
				+ "JOIN DonHang ON ChiTietDonHang.MaDH = DonHang.MaDH " + "WHERE Nuoc.Loai = ? "
				+ "AND MONTH(DonHang.NgayDatHang) = MONTH(GETDATE()) "
				+ "AND YEAR(DonHang.NgayDatHang) = YEAR(GETDATE()) "
				+ "GROUP BY Nuoc.MaNuoc, Nuoc.TenNuoc, Nuoc.Gia, Nuoc.Loai, MONTH(DonHang.NgayDatHang), YEAR(DonHang.NgayDatHang) "
				+ "ORDER BY Nuoc.Loai ASC, TongSoLuongDat DESC";
		try {
			con = connectiondb.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, itemselected);
			ResultSet rs = pst.executeQuery();

			String maNuoc = null;
			String tenNuoc = null;
			double gia = 0;
			String loai = null;
			int tongSoLuongDat = 0;
			int Thang = 0;
			int Nam = 0;
			if (rs.next()) {
				maNuoc = rs.getString("MaNuoc");
				tenNuoc = rs.getString("tenNuoc");
				gia = rs.getDouble("Gia");
				loai = rs.getString("Loai");
				tongSoLuongDat = rs.getInt("TongSoLuongDat");
				Thang = rs.getInt("Thang");
				Nam = rs.getInt("Nam");
			}
			bc = new BaoCaoBestSeller(maNuoc, tenNuoc, gia, loai, tongSoLuongDat, Thang, Nam);

			System.out.println("Lấy dữ liệu doanh thu theo năm từ BaoCaoBestSeller thành công");
			rs.close();
			pst.close();
			return bc;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			connectiondb.closeConnection(con);
		}
		return null;

	}
	
		

//	public List<BaoCao> layDoanhThuTheoKhachHang(String sdt) {
//		List<BaoCao> list = new ArrayList<>();
//		Connection con = null;
//		PreparedStatement stmt = null;
//		ResultSet rs = null;
//
//		try {
//			con = connectiondb.getConnection();
//			String sql = """
//					    SELECT
//					        CAST(DH.NgayThanhToan AS DATE) AS thoiGian,
//					        SUM(CTDH.SoLuong * CTDH.DonGia) AS tongDoanhThu,
//					        COUNT(DISTINCT DH.MaDH) AS tongDon
//					    FROM DonHang DH
//					    JOIN ChiTietDonHang CTDH ON DH.MaDH = CTDH.MaDH
//					    JOIN KhachHang KH ON DH.MaKH = KH.MaKH
//					    WHERE KH.SDT = ?
//					    GROUP BY CAST(DH.NgayThanhToan AS DATE)
//					    ORDER BY thoiGian ASC
//					""";
//			stmt = con.prepareStatement(sql);
//			stmt.setString(1, sdt);
//			rs = stmt.executeQuery();
//
//			while (rs.next()) {
//				String thoiGian = rs.getString("thoiGian");
//				double doanhThu = rs.getDouble("tongDoanhThu");
//				int tongDon = rs.getInt("tongDon");
//				BaoCao baoCao = new BaoCao(thoiGian, doanhThu, tongDon);
//				list.add(baoCao);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			connectiondb.closeConnection(con);
//		}
//		return list;
//	}

}
