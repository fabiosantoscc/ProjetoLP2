package InterfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import Executar.Run;

import java.awt.Font;
import javax.swing.ImageIcon;

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
		try {
			textPane.setText(Run.hotel.getComentarios());
		} catch ( Exception e ) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
			
		textPane.setEditable(false);
		
		JLabel lblNotaDeAceitao = new JLabel("Nota de Aceita\u00E7\u00E3o");
		lblNotaDeAceitao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNotaDeAceitao.setBounds(57, 25, 251, 50);
		add(lblNotaDeAceitao);
		
		JLabel label = new JLabel(Run.hotel.getNotaDeAceitacao() + "");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(250, 25, 200, 50);
		add(label);
		
		JLabel lblComentriosDosHospedes = new JLabel("Coment\u00E1rios dos hospedes");
		lblComentriosDosHospedes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblComentriosDosHospedes.setBounds(57, 150, 307, 50);
		add(lblComentriosDosHospedes);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(NotaEComentario.class.getResource("/Icons/comments.png")));
		lblNewLabel.setBounds(367, 164, 54, 26);
		add(lblNewLabel);

	}
}
