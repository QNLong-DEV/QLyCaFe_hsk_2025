package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controller.DanhSachChiTietDonHang;
import controller.DanhSachDonHang;
import controller.DanhSachNhanVien;
import controller.DanhSachNuoc;
import dao.NhanVienDAO;
import dao.NuocDAO;
import model.ChiTietDonHang;
import model.DonHang;
import model.NhanVien;
import model.Nuoc;
import util.LookAndFeelConfig;
import util.MaDonHangGenerator;

public class MenuNuocGUI extends JPanel implements ActionListener {

	private JLabel lblTitle;
	private JButton btnThanhToan;
	private JButton btnHuy;
	private JButton btnXoa;
	private Container pnlWest;
	private JPanel pnlSouth;
	private JLabel lblTong;
	private JTextField txtTong;
	private DefaultTableModel tblModel;
	private JTable tbl;
	private JScrollPane scrollTable;
	private JPanel pnlGridmenu;
	private JScrollPane scrollPane;
	static DanhSachNuoc listNuoc = new DanhSachNuoc();
	NuocDAO Nuocdao = new NuocDAO();
	static DanhSachChiTietDonHang listChiTietDonHang = new DanhSachChiTietDonHang();
	NhanVienDAO NhanViendao = new NhanVienDAO();
	static DanhSachNhanVien listNhanVien = new DanhSachNhanVien();
	private JPanel pnlCard;
	private JLabel lblmaCard;
	private JLabel lbltenCard;
	private JLabel lblgiaCard;
	private JLabel lblloaiCard;
	private JButton btnChon;
	private JPanel pnlSouthCard;
	private Box CBox0;
	private Box CBox1;
	private Box CBox2;
	private Dimension lblCardSize;
	private Font lblFont;
	private AbstractButton lblImg;
	private JButton btnGiam;
	private JButton btnTang;
	private JButton btnXoaTrang;
	private thanhToanGUI thanhtoanWindow = null;
	static MaDonHangGenerator genMa = new MaDonHangGenerator();
	private String MaDH = genMa.taoMaDH("A001");
	private NhanVien nvOn;

