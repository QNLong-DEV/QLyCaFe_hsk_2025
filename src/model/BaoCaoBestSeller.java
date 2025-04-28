package model;

import java.time.LocalDateTime;

public class BaoCaoBestSeller {
	private String maNuoc;
	private String tenNuoc;
	private double gia;
	private String loai;
	private int tongSoLuongDat;
	private int Thang;
	private int Nam;

	// Constructor
	public BaoCaoBestSeller() {

	}

	public BaoCaoBestSeller(String maNuoc, String tenNuoc, double gia, String loai, int tongSoLuongDat, int thang,
			int nam) {
		super();
		this.maNuoc = maNuoc;
		this.tenNuoc = tenNuoc;
		this.gia = gia;
		this.loai = loai;
		this.tongSoLuongDat = tongSoLuongDat;
		Thang = thang;
		Nam = nam;
	}

	public String getMaNuoc() {
		return maNuoc;
	}

	public void setMaNuoc(String maNuoc) {
		this.maNuoc = maNuoc;
	}

	public String getTenNuoc() {
		return tenNuoc;
	}

	public void setTenNuoc(String tenNuoc) {
		this.tenNuoc = tenNuoc;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public int getTongSoLuongDat() {
		return tongSoLuongDat;
	}

	public void setTongSoLuongDat(int tongSoLuongDat) {
		this.tongSoLuongDat = tongSoLuongDat;
	}

	public int getThang() {
		return Thang;
	}

	public void setThang(int thang) {
		Thang = thang;
	}

	public int getNam() {
		return Nam;
	}

	public void setNam(int nam) {
		Nam = nam;
	}

	@Override
	public String toString() {
		return "BaoCaoBestSeller [maNuoc=" + maNuoc + ", tenNuoc=" + tenNuoc + ", gia=" + gia + ", loai=" + loai
				+ ", tongSoLuongDat=" + tongSoLuongDat + ", Thang=" + Thang + ", Nam=" + Nam + "]";
	}

}
