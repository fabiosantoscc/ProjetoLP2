package interfaceGrafica;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;

import classes.Cadastro;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

public class DefaultMenu extends JPanel {

	/*
	 * Cria um menu default para a tela inicial do projeto.
	 * 
	 */
	
	public DefaultMenu(Cadastro cadastroAtual) {
		setLayout(null);
		
		this.setBackground(Color.GRAY);
		
		JLabel lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		lblLogoHotel.setBackground(Color.GRAY);
		add(lblLogoHotel);
		
		JLabel lblInformaesSobreO = new JLabel("Olá "+cadastroAtual.getNome());
		lblInformaesSobreO.setFont(new Font("Dialog", Font.BOLD, 28));
		lblInformaesSobreO.setForeground(Color.YELLOW);
		lblInformaesSobreO.setBounds(53, 52, 381, 35);
		add(lblInformaesSobreO);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DefaultMenu.class.getResource("/Icons/Background.jpg")));
		lblNewLabel.setBounds(-44, 0, 883, 539);
		lblNewLabel.setOpaque(true);
		add(lblNewLabel);

	}
}
