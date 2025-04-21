package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
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
	private JPanel pnlGridmenu;
	private JButton btnEx1;
	private JButton btnEx2;
	private JButton btnEx3;
	private JButton btnEx4;
	private JButton btnEx5;
	private JButton btnEx6;
	private JButton btnEx7;
	private JButton btnEx8;
	private JButton btnEx9;
	private JButton btnEx10;
	private Component pnlGridMenu;
	private JScrollPane scrollPane;

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
		
		pnlGridmenu = new JPanel();
		pnlGridmenu.setLayout(new GridLayout(0, 5, 30, 30));
		pnlGridmenu.setPreferredSize(new Dimension(800, 1000)); 
		pnlGridmenu.add(new JButton("card1"));
		pnlGridmenu.add(new JButton("card2"));
		pnlGridmenu.add(new JButton("card3"));
		pnlGridmenu.add(new JButton("card4"));
		pnlGridmenu.add(new JButton("card5"));
		pnlGridmenu.add(new JButton("card6"));
		pnlGridmenu.add(new JButton("card7"));
		pnlGridmenu.add(new JButton("card8"));
		pnlGridmenu.add(new JButton("card9"));
		pnlGridmenu.add(new JButton("card10"));
		pnlGridmenu.add(new JButton("card11"));
		pnlGridmenu.add(new JButton("card12"));
		pnlGridmenu.add(new JButton("card13"));
		pnlGridmenu.add(new JButton("card14"));
		pnlGridmenu.add(new JButton("card15"));
		JScrollPane scrollPane = new JScrollPane(pnlGridmenu);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(50); //tăng tốc độ lăn chuột

		
		Object[] colsTable = { "Mã nước", "Tên Nước", "Giá Nước", "Số lượng", "Loại nước" };
		tblModel = new DefaultTableModel(colsTable, 0);
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
