package interfaceGráfica;

import javax.swing.JPanel;
import javax.swing.JLabel;

import classes.Arquivos;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;

public class TelaSobre extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaSobre() {
		setLayout(null);
		
		JLabel lblDesenvolvedores = new JLabel("Desenvolvedores:");
		lblDesenvolvedores.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDesenvolvedores.setBounds(23, 164, 125, 28);
		add(lblDesenvolvedores);
		
		JLabel lblFabioAlexandre = new JLabel("Fabio Alexandre");
		lblFabioAlexandre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFabioAlexandre.setBounds(146, 203, 165, 17);
		add(lblFabioAlexandre);
		
		JLabel lblRaviLeite = new JLabel("Ravi Leite");
		lblRaviLeite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRaviLeite.setBounds(146, 231, 165, 17);
		add(lblRaviLeite);
		
		JLabel lblRonanSouza = new JLabel("Ronan Souza");
		lblRonanSouza.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRonanSouza.setBounds(146, 259, 165, 17);
		add(lblRonanSouza);
		
		JLabel lblLogoHotel = new JLabel("");
		lblLogoHotel.setIcon(new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")));
		lblLogoHotel.setBounds(694, 11, 66, 70);
		add(lblLogoHotel);
		
		JLabel lblLogoUFCG = new JLabel("");
		lblLogoUFCG.setIcon(new ImageIcon(TelaSobre.class.getResource("/Icons/logo_ufcg.png")));
		lblLogoUFCG.setBounds(311, 11, 117, 136);
		add(lblLogoUFCG);
		
		JLabel lblLogoComputacao = new JLabel("");
		lblLogoComputacao.setIcon(new ImageIcon(TelaSobre.class.getResource("/Icons/logo_computacao2.png")));
		lblLogoComputacao.setBounds(503, 485, 257, 54);
		add(lblLogoComputacao);
		
		JLabel lblDescricao = new JLabel("Descri\u00E7\u00E3o do Projeto:");
		lblDescricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDescricao.setBounds(23, 318, 146, 28);
		add(lblDescricao);
		
		JTextPane textDescricao = new JTextPane();
		textDescricao.setEditable(false);
		textDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textDescricao.setText("Software desenvolvido para conclus\u00E3o da cadeira de Laborat\u00F3rio de programa\u00E7\u00E3o 2 do semestre 2014.2 da Universidade Federal de Campina Grande.\r\n");
		textDescricao.setBounds(142, 348, 436, 70);
		add(textDescricao);

	}
}
