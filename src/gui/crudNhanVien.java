package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DanhSachNhanVien;
import dao.NhanVienDAO;
import model.NhanVien;
import util.LookAndFeelConfig;
import util.txtSource;

public class crudNhanVien extends JPanel implements ActionListener, FocusListener {

	private JPanel pnlNorth;
	private JLabel lblTitle;
	private Box Box1;
	private Box Box2;
	private Box Box3;
	private JLabel lblMaNV;
	private JTextField txtMaNV;
	private Box Box0;
	private JLabel lblHotenNV;
	private JLabel lblSdt;
	private JLabel lblNgaySinh;
	private JLabel lblEmail;
	private JLabel lblMatkhau;
	private JTextField txtHotenNV;
	private JTextField txtSdt;
	private JTextField txtNgaySinh;
	private JTextField txtEmail;
	private JTextField txtMatkhau;
	private DefaultTableModel tblModel;
	private JTable tbl;
	private JScrollPane scrollTable;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JPanel pnlWest;
	txtSource txtHelper = new txtSource();
	static DanhSachNhanVien list = new DanhSachNhanVien();
	NhanVienDAO dao = new NhanVienDAO();
	NhanVien nvON;
	private JPanel pnlCenter;
	private JLabel lblma;
	private JLabel lblten;
	private JLabel lblsdt;
	private JLabel lblngaysinh;
	private JLabel lblemail;
	private JLabel lblmatkhau;
	private JTextField txtten;
	private JTextField txtma;
	private JTextField txtsdt;
	private JTextField txtngaysinh;
	private JTextField txtemail;
	private JTextField txtmatkhau;
	private Box Box4;
	private Box Box5;
	private Box Box6;
	private Dimension txtSizeShowInFor;

