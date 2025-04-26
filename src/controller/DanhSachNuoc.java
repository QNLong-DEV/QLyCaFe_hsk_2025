package controller;

import java.util.ArrayList;

import model.NhanVien;
import model.Nuoc;

public class DanhSachNuoc {
	private ArrayList<Nuoc> list;

	public DanhSachNuoc() {
		list = new ArrayList<Nuoc>();
	}

	public ArrayList<Nuoc> getList() {
		return list;
	}

	public void setList(ArrayList<Nuoc> list) {
		this.list = list;
	}

	public boolean addList(Nuoc nuoc) {
		for (Nuoc x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(nuoc.getMaNuoc())) {
				return false;
			}
		}
		return list.add(nuoc);
	}

	public boolean deleteList(String manuoc) {
		for (Nuoc x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(manuoc)) {
				list.remove(x);
				return true;
			}
		}
		return false;
	}

	public boolean updateList(Nuoc nuoc) {
		int index = list.indexOf(nuoc);
		for (Nuoc x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(nuoc.getMaNuoc())) {
				list.set(index, nuoc);
				return true;
			}
		}
		return false;
	}

	public int getSize() {
		return list.size();
	}

	public boolean checktrungma(String manuoc) {
		for (Nuoc x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(manuoc)) {
				return false;
			}
		}
		return true;
	}

	public boolean removeNuoc(String manuoc) {
		for (Nuoc x : list) {
			if (x.getMaNuoc().equalsIgnoreCase(manuoc)) {
				list.remove(x);
				return true;
			}
		}
		return false;
	}

	public String timTenNuocTheoMa(String maNuoc) {
		for (Nuoc n : list) {
			if (n.getMaNuoc().equalsIgnoreCase(maNuoc)) {
				return n.getTenNuoc();
			}
		}
		return null;
	}
}
