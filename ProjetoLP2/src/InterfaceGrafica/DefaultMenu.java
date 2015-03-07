package InterfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

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

	}
}
