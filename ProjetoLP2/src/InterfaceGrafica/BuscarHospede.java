package InterfaceGrafica;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;

public class BuscarHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	public BuscarHospede() {
		setBackground(Color.YELLOW);
		setForeground(Color.YELLOW);
		setLayout(null);
		
		JLabel label = new JLabel("New label");
		label.setBackground(Color.YELLOW);
		label.setBounds(193, 149, 200, 50);
		add(label);

	}
}
