package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
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
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import controller.DanhSachNhanVien;
import dao.NhanVienDAO;
import model.NhanVien;
import util.LookAndFeelConfig;
import util.txtSource;

public class crudNhanVien extends JPanel implements ActionListener, FocusListener {

	txtSource txtHelper = new txtSource();
	static DanhSachNhanVien list = new DanhSachNhanVien();
	NhanVienDAO dao = new NhanVienDAO();
	NhanVien nvON;
	private JPanel pnlRight;
	private Font lblFont;
	private JLabel lblMaNVshow;
	private JLabel lblTenNVshow;
	private JLabel lblNgaySinhNVshow;
	private JLabel lblSdtNVshow;
	private JLabel lblEmailNVshow;
	private JPanel pnlLeft;
	private JLabel lblTenNV;
	private JTextField txtTenNV;
	private JLabel lblSdtNV;
	private JTextField txtSdtNV;
	private JLabel lblNgaySinhNV;
	private JTextField txtNgaySinhNV;
	private JLabel lblEmailNV;
	private JTextField txtEmailNV;
	private Box Box0;
	private Box Box1;
	private Box Box2;
	private Box Box3;
	private JButton btnXoaTrang;
	private JButton btnSua;
	private JPanel pnlBtn;
	private Container mainPanel;
	static String maNVON;
	DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private JLabel lblTT;
	private JLabel lblCNTT;
	private Box BoxTT;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public crudNhanVien(String manv) {
		nvON = dao.getNhanVienByMaNV(manv);
		maNVON = manv;
		pnlRight = new JPanel();

		pnlRight.setLayout(new BoxLayout(pnlRight, BoxLayout.Y_AXIS));
		pnlRight.setBorder(BorderFactory.createDashedBorder(Color.DARK_GRAY));
		pnlRight.setPreferredSize(new Dimension(700, 300));
		lblFont = new Font("Arial", Font.BOLD, 20);

		lblTT = new JLabel("Thông tin nhân viên");
		lblTT.setForeground(new Color(168, 80, 28));
		lblTT.setFont(new Font("Arial", Font.BOLD, 40));
		lblTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTT.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTT.setMaximumSize(new Dimension(Integer.MAX_VALUE, lblTT.getPreferredSize().height));

		lblMaNVshow = new JLabel("Mã nhân viên:  " + nvON.getMaNV());
		lblMaNVshow.setFont(lblFont);
		lblMaNVshow.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaNVshow.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblMaNVshow.setMaximumSize(new Dimension(Integer.MAX_VALUE, lblMaNVshow.getPreferredSize().height));

		lblTenNVshow = new JLabel("Tên nhân viên:  " + nvON.getTenNV());
		lblTenNVshow.setFont(lblFont);
		lblTenNVshow.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNVshow.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTenNVshow.setMaximumSize(new Dimension(Integer.MAX_VALUE, lblTenNVshow.getPreferredSize().height));

		lblSdtNVshow = new JLabel("SDT nhân viên:  " + nvON.getSdt());
		lblSdtNVshow.setFont(lblFont);
		lblSdtNVshow.setHorizontalAlignment(SwingConstants.CENTER);
		lblSdtNVshow.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSdtNVshow.setMaximumSize(new Dimension(Integer.MAX_VALUE, lblSdtNVshow.getPreferredSize().height));

		lblNgaySinhNVshow = new JLabel("Ngày sinh nhân viên:  " + outputFormat.format(nvON.getNgaysinh()));
		lblNgaySinhNVshow.setFont(lblFont);
		lblNgaySinhNVshow.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgaySinhNVshow.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNgaySinhNVshow.setMaximumSize(new Dimension(Integer.MAX_VALUE, lblNgaySinhNVshow.getPreferredSize().height));

		lblEmailNVshow = new JLabel("Email nhân viên:  " + nvON.getEmail());
		lblEmailNVshow.setFont(lblFont);
		lblEmailNVshow.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmailNVshow.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblEmailNVshow.setMaximumSize(new Dimension(Integer.MAX_VALUE, lblEmailNVshow.getPreferredSize().height));

		pnlRight.add(lblTT);
		pnlRight.add(Box.createVerticalStrut(20));
		pnlRight.add(lblMaNVshow);
		pnlRight.add(Box.createVerticalStrut(20));
		pnlRight.add(lblTenNVshow);
		pnlRight.add(Box.createVerticalStrut(20));
		pnlRight.add(lblMaNVshow);
		pnlRight.add(Box.createVerticalStrut(20));
		pnlRight.add(lblSdtNVshow);
		pnlRight.add(Box.createVerticalStrut(20));
		pnlRight.add(lblEmailNVshow);
		pnlRight.add(Box.createVerticalStrut(20));
		pnlRight.add(lblNgaySinhNVshow);

		Font lblFont = new Font("Arial", Font.BOLD, 20);

		pnlLeft = new JPanel();
		pnlLeft.setLayout(new BoxLayout(pnlLeft, BoxLayout.Y_AXIS));
		pnlLeft.setPreferredSize(new Dimension(700, 300));
		Dimension textFieldSize = new Dimension(300, 40);

		lblCNTT = new JLabel("Cập nhật thông tin nhân viên");
		lblCNTT.setForeground(new Color(168, 80, 28));
		lblCNTT.setFont(new Font("Arial", Font.BOLD, 30));
		lblCNTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblCNTT.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblCNTT.setMaximumSize(new Dimension(Integer.MAX_VALUE, lblCNTT.getPreferredSize().height));

		BoxTT = new Box(BoxLayout.X_AXIS);
		BoxTT.add(lblCNTT);

		lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(lblFont);
		txtTenNV = new JTextField(nvON.getTenNV());
		txtTenNV.setFont(lblFont);
		txtTenNV.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		txtTenNV.setPreferredSize(textFieldSize);

		Box0 = new Box(BoxLayout.X_AXIS);
		Box0.add(lblTenNV);
		Box0.add(Box.createHorizontalStrut(20));
		Box0.add(txtTenNV);

		lblSdtNV = new JLabel("Số điện thoại:");
		lblSdtNV.setFont(lblFont);
		txtSdtNV = new JTextField(nvON.getSdt());
		txtSdtNV.setFont(lblFont);
		txtSdtNV.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		txtSdtNV.setPreferredSize(textFieldSize);

		Box1 = new Box(BoxLayout.X_AXIS);
		Box1.add(lblSdtNV);
		Box1.add(Box.createHorizontalStrut(20));
		Box1.add(txtSdtNV);

		lblNgaySinhNV = new JLabel("Ngày sinh:");
		lblNgaySinhNV.setFont(lblFont);
		txtNgaySinhNV = new JTextField(outputFormat.format(nvON.getNgaysinh()));
		txtNgaySinhNV.setFont(lblFont);
		txtNgaySinhNV.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
		txtNgaySinhNV.setPreferredSize(textFieldSize);

		Box2 = new Box(BoxLayout.X_AXIS);
		Box2.add(lblNgaySinhNV);
		Box2.add(Box.createHorizontalStrut(20));
		Box2.add(txtNgaySinhNV);

		lblEmailNV = new JLabel("Email:");
		lblEmailNV.setFont(lblFont);
		txtEmailNV = new JTextField(nvON.getEmail());
		txtEmailNV.setFont(lblFont);
		txtEmailNV.setMaximumSize(new Dimension(580, 40));

		Box3 = new Box(BoxLayout.X_AXIS);
		Box3.add(lblEmailNV);
		Box3.add(Box.createHorizontalStrut(20));
		Box3.add(txtEmailNV);

		btnXoaTrang = new JButton("Xóa trắng");
		btnSua = new JButton("Sửa thông tin");

		btnXoaTrang.setMaximumSize(new Dimension(Short.MAX_VALUE, btnXoaTrang.getPreferredSize().height));
		btnSua.setMaximumSize(new Dimension(Short.MAX_VALUE, btnSua.getPreferredSize().height));

		btnXoaTrang.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnSua.setAlignmentX(Component.CENTER_ALIGNMENT);

		pnlBtn = new JPanel();
		pnlBtn.setLayout(new BoxLayout(pnlBtn, BoxLayout.X_AXIS));
		pnlBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnlBtn.add(btnXoaTrang);
		pnlBtn.add(Box.createHorizontalStrut(20));
		pnlBtn.add(btnSua);

		pnlLeft.add(BoxTT);
		pnlLeft.add(Box.createVerticalStrut(20));
		pnlLeft.add(Box0);
		pnlLeft.add(Box.createVerticalStrut(20));
		pnlLeft.add(Box1);
		pnlLeft.add(Box.createVerticalStrut(20));
		pnlLeft.add(Box2);
		pnlLeft.add(Box.createVerticalStrut(20));
		pnlLeft.add(Box3);
		pnlLeft.add(Box.createVerticalStrut(20));
		pnlLeft.add(pnlBtn);

		pnlLeft.setMaximumSize(pnlLeft.getPreferredSize());
		pnlRight.setMaximumSize(pnlRight.getPreferredSize());

		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		mainPanel.add(Box.createHorizontalGlue());
		mainPanel.add(pnlLeft);
		mainPanel.add(Box.createHorizontalStrut(20)); // Khoảng cách giữa hai panel
		mainPanel.add(pnlRight);
		mainPanel.add(Box.createHorizontalGlue());

		btnSua.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		setLayout(new BorderLayout());
		add(mainPanel, BorderLayout.CENTER);
		setVisible(true);
	}

