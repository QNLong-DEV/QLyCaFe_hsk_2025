package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
	private JPanel navPanel;
	private JPanel logoPanel;
	private JButton[] buttons;
	private JPanel contentPanel;
	private JPanel pnlSouth;

	public MenuGUI(String manv) {
		setTitle("Quản lý quán cafe");
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width, screenSize.height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		LookAndFeelConfig.applyLookAndFeel();
		setLayout(new BorderLayout());

		nvON = dao.getNhanVienByMaNV(manv);
		tabbedPane = new JTabbedPane();

		// NAV PANEL
		navPanel = new JPanel();
		navPanel.setLayout(new BorderLayout());
		navPanel.setBackground(Color.decode("#6B4A24"));

		// Khởi tạo logoPanel trước khi sử dụng
		logoPanel = new JPanel();
		logoPanel.setBackground(Color.decode("#6B4A24"));

		// Tạo ImageIcon với ảnh logo
		ImageIcon logoIcon = new ImageIcon(getClass().getResource("/img/echo_logo.png"));
		Image image = logoIcon.getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH);
		logoIcon = new ImageIcon(image);

		JLabel logoLabel = new JLabel(logoIcon);
		logoPanel.add(logoLabel);

		// Thêm logoPanel vào phần trái của navPanel
		navPanel.add(logoPanel, BorderLayout.WEST);

		// Khu vực chứa nút
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		buttonPanel.setBackground(Color.decode("#6B4A24"));
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

		menunuocGUI = new MenuNuocGUI(manv);
		tabbedPane.addTab("Menu nước", menunuocGUI);

		thongkeGUI = new ThongKeDoanhThuGUI();
		tabbedPane.addTab("Doanh thu", thongkeGUI);

		// Mảng tabs với tên của các tab
		String[] tabs = { "Nhân viên", "Menu nước", "Doanh thu", "Khách hàng" };
		buttons = new JButton[tabs.length];

		// Tạo các biểu tượng cho từng nút
		ImageIcon[] icons = new ImageIcon[tabs.length];
		icons[0] = new ImageIcon(getClass().getResource("/img/staff.png"));
		icons[1] = new ImageIcon(getClass().getResource("/img/menu.png"));
		icons[2] = new ImageIcon(getClass().getResource("/img/stats.png"));
		icons[3] = new ImageIcon(getClass().getResource("/img/service.png"));

		for (int i = 0; i < icons.length; i++) {
			Image img = icons[i].getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
			icons[i] = new ImageIcon(img);
		}

		// Tạo nút cho từng tab
		for (int i = 0; i < tabs.length; i++) {
			String tabName = tabs[i];
			buttons[i] = new JButton(tabName);

			buttons[i].setIcon(icons[i]);

			// Đảm bảo icon vừa với nút
			buttons[i].setIconTextGap(10);
			buttons[i].setFocusPainted(false);
			buttons[i].setBackground(Color.decode("#A99273"));
			buttons[i].setForeground(Color.WHITE);
			buttons[i].setFont(new Font("Arial", Font.BOLD, 14));
			buttons[i].setBorder(null);
			buttons[i].setPreferredSize(new Dimension(150, 40));
			
			int index = i;
            buttons[i].addActionListener(e -> {
                CardLayout cl = (CardLayout) (contentPanel.getLayout());
                cl.show(contentPanel, tabName);
                updateButtonColors(index); 
            });
            
			buttonPanel.add(buttons[i]);
		}

		// Thêm buttonPanel vào phần dưới của navPanel
		navPanel.add(buttonPanel, BorderLayout.CENTER);

		// CONTENT PANEL
		contentPanel = new JPanel(new CardLayout());

		menunuocGUI = new MenuNuocGUI(manv);
		thongkeGUI = new ThongKeDoanhThuGUI();
		contentPanel.add(menunuocGUI, "Menu nước");
		contentPanel.add(thongkeGUI, "Doanh thu");

		pnlSouth = new JPanel();
		JLabel lblXinChao = new JLabel("Xin chào NV  " + nvON.getTenNV());
		btnDangXuat = new JButton("Đăng xuất");
		lblXinChao.setFont(new Font("Arial", Font.BOLD, 16));
		lblXinChao.setHorizontalAlignment(JLabel.CENTER);

		pnlSouth.add(lblXinChao);
		pnlSouth.add(btnDangXuat);

		add(navPanel, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		add(pnlSouth, BorderLayout.SOUTH);

		btnDangXuat.addActionListener(this);
		updateButtonColors(0); 
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

	// Hàm đổi màu nút khi chọn
	private void updateButtonColors(int selectedIndex) {
		for (int i = 0; i < buttons.length; i++) {
			if (i == selectedIndex) {
				buttons[i].setBackground(Color.decode("#6B4A24"));
			} else {
				buttons[i].setBackground(Color.decode("#A99273"));
			}
		}
	}
}
