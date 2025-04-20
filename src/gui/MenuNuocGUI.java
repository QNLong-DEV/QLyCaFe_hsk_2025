package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import resource.LookAndFeelConfig;

public class MenuNuocGUI extends JPanel {

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

	public MenuNuocGUI() {
		setLayout(new BorderLayout());
		LookAndFeelConfig.applyLookAndFeel();
		lblTitle = new JLabel("Menu Nước", SwingConstants.CENTER);
		lblTitle.setFont(new Font("arial", Font.BOLD, 30));
		this.add(lblTitle, BorderLayout.NORTH);

		btnThanhToan = new JButton("Thanh toán");
		btnHuy = new JButton("Hủy đơn hàng");
		btnXoa = new JButton("Xóa món");

		Dimension btnSize = new Dimension(200, 50);
		btnThanhToan.setMaximumSize(btnSize); // Cài đặt kích thước tối đa
		btnHuy.setMaximumSize(btnSize);
		btnXoa.setMaximumSize(btnSize);
		
		
		
		//thêm 1 panel Grid để chứa menu nước, chia theo 3 cột tạo menu card
		
		
		Object[] colsTable = { "Mã nước", "Tên Nước", "Giá Nước", "Số lượng", "Loại nước" };
		tblModel = new DefaultTableModel(colsTable, 0);
		tbl = new JTable();
		tbl.setModel(tblModel);
		scrollTable = new JScrollPane(tbl);
		this.add(scrollTable, BorderLayout.CENTER);

		pnlWest = new JPanel();
		pnlWest.setLayout(new BoxLayout(pnlWest, BoxLayout.Y_AXIS));
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnThanhToan);
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnHuy);
		pnlWest.add(Box.createVerticalStrut(30));
		pnlWest.add(btnXoa);
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
	}
}
