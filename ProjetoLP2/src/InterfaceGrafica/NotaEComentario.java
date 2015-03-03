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
		scrollPane.setBounds(57, 224, 621, 256);
		add(scrollPane);
		
		JTextPane textPane = new JTextPane();
		scrollPane.setViewportView(textPane);
		textPane.setText(Run.hotel.getComentarios());
		textPane.setEditable(false);
		
		JLabel lblNotaDeAceitao = new JLabel("Nota de Aceita\u00E7\u00E3o");
		lblNotaDeAceitao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNotaDeAceitao.setBounds(57, 122, 251, 50);
		add(lblNotaDeAceitao);
		
		JLabel label = new JLabel(Run.hotel.getNotaDeAceitacao()+"");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(264, 124, 200, 50);
		add(label);
		
		JLabel lblComentriosDosHospedes = new JLabel("Coment\u00E1rios dos hospedes");
		lblComentriosDosHospedes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblComentriosDosHospedes.setBounds(34, 26, 307, 50);
		add(lblComentriosDosHospedes);

	}
}