	public void suaThongTinNhanVien() {
		String tennv = txtTenNV.getText();
		String sdt = txtSdtNV.getText();
		String ngaySinh = txtNgaySinhNV.getText();
		String email = txtEmailNV.getText();

		String hoTenRegex = "^[\\p{L}\\p{M}\\s]+$";
		if ((tennv == null) || !tennv.matches(hoTenRegex)) {
			JOptionPane.showMessageDialog(null, "tên nhân viên không được rỗng, phải đúng định dạng, không có số");
			txtTenNV.requestFocus();
			return;
		}

		String sdtRegex = "0[3589]\\d{8}";
		if ((sdt == null) || !sdt.matches(sdtRegex)) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được rỗng, phải đúng định dạng");
			txtSdtNV.requestFocus();
			return;
		}

		String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
		if ((email == null) || !email.matches(emailRegex)) {
			JOptionPane.showMessageDialog(null, "Email không được rỗng, phải đúng định dạng");
			txtEmailNV.requestFocus();
			return;
		}

		String ngaySinhRegex = "\\d{2}/\\d{2}/\\d{4}";
		if ((ngaySinh == null) || !ngaySinh.matches(ngaySinhRegex)) {
			JOptionPane.showMessageDialog(null, "Ngày sinh không được rỗng, phải đúng định dạng dd/mm/yyyy");
			txtNgaySinhNV.requestFocus();
			return;
		}

