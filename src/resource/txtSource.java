package resource;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JTextField;

public class txtSource {
	
	public txtSource() {
		
	}

	public void addPlaceholder(JTextField txt, String placeholder) {
		txt.setText(placeholder);
		txt.setForeground(Color.GRAY);
		txt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txt.getText().equals(placeholder)) {
					txt.setText("");
					txt.setForeground(Color.BLACK);
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (txt.getText().isEmpty()) {
					txt.setText(placeholder);
					txt.setForeground(Color.GRAY);
				}
			}
		});
	}
}
