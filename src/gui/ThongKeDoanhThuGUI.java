package gui;

import dao.BaoCaoDAO;
import model.BaoCao;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ThongKeDoanhThuGUI extends JPanel implements ActionListener {
    private ChartPanel chartPanel;
    private JTable table;
    private DefaultTableModel tableModel;
    private BaoCaoDAO baoCaoDAO;
    private JRadioButton radNgay;
    private JRadioButton radThang;
    private JRadioButton radNam;
    private JPanel pLeft;

    public ThongKeDoanhThuGUI() {
        setSize(800, 600);
        baoCaoDAO = new BaoCaoDAO();
        setLayout(new BorderLayout());

        pLeft = new JPanel(new GridLayout(3, 1, 10, 10));
        pLeft.setBorder(BorderFactory.createTitledBorder("Loại thống kê"));

        radNgay = new JRadioButton("Theo ngày");
        radThang = new JRadioButton("Theo tháng");
        radNam = new JRadioButton("Theo năm");

        ButtonGroup group = new ButtonGroup();
        group.add(radNgay);
        group.add(radThang);
        group.add(radNam);

        pLeft.add(radNgay);
        pLeft.add(radThang);
        pLeft.add(radNam);
        add(pLeft, BorderLayout.WEST);

        radNgay.addActionListener(this);
        radThang.addActionListener(this);
        radNam.addActionListener(this);

        chartPanel = new ChartPanel(null);
        add(chartPanel, BorderLayout.CENTER);

        tableModel = new DefaultTableModel(new Object[]{"Thời gian", "Doanh thu", "Tổng số đơn"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 200));
        add(scrollPane, BorderLayout.SOUTH);

        radNgay.setSelected(true);
        capNhatBieuDo("ngay");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o == radNgay) {
            capNhatBieuDo("ngay");
        }else if(o == radThang) {
            capNhatBieuDo("thang");
        }else if(o == radNam) {
            capNhatBieuDo("nam");
        }
    }

    private void capNhatBieuDo(String kieu) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<BaoCao> list;

        switch(kieu) {
            case "ngay":
                list = baoCaoDAO.layDoanhThuTheoNgay();
                break;
            case "thang":
                list = baoCaoDAO.layDoanhThuTheoThang();
                break;
            case "nam":
                list = baoCaoDAO.layDoanhThuTheoNam();
                break;
            default:
                list = List.of();
                break;
        }

        tableModel.setRowCount(0);
        if(list.isEmpty()) {
            System.out.println("Không có dữ liệu để hiển thị.");
            return;
        }

        for(BaoCao baoCao : list) {
            String time = baoCao.getThoiGian();
            double dThu = baoCao.getDoanhThu();
            int tongDon = baoCao.getTongSoDon();

            dataset.addValue(dThu, "Doanh thu", time);
            tableModel.addRow(new Object[]{time, dThu, tongDon});
        }

        String chartTitle = switch(kieu) {
            case "ngay" -> "Doanh thu theo ngày";
            case "thang" -> "Doanh thu theo tháng";
            case "nam" -> "Doanh thu theo năm";
            default -> "Biểu đồ doanh thu";
        };

        if(dataset.getRowCount() > 0) {
            JFreeChart chart = ChartFactory.createBarChart(
                    chartTitle,
                    "Thời gian",
                    "VNĐ",
                    dataset
            );
            chartPanel.setChart(chart);
        }else {
            System.out.println("Không có dữ liệu để hiển thị biểu đồ.");
        }
    }

    public static void main(String[] args) {
    	new ThongKeDoanhThuGUI();
	}
}

