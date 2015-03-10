package interfaceGráfica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;

import executar.Run;

public class NotaEComentario extends JPanel {

	String comentarios;
	
	/**
	 * Create the panel.
	 */
	public NotaEComentario() {
		setLayout(null);
		
		JScrollPane scrollPaneComentarios = new JScrollPane();
		scrollPaneComentarios.setBounds(57, 224, 621, 256);
		add(scrollPaneComentarios);
		
		JTextPane textPaneComentarios = new JTextPane();
		scrollPaneComentarios.setViewportView(textPaneComentarios);
		try {
			textPaneComentarios.setText(Run.hotel.getComentarios());
		} catch ( Exception e ) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
			
		textPaneComentarios.setEditable(false);
		
		JLabel lblNotaDeAceitao = new JLabel("Nota de Aceita\u00E7\u00E3o");
		lblNotaDeAceitao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNotaDeAceitao.setBounds(57, 25, 251, 50);
		add(lblNotaDeAceitao);
		
		JLabel lblNota = new JLabel(Run.hotel.getNotaDeAceitacao() + "");
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNota.setBounds(250, 25, 200, 50);
		add(lblNota);
		
		JLabel lblComentriosDosHospedes = new JLabel("Coment\u00E1rios dos hospedes");
		lblComentriosDosHospedes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblComentriosDosHospedes.setBounds(57, 150, 307, 50);
		add(lblComentriosDosHospedes);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(NotaEComentario.class.getResource("/Icons/comments.png")));
		lblIcon.setBounds(367, 164, 54, 26);
		add(lblIcon);

	}
}
