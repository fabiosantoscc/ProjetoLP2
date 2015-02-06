package InterfaceGrafica;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;

public class BuscarHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	public BuscarHospede() {
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
		
		JLabel lblBuscarHospode = new JLabel("Buscar Hospede ");
		lblBuscarHospode.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBuscarHospode.setBounds(41, 63, 241, 28);
		add(lblBuscarHospode);
		

	}
}
