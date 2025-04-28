package model;

public class BaoCao {
	private String thoiGian;
	private double doanhThu;
	private int tongSoDon;

	public BaoCao(String thoiGian, double doanhThu, int tongSoDon) {
		this.thoiGian = thoiGian;
		this.doanhThu = doanhThu;
		this.tongSoDon = tongSoDon;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public double getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}

	public int getTongSoDon() {
		return tongSoDon;
	}

	public void setTongSoDon(int tongSoDon) {
		this.tongSoDon = tongSoDon;
	}
}
