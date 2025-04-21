package model;

public class Nuoc {
	private String MaNuoc;
	private String TenNuoc;
	private double Gia;
	private String Loai;
	private String Img;

	public Nuoc(String maNuoc, String tenNuoc, double gia, String loai, String img) {
		super();
		MaNuoc = maNuoc;
		TenNuoc = tenNuoc;
		Gia = gia;
		Loai = loai;
		Img = img;
	}

	public String getMaNuoc() {
		return MaNuoc;
	}

	public void setMaNuoc(String maNuoc) {
		MaNuoc = maNuoc;
	}

	public String getTenNuoc() {
		return TenNuoc;
	}

	public void setTenNuoc(String tenNuoc) {
		TenNuoc = tenNuoc;
	}

	public double getGia() {
		return Gia;
	}

	public void setGia(double gia) {
		Gia = gia;
	}

	public String getLoai() {
		return Loai;
	}

	public void setLoai(String loai) {
		Loai = loai;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}

	@Override
	public String toString() {
		return MaNuoc + " " + TenNuoc + " " + Gia + " " + Loai + " " + Img;
	}

}
