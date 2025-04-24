package model;

import java.time.LocalDate;

public class KhachHang {
	private String MaKH;
	private String TenKH;
	private String Sdt;
	private String LoaiKH;
	private LocalDate NgayDangKy;

	public KhachHang(String maKH, String tenKH, String sdt, String loaiKH, LocalDate ngayDangKy) {
		super();
		MaKH = maKH;
		TenKH = tenKH;
		Sdt = sdt;
		LoaiKH = loaiKH;
		NgayDangKy = ngayDangKy;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getTenKH() {
		return TenKH;
	}

	public void setTenKH(String tenKH) {
		TenKH = tenKH;
	}

	public String getSdt() {
		return Sdt;
	}

	public void setSdt(String sdt) {
		Sdt = sdt;
	}

	public String getLoaiKH() {
		return LoaiKH;
	}

	public void setLoaiKH(String loaiKH) {
		LoaiKH = loaiKH;
	}

	public LocalDate getNgayDangKy() {
		return NgayDangKy;
	}

	public void setNgayDangKy(LocalDate ngayDangKy) {
		NgayDangKy = ngayDangKy;
	}

	@Override
	public String toString() {
		return MaKH + " " + TenKH + " " + Sdt + " " + LoaiKH + " " + NgayDangKy;
	}
}
