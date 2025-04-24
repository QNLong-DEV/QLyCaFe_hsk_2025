package util;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class MaDonHangGenerator {

	public String taoMaDH(String makh) {
		String ngayHienTai = new SimpleDateFormat("ddMMyyyy").format(new Date());
		LocalTime gioHienTai = LocalTime.now();
		DateTimeFormatter dinhDang = DateTimeFormatter.ofPattern("HH:mm:ss");
		String gioDangFormat = gioHienTai.format(dinhDang);

		return "DH-" + ngayHienTai + "-" + gioDangFormat + "-" + makh;
	}


}
