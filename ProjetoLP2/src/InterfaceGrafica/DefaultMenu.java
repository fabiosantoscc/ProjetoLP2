package InterfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class DefaultMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public DefaultMenu() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Ronan\\git\\ProjetoLP2\\ProjetoLP2\\src\\Icons\\lc_hotel_riviera.jpg"));
		lblNewLabel.setBounds(0, 0, 771, 555);
		add(lblNewLabel);

	}

}