		LocalDate dateBorn = LocalDate.parse(ngaySinh, formatter);

		NhanVien nvNew = new NhanVien(nvON.getMaNV(), tennv, sdt, dateBorn, email, nvON.getMatkhau());
		if (!dao.suaNhanVienTheoMa(nvNew)) {
			JOptionPane.showConfirmDialog(null, "Dữ liệu lỗi không thể sửa nhân viên");
			return;
		} else {
			JOptionPane.showMessageDialog(null, "Sửa thông tin thành công!");
		}
	}

	public void loadLaiThongTinNhanVien() {
		lblMaNVshow.setText("Mã nhân viên: " + nvON.getMaNV());
		lblTenNVshow.setText("Tên nhân viên: " + nvON.getTenNV());
		lblNgaySinhNVshow.setText("Ngày sinh nhân viên: " + formatter.format(nvON.getNgaysinh()));
		lblSdtNVshow.setText("SDT nhân viên: " + nvON.getSdt());
		lblEmailNVshow.setText("Email nhân viên: " + nvON.getEmail());
	}

	public void xoaTrang() {
		txtTenNV.setText("");
		txtSdtNV.setText("");
		txtNgaySinhNV.setText("");
		txtEmailNV.setText("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSua) {
			suaThongTinNhanVien();
			nvON = dao.getNhanVienByMaNV(maNVON);
			loadLaiThongTinNhanVien();

		} else if (e.getSource() == btnXoaTrang) {
			xoaTrang();
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}