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

import util.LookAndFeelConfig;

public class MenuGUI extends JFrame {

	private JTabbedPane tabbedPane;
	private JPanel pnlNhanVien;
	private JPanel pnlDoanhThu;
	private crudNhanVien nhanvienGUI;
	private Dimension screenSize;
	private MenuNuocGUI menunuocGUI;
	private JPanel pnlKhachHang;
	private ThongKeDoanhThuGUI thongkeGUI;

	public MenuGUI(String manv) {
		setTitle("Quản lý quán cafe");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

		LookAndFeelConfig.applyLookAndFeel();
		setLayout(new BorderLayout());

		tabbedPane = new JTabbedPane();

		nhanvienGUI = new crudNhanVien();
		tabbedPane.addTab("Nhân viên", nhanvienGUI);

		menunuocGUI = new MenuNuocGUI(manv);
		tabbedPane.addTab("Menu nước", menunuocGUI);

		thongkeGUI = new ThongKeDoanhThuGUI();
		tabbedPane.addTab("Doanh thu", thongkeGUI);

		pnlKhachHang = new JPanel();
		pnlKhachHang.add(new JLabel("Quản lý khách hàng"));
		tabbedPane.addTab("Khách hàng", pnlKhachHang);

		this.add(tabbedPane, BorderLayout.CENTER);

		JLabel lblXinChao = new JLabel("Xin chào NV  " + manv);
		lblXinChao.setFont(new Font("Arial", Font.BOLD, 16));
		lblXinChao.setHorizontalAlignment(JLabel.CENTER);
		lblXinChao.setForeground(new Color(0, 102, 204));
		this.add(lblXinChao, BorderLayout.SOUTH);

	}
}
