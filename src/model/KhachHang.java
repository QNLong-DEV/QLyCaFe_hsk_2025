package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class KhachHang {
	private String MaKH;
	private String TenKH;
	private String Sdt;
	private String LoaiKH;
	private LocalDateTime NgayDangKy;

	public KhachHang() {

	}

	public KhachHang(String maKH, String tenKH, String sdt, String loaiKH, LocalDateTime ngayDangKy) {
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

	public LocalDateTime getNgayDangKy() {
		return NgayDangKy;
	}

	public void setNgayDangKy(LocalDateTime ngayDangKy) {
		NgayDangKy = ngayDangKy;
	}

	@Override
	public String toString() {
		return MaKH + " " + TenKH + " " + Sdt + " " + LoaiKH + " " + NgayDangKy;
	}
}
