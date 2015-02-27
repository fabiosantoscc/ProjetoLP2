package InterfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import Executar.Run;

import java.awt.Font;

public class NotaEComentario extends JPanel {

	String comentarios;
	
	/**
	 * Create the panel.
	 */
	public NotaEComentario() {
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 128, 644, 352);
		add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setText(Run.hotel.getComentarios());
		textPane.setEditable(false);
		
		JLabel lblNotaDeAceitao = new JLabel("Nota de Aceita\u00E7\u00E3o");
		lblNotaDeAceitao.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNotaDeAceitao.setBounds(34, 32, 251, 50);
		add(lblNotaDeAceitao);
		
		JLabel label = new JLabel(Run.hotel.getNotaDeAceitacao()+"");
		label.setFont(new Font("Tahoma", Font.PLAIN, 26));
		label.setBounds(270, 32, 200, 50);
		add(label);

	}
}
