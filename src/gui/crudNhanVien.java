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
import resource.LookAndFeelConfig;
import resource.txtSource;

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

	public crudNhanVien() {
		this.setSize(800, 600);
		this.setVisible(true);
		this.setLayout(new BorderLayout());

		LookAndFeelConfig.applyLookAndFeel();

		pnlNorth = new JPanel();
		pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));
		this.add(pnlNorth, BorderLayout.NORTH);
		lblTitle = new JLabel("Danh sách nhân viên");
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

		Object[] colsTable = { "Mã NV", "Họ tên", "SDT", "Ngày sinh", "Email", "Mật khẩu" };
		tblModel = new DefaultTableModel(colsTable, 0);
		tbl = new JTable();
		tbl.setModel(tblModel);
		scrollTable = new JScrollPane(tbl);
		tbl.setDefaultEditor(Object.class, null);
		this.add(scrollTable, BorderLayout.CENTER);

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
		loadDSLenTable();
	}

	public void loadDSLenTable() {
		list = dao.layDanhSachNhanVien();
		if (list == null) {
			JOptionPane.showMessageDialog(null, "Lấy danh sách nhân viên không thành công");
			return;
		}

		for (NhanVien nv : list.getList()) {
			Object[] row = new Object[6];
			row[0] = nv.getMaNV();
			row[1] = nv.getTenNV();
			row[2] = nv.getSdt();
			row[3] = nv.getNgaysinh();
			row[4] = nv.getEmail();
			row[5] = nv.getMatkhau();
			tblModel.addRow(row); // Thêm dòng vào bảng
		}
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
		try {

			list.addList(nvNew);
			Object[] row = new Object[6];
			row[0] = nvNew.getMaNV();
			row[1] = nvNew.getTenNV();
			row[2] = nvNew.getSdt();
			row[3] = nvNew.getNgaysinh();
			row[4] = nvNew.getEmail();
			row[5] = nvNew.getMatkhau();
			tblModel.addRow(row);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi không thêm được dữ liệu");
		}
		if (!dao.themNhanVienVaodb(nvNew)) {
			JOptionPane.showConfirmDialog(null, "Dữ liệu lỗi không thể thêm vào database");
			return;
		}
	}

	public void xoaNhanVien() {
		int rowSelected = tbl.getSelectedRow();
		String manv = tbl.getValueAt(rowSelected, 0).toString();
		if (rowSelected != -1) {
			int confirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên "+manv+" không?",
					"Xác nhận xóa", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if (confirm == JOptionPane.YES_OPTION) {
				tblModel.removeRow(rowSelected);
				if (!list.removeNV(manv)) {
					JOptionPane.showMessageDialog(null, "lỗi không tìm thấy nhân viên trong list");
					return;
				}
				if (!dao.xoaNhanVienKhoidb(manv)) {
					JOptionPane.showMessageDialog(null, "lỗi không tìm thấy nhân viên trong database");
					return;
				}
				JOptionPane.showMessageDialog(null, "Xóa thành công nhân viên có mã là: " + manv);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên để xóa");
			return;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnThem) {
			themNhanVien();
		} else if (e.getSource() == btnXoa) {
			xoaNhanVien();
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
