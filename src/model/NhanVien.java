package model;

import java.time.LocalDate;

public class NhanVien {
	private String MaNV;
	private String TenNV;
	private String Sdt;
	private LocalDate Ngaysinh;
	private String Email;
	private String Matkhau;

	public NhanVien(String maNV, String tenNV, String sdt, LocalDate ngaySinh, String email, String matkhau) {
		super();
		MaNV = maNV;
		TenNV = tenNV;
		Sdt = sdt;
		Ngaysinh = ngaySinh;
		Email = email;
		Matkhau = matkhau;
	}

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getTenNV() {
		return TenNV;
	}

	public void setTenNV(String tenNV) {
		TenNV = tenNV;
	}

	public String getSdt() {
		return Sdt;
	}

	public void setSdt(String sdt) {
		Sdt = sdt;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public LocalDate getNgaysinh() {
		return Ngaysinh;
	}

	public void setNgaysinh(LocalDate ngaysinh) {
		Ngaysinh = ngaysinh;
	}

	public String getMatkhau() {
		return Matkhau;
	}

	public void setMatkhau(String matkhau) {
		Matkhau = matkhau;
	}

	@Override
	public String toString() {
		return MaNV + " " + TenNV + " " + Sdt + " " + Ngaysinh + " " + Email + " " + Matkhau;
	}

}
