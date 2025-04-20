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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
	
	public crudNhanVien() {
		this.setSize(800, 600);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		
		LookAndFeelConfig.applyLookAndFeel();
		
		pnlNorth = new JPanel();
		pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));
		this.add(pnlNorth, BorderLayout.NORTH);
		lblTitle = new JLabel("CRUD nhân viên");
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
		this.add(scrollTable, BorderLayout.CENTER);

		btnThem = new JButton("Thêm");
		btnXoa = new JButton("Xóa");
		btnSua = new JButton("Sửa");
		pnlWest = new JPanel();
		pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
		pnlWest.add(btnThem);
		pnlWest.add(btnXoa);
		pnlWest.add(btnSua);
		this.add(pnlWest, BorderLayout.WEST);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

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