	public crudNhanVien(String manv) {
		this.setSize(800, 600);
		this.setVisible(true);
		this.setLayout(new BorderLayout());

		LookAndFeelConfig.applyLookAndFeel();
		nvON = dao.getNhanVienByMaNV(manv);

		pnlNorth = new JPanel();
		pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));
		this.add(pnlNorth, BorderLayout.NORTH);
		lblTitle = new JLabel("Thông tin nhân viên");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25)); // Đặt font và cỡ chữ
		lblTitle.setForeground(Color.BLUE); // Đặt màu chữ
		lblTitle.setAlignmentX(CENTER_ALIGNMENT);

		Box0 = new Box(BoxLayout.X_AXIS);
		Box1 = new Box(BoxLayout.X_AXIS);
		Box2 = new Box(BoxLayout.X_AXIS);
		Box3 = new Box(BoxLayout.X_AXIS);

		Box0.add(lblTitle);
		lblMaNV = new JLabel("Mã nhân viên:");
		lblHotenNV = new JLabel("Họ tên nhân viên:");
		lblSdt = new JLabel("Số điện thoại:");
		lblNgaySinh = new JLabel("Ngày sinh:");
		lblEmail = new JLabel("Email:");
		lblMatkhau = new JLabel("Mật khẩu:");

		Dimension lblSize = new Dimension(100, 25);
		lblMaNV.setPreferredSize(lblSize);
		lblHotenNV.setPreferredSize(lblSize);
		lblSdt.setPreferredSize(lblSize);
		lblNgaySinh.setPreferredSize(lblSize);
		lblEmail.setPreferredSize(lblSize);
		lblMatkhau.setPreferredSize(lblSize);

		txtMaNV = new JTextField(10);
		txtHelper.addPlaceholder(txtMaNV, "Đúng định dạng U001");
		txtHotenNV = new JTextField(10);
		txtHelper.addPlaceholder(txtHotenNV, "Không được có số");
		txtSdt = new JTextField(10);
		txtHelper.addPlaceholder(txtSdt, "Đúng định dạng 10 số");
		txtNgaySinh = new JTextField(10);
		txtHelper.addPlaceholder(txtNgaySinh, "Đúng định dạng dd/mm/yyyy");
		txtEmail = new JTextField(10);
		txtHelper.addPlaceholder(txtEmail, "Đúng định dạng user@gmail.com");
		txtMatkhau = new JTextField(10);
		txtHelper.addPlaceholder(txtMatkhau, "Đúng định dạng 1 hoa, 1 số, 1 thường");

		Dimension txtSize = new Dimension(120, 25);
		txtMaNV.setPreferredSize(txtSize);
		txtHotenNV.setPreferredSize(txtSize);
		txtSdt.setPreferredSize(txtSize);
		txtNgaySinh.setPreferredSize(txtSize);
		txtEmail.setPreferredSize(txtSize);
		txtMatkhau.setPreferredSize(txtSize);

		Box1.add(lblMaNV);
		Box1.add(txtMaNV);
		Box1.add(Box.createHorizontalStrut(10));
		Box1.add(lblHotenNV);
		Box1.add(Box.createHorizontalStrut(10));
		Box1.add(txtHotenNV);

		Box2.add(lblSdt);
		Box2.add(txtSdt);
		Box2.add(Box.createHorizontalStrut(10));
		Box2.add(lblNgaySinh);
		Box2.add(Box.createHorizontalStrut(10));
		Box2.add(txtNgaySinh);

		Box3.add(lblEmail);
		Box3.add(txtEmail);
		Box3.add(Box.createHorizontalStrut(10));
		Box3.add(lblMatkhau);
		Box3.add(Box.createHorizontalStrut(10));
		Box3.add(txtMatkhau);

		pnlNorth.add(Box0);
		pnlNorth.add(Box.createVerticalStrut(10));
		pnlNorth.add(Box1);
		pnlNorth.add(Box.createVerticalStrut(10));
		pnlNorth.add(Box2);
		pnlNorth.add(Box.createVerticalStrut(10));
		pnlNorth.add(Box3);
		pnlNorth.add(Box.createVerticalStrut(10));

		pnlCenter = new JPanel();
		pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.Y_AXIS));
		this.add(pnlCenter,BorderLayout.CENTER);
		lblma = new JLabel("Mã nhân viên:");
		lblten = new JLabel("Tên nhân viên:");
		lblsdt = new JLabel("SDT nhân viên:");
		lblngaysinh = new JLabel("Ngày sinh nhân viên:");
		lblemail = new JLabel("Email nhân viên:");
		lblmatkhau = new JLabel("Mật khẩu nhân viên:");
		
		lblma.setPreferredSize(lblSize);
		lblten.setPreferredSize(lblSize);
		lblsdt.setPreferredSize(lblSize);
		lblngaysinh.setPreferredSize(lblSize);
		lblemail.setPreferredSize(lblSize);
		lblmatkhau.setPreferredSize(lblSize);

		txtma = new JTextField(10);
		txtten = new JTextField(10);
		txtsdt = new JTextField(10);
		txtngaysinh = new JTextField(10);
		txtemail = new JTextField(10);
		txtmatkhau = new JTextField(10);
		
		txtSizeShowInFor = new Dimension(200,25);
		txtma.setMaximumSize(txtSizeShowInFor);
		txtten.setMaximumSize(txtSizeShowInFor);
		txtsdt.setMaximumSize(txtSizeShowInFor);
		txtngaysinh.setMaximumSize(txtSizeShowInFor);
		txtemail.setMaximumSize(txtSizeShowInFor);
		txtmatkhau.setMaximumSize(txtSizeShowInFor);

		Box4 = new Box(BoxLayout.X_AXIS);
		Box4.setMaximumSize(new Dimension(getWidth(),30));
		Box5 = new Box(BoxLayout.X_AXIS);
		Box5.setMaximumSize(new Dimension(getWidth(),30));
		Box6 = new Box(BoxLayout.X_AXIS);
		Box6.setMaximumSize(new Dimension(getWidth(),30));

		Box4.add(lblma);
		Box4.add(Box.createHorizontalStrut(10));
		Box4.add(txtma);
		Box4.add(Box.createHorizontalStrut(10));
		Box4.add(lblten);
		Box4.add(Box.createHorizontalStrut(10));
		Box4.add(txtten);

		Box5.add(lblsdt);
		Box5.add(Box.createHorizontalStrut(10));
		Box5.add(txtsdt);
		Box5.add(Box.createHorizontalStrut(10));
		Box5.add(lblngaysinh);
		Box5.add(Box.createHorizontalStrut(10));
		Box5.add(txtngaysinh);

		Box6.add(lblemail);
		Box6.add(Box.createHorizontalStrut(10));
		Box6.add(txtemail);
		Box6.add(Box.createHorizontalStrut(10));
		Box6.add(lblmatkhau);
		Box6.add(Box.createHorizontalStrut(10));
		Box6.add(txtmatkhau);

		pnlCenter.add(Box.createVerticalStrut(100));
		pnlCenter.add(Box4);
		pnlCenter.add(Box.createVerticalStrut(10));
		pnlCenter.add(Box5);
		pnlCenter.add(Box.createVerticalStrut(10));
		pnlCenter.add(Box6);
		pnlCenter.add(Box.createVerticalStrut(10));
		
		btnThem = new JButton("Thêm");
		btnXoa = new JButton("Xóa");
		btnSua = new JButton("Sửa");

		Dimension btnSize = new Dimension(200, 50);
		btnThem.setMaximumSize(btnSize);
		btnSua.setMaximumSize(btnSize);
		btnXoa.setMaximumSize(btnSize);

		pnlWest = new JPanel();
		pnlWest.setPreferredSize(new Dimension(150, 0));
		pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnThem);
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnXoa);
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnSua);
		pnlWest.add(Box.createVerticalStrut(30));
		this.add(pnlWest, BorderLayout.WEST);

		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
