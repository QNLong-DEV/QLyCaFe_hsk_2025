package main;

import java.sql.Connection;
import java.util.ArrayList;

import connection.connectiondb;
import controller.DanhSachNhanVien;
import dao.NhanVienDAO;
import gui.MenuGUI;
import gui.MenuNuocGUI;
import gui.crudNhanVien;
import gui.dangNhapGUI;
import model.NhanVien;

public class mainTest {
	private static DanhSachNhanVien listNV;

	public static void main(String[] args) {
//		new MenuGUI(null);
		new dangNhapGUI();
	}
}
