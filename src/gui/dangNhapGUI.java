package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.MediaTracker;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

import dao.NhanVienDAO;
import model.NhanVien;
import util.LookAndFeelConfig;
import util.txtSource;

public class dangNhapGUI extends JFrame {
	private JPasswordField txtMatKhau;
	private JButton btnDangNhap;
	private JLabel lblDangNhap;
	private JLabel lblMatKhau;
	private Box box0;
	private Box box1;
	private Box box2;
	private JPanel pnlCenter;
	private loadingGUI loadingwindow;
	private JLabel lblSdt;
	private JTextField txtSdt;
	txtSource txtHelper = new txtSource();

	public dangNhapGUI() {
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 200);
		setLocationRelativeTo(null);

		LookAndFeelConfig.applyLookAndFeel();

	

		ImageIcon originalIcon = new ImageIcon(getClass().getResource("/img/user.png"));
		Image originalImage = originalIcon.getImage();

	
		Image scaledImage = originalImage.getScaledInstance(120, 120, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);

		JLabel lblImage = new JLabel(scaledIcon);

		JPanel pnlWest = new JPanel();
		pnlWest.add(lblImage);
	

		lblDangNhap = new JLabel("Đăng nhập tài khoản");
		lblDangNhap.setFont(new Font("Arial", Font.BOLD, 20));
		lblDangNhap.setForeground(Color.WHITE);
		lblDangNhap.setAlignmentX(CENTER_ALIGNMENT);
		lblSdt = new JLabel("SĐT:");
		lblMatKhau = new JLabel("Mật khẩu:");

		Dimension lblSize = new Dimension(100, 25);
		lblSdt.setPreferredSize(lblSize);
		lblMatKhau.setPreferredSize(lblSize);

		txtSdt = new JTextField(10);
		txtMatKhau = new JPasswordField(10);
		txtHelper.addPlaceholder(txtSdt, "nhập đúng định dạng: 09xxxxxxxx");

		Dimension txtSize = new Dimension(100, 15);
		txtSdt.setPreferredSize(txtSize);
		txtMatKhau.setPreferredSize(txtSize);

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(e -> dangNhap());
		btnDangNhap.setAlignmentX(CENTER_ALIGNMENT);

		box0 = new Box(BoxLayout.X_AXIS);
		box1 = new Box(BoxLayout.X_AXIS);
		box2 = new Box(BoxLayout.X_AXIS);

		box0.add(lblDangNhap);
		box1.add(lblSdt);
		box1.add(Box.createHorizontalStrut(20));
		box1.add(txtSdt);
		box2.add(lblMatKhau);
		box2.add(Box.createHorizontalStrut(20));
		box2.add(txtMatKhau);

		pnlCenter = new JPanel();
		pnlCenter.add(box0);
		pnlCenter.add(Box.createVerticalStrut(10));
		pnlCenter.add(box1);
		pnlCenter.add(Box.createVerticalStrut(10));
		pnlCenter.add(box2);
		pnlCenter.add(Box.createVerticalStrut(10));
		pnlCenter.add(btnDangNhap);
		pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.Y_AXIS));
		add(pnlCenter, BorderLayout.CENTER);
		add(pnlWest, BorderLayout.WEST);
		setVisible(true);
	}

	private void dangNhap() {
		String Sdt = txtSdt.getText();
		String matKhau = new String(txtMatKhau.getPassword());

		String sdtRegex = "0[3589]\\d{8}";
		String matKhauRegex = "";

		if (!Sdt.matches(sdtRegex)) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không đúng định dạng! Ví dụ: 0912345678");
			txtSdt.requestFocus(true);
			return;
		}

		loadingwindow = new loadingGUI();
		loadingwindow.showLoading();

		SwingWorker<NhanVien, Void> worker = new SwingWorker<>() {

			@Override
			protected NhanVien doInBackground() throws Exception {
				Thread.sleep(3000);

				NhanVienDAO dao = new NhanVienDAO();
				return dao.getNhanVienByEmailVaMatKhau(Sdt, matKhau);
			}

			@Override
			protected void done() {
				try {
					NhanVien nv = get();
					loadingwindow.hideLoading();
					if (nv != null) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công, Xin chào " + nv.getTenNV());
						String saveMaNV = nv.getMaNV();
						dispose(); // ẩn cửa sổ đăng nhập
						loadingwindow.hideLoading();
						new MenuGUI(saveMaNV); // mở giao diện chính
					} else {
						JOptionPane.showMessageDialog(null, "Email hoặc mật khẩu không đúng", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e) {
					e.printStackTrace();
					loadingwindow.hideLoading();
					JOptionPane.showMessageDialog(null, "Đã xảy ra lỗi!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		worker.execute();
	}
}