package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dao.KhachHangDAO;
import model.KhachHang;
import util.LookAndFeelConfig;
import util.MaKhachHangGenerator;

public class taoTaiKhoanKHGUI extends JFrame implements ActionListener {

	private JPanel pnlNorth;
	private JLabel lblTitle;
	private Dimension lblsize;
	private Dimension txtsize;
	private JLabel lblSdt;
	private JTextField txtSdt;
	private JLabel lblTenKH;
	private JTextField txtTenKH;
	private Box BoxTitle;
	private Box Box0;
	private Box Box1;
	private JPanel pnlSouth;
	private JButton btnXacNhan;
	private JButton btnHuyDon;
	static KhachHangDAO khachhangdao = new KhachHangDAO();
	static MaKhachHangGenerator genmakh = new MaKhachHangGenerator();
	private String makh = genmakh.taoMaKH();
	private thanhToanGUI parent;

	public taoTaiKhoanKHGUI(thanhToanGUI parentGUI) {
		this.parent = parentGUI;
		setTitle("Đăng ký hội viên");
		setSize(400, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		LookAndFeelConfig.applyLookAndFeel();

		pnlNorth = new JPanel();
		pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));
		add(pnlNorth, BorderLayout.NORTH);

		lblTitle = new JLabel("Đăng ký hội viên");
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));

		lblsize = new Dimension(150, 25);
		txtsize = new Dimension(200, 25);

		lblSdt = new JLabel("Số Điện thoại:");
		lblSdt.setMaximumSize(lblsize);
		txtSdt = new JTextField(10);
		txtSdt.setMaximumSize(txtsize);

		lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setMaximumSize(lblsize);
		txtTenKH = new JTextField(10);
		txtTenKH.setMaximumSize(txtsize);

		BoxTitle = new Box(BoxLayout.X_AXIS);
		BoxTitle.add(lblTitle);

		Box0 = new Box(BoxLayout.X_AXIS);
		Box0.add(lblSdt);
		Box0.add(Box.createHorizontalStrut(10));
		Box0.add(txtSdt);
		Box0.add(Box.createHorizontalStrut(10));

		Box1 = new Box(BoxLayout.X_AXIS);
		Box1.add(lblTenKH);
		Box1.add(Box.createHorizontalStrut(10));
		Box1.add(txtTenKH);
		Box1.add(Box.createHorizontalStrut(10));

		pnlNorth.add(BoxTitle);
		pnlNorth.add(Box.createVerticalStrut(15));
		pnlNorth.add(Box0);
		pnlNorth.add(Box.createVerticalStrut(15));
		pnlNorth.add(Box1);
		pnlNorth.add(Box.createVerticalStrut(15));

		pnlSouth = new JPanel();
		btnXacNhan = new JButton("Xác nhận");
		btnHuyDon = new JButton("Hủy đăng ký");

		pnlSouth.add(btnXacNhan);
		pnlSouth.add(btnHuyDon);
		add(pnlSouth, BorderLayout.SOUTH);

		btnXacNhan.addActionListener(this);
		btnHuyDon.addActionListener(this);

	}

	public void themTaiKhoan() {
		String sdt = txtSdt.getText();
		String ten = txtTenKH.getText();
		String ma = makh;
		String loai = "Tiềm năng";
		LocalDateTime ngaytao = LocalDateTime.now();

		KhachHang kh = new KhachHang(ma, ten, sdt, loai, ngaytao);
		if (!khachhangdao.saveKH(kh)) {
			JOptionPane.showMessageDialog(null, "Thêm hội viên không thành công");
			return;
		} else {
			JOptionPane.showMessageDialog(null, "Thêm hội viên thành công");
			parent.loadlistkh();
			parent.loadthongtin(ma);
			this.dispose();
			return;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnXacNhan) {
			themTaiKhoan();
		} else if (e.getSource() == btnHuyDon) {
			this.dispose();
		}

	}

//	public static void main(String[] args) {
//		new taoTaiKhoanKHGUI();
//	}
}
