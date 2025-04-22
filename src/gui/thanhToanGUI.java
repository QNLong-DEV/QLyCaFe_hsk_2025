package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import util.LookAndFeelConfig;

public class thanhToanGUI extends JFrame {
	private JPanel pnlNorth;
	private JLabel lblTitle;
	private JPanel pnlCenter;
	private JLabel lblSdt;
	private JTextField txtSdt;
	private Dimension lblsize;
	private Dimension txtsize;
	private Box Box0;
	private JLabel lblTenKH;

	public thanhToanGUI() {
		setTitle("Thanh Toán");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		LookAndFeelConfig.applyLookAndFeel();

		pnlNorth = new JPanel();
		lblTitle = new JLabel("Lập Hóa Đơn Thanh Toán");
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		pnlNorth.add(lblTitle);
		add(pnlNorth, BorderLayout.NORTH);
		
		pnlCenter = new JPanel();
		pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.Y_AXIS));
		
		lblsize = new Dimension(150,25);
		txtsize = new Dimension(200,25);
		
		lblSdt = new JLabel("Số Điện thoại khách hàng:");
		lblSdt.setMaximumSize(lblsize);
		txtSdt = new JTextField(10);
		txtSdt.setMaximumSize(txtsize);
		lblTenKH = new JLabel("Tên khách hàng:");
		Box0 = new Box(BoxLayout.X_AXIS);
		Box0.add(lblSdt);
		Box0.add(Box.createHorizontalStrut(10));
		Box0.add(txtSdt);
		pnlCenter.add(Box0);
		pnlCenter.add(Box.createVerticalStrut(20));	
		add(pnlCenter,BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		new thanhToanGUI();
	}

}
