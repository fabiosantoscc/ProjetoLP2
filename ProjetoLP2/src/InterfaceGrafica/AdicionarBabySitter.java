package InterfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import Executar.Run;
import classes.Arquivos;
import classes.BabySitter;
import classes.Hospede;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AdicionarBabySitter extends JPanel {
	private JTextField tFHorarioInicial;
	private JTextField tFDuracao;

	/**
	 * Create the panel.
	 */
	public AdicionarBabySitter(Hospede hospedeAtual) {
		setLayout(null);
		
		JLabel lblBabySitter = new JLabel("Baby Sitter");
		lblBabySitter.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBabySitter.setBounds(29, 24, 247, 51);
		add(lblBabySitter);
		
		JLabel lblHorarioInicial = new JLabel("Hor\u00E1rio Inicial");
		lblHorarioInicial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHorarioInicial.setBounds(29, 164, 126, 23);
		add(lblHorarioInicial);
		
		JLabel lblDuracaoEmHoras = new JLabel("Dura\u00E7\u00E3o (em horas)");
		lblDuracaoEmHoras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDuracaoEmHoras.setBounds(29, 197, 141, 22);
		add(lblDuracaoEmHoras);
		
		tFHorarioInicial = new JTextField();
		tFHorarioInicial.setBounds(190, 167, 86, 20);
		add(tFHorarioInicial);
		tFHorarioInicial.setColumns(10);
		
		tFDuracao = new JTextField();
		tFDuracao.setBounds(190, 200, 86, 20);
		add(tFDuracao);
		tFDuracao.setColumns(10);
		
		JButton btnAdicionarServico = new JButton("Adicionar Servi\u00E7o");
		btnAdicionarServico.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAdicionarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BabySitter babyAtual = new BabySitter(Integer.parseInt(tFHorarioInicial.getText()), Integer.parseInt(tFDuracao.getText()));
					Run.hotel.adicionaServico(hospedeAtual, babyAtual);
					Arquivos.salvaHotel(Run.hotel);
					JOptionPane.showMessageDialog(null, "Baby Sitter adicionado com sucesso!");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "0");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnAdicionarServico.setBounds(306, 323, 174, 40);
		add(btnAdicionarServico);
	}
}
