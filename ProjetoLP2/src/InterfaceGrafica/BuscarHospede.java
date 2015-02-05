package InterfaceGrafica;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class AdicionarHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdicionarHospede() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Buscar por nome");
		lblNewLabel.setBounds(41, 206, 161, 28);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Buscar por CPF");
		lblNewLabel_1.setBounds(41, 265, 139, 15);
		add(lblNewLabel_1);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(178, 213, 179, 21);
		add(textPane);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(178, 259, 179, 21);
		add(textPane_1);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.setBounds(399, 350, 117, 25);
		add(btnNewButton);
		

	}
}
