package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import resource.LookAndFeelConfig;

public class MenuGUI extends JFrame {

	private JTabbedPane tabbedPane;
	private JPanel pnlNhanVien;
	private JPanel pnlMenu;
	private JPanel pnlDoanhThu;
	private crudNhanVien nhanvienGUI;
	private Dimension screenSize;

	public MenuGUI() {
		setTitle("Quản lý quán cafe");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width,screenSize.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		LookAndFeelConfig.applyLookAndFeel();
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
