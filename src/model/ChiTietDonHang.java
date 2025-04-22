package model;

public class ChiTietDonHang {
	private String maDH;
	private String maNuoc;
	private int soLuong;
	private double donGia;
	private double thanhTien; // Đây là cột được tính tự động từ DB (computed column)

	public ChiTietDonHang(String maDH, String maNuoc, int soLuong, double donGia, double thanhTien) {
		super();
		this.maDH = maDH;
		this.maNuoc = maNuoc;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.thanhTien = thanhTien;
	}

	public String getMaDH() {
		return maDH;
	}

	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}


	public String getMaNuoc() {
		return maNuoc;
	}

	public void setMaNuoc(String maNuoc) {
		this.maNuoc = maNuoc;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public double getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(double thanhTien) {
		this.thanhTien = thanhTien;
	}

	@Override
	public String toString() {
		return "ChiTietDonHang [maDH=" + maDH + ", maNuoc=" + maNuoc + ", soLuong=" + soLuong + ", donGia=" + donGia
				+ ", thanhTien=" + thanhTien + "]";
	}
	

}