package model;

public class ChiTietDonHang {
	private String MaDH;
	private String MaNuoc;
	private int SoLuong;
	private double DonGia;
	private double ThanhTien; // Đây là cột được tính tự động từ DB (computed column)

	public ChiTietDonHang(String maDH, String maNuoc, int soLuong, double donGia, double thanhTien) {
		super();
		this.MaDH = maDH;
		this.MaNuoc = maNuoc;
		this.SoLuong = soLuong;
		this.DonGia = donGia;
		this.ThanhTien = thanhTien;
	}

	public String getMaDH() {
		return MaDH;
	}

	public void setMaDH(String maDH) {
		this.MaDH = maDH;
	}


	public String getMaNuoc() {
		return MaNuoc;
	}

	public void setMaNuoc(String maNuoc) {
		this.MaNuoc = maNuoc;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		this.SoLuong = soLuong;
	}

	public double getDonGia() {
		return DonGia;
	}

	public void setDonGia(double donGia) {
		this.DonGia = donGia;
	}

	public double getThanhTien() {
		return ThanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.ThanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [MaDH=" + MaDH + ", MaNuoc=" + MaNuoc + ", SoLuong=" + SoLuong + ", DonGia=" + DonGia
				+ ", ThanhTien=" + ThanhTien + "]";
	}
	

}