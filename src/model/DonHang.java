package model;

import java.time.LocalDate;

import controller.DanhSachChiTietDonHang;

public class DonHang {
	private String MaDH;
	private String MaKH;
	private String MaNV;
	private LocalDate NgayDatHang;
	private DanhSachChiTietDonHang listCTiet;
	private double TongTien;

	public DonHang() {

	}

	public DonHang(String maDH, String maKH, String maNV, LocalDate ngayDatHang, DanhSachChiTietDonHang listCTiet,
			double tongTien) {
		super();
		MaDH = maDH;
		MaKH = maKH;
		MaNV = maNV;
		NgayDatHang = ngayDatHang;
		this.listCTiet = (listCTiet != null) ? listCTiet : new DanhSachChiTietDonHang();
		TongTien = tongTien;
	}

	public String getMaDH() {
		return MaDH;
	}

	public void setMaDH(String maDH) {
		MaDH = maDH;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public LocalDate getNgayDatHang() {
		return NgayDatHang;
	}

	public void setNgayDatHang(LocalDate ngayDatHang) {
		NgayDatHang = ngayDatHang;
	}

	public DanhSachChiTietDonHang getListCTiet() {
		return listCTiet;
	}

	public void setListCTiet(DanhSachChiTietDonHang listCTiet) {
		this.listCTiet = listCTiet;
	}

	public double getTongTien() {
		return TongTien;
	}

	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}

	@Override
	public String toString() {
		return "DonHang [MaDH=" + MaDH + ", MaKH=" + MaKH + ", MaNV=" + MaNV + ", NgayDatHang=" + NgayDatHang
				+ ", listCTiet=" + listCTiet.xuat()+ ", TongTien=" + TongTien + "]";
	}

}
