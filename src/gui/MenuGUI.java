package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class MenuGUI extends JFrame {

	private JTabbedPane tabbedPane;
	private JPanel pnlNhanVien;
	private JPanel pnlMenu;
	private JPanel pnlDoanhThu;
	private crudNhanVien nhanvienGUI;

	public MenuGUI() {
		setTitle("Quản lý quán cafe");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		// Áp dụng giao diện FlatLaf
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Không thể thiết lập giao diện");
		}
		UIManager.put("Panel.background", Color.decode("#F0F0F0")); // màu nền
		UIManager.put("Label.foreground", Color.DARK_GRAY);        // màu chữ
		UIManager.put("Button.arc", 15);
		UIManager.put("Component.arc", 15); // Áp dụng cho TextField, ComboBox, v.v.
		UIManager.put("ProgressBar.arc", 999); // Làm progress bar tròn
		UIManager.put("Button.hoverBackground", Color.decode("#D6EAF8"));
		UIManager.put("Button.hoverForeground", Color.BLACK);
		UIManager.put("TabbedPane.selectedBackground", Color.WHITE);
		UIManager.put("TabbedPane.background", Color.decode("#FDFEFE"));
		UIManager.put("TabbedPane.foreground", Color.decode("#2E4053"));
		UIManager.put("TabbedPane.selectedForeground", Color.BLUE);
		UIManager.put("Button.padding", new Insets(10, 20, 10, 20)); // top, left, bottom, right
		UIManager.put("Component.focusWidth", 1); // Độ dày viền khi focus


		tabbedPane = new JTabbedPane();
		JTabbedPane tabbedPane = new JTabbedPane();

		pnlNhanVien = new JPanel();
		nhanvienGUI = new crudNhanVien();
		tabbedPane.addTab("Nhân viên", nhanvienGUI);

		pnlMenu = new JPanel();
		pnlMenu.add(new JLabel("menu nước"));

		pnlDoanhThu = new JPanel();
		pnlDoanhThu.add(new JLabel("Quản lý doanh thu"));

		tabbedPane.addTab("Menu nước", pnlMenu);
		tabbedPane.addTab("Doanh thu", pnlDoanhThu);

		this.add(tabbedPane);

	}
}
