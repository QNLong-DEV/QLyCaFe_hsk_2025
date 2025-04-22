package controller;

import java.util.ArrayList;

import model.ChiTietDonHang;

public class DanhSachChiTietDonHang {
	private ArrayList<ChiTietDonHang> list;

	public DanhSachChiTietDonHang() {
		list = new ArrayList<ChiTietDonHang>();
	}

	public void themChiTiet(ChiTietDonHang chiTiet) {
		list.add(chiTiet);
	}

	public boolean xoaChiTiet(String manuoc) {
		for (ChiTietDonHang x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(manuoc)) {
				list.remove(x);
				return true;
			}
		}
		return false;
	}

	public double tongTien() {
		if (list == null || list.isEmpty())
			return 0;
		double res = 0;
		for (ChiTietDonHang x : list) {
			res += x.getThanhTien();
		}
		return res;
	}

	public double tongTienMotNuoc(String ma) {
		double thanhtien = 0;
		for (ChiTietDonHang x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(ma)) {
				thanhtien += x.getSoLuong() * x.getDonGia();
			}
		}
		return thanhtien;
	}

	public boolean xoaToanBo() {
		if (list != null && !list.isEmpty()) {
			list.clear();
			return true;
		}
		return false;
	}

	public double tangSoLuonNuoc(String manuoc) {
		for (ChiTietDonHang x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(manuoc)) {
				int sl = x.getSoLuong();
				x.setSoLuong(sl + 1);
				x.setThanhTien(tongTienMotNuoc(manuoc));
				return x.getThanhTien();
			}
		}
		return 0;
	}

	public double giamSoLuongNuoc(String manuoc) {
		for (ChiTietDonHang x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(manuoc)) {
				int sl = x.getSoLuong();
				x.setSoLuong(sl - 1);
				if(x.getSoLuong() <= 0) {
					list.remove(x);
					break;
				}
				x.setThanhTien(tongTienMotNuoc(manuoc));
				return x.getThanhTien();
			}
		}
		return 0;
	}
	
	public double tangSoLuongNuoc(String manuoc) {
		for (ChiTietDonHang x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(manuoc)) {
				int sl = x.getSoLuong();
				x.setSoLuong(sl + 1);
				x.setThanhTien(tongTienMotNuoc(manuoc));
				return x.getThanhTien();
			}
		}
		return 0;
	}
	
	public String xuat() {
		String res = "";
		for (ChiTietDonHang x : list) {
			res += x.toString() + "\n";
		}
		return res;
	}
}