//		loadDSLenTable();
	}

	public void themNhanVien() {
		String manv = txtMaNV.getText();
		String tennv = txtHotenNV.getText();
		String sdt = txtSdt.getText();
		String ngaySinh = txtNgaySinh.getText();
		String email = txtEmail.getText();
		String matKhau = txtMatkhau.getText();

		String ngaySinhRegex = "\\d{2}/\\d{2}/\\d{4}";
		if ((ngaySinh == null) || !ngaySinh.matches(ngaySinhRegex)) {
			JOptionPane.showMessageDialog(null, "Ngày sinh không được rỗng, phải đúng định dạng");
			return;
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateBorn = LocalDate.parse(ngaySinh, formatter);

		String manvRegex = "NV\\d{3}";
		if (!list.checktrungma(manv) || manv == null || !manv.matches(manvRegex)) {
			JOptionPane.showMessageDialog(null, "Không được trùng mã, không được rỗng, phải đúng định dạng");
			return;
		}

		String hoTenRegex = "^[\\p{L}\\p{M}\\s]+$";
		if ((tennv == null) || !tennv.matches(hoTenRegex)) {
			JOptionPane.showMessageDialog(null, "tên nhân viên không được rỗng, phải đúng định dạng, không có số");
			return;
		}

		String sdtRegex = "0[3589]\\d{8}";
		if ((sdt == null) || !sdt.matches(sdtRegex)) {
			JOptionPane.showMessageDialog(null, "Số điện thoại không được rỗng, phải đúng định dạng");
			return;
		}

		String emailRegex = "^[a-zA-Z0-9._%+-]+@gmail\\.com$";
		if ((email == null) || !email.matches(emailRegex)) {
			JOptionPane.showMessageDialog(null, "Email không được rỗng, phải đúng định dạng");
			return;
		}

		String matkhauRegex = "";
		if (matKhau == null) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không được rỗng, phải đúng định dạng");
			return;
		}

		NhanVien nvNew = new NhanVien(manv, tennv, sdt, dateBorn, email, matKhau);
		if (!dao.themNhanVienVaodb(nvNew)) {
			JOptionPane.showConfirmDialog(null, "Dữ liệu lỗi không thể thêm vào database");
			return;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnThem) {
			themNhanVien();
		} else if (e.getSource() == btnXoa) {

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