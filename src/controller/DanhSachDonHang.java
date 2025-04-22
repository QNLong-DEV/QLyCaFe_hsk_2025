package controller;

import java.util.ArrayList;
import java.util.Iterator;

import model.DonHang;

public class DanhSachDonHang {
	private ArrayList<DonHang> list;

	public DanhSachDonHang() {
		list = new ArrayList<DonHang>();
	}

	public boolean themDH(DonHang dh) {
		for (DonHang x : list) {
			if (x.getMaDH().equalsIgnoreCase(dh.getMaDH())) {
				return false;
			}
		}
		list.add(dh);
		return true;
	}

	public boolean clearAllDH() {
		if (list != null && !list.isEmpty()) {
			list.clear();
			return true;
		}
		return false;
	}
}
