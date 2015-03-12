package interfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import executar.Run;

public class NotaEComentario extends JPanel {

	private JLabel lblLogoHotel, lblNotaDeAceitao, lblComentriosDosHospedes, lblIcon;
	private JScrollPane scrollPaneComentarios;
	private JTextPane textPaneComentarios;
	private String comentarios, notaFormatada;
	
	public NotaEComentario() {
		setLayout(null);
		
		lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		scrollPaneComentarios = new JScrollPane();
		scrollPaneComentarios.setBounds(57, 224, 621, 256);
		add(scrollPaneComentarios);
		
		textPaneComentarios = new JTextPane();
		scrollPaneComentarios.setViewportView(textPaneComentarios);
		try {
			textPaneComentarios.setText(Run.hotel.getComentarios());
		} catch ( Exception e ) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
			
		textPaneComentarios.setEditable(false);
		
		lblNotaDeAceitao = CriaObjetosNaTela.criaLabel("Nota de Aceita\u00E7\u00E3o", new Rectangle(57, 25, 251, 50), CriaObjetosNaTela.getFontePadrao(20), null, null);
		add(lblNotaDeAceitao);
		
		notaFormatada = String.format("%.2f", Run.hotel.getNotaDeAceitacao());
		JLabel lblNota = new JLabel(notaFormatada);
		lblNota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNota.setBounds(250, 25, 200, 50);
		add(lblNota);
		
		lblComentriosDosHospedes = CriaObjetosNaTela.criaLabel("Coment\u00E1rios dos hospedes", new Rectangle(57, 150, 307, 50), CriaObjetosNaTela.getFontePadrao(24), null, null);
		add(lblComentriosDosHospedes);
		
		lblIcon = CriaObjetosNaTela.criaLabel(null, new Rectangle(367, 164, 54, 26), CriaObjetosNaTela.getFontePadrao(16),new ImageIcon(NotaEComentario.class.getResource("/Icons/comments.png")), null); 
		add(lblIcon);

	}
}
