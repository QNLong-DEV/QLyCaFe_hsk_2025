package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;

import dao.NhanVienDAO;
import model.ChiTietDonHang;
import model.NhanVien;
import util.LookAndFeelConfig;

public class MenuGUI extends JFrame implements ActionListener {
	private JTabbedPane tabbedPane;
	private JPanel pnlNhanVien;
	private JPanel pnlDoanhThu;
	private crudNhanVien nhanvienGUI;
	private Dimension screenSize;
	private MenuNuocGUI menunuocGUI;
	private JPanel pnlKhachHang;
	private ThongKeDoanhThuGUI thongkeGUI;
	static NhanVienDAO dao = new NhanVienDAO();
	private NhanVien nvON;
	private JButton btnDangXuat;

	public MenuGUI(String manv) {

		LookAndFeelConfig.applyLookAndFeel();
		setLayout(new BorderLayout());
		nvON = dao.getNhanVienByMaNV(manv);
		tabbedPane = new JTabbedPane();
		tabbedPane.setBackground(new Color(35, 85, 136));
		tabbedPane.setForeground(Color.white);

		menunuocGUI = new MenuNuocGUI(manv);
		tabbedPane.addTab("Menu nước", menunuocGUI);

		thongkeGUI = new ThongKeDoanhThuGUI();
		tabbedPane.addTab("Doanh thu", thongkeGUI);

//		nhanvienGUI = new crudNhanVien(manv);
//		tabbedPane.addTab("Nhân viên", nhanvienGUI);

//		pnlKhachHang = new JPanel();
//		pnlKhachHang.add(new JLabel("Quản lý khách hàng"));
//		tabbedPane.addTab("Khách hàng", pnlKhachHang);

		this.add(tabbedPane, BorderLayout.CENTER);

		JLabel lblXinChao = new JLabel("Xin chào NV  " + nvON.getTenNV());
		btnDangXuat = new JButton("Đăng xuất");
		lblXinChao.setFont(new Font("Arial", Font.BOLD, 16));
		lblXinChao.setHorizontalAlignment(JLabel.CENTER);
		lblXinChao.setBackground(new Color(35, 85, 136));
		lblXinChao.setForeground(Color.white);

		JPanel pnlSouth = new JPanel();
		pnlSouth.add(lblXinChao);
		pnlSouth.add(btnDangXuat);
		pnlSouth.setBackground(new Color(35, 85, 136));
		this.add(pnlSouth, BorderLayout.SOUTH);

		btnDangXuat.addActionListener(this);
		setTitle("Quản lý quán cafe");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public void dangXuat() {
		int response = JOptionPane.showConfirmDialog(null, "Bạn muốn đăng xuất?", "Xác nhận", JOptionPane.YES_NO_OPTION,
				JOptionPane.WARNING_MESSAGE);
		if (response == JOptionPane.YES_OPTION) {
			nvON = null;
			this.dispose();
			new dangNhapGUI();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnDangXuat) {
			dangXuat();
		}
	}
}
