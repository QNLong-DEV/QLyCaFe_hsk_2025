package controller;

import java.util.ArrayList;

import model.NhanVien;

public class DanhSachNhanVien {
	private ArrayList<NhanVien> list;

	public DanhSachNhanVien() {
		list = new ArrayList<NhanVien>();
	}

	public boolean addList(NhanVien nv) {
		for (NhanVien x : list) {
			if (x.getMaNV().equalsIgnoreCase(nv.getMaNV())) {
				return false;
			}
		}
		return list.add(nv);
	}

	public boolean deleteList(String manv) {
		for (NhanVien x : list) {
			if (x.getMaNV().equalsIgnoreCase(manv)) {
				list.remove(x);
				return true;
			}
		}
		return false;
	}

	public boolean updateList(NhanVien nv) {
		int index = list.indexOf(nv);
		for (NhanVien x : list) {
			if (x.getMaNV().equalsIgnoreCase(nv.getMaNV())) {
				list.set(index, nv);
				return true;
			}
		}
		return false;
	}
	
}
