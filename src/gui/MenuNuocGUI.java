package gui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
import util.txtSource;

public class MenuNuocGUI extends JPanel implements ActionListener, DocumentListener {

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
	private txtSource txtHelper = new txtSource();
	private ArrayList<JPanel> danhSachCard = new ArrayList<>();
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
	private NhanVien nvOn;
	private JLabel lblTimNuoc;
	private JTextField txtTimNuoc;
	private JComboBox cboLoaiNuoc;
	private Font txtFont;
	private JPanel pnlCardEast;
	private Color lblcolorblue;
	private Font lblcardfont;

	public MenuNuocGUI(String manv) {
		setLayout(new BorderLayout());
		LookAndFeelConfig.applyLookAndFeel();

		JPanel pnlNorth = new JPanel(new BorderLayout());
		lblTitle = new JLabel("Menu Nước", SwingConstants.CENTER);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));

		pnlNorth.add(lblTitle, BorderLayout.CENTER);
		JPanel pnlSearch = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		lblTimNuoc = new JLabel("Tìm nước:");
		txtTimNuoc = new JTextField(10);
		pnlSearch.add(lblTimNuoc);
		pnlSearch.add(txtTimNuoc);
		String[] loaiNuoc = { "Tất cả", "Trà sữa", "Cà phê", "Frosty", "Trà trái cây", "Trà xanh" };
		cboLoaiNuoc = new JComboBox<>(loaiNuoc);
		pnlSearch.add(cboLoaiNuoc);
		pnlNorth.add(pnlSearch, BorderLayout.EAST);

		this.add(pnlNorth, BorderLayout.NORTH);

		loadingData();
		listNhanVien = NhanViendao.layDanhSachNhanVien();
		nvOn = NhanViendao.getNhanVienByMaNV(manv);

		btnThanhToan = new JButton("Thanh toán");
		btnXoa = new JButton("Xóa món");
		btnGiam = new JButton("Giảm số lượng");
		btnTang = new JButton("Tăng số lượng");
		btnXoaTrang = new JButton("Xóa tất cả");

		Dimension btnSize = new Dimension(200, 50);
		btnThanhToan.setMaximumSize(btnSize); // Cài đặt kích thước tối đa
		btnXoa.setMaximumSize(btnSize);
		btnGiam.setMaximumSize(btnSize);
		btnTang.setMaximumSize(btnSize);
		btnXoaTrang.setMaximumSize(btnSize);

		pnlGridmenu = new JPanel();
		pnlGridmenu.setLayout(new GridLayout(0, 3, 30, 30));
		for (Nuoc nuoc : listNuoc.getList()) {
			JPanel pnlCard = createCard(nuoc.getMaNuoc(), nuoc.getTenNuoc(), nuoc.getGia(), nuoc.getLoai(),
					nuoc.getImg());
			pnlGridmenu.add(pnlCard);
			danhSachCard.add(pnlCard);
		}

		JScrollPane scrollPane = new JScrollPane(pnlGridmenu);
		scrollPane.setMaximumSize(new Dimension(400, 600));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(50); // tăng tốc độ lăn chuột

		Object[] colsTable = { "Mã nước", "Tên Nước", "Giá Nước", "Số lượng", "Thành tiền" };

		tblModel = new DefaultTableModel(colsTable, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tbl = new JTable(tblModel);
		scrollTable = new JScrollPane(tbl);
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, scrollPane, scrollTable);
		splitPane.setResizeWeight(0.6);
		this.add(splitPane, BorderLayout.CENTER);

		pnlWest = new JPanel();
		pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnThanhToan);
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
		lblTong.setForeground(Color.white);
		txtTong = new JTextField(50);
		txtTong.setMaximumSize(new Dimension(150, 50));
		txtTong.setEditable(false);
		pnlSouth.add(lblTong);
		pnlSouth.add(txtTong);
		add(pnlSouth, BorderLayout.SOUTH);

		btnGiam.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnTang.addActionListener(this);
		btnXoa.addActionListener(this);
		btnThanhToan.addActionListener(this);
		cboLoaiNuoc.addActionListener(this);
		autoSearch();
		loc();
		pnlGridmenu.revalidate(); // Cập nhật lại layout
		pnlGridmenu.repaint(); // Vẽ lại giao diện

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

	public String autoXuongDong(String ten) {
		String res = "";
		String[] words = ten.split(" ");

		for (int i = 0; i < words.length; i++) {
			res += words[i] + " ";
			if (i == 4) {
				res += "<br>";
			}
		}

		return "<html><div>" + res.trim() + "</div></html>";
	}

	public JPanel createCard(String ma, String ten, double gia, String loai, String img) {
		lblcolorblue = new Color(35, 85, 136);
		lblcardfont = new Font("Arial", Font.BOLD, 15);

		String giaString = String.valueOf(gia);
		pnlCard = new JPanel();
		pnlCard.setLayout(new BorderLayout());
		pnlCard.setBackground(Color.white);

		ImageIcon icon = new ImageIcon("src/img/" + img);
		Image imgNuoc = icon.getImage();
		Image scaledImg = imgNuoc.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImg);
		JLabel lblImg = new JLabel(scaledIcon);
		pnlCard.add(lblImg, BorderLayout.CENTER);

		lblmaCard = new JLabel(ma);
		lblmaCard.setPreferredSize(new Dimension(150, 30));
		lblmaCard.setForeground(lblcolorblue);
		lblmaCard.setFont(lblcardfont);

		lbltenCard = new JLabel(autoXuongDong(ten));
		lbltenCard.setPreferredSize(new Dimension(150, 30));
		lbltenCard.setForeground(lblcolorblue);
		lbltenCard.setFont(lblcardfont);

		lblgiaCard = new JLabel(giaString + "Đ");
		lblgiaCard.setPreferredSize(new Dimension(150, 30));
		lblgiaCard.setFont(lblcardfont);

		lblloaiCard = new JLabel(loai);
		lblloaiCard.setPreferredSize(new Dimension(150, 30));
		lblloaiCard.setFont(lblcardfont);

		lblmaCard.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		lbltenCard.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		lblgiaCard.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		lblloaiCard.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		btnChon = new JButton("Chọn");
		btnChon.setPreferredSize(new Dimension(120, 40));
		btnChon.setAlignmentX(Component.CENTER_ALIGNMENT);

		btnChon.addActionListener(e -> {
			tangVaTaoMoiMonNuoc(ma, ten, gia, loai);
			setTongTien();
		});

		pnlCardEast = new JPanel();
		pnlCardEast.setLayout(new BoxLayout(pnlCardEast, BoxLayout.Y_AXIS));
		pnlCardEast.setBackground(Color.white);
		pnlCardEast.add(lblmaCard);
		pnlCardEast.add(Box.createVerticalStrut(5));
		pnlCardEast.add(lbltenCard);
		pnlCardEast.add(Box.createVerticalStrut(5));
		pnlCardEast.add(lblgiaCard);
		pnlCardEast.add(Box.createVerticalStrut(5));
		pnlCardEast.add(lblloaiCard);
		pnlCard.add(pnlCardEast, BorderLayout.EAST);
		pnlCard.add(btnChon, BorderLayout.SOUTH);
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
				thanhtoanWindow.loadulieulenJFrameThanhToan(tblModel, listChiTietDonHang, nvOn, listNuoc);
				thanhtoanWindow.visibleTrue();
			}

		}
	}

	private void timKiemNuoc() {
		String tuKhoa = txtTimNuoc.getText().toLowerCase().trim();
		pnlGridmenu.removeAll();

		for (Nuoc nuoc : listNuoc.getList()) {
			if (nuoc.getTenNuoc().toLowerCase().contains(tuKhoa)) {
				JPanel pnlCard = createCard(nuoc.getMaNuoc(), nuoc.getTenNuoc(), nuoc.getGia(), nuoc.getLoai(),
						nuoc.getImg());
				pnlGridmenu.add(pnlCard);
			}
		}

		pnlGridmenu.revalidate();
		pnlGridmenu.repaint();
	}

	private void locTheoLoai() {
		String loai = cboLoaiNuoc.getSelectedItem().toString().toLowerCase();
		pnlGridmenu.removeAll(); // Xóa các card cũ

		for (Nuoc nuoc : listNuoc.getList()) {
			// Nếu chọn "Tất cả" thì hiện hết, còn không thì lọc theo loại
			if (loai.equals("tất cả") || nuoc.getLoai().toLowerCase().contains(loai)) {
				JPanel pnlCard = createCard(nuoc.getMaNuoc(), nuoc.getTenNuoc(), nuoc.getGia(), nuoc.getLoai(),
						nuoc.getImg());
				pnlGridmenu.add(pnlCard);
			}
		}

		pnlGridmenu.revalidate(); // Refresh giao diện
		pnlGridmenu.repaint();
	}

	public void autoSearch() {
		txtTimNuoc.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				timKiemNuoc();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				timKiemNuoc();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				timKiemNuoc();
			}
		});
	}

	public void loc() {
		cboLoaiNuoc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				locTheoLoai(); // Gọi hàm lọc theo loại
			}
		});
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub

	}

}
