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

public class AdicionarBabySitter extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public AdicionarBabySitter(Hospede hospedeAtual) {
		setLayout(null);
		
		JLabel lblBabySitter = new JLabel("Baby Sitter");
		lblBabySitter.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBabySitter.setBounds(29, 24, 247, 51);
		add(lblBabySitter);
		
		JLabel lblHorrioInicial = new JLabel("Hor\u00E1rio Inicial");
		lblHorrioInicial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHorrioInicial.setBounds(29, 164, 126, 23);
		add(lblHorrioInicial);
		
		JLabel lblDuraoemHoras = new JLabel("Dura\u00E7\u00E3o (em horas)");
		lblDuraoemHoras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDuraoemHoras.setBounds(29, 197, 141, 22);
		add(lblDuraoemHoras);
		
		textField = new JTextField();
		textField.setBounds(190, 167, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(190, 200, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Adicionar Servi\u00E7o");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BabySitter babyAtual = new BabySitter(Integer.parseInt(textField.getText()), Integer.parseInt(textField_1.getText()));
					Run.hotel.adicionaServico(hospedeAtual, babyAtual);
					Arquivos.salvaHotel(Run.hotel);
					JOptionPane.showMessageDialog(null, "Baby Sitter adicionado com sucesso!");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "0");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(306, 323, 174, 40);
		add(btnNewButton);
	}
}
