package interfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import classes.Arquivos;
import classes.Opiniao;
import classes.dadosDoHospede.Hospede;

import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

import executar.Run;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class CheckOut extends JPanel {
	
	private JTextField textNotaAceitacao;
	private JLabel lblLogoHotel, lblRealizarChekOut, lblNotaDeAceitao, lblComentario;
	private JTextPane textPaneComentarios;
	private JScrollPane scrollPaneComentarios;
	private JSpinner spinnerNota;
	private JButton btnCheckOut;
	
	public CheckOut(Hospede hospedeAtual) {
		setLayout(null);
		
		lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		lblRealizarChekOut = CriaObjetosNaTela.criaLabel("Realizar Check out", new Rectangle(37, 41, 235, 35), CriaObjetosNaTela.getFontePadrao(26), null, null);
		add(lblRealizarChekOut);
		
		lblNotaDeAceitao = CriaObjetosNaTela.criaLabel("Nota de Aceita\u00E7\u00E3o: ", new Rectangle(37, 154, 173, 50), CriaObjetosNaTela.getFontePadrao(16), null, null);
		add(lblNotaDeAceitao);
		
		lblComentario = CriaObjetosNaTela.criaLabel("Coment\u00E1rio:", new Rectangle(37, 238, 120, 28), CriaObjetosNaTela.getFontePadrao(17), null, null);
		add(lblComentario);
		
		scrollPaneComentarios = new JScrollPane();
		scrollPaneComentarios.setBounds(163, 238, 325, 69);
		add(scrollPaneComentarios);
		
		textPaneComentarios = new JTextPane();
		scrollPaneComentarios.setViewportView(textPaneComentarios);
		
		spinnerNota = CriaObjetosNaTela.criaSpinner(new Rectangle(192, 171, 41, 20), CriaObjetosNaTela.getFontePadrao(14));
		spinnerNota.setModel(new SpinnerNumberModel(0, 0, 10, 1));
		add(spinnerNota);
		
		btnCheckOut = CriaObjetosNaTela.criaBotao("Check Out", new Rectangle(329, 426, 184, 45), CriaObjetosNaTela.getFontePadrao(17), null, null);
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String informacoes = "";
				try{
					Opiniao novaOpiniao = new Opiniao(textPaneComentarios.getText(), Double.parseDouble(spinnerNota.getValue().toString()));
					Run.hotel.adicionaOpiniao(novaOpiniao);
					informacoes = Run.hotel.realizaCheckout(hospedeAtual);
					JOptionPane.showMessageDialog(null, "Contrato fechado com Sucesso");
					JOptionPane.showMessageDialog(null, informacoes);
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "MenuPadrao");
					Arquivos.salvaHotel(Run.hotel);
					}catch(Exception c){
						JOptionPane.showMessageDialog(null, c.getMessage());
					}
			}
		});
		add(btnCheckOut);
		
		try {
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}
}
