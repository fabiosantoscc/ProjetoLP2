package InterfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JComboBox;

import Executar.Run;
import excecoes.HospedeInvalidoException;

public class BuscarQuartoAtualizar extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	public BuscarQuartoAtualizar() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Atualizar Quartos do Hospede");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 329, 40);
		add(lblNovoContrato);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(216, 132, 116, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(381, 132, 148, 20);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MenuPrincipal.listaQuartosAtualizar = new ListaQuartos(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.listaQuartosAtualizar, "22");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "22");
					cpfAPesquisar.setText("");
				} catch (HospedeInvalidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button.setBounds(335, 191, 97, 27);
		add(button);

	}
}