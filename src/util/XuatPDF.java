package util;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

public class XuatPDF {
	public void xuatHoaDonPDF(String hd, String mahd) {
		try {
			Document doc = new Document();
			PdfWriter.getInstance(doc, new FileOutputStream(mahd + ".pdf"));

			doc.open();
			// Tạo BaseFont từ Arial Black
			BaseFont baseFont = BaseFont.createFont("C:\\Windows\\Fonts\\ARIALBD.TTF", BaseFont.IDENTITY_H,
					BaseFont.EMBEDDED);
			Font font = new Font(baseFont, 12);

			// Tạo Paragraph với font
			Paragraph paragraph = new Paragraph(hd, font);
			doc.add(paragraph);

			doc.close();
			System.out.println("Xuất file pdf thành công");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Xuất file pdf không thành công");
		}
	}
}
