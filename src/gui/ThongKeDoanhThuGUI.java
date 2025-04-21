package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

public class ThongKeDoanhThuGUI extends JPanel {
	private JComboBox<String> cboLoaiThongKe;
	private ChartPanel chartPanel;

	public ThongKeDoanhThuGUI() {
		setSize(800, 600);
		setLayout(new BorderLayout());

		// ComboBox
		cboLoaiThongKe = new JComboBox<>(new String[] { "Theo ngày", "Theo tháng", "Theo năm" });
		cboLoaiThongKe.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				capNhatBieuDo();
			}
		});

		JPanel topPanel = new JPanel();
		topPanel.add(new JLabel("Chọn loại thống kê:"));
		topPanel.add(cboLoaiThongKe);
		add(topPanel, BorderLayout.NORTH);

		// Biểu đồ mặc định
		chartPanel = new ChartPanel(createDoanhThuTheoNgayChart());
		add(chartPanel, BorderLayout.CENTER);

		setVisible(true);
	}

	private void capNhatBieuDo() {
		String selected = (String) cboLoaiThongKe.getSelectedItem();
		JFreeChart chart = null;

		switch (selected) {
		case "Theo ngày":
			chart = createDoanhThuTheoNgayChart();
			break;
		case "Theo tháng":
			chart = createDoanhThuTheoThangChart();
			break;
		case "Theo năm":
			chart = createDoanhThuTheoNamChart();
			break;
		}

		chartPanel.setChart(chart);
	}

	private JFreeChart createDoanhThuTheoNgayChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(1200000, "Doanh thu", "01/04");
		dataset.addValue(1800000, "Doanh thu", "02/04");
		dataset.addValue(1500000, "Doanh thu", "03/04");
		return ChartFactory.createBarChart("Doanh thu theo ngày", "Ngày", "VNĐ", dataset);
	}

	private JFreeChart createDoanhThuTheoThangChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(25000000, "Doanh thu", "Tháng 1");
		dataset.addValue(30000000, "Doanh thu", "Tháng 2");
		return ChartFactory.createBarChart("Doanh thu theo tháng", "Tháng", "VNĐ", dataset);
	}

	private JFreeChart createDoanhThuTheoNamChart() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(350000000, "Doanh thu", "2022");
		dataset.addValue(420000000, "Doanh thu", "2023");
		return ChartFactory.createBarChart("Doanh thu theo năm", "Năm", "VNĐ", dataset);
	}

	public static void main(String[] args) {
		new ThongKeDoanhThuGUI();
	}
}
