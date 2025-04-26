package controller;

import java.util.ArrayList;

import model.KhachHang;
import model.Nuoc;

public class DanhSachKhachHang {
	private ArrayList<KhachHang> list;

	public DanhSachKhachHang() {
		list = new ArrayList<KhachHang>();
	}

	public ArrayList<KhachHang> getList() {
		return list;
	}

	public void setList(ArrayList<KhachHang> list) {
		this.list = list;
	}

	public boolean addList(KhachHang kh) {
		for (KhachHang x : list) {
			if (x.getMaKH().equalsIgnoreCase(kh.getMaKH())) {
				return false;
			}
		}
		return list.add(kh);
	}

	public boolean deleteList(String makh) {
		for (KhachHang x : list) {
			if (x.getMaKH().equalsIgnoreCase(makh)) {
				list.remove(x);
				return true;
			}
		}
		return false;
	}

	public boolean updateList(KhachHang kh) {
		int index = list.indexOf(kh);
		for (KhachHang x : list) {
			if (x.getMaKH().equalsIgnoreCase(kh.getMaKH())) {
				list.set(index, kh);
				return true;
			}
		}
		return false;
	}

	public int getSize() {
		return list.size();
	}

	public boolean checktrungma(String makh) {
		for (KhachHang x : list) {
			if (x.getMaKH().equalsIgnoreCase(makh)) {
				return false;
			}
		}
		return true;
	}

	public boolean removeKH(String makh) {
		for (KhachHang x : list) {
			if (x.getMaKH().equalsIgnoreCase(makh)) {
				list.remove(x);
				return true;
			}
		}
		return false;
	}

	public KhachHang timKiemKHBangSDT(String sdt) {
		for (KhachHang kh : list) {
			if (kh.getSdt().equalsIgnoreCase(sdt)) {
				return kh;
			}
		}
		return null;
	}
}
