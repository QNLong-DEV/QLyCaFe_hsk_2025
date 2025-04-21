package controller;

import java.util.ArrayList;

import model.NhanVien;

public class DanhSachNhanVien {
	private ArrayList<NhanVien> list;

	public ArrayList<NhanVien> getList() {
		return list;
	}

	public void setList(ArrayList<NhanVien> list) {
		this.list = list;
	}

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

	public int getSize() {
		return list.size();
	}

	public boolean checktrungma(String ma) {
		for (NhanVien x : list) {
			if (x.getMaNV().equalsIgnoreCase(ma)) {
				return false;
			}
		}
		return true;
	}

	public boolean removeNV(String ma) {
		for (NhanVien nv : list) {
			if (nv.getMaNV().equalsIgnoreCase(ma)) {
				list.remove(nv);
				return true;
			}
		}
		return false;
	}

}
