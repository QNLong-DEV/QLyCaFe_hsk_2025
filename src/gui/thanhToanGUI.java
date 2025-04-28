package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.DanhSachChiTietDonHang;
import controller.DanhSachDonHang;
import controller.DanhSachKhachHang;
import controller.DanhSachNuoc;
import dao.ChiTietDonHangDAO;
import dao.DonHangDAO;
import dao.KhachHangDAO;
import model.ChiTietDonHang;
import model.DonHang;
import model.KhachHang;
import model.NhanVien;
import model.Nuoc;
import util.LookAndFeelConfig;
import util.MaDonHangGenerator;
import util.MaKhachHangGenerator;
import util.XuatPDF;

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
	private JButton btnTim;

	static DanhSachChiTietDonHang listChiTietDonHang = new DanhSachChiTietDonHang();
	static DonHang dh;
	static MaDonHangGenerator genMaDH = new MaDonHangGenerator();
	static MaKhachHangGenerator genMaKH = new MaKhachHangGenerator();
	static DanhSachDonHang listDonHang = new DanhSachDonHang();
	static DanhSachKhachHang listKhachHang = new DanhSachKhachHang();
	static KhachHangDAO khachhangdao = new KhachHangDAO();
	static DonHangDAO donhangdao = new DonHangDAO();
	static ChiTietDonHangDAO chitietdonhangdao = new ChiTietDonHangDAO();
	static DanhSachNuoc listnc = new DanhSachNuoc();
	static String maDH;
	static KhachHang khON;
	static NhanVien nvOn;

	private String madhvanglai;
	private String maKHVangLai;
	private String tenKHVangLai;
	private JButton btnTaoDonVangLai;
	private static String sdtKHVangLai = "xxx";
	DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	DecimalFormat decimalFormat = new DecimalFormat("###,###");

	public thanhToanGUI() {
		listKhachHang = khachhangdao.getALLKhachHang();
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
		lblTitle.setMaximumSize(new Dimension(Integer.MAX_VALUE, lblTitle.getPreferredSize().height));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

		lblsize = new Dimension(150, 25);
		txtsize = new Dimension(200, 25);

		lblSdt = new JLabel("Số Điện thoại khách hàng:");
		lblSdt.setMaximumSize(lblsize);
		txtSdt = new JTextField(10);
		txtSdt.setMaximumSize(txtsize);
		btnTim = new JButton("Tìm");
		btnTaoDonVangLai = new JButton("Tạo đơn hàng vãng lai");

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
		Box0.add(Box.createHorizontalStrut(20));
		Box0.add(txtSdt);
		Box0.add(Box.createHorizontalStrut(10));
		Box0.add(btnTim);
		Box0.add(Box.createHorizontalStrut(10));
		Box0.add(btnTaoDonVangLai);
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
		btnHuyDon.addActionListener(this);
		btnTim.addActionListener(this);
		btnTaoDonVangLai.addActionListener(this);
		setVisible(false);
	}

	public void visibleTrue() {
		setVisible(true);
	}

	public void visibleFalse() {
		setVisible(false);
	}

	public void loadulieulenJFrameThanhToan(DefaultTableModel tblmodel, DanhSachChiTietDonHang list, NhanVien nv,
			DanhSachNuoc listnc) {
		thanhToanGUI.listnc = listnc;
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

	public void napDonHangVangLai() {
		KhachHang khVangLai = khachhangdao.timTheoMaKH("VL01");
		double tongtien = listChiTietDonHang.tongTien("Vãng lai");
		maKHVangLai = "VL01";
		tenKHVangLai = khVangLai.getTenKH();
		sdtKHVangLai = khVangLai.getSdt();
		txtSdt.setText(sdtKHVangLai);
		txtTenKH.setText(tenKHVangLai);
		txtLoaiKH.setText("Vãng lai");
		txtTong.setText(decimalFormat.format(tongtien));
	}

	public void taoDonHangVangLai() {
		madhvanglai = genMaDH.taoMaDHVangLai();
		for (ChiTietDonHang ct : listChiTietDonHang.getList()) {
			ct.setMaDH(madhvanglai);
		}
		dh = new DonHang(madhvanglai, maKHVangLai, nvOn.getMaNV(), "Vãng lai", LocalDateTime.now(), listChiTietDonHang,
				listChiTietDonHang.tongTien("Vãng lai"));

		donhangdao.saveDonHang(dh);
		for (ChiTietDonHang ct : listChiTietDonHang.getList()) {
			chitietdonhangdao.saveChiTietDonHang(ct);
		}
		JOptionPane.showMessageDialog(null, "Thanh toán vãng lai thành công!");

	}

	public void napThongTinKhachHang(KhachHang kh) {
		khON = kh;
		txtTenKH.setText(kh.getTenKH());
		txtSdt.setText(kh.getSdt());
		txtLoaiKH.setText(kh.getLoaiKH());
	}

	public void napThongTinDonHang() {
		String sdt = txtSdt.getText();
		khON = khachhangdao.timTheoSDT(sdt);
		if (khON != null) {
			double tongtien = listChiTietDonHang.tongTien(khON.getLoaiKH());
			for (ChiTietDonHang ct : listChiTietDonHang.getList()) {
				ct.setMaDH(khON.getMaKH());
			}
			txtTenKH.setText(khON.getTenKH());
			txtLoaiKH.setText(khON.getLoaiKH());
			txtTong.setText(decimalFormat.format(tongtien));
		} else {
			int response = JOptionPane.showConfirmDialog(null,
					"Khách hàng chưa có hội viên! Bạn có muốn tạo hội viên cho khách hàng?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (response == JOptionPane.YES_OPTION) {
				taoTaiKhoanKHGUI taoForm = new taoTaiKhoanKHGUI(this, this);
				double tongtien = listChiTietDonHang.tongTien(khON.getLoaiKH());
				for (ChiTietDonHang ct : listChiTietDonHang.getList()) {
					ct.setMaDH(khON.getMaKH());
				}
				txtSdt.setText(khON.getSdt());
				txtTenKH.setText(khON.getTenKH());
				txtLoaiKH.setText(khON.getLoaiKH());
				txtTong.setText(decimalFormat.format(tongtien));
				System.out.println("tạo tài khoản");
			} else {
				return;
			}
		}
	}

	public void taoDonHangHoiVien() {
		maDH = genMaDH.taoMaDH(khON.getMaKH());
		for (ChiTietDonHang ct : listChiTietDonHang.getList()) {
			ct.setMaDH(maDH);
		}
		dh = new DonHang(maDH, khON.getMaKH(), nvOn.getMaNV(), khON.getLoaiKH(), LocalDateTime.now(),
				listChiTietDonHang, listChiTietDonHang.tongTien(khON.getLoaiKH()));
		donhangdao.saveDonHang(dh);
		for (ChiTietDonHang ct : listChiTietDonHang.getList()) {
			chitietdonhangdao.saveChiTietDonHang(ct);
		}
		JOptionPane.showMessageDialog(null, "Thanh toán hội viên thành công!");
	}

	public String xuatHoaDonVangLai() {
		StringBuilder hoaDon = new StringBuilder();

		hoaDon.append("----- HÓA ĐƠN -----\n");
		hoaDon.append("Mã Đơn Hàng: ").append(madhvanglai).append("\n");
		hoaDon.append("Mã Khách Hàng: ").append(maKHVangLai).append("\n");
		hoaDon.append("Mã Nhân Viên: ").append(nvOn.getMaNV()).append("\n");
		hoaDon.append("Loại Khách Hàng: ").append("Khách vãng lai").append("\n");
		hoaDon.append("Ngày Đặt Hàng: ").append(outputFormat.format(LocalDateTime.now())).append("\n");

		hoaDon.append("\nChi Tiết Đơn Hàng:\n");
		for (ChiTietDonHang chiTiet : listChiTietDonHang.getList()) {
			for (Nuoc nc : listnc.getList()) {
				if (chiTiet.getMaNuoc().equalsIgnoreCase(nc.getMaNuoc())) {
					hoaDon.append("Mã Nước: ").append(chiTiet.getMaNuoc()).append(", Tên nước: ")
							.append(nc.getTenNuoc()).append(", Số Lượng: ").append(chiTiet.getSoLuong())
							.append(", Đơn Giá: ").append(decimalFormat.format(chiTiet.getDonGia()))
							.append("Đ, Thành Tiền: ").append(decimalFormat.format(chiTiet.getThanhTien()))
							.append("Đ\n");
				}
			}
		}

		hoaDon.append("\nTổng Tiền: ").append(decimalFormat.format(listChiTietDonHang.tongTien(tenKHVangLai)))
				.append("Đ\n");
		hoaDon.append("--------------------");

		return hoaDon.toString();
	}

	public String xuatHoaDonHoiVien() {
		StringBuilder hoaDon = new StringBuilder();

		hoaDon.append("----- HÓA ĐƠN -----\n");
		hoaDon.append("Mã Đơn Hàng: ").append(dh.getMaDH()).append("\n");
		hoaDon.append("Mã Khách Hàng: ").append(dh.getMaKH()).append("\n");
		hoaDon.append("Mã Nhân Viên: ").append(dh.getMaNV()).append("\n");
		hoaDon.append("Loại Khách Hàng: ").append(dh.getLoaiKH()).append("\n");
		hoaDon.append("Ngày Đặt Hàng: ").append(outputFormat.format(dh.getNgayDatHang())).append("\n");

		hoaDon.append("\nChi Tiết Đơn Hàng:\n");
		for (ChiTietDonHang chiTiet : listChiTietDonHang.getList()) {
			for (Nuoc nc : listnc.getList()) {
				if (chiTiet.getMaNuoc().equalsIgnoreCase(nc.getMaNuoc())) {
					hoaDon.append("Mã Nước: ").append(chiTiet.getMaNuoc()).append(", Tên nước: ")
							.append(nc.getTenNuoc()).append(", Số Lượng: ").append(chiTiet.getSoLuong())
							.append(", Đơn Giá: ").append(decimalFormat.format(chiTiet.getDonGia()))
							.append("Đ, Thành Tiền: ").append(decimalFormat.format(chiTiet.getThanhTien()))
							.append("Đ\n");
				}
			}
		}

		if (dh.getLoaiKH().equalsIgnoreCase("Tiềm năng")) {
			hoaDon.append("\nGiảm giá: 5%");
		} else if (dh.getLoaiKH().equalsIgnoreCase("Thân thiết")) {
			hoaDon.append("\nGiảm giá: 10%");
		}

		hoaDon.append("\nTổng Tiền: ").append(decimalFormat.format(listChiTietDonHang.tongTien(dh.getLoaiKH())))
				.append("Đ\n");
		hoaDon.append("--------------------");

		return hoaDon.toString();
	}

	public void xoaTrang() {
		khON = null;
		dh = null;
		madhvanglai = "";
		tenKHVangLai = "";
		maKHVangLai = "";
		tblModel.setRowCount(0);
		txtSdt.setText("");
		txtLoaiKH.setText("");
		txtTenKH.setText("");
		txtTong.setText("");
		this.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnXacNhan) {
			if (txtSdt.getText().trim().isEmpty() || txtMaNV == null) {
				JOptionPane.showMessageDialog(null, "Chưa nhập số điện thoại khách hàng");
				return;
			} else {
				if (khON == null) {
					taoDonHangVangLai();
					System.out.println(xuatHoaDonVangLai());
					new XuatPDF().xuatHoaDonPDF(xuatHoaDonVangLai(), "hoadonvanglai");
					xoaTrang();
				} else {
					taoDonHangHoiVien();
					System.out.println(xuatHoaDonHoiVien());
					new XuatPDF().xuatHoaDonPDF(xuatHoaDonHoiVien(), "hoadonhoivien");
					xoaTrang();
				}
			}
		} else if (e.getSource() == btnHuyDon) {
			xoaTrang();
		} else if (e.getSource() == btnTim) {
			napThongTinDonHang();
		} else if (e.getSource() == btnTaoDonVangLai) {
			napDonHangVangLai();
		}
	}
}
