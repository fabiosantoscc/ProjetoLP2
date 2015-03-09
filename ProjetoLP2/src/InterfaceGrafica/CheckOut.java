package InterfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import Executar.Run;
import classes.Arquivos;
import classes.Hospede;
import classes.Opiniao;

import java.awt.Font;
import java.awt.TextField;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckOut extends JPanel {
	private JTextField textNotaAceitacao;

	/**
	 * Create the panel.
	 */
	
	public CheckOut(Hospede hospedeAtual) {
		setToolTipText("aaa");
		setLayout(null);
		
		JLabel lblRealizarChekOut = new JLabel("Realizar check out");
		lblRealizarChekOut.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblRealizarChekOut.setBounds(37, 41, 235, 35);
		add(lblRealizarChekOut);
		
		JLabel lblNotaDeAceitao = new JLabel("Nota de Aceita\u00E7\u00E3o: ");
		lblNotaDeAceitao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNotaDeAceitao.setBounds(37, 154, 173, 50);
		add(lblNotaDeAceitao);
		
		textNotaAceitacao = new JTextField();
		textNotaAceitacao.setBounds(186, 171, 80, 20);
		add(textNotaAceitacao);
		textNotaAceitacao.setColumns(10);
		
		JLabel lblComentario = new JLabel("Coment\u00E1rio:");
		lblComentario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblComentario.setBounds(37, 238, 120, 28);
		add(lblComentario);
		
		JScrollPane scrollPaneComentarios = new JScrollPane();
		scrollPaneComentarios.setBounds(163, 238, 325, 69);
		add(scrollPaneComentarios);
		
		JTextPane textPaneComentarios = new JTextPane();
		scrollPaneComentarios.setViewportView(textPaneComentarios);
		
		JButton btnCheckOut = new JButton("Check out");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Opiniao novaOpiniao = new Opiniao(textPaneComentarios.getText(), Double.parseDouble(textNotaAceitacao.getText()));
					Run.hotel.adicionaOpiniao(novaOpiniao);
					Run.hotel.getContratoAberto(hospedeAtual).setAberto(false);
					JOptionPane.showMessageDialog(null, "Contrato fechado com Sucesso");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "MenuPadrao");
					Arquivos.salvaHotel(Run.hotel);
					}catch(Exception c){
						JOptionPane.showMessageDialog(null, c.getMessage());
					}
			}
		});
		btnCheckOut.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCheckOut.setBounds(329, 426, 184, 45);
		add(btnCheckOut);
		
		try {
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

	}
}
