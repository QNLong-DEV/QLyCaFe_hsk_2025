package util;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import dao.KhachHangDAO;

public class MaKhachHangGenerator {
	public String taoMaKH() {
		KhachHangDAO dao = new KhachHangDAO();
		return "KH" +  (dao.countKH() + 1);
	}
	
	public String taoMaKHVangLai() {
		String ngayHienTai = new SimpleDateFormat("ddMMyyyy").format(new Date());
		LocalTime gioHienTai = LocalTime.now();
		DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("HH:mm:ss");
		String gioDangFormat = gioHienTai.format(dinhDang);

		return "KH-" + ngayHienTai + "-" + gioDangFormat;
	}
}
