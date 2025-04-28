package util;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatMaterialDesignDarkIJTheme;

import javax.swing.UIManager;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Insets;

public class LookAndFeelConfig {

	// Hàm thiết lập giao diện FlatLaf và các tùy chỉnh UI
	public static void applyLookAndFeel() {
		try {
			// Áp dụng giao diện FlatLaf
			UIManager.setLookAndFeel(new FlatArcOrangeIJTheme());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Không thể thiết lập giao diện");
		}

		// Cấu hình giao diện chung
		UIManager.put("Panel.background", Color.decode("#A99273")); // Màu nền
//		UIManager.put("Label.foreground", Color.decode("#FFFFFF")); // Màu chữ
//        UIManager.put("Component.arc", 500); // Áp dụng cho TextField, ComboBox, v.v.
		UIManager.put("ProgressBar.arc", 999); // Làm progress bar tròn
		UIManager.put("TabbedPane.selectedBackground", Color.WHITE); // Màu nền khi chọn tab
		UIManager.put("TabbedPane.background", Color.decode("#fff4e4")); // Màu nền của tab
		UIManager.put("TabbedPane.foreground", Color.decode("#2E4053")); // Màu chữ của tab
		UIManager.put("TabbedPane.selectedForeground", Color.decode("#6B4A24")); // Màu chữ của tab khi chọn

		// Button
		UIManager.put("Button.background", Color.decode("#6B4A24")); // Màu nền button
		UIManager.put("Button.foreground", Color.WHITE); // Màu chữ button
		UIManager.put("Button.arc", 20); // Bo góc button
		UIManager.put("Button.padding", new Insets(12, 24, 12, 24)); // Padding của button
		UIManager.put("Button.hoverBackground", Color.decode("#fff4e4")); // Màu nền khi hover
		UIManager.put("Button.hoverForeground", Color.BLACK); // Màu chữ khi hover

		// TextField
		UIManager.put("TextField.arc", 15); // Bo góc TextField
		UIManager.put("TextComponent.arc", 20); // Áp dụng cho tất cả text component (TextArea, PasswordField...)
		UIManager.put("TextField.foreground", Color.BLACK); // Chữ

		UIManager.put("Component.focusWidth", 2); // Độ dày viền khi focus
		UIManager.put("Component.focusColor", Color.decode("#FFC107")); // Màu viền khi focus

		// ComboBox
		UIManager.put("ComboBox.arc", 15);
		UIManager.put("ComboBox.foreground", Color.BLACK);

		// PasswordField
		UIManager.put("PasswordField.foreground", Color.BLACK); // Màu chữ PasswordField
		UIManager.put("PasswordField.arc", 15); // Bo góc PasswordField

		// ScrollPane
		UIManager.put("ScrollPane.background", Color.decode("#fff4e4")); // Màu nền ScrollPane
		UIManager.put("ScrollBar.background", Color.decode("#F9E4D4")); // Màu nền thanh cuộn
		UIManager.put("ScrollBar.thumb", Color.decode("#6B4A24")); // Màu thanh cuộn

		// Table
		UIManager.put("Table.foreground", Color.BLACK); // Màu chữ bảng
		UIManager.put("Table.selectionBackground", Color.decode("#B1997C")); // Màu nền khi chọn hàng
		UIManager.put("Table.selectionForeground", Color.WHITE); // Màu chữ khi chọn hàng

	}
}