	public MenuNuocGUI(String manv) {
		setLayout(new BorderLayout());
		LookAndFeelConfig.applyLookAndFeel();
		lblTitle = new JLabel("Menu Nước", SwingConstants.CENTER);
		lblTitle.setFont(new Font("arial", Font.BOLD, 30));
		this.add(lblTitle, BorderLayout.NORTH);

		loadingData();
		listNhanVien = NhanViendao.layDanhSachNhanVien();
		nvOn = NhanViendao.getNhanVienByMaNV(manv);

		btnThanhToan = new JButton("Thanh toán");
		btnHuy = new JButton("Hủy đơn hàng");
		btnXoa = new JButton("Xóa món");
		btnGiam = new JButton("Giảm số lượng");
		btnTang = new JButton("Tăng số lượng");
		btnXoaTrang = new JButton("Xóa tất cả");

		Dimension btnSize = new Dimension(200, 50);
		btnThanhToan.setMaximumSize(btnSize); // Cài đặt kích thước tối đa
		btnHuy.setMaximumSize(btnSize);
		btnXoa.setMaximumSize(btnSize);
		btnGiam.setMaximumSize(btnSize);
		btnTang.setMaximumSize(btnSize);
		btnXoaTrang.setMaximumSize(btnSize);

		pnlGridmenu = new JPanel();
		pnlGridmenu.setLayout(new GridLayout(0, 5, 30, 30));
		pnlGridmenu.setPreferredSize(new Dimension(800, 1000));

		for (Nuoc nuoc : listNuoc.getList()) {
			JPanel pnlCard = createCard(nuoc.getMaNuoc(), nuoc.getTenNuoc(), nuoc.getGia(), nuoc.getLoai(),
					nuoc.getImg());
			pnlGridmenu.add(pnlCard);
		}

		JScrollPane scrollPane = new JScrollPane(pnlGridmenu);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(50); // tăng tốc độ lăn chuột

		Object[] colsTable = { "Mã nước", "Tên Nước", "Giá Nước", "Số lượng", "Thành tiền" };

		tblModel = new DefaultTableModel(colsTable, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Tắt chỉnh sửa cho tất cả các ô
			}
		};
		tbl = new JTable(tblModel);
		scrollTable = new JScrollPane(tbl);

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane, scrollTable);
		splitPane.setResizeWeight(0.6); // tỉ lệ phân chia chiều cao: 60% cho trên, 40% cho dưới

		this.add(splitPane, BorderLayout.CENTER);

		pnlWest = new JPanel();
		pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnThanhToan);
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnHuy);
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnXoa);
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnTang);
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnGiam);
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnXoaTrang);
		pnlWest.add(Box.createVerticalStrut(30));
		this.add(pnlWest, BorderLayout.WEST);

		pnlSouth = new JPanel();
		lblTong = new JLabel("Tổng hóa đơn:");
		lblTong.setFont(new Font("Arial", Font.BOLD, 30));
		txtTong = new JTextField(50);
		txtTong.setMaximumSize(new Dimension(150, 50));
		txtTong.setEditable(false);
		txtTong.setOpaque(false);
		txtTong.setCaretColor(null);
		pnlSouth.add(lblTong);
		pnlSouth.add(txtTong);
		add(pnlSouth, BorderLayout.SOUTH);

		btnGiam.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnTang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThanhToan.addActionListener(this);
	}

	public void loadingData() {
		listNuoc = Nuocdao.layDanhSachNuoc();
		if (listNuoc == null) {
			JOptionPane.showMessageDialog(null, "Không load được dữ liệu");
		}
	}

	public void tangVaTaoMoiMonNuoc(String ma, String ten, double gia, String loai) {
		boolean found = false;

		for (int i = 0; i < tblModel.getRowCount(); i++) {
			String maNuocCoTrongTable = tblModel.getValueAt(i, 0).toString();

			if (maNuocCoTrongTable.equalsIgnoreCase(ma)) {
				int cotSoLuong = (Integer) tblModel.getValueAt(i, 3);
				tblModel.setValueAt(cotSoLuong + 1, i, 3);
				tblModel.setValueAt(listChiTietDonHang.tangSoLuonNuoc(maNuocCoTrongTable), i, 4);
				System.out.println(listChiTietDonHang.xuat());
				found = true;
				break;
			}
		}
		if (!found) {
			ChiTietDonHang newCT = new ChiTietDonHang("", ma, 1, gia, gia);
			listChiTietDonHang.themChiTiet(newCT);
			System.out.println(listChiTietDonHang.xuat());
			tblModel.addRow(new Object[] { ma, ten, gia, 1, gia });
		}
	}

	public void giamSoLuongMonNuoc() {
		int selectedRow = tbl.getSelectedRow();
		if (selectedRow < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nước muốn giảm số lượng!");
			return;
		}
		String maNuocDangDuocChon = tblModel.getValueAt(selectedRow, 0).toString();
		int soLuongHienHanh = (Integer) tbl.getValueAt(selectedRow, 3);
		tblModel.setValueAt(soLuongHienHanh - 1, selectedRow, 3);
		double thanhtien = listChiTietDonHang.giamSoLuongNuoc(maNuocDangDuocChon);
		if (thanhtien <= 0) {
			tblModel.removeRow(selectedRow);
		} else {
			tblModel.setValueAt(thanhtien, selectedRow, 4);
		}
		System.out.println(listChiTietDonHang.xuat());
	}

	public void tangSoLuongMonNuoc() {
		int selectedRow = tbl.getSelectedRow();
		if (selectedRow < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nước muốn tăng số lượng!");
			return;
		}
		String maNuocDangDuocChon = tblModel.getValueAt(selectedRow, 0).toString();
		int soLuongHienHanh = (Integer) tbl.getValueAt(selectedRow, 3);
		tblModel.setValueAt(soLuongHienHanh + 1, selectedRow, 3);
		double thanhtien = listChiTietDonHang.tangSoLuongNuoc(maNuocDangDuocChon);
		tblModel.setValueAt(thanhtien, selectedRow, 4);
		System.out.println(listChiTietDonHang.xuat());
	}

	public void xoaTatCaMon() {
		listChiTietDonHang.xoaToanBo();
		tblModel.setRowCount(0);
	}

	public void setTongTien() {
		double tong = listChiTietDonHang.tongTien("");
		txtTong.setText(String.valueOf(tong) + "Đ");
	}

	public void xoaMotMon() {
		int selectedRow = tbl.getSelectedRow();
		if (selectedRow < 0) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn nước muốn xóa!");
			return;
		}
		String maNuocDangDuocChon = tblModel.getValueAt(selectedRow, 0).toString();
		listChiTietDonHang.xoaChiTiet(maNuocDangDuocChon);
		tblModel.removeRow(selectedRow);
	}

	public JPanel createCard(String ma, String ten, double gia, String loai, String img) {
		String giaString = String.valueOf(gia);

		// String imgPath = "D:\\QLyCaFe_hsk_2025\\src\\img\\trasua1.jpg";

		pnlCard = new JPanel();
		pnlCard.setLayout(new BorderLayout());
		pnlCard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pnlCard.setPreferredSize(new Dimension(200, 300));

		ImageIcon icon = new ImageIcon("src/img/trasua1.jpg");
		Image imgNuoc = icon.getImage();
		Image scaledImg = imgNuoc.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		JLabel lblImg = new JLabel(scaledIcon);

		pnlCard.add(lblImg, BorderLayout.CENTER); // Gán ảnh vào card

		lblmaCard = new JLabel("Mã: " + ma);
		lbltenCard = new JLabel("Tên: " + ten);
		lblgiaCard = new JLabel("Giá: " + giaString + "Đ");
		lblloaiCard = new JLabel("Loại: " + loai);

		lblCardSize = new Dimension(80, 20);
		lblFont = new Font("Arial", Font.BOLD, 10);

		lblmaCard.setPreferredSize(lblCardSize);
		lblmaCard.setFont(lblFont);

		lbltenCard.setPreferredSize(lblCardSize);
		lbltenCard.setFont(lblFont);

		lblgiaCard.setPreferredSize(lblCardSize);
		lblgiaCard.setFont(lblFont);

		lblloaiCard.setPreferredSize(lblCardSize);
		lblloaiCard.setFont(lblFont);

		btnChon = new JButton("Chọn món");
		btnChon.setPreferredSize(new Dimension(120, 40));
		btnChon.setAlignmentX(Component.CENTER_ALIGNMENT);

		btnChon.addActionListener(e -> {
			tangVaTaoMoiMonNuoc(ma, ten, gia, loai);
			setTongTien();
		});

		pnlSouthCard = new JPanel();
		pnlSouthCard.setLayout(new BoxLayout(pnlSouthCard, BoxLayout.Y_AXIS));

		CBox0 = new Box(BoxLayout.X_AXIS);
		CBox1 = new Box(BoxLayout.X_AXIS);
		CBox2 = new Box(BoxLayout.X_AXIS);

		CBox0.add(lblmaCard);
		CBox0.add(Box.createHorizontalStrut(10));
		CBox0.add(lbltenCard);
		CBox1.add(lblgiaCard);
		CBox1.add(Box.createHorizontalStrut(10));
		CBox1.add(lblloaiCard);
		CBox2.add(btnChon);
		pnlSouthCard.add(CBox0);
		pnlSouthCard.add(CBox1);
		pnlSouthCard.add(CBox2);
		pnlCard.add(pnlSouthCard, BorderLayout.SOUTH);
		return pnlCard;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnGiam) {
			giamSoLuongMonNuoc();
			setTongTien();
		} else if (e.getSource() == btnXoaTrang) {
			xoaTatCaMon();
			setTongTien();
		} else if (e.getSource() == btnTang) {
			tangSoLuongMonNuoc();
			setTongTien();
		} else if (e.getSource() == btnXoa) {
			xoaMotMon();
			setTongTien();
		} else if (e.getSource() == btnThanhToan) {
			if (listChiTietDonHang == null || listChiTietDonHang.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Bạn phải chọn món để thanh toán!");
				return;
			} else {
				if (thanhtoanWindow == null) {
					thanhtoanWindow = new thanhToanGUI();
				}
				thanhtoanWindow.loadulieulenJFrameThanhToan(tblModel, listChiTietDonHang, nvOn);
				//thanhtoanWindow.setTongTienThanhToan(txtTong.getText());
				thanhtoanWindow.visibleTrue();
			}	
			
		}
	}

}
