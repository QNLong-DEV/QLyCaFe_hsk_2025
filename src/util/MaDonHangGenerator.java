package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MaDonHangGenerator {

	public String taoMaDH(String makh) {
		int soluongdonhangtrongngay = getSoLuongDHTrongNgay();

		if (soluongdonhangtrongngay == 0) {
			soluongdonhangtrongngay = 1;
		} else {
			soluongdonhangtrongngay += 1;
		}

		String ngayHienTai = new SimpleDateFormat("ddMMyyyy").format(new Date());
		return "DH-" + ngayHienTai + "-" + makh + "-" + soluongdonhangtrongngay;
	}

	public int getSoLuongDHTrongNgay() {
		return 0;
	}
}
