package gui;

import dao.BaoCaoDAO;
import dao.DonHangDAO;
import dao.KhachHangDAO;
import model.BaoCao;
import model.BaoCaoBestSeller;
import model.DonHang;
import model.KhachHang;
import util.txtSource;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import controller.DanhSachChiTietDonHang;
import controller.DanhSachDonHang;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ThongKeDoanhThuGUI extends JPanel implements ActionListener {
	private ChartPanel chartPanel;
	private JComboBox<String> cboBestSeller;
	private DefaultTableModel tblBestSellerModel;
	private JScrollPane scrollPanelBestSeller;
	private JTable tblBestSeller;
	private JLabel lblBestSeller;
	private JSplitPane pnlBestSeller;
	private JPanel pnlCBoBestSeller;
	private JPanel pnlChartBD;
	private DefaultTableModel tblChartModel;
	private JTable tblChart;
	private JScrollPane scrollPaneChart;
	private JComboBox<String> cboChart;
	private JSplitPane pnlChart;
	private JPanel pnlBtnSdt;
	private JButton btnTim;
	private JTextField txtSdt;
	private DefaultTableModel tblTongDonHangModel;
	private JTable tblTongDonHang;
	private JScrollPane scrollPaneTongDonHang;
	private JSplitPane pnlTongDonHang;
	private JPanel pnlTop;
	static txtSource txtHelper = new txtSource();

	private KhachHang khON;
	private static ThongKeDoanhThuGUI instance;

	public static ThongKeDoanhThuGUI getInstance() {
		return instance;
	}

	public ThongKeDoanhThuGUI() {
		instance = this;
		lblBestSeller = new JLabel("Best Seller: ");
		String[] bestseller = { "Trà sữa", "Cà phê", "Frosty", "Trà trái cây", "Trà xanh" };
		cboBestSeller = new JComboBox<String>(bestseller);
		pnlCBoBestSeller = new JPanel();
		pnlCBoBestSeller.add(lblBestSeller);
		pnlCBoBestSeller.add(cboBestSeller);
		pnlCBoBestSeller.setMaximumSize(new Dimension(400, 500));

		String[] tblBestSellerCol = { "Mã nước", "Tên nước", "Giá nước", "Loại nước", "Doanh số", "Tháng", "Năm" };
		tblBestSellerModel = new DefaultTableModel(tblBestSellerCol, 0);
		tblBestSeller = new JTable(tblBestSellerModel);
		scrollPanelBestSeller = new JScrollPane(tblBestSeller);
		tblBestSeller.setPreferredScrollableViewportSize(new Dimension(300, 200));

		pnlBestSeller = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnlCBoBestSeller, scrollPanelBestSeller);
		pnlBestSeller.setResizeWeight(0.2);

		pnlChartBD = new JPanel();
		pnlChartBD.setLayout(new BorderLayout());

		String[] cboChartItem = { "Ngày", "Tháng", "Năm" };
		cboChart = new JComboBox<String>(cboChartItem);

		String[] tblChartCol = { "Thời gian", "Doanh Thu", "Tổng số đơn" };
		tblChartModel = new DefaultTableModel(tblChartCol, 0);
		tblChart = new JTable(tblChartModel);
		scrollPaneChart = new JScrollPane(tblChart);
		tblChart.setPreferredScrollableViewportSize(new Dimension(300, 200));

		chartPanel = createChart();
		chartPanel.setPreferredSize(new Dimension(300, 200));

		pnlChartBD.add(chartPanel, BorderLayout.CENTER);
		pnlChartBD.add(cboChart, BorderLayout.SOUTH);

		pnlChart = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnlChartBD, scrollPaneChart);

		pnlBtnSdt = new JPanel();
		txtSdt = new JTextField(20);
		txtHelper.addPlaceholder(txtSdt, "Nhập sdt khách hàng");
		btnTim = new JButton("Tìm");
		pnlBtnSdt.add(txtSdt);
		pnlBtnSdt.add(btnTim);

		String[] tblTongDonHangCol = { "Mã đơn hàng", "Mã khách hàng", "Mã nhân viên", "Loại khách hàng",
				"Ngày mua hàng", "Tổng tiền" };
		tblTongDonHangModel = new DefaultTableModel(tblTongDonHangCol, 0);
		tblTongDonHang = new JTable(tblTongDonHangModel);
		scrollPaneTongDonHang = new JScrollPane(tblTongDonHang);

		pnlTongDonHang = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnlBtnSdt, scrollPaneTongDonHang);
		pnlTongDonHang.setResizeWeight(0.2);

		pnlTop = new JPanel();
		pnlTop.setLayout(new BoxLayout(pnlTop, BoxLayout.X_AXIS));
		pnlTop.add(pnlBestSeller);
		pnlTop.add(pnlChart);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(pnlTop);
		add(pnlTongDonHang);

		cboChart.addActionListener(this);
		cboBestSeller.addActionListener(this);
		btnTim.addActionListener(this);
		setVisible(true);

	}

	public ChartPanel createChart() {
		String itemselected = cboChart.getSelectedItem().toString();
		String chartTitle = "";
		BaoCaoDAO dao = new BaoCaoDAO();
		tblChartModel.setRowCount(0);

		List<BaoCao> listbc;

		try {
			if (itemselected.equalsIgnoreCase("Ngày")) {
				listbc = dao.layDoanhThuTheoNgay();
				chartTitle = "Doanh thu theo ngày";
			} else if (itemselected.equalsIgnoreCase("Tháng")) {
				listbc = dao.layDoanhThuTheoThang();
				chartTitle = "Doanh thu theo tháng";
			} else if (itemselected.equalsIgnoreCase("Năm")) {
				listbc = dao.layDoanhThuTheoNam();
				chartTitle = "Doanh thu theo năm";
			} else {
				listbc = List.of();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			listbc = List.of();
		}

		if (listbc.isEmpty()) {
			System.out.println("Không có dữ liệu để hiển thị.");
			return null;
		}

		DefaultCategoryDataset duLieuCot = new DefaultCategoryDataset();

		for (BaoCao baoCao : listbc) {
			String time = baoCao.getThoiGian();
			double dThu = baoCao.getDoanhThu();
			int tongDon = baoCao.getTongSoDon();
			duLieuCot.addValue(dThu, "Doanh thu", time);
			tblChartModel.addRow(new Object[] { time, dThu, tongDon });
		}

		JFreeChart chart = ChartFactory.createBarChart(chartTitle, "Thời gian", "VNĐ", duLieuCot);

		ChartPanel panel = new ChartPanel(chart);
		return panel;
	}

	public void setBestSeller() {
		tblBestSellerModel.setRowCount(0);
		String itemselected = cboBestSeller.getSelectedItem().toString();
		BaoCaoDAO dao = new BaoCaoDAO();
		BaoCaoBestSeller bc = dao.getBestseller(itemselected);

		tblBestSellerModel.addRow(new Object[] { bc.getMaNuoc(), bc.getTenNuoc(), bc.getGia(), bc.getLoai(),
				bc.getTongSoLuongDat(), bc.getThang(), bc.getNam() });

	}

	public void setThongKeTheoKhachHang() {
		tblTongDonHangModel.setRowCount(0);
		String sdt = txtSdt.getText();
		KhachHangDAO khdao = new KhachHangDAO();
		khON = khdao.timTheoSDT(sdt);
		if (khON != null) {
			DanhSachDonHang ds = new DanhSachDonHang();
			DonHangDAO dhdao = new DonHangDAO();
			ds = dhdao.getDonHang(khON.getMaKH());
			for (DonHang dh : ds.getList()) {
				tblTongDonHangModel.addRow(new Object[] { dh.getMaDH(), dh.getMaKH(), dh.getMaNV(), dh.getLoaiKH(),
						dh.getNgayDatHang(), dh.getTongTien() });
			}
		} else {
			JOptionPane.showMessageDialog(null, "Không tìm thấy khách hàng");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cboChart) {
			ChartPanel newChartPanel = createChart();
			newChartPanel.setPreferredSize(new Dimension(300, 200));
			if (newChartPanel != null) {
				pnlChartBD.remove(chartPanel); // Xóa biểu đồ cũ
				pnlChartBD.add(newChartPanel, BorderLayout.CENTER);
				pnlChartBD.revalidate();
				pnlChartBD.repaint();
				chartPanel = newChartPanel;
			}
		} else if (e.getSource() == cboBestSeller) {
			setBestSeller();
		} else if (e.getSource() == btnTim) {
			setThongKeTheoKhachHang();
		}

	}

}
