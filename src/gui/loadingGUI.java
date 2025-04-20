package gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class loadingGUI extends JFrame {

	private JLabel loadingLabel;
	private ImageIcon loadingIcon;

	public loadingGUI() {
		setTitle("Loading...");
		setSize(300, 200);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setUndecorated(true); // Nếu muốn ẩn các viền cửa sổ

		loadingLabel = new JLabel();
		loadingLabel.setHorizontalAlignment(SwingConstants.CENTER);
		loadingLabel.setVerticalAlignment(SwingConstants.CENTER);

		ImageIcon loadingIcon = new ImageIcon(getClass().getResource("/img/Rhombus.gif"));
		loadingLabel.setIcon(loadingIcon);
		add(loadingLabel, BorderLayout.CENTER);
	}

	public void showLoading() {
		setVisible(true); // Hiển thị cửa sổ loading
	}

	public void hideLoading() {
		setVisible(false); // Ẩn cửa sổ loading
		dispose();
	}
}
