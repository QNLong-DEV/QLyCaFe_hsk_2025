package resource;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Insets;

public class LookAndFeelConfig {

	// Hàm thiết lập giao diện FlatLaf và các tùy chỉnh UI
	public static void applyLookAndFeel() {
		try {
			// Áp dụng giao diện FlatLaf
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Không thể thiết lập giao diện");
		}

		// Cấu hình giao diện
		UIManager.put("Panel.background", Color.decode("#F0F0F0")); // Màu nền
		UIManager.put("Label.foreground", Color.DARK_GRAY); // Màu chữ
		UIManager.put("Button.arc", 15); // Bo góc button
		UIManager.put("Component.arc", 15); // Áp dụng cho TextField, ComboBox, v.v.
		UIManager.put("ProgressBar.arc", 999); // Làm progress bar tròn
		UIManager.put("Button.hoverBackground", Color.decode("#D6EAF8")); // Màu nền khi hover
		UIManager.put("Button.hoverForeground", Color.BLACK); // Màu chữ khi hover
		UIManager.put("TabbedPane.selectedBackground", Color.WHITE); // Màu nền khi chọn tab
		UIManager.put("TabbedPane.background", Color.decode("#FDFEFE")); // Màu nền của tab
		UIManager.put("TabbedPane.foreground", Color.decode("#2E4053")); // Màu chữ của tab
		UIManager.put("TabbedPane.selectedForeground", Color.BLUE); // Màu chữ của tab khi chọn
		UIManager.put("Button.padding", new Insets(10, 20, 10, 20)); // Padding của button
		UIManager.put("Component.focusWidth", 1); // Độ dày viền khi focus
	}
}
