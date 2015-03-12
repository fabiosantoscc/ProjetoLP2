package interfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;

public class DefaultMenu extends JPanel {

	/*
	 * Cria um menu default para a tela inicial do projeto.
	 * 
	 */
	
	public DefaultMenu() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(82, 189, 596, 291);
		add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);	
		textPane.setEditable(false);
		
		JLabel lblInformaesSobreO = new JLabel("Informa\u00E7\u00F5es sobre o hotel");
		lblInformaesSobreO.setFont(new Font("Dialog", Font.BOLD, 28));
		lblInformaesSobreO.setBounds(184, 79, 381, 35);
		add(lblInformaesSobreO);

	}
}