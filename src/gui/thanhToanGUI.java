package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.DanhSachChiTietDonHang;
import controller.DanhSachDonHang;
import model.ChiTietDonHang;
import model.DonHang;
import model.NhanVien;
import util.LookAndFeelConfig;
import util.MaDonHangGenerator;

public class thanhToanGUI extends JFrame implements ActionListener {
	private JPanel pnlNorth;
	private JLabel lblTitle;
	private JLabel lblSdt;
	private JTextField txtSdt;
	private Dimension lblsize;
	private Dimension txtsize;
	private Box Box0;
	private JLabel lblTenKH;
	private JTextField txtTenKH;
	private JLabel lblMaNV;
	private JTextField txtMaNV;
	private Box Box1;
	private Box Box2;
	private Box BoxTitle;
	private DefaultTableModel tblModel;
	private JTable tbl;
	private JScrollPane scrollTable;
	private JPanel pnlCenterDown;
	private JLabel lblTong;
	private JTextField txtTong;
	private JLabel lblLoaiKH;
	private JTextField txtLoaiKH;
	private Box Box3;
	private JPanel pnlSouth;
	private JButton btnXacNhan;
	private JButton btnHuyDon;
	static DanhSachChiTietDonHang listChiTietDonHang = new DanhSachChiTietDonHang();
	static DonHang dh;
	static MaDonHangGenerator genMa = new MaDonHangGenerator();
	static DanhSachDonHang listDonHang = new DanhSachDonHang();
	static NhanVien nvOn;

	public thanhToanGUI() {
		setTitle("Thanh Toán");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		LookAndFeelConfig.applyLookAndFeel();

		pnlNorth = new JPanel();
		pnlNorth.setLayout(new BoxLayout(pnlNorth, BoxLayout.Y_AXIS));
		add(pnlNorth, BorderLayout.NORTH);

		lblTitle = new JLabel("Lập Hóa Đơn Thanh Toán");
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));

		lblsize = new Dimension(150, 25);
		txtsize = new Dimension(200, 25);

		lblSdt = new JLabel("Số Điện thoại khách hàng:");
		lblSdt.setMaximumSize(lblsize);
		txtSdt = new JTextField(10);
		txtSdt.setMaximumSize(txtsize);

		lblTenKH = new JLabel("Tên khách hàng:");
		lblTenKH.setMaximumSize(lblsize);
		txtTenKH = new JTextField(10);
		txtTenKH.setMaximumSize(txtsize);
		txtTenKH.setEditable(false);

		lblLoaiKH = new JLabel("Loại khách hàng:");
		lblLoaiKH.setMaximumSize(lblsize);
		txtLoaiKH = new JTextField(10);
		txtLoaiKH.setMaximumSize(txtsize);
		txtLoaiKH.setEditable(false);

		lblMaNV = new JLabel("Mã nhân viên đứng ca:");
		lblMaNV.setMaximumSize(lblsize);
		txtMaNV = new JTextField(10);
		txtMaNV.setMaximumSize(txtsize);
		txtMaNV.setEditable(false);

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

		Box2 = new Box(BoxLayout.X_AXIS);
		Box2.add(lblLoaiKH);
		Box2.add(Box.createHorizontalStrut(10));
		Box2.add(txtLoaiKH);
		Box2.add(Box.createHorizontalStrut(10));

		Box3 = new Box(BoxLayout.X_AXIS);
		Box3.add(lblMaNV);
		Box3.add(Box.createHorizontalStrut(10));
		Box3.add(txtMaNV);
		Box3.add(Box.createHorizontalStrut(10));

		pnlNorth.add(BoxTitle);
		pnlNorth.add(Box.createVerticalStrut(15));
		pnlNorth.add(Box0);
		pnlNorth.add(Box.createVerticalStrut(15));
		pnlNorth.add(Box1);
		pnlNorth.add(Box.createVerticalStrut(15));
		pnlNorth.add(Box2);
		pnlNorth.add(Box.createVerticalStrut(15));
		pnlNorth.add(Box3);
		pnlNorth.add(Box.createVerticalStrut(15));

		Object[] colsTable = { "Mã nước", "Tên Nước", "Giá Nước", "Số lượng", "Thành tiền" };
		tblModel = new DefaultTableModel(colsTable, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Tắt chỉnh sửa cho tất cả các ô
			}
		};
		tbl = new JTable(tblModel);
		scrollTable = new JScrollPane(tbl);
		add(scrollTable, BorderLayout.CENTER);

		pnlCenterDown = new JPanel();
		lblTong = new JLabel("Tổng hóa đơn:");
		lblTong.setMaximumSize(lblsize);
		txtTong = new JTextField(10);
		txtTong.setMaximumSize(txtsize);
		txtTong.setEditable(false);
		pnlCenterDown.add(lblTong);
		pnlCenterDown.add(txtTong);
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollTable, pnlCenterDown);
		splitPane.setResizeWeight(0.8);
		add(splitPane, BorderLayout.CENTER);

		pnlSouth = new JPanel();
		btnXacNhan = new JButton("Xác nhận");
		btnHuyDon = new JButton("Hủy đơn");

		pnlSouth.add(btnXacNhan);
		pnlSouth.add(btnHuyDon);
		add(pnlSouth, BorderLayout.SOUTH);

		btnXacNhan.addActionListener(this);
		setVisible(false);
	}

	public void visibleTrue() {
		setVisible(true);
	}

	public void visibleFalse() {
		setVisible(false);
	}

	public void loadulieulenJFrameThanhToan(DefaultTableModel tblmodel, DanhSachChiTietDonHang list, NhanVien nv) {
		tblModel.setRowCount(0);
		listChiTietDonHang = null;
		nvOn = null;
		for (int i = 0; i < tblmodel.getRowCount(); i++) {
			Object[] rowNewData = new Object[tblmodel.getColumnCount()];
			for (int j = 0; j < tblmodel.getColumnCount(); j++) {
				rowNewData[j] = tblmodel.getValueAt(i, j);
			}
			tblModel.addRow(rowNewData);
		}
		listChiTietDonHang = list;
		nvOn = nv;
		txtMaNV.setText(nvOn.getMaNV());
	}

	public void setTongTienThanhToan(String tong) {
		txtTong.setText(tong);
	}

	public void taoDonHang() {
		LocalDate ngaydat = LocalDate.now();
		String MaDH = genMa.taoMaDH("A001");
		for (ChiTietDonHang ct : listChiTietDonHang.getList()) {
			ct.setMaDH(MaDH);
		}
		dh = new DonHang(MaDH, "A001", nvOn.getMaNV(), ngaydat, listChiTietDonHang, listChiTietDonHang.tongTien());
		if (listDonHang.themDH(dh)) {
			System.out.println(listDonHang.xuat());
			JOptionPane.showMessageDialog(null, "Thanh toán thành công!");
			this.visibleFalse();
			return;
		} else {
			JOptionPane.showMessageDialog(null, "Thanh toán không thành công!");
			return;
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnXacNhan) {
			taoDonHang();
		}

	}

}
