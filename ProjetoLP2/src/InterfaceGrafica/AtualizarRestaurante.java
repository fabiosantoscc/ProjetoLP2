package InterfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import Executar.Run;
import classes.Hospede;
import classes.Restaurante;
import classes.Servicos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class AtualizarRestaurante extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AtualizarRestaurante(Hospede hospedeAtual) {
		setLayout(null);
		
		JLabel lblAdicionarConsumo = new JLabel("Adicionar Consumo");
		lblAdicionarConsumo.setBounds(40, 28, 200, 53);
		add(lblAdicionarConsumo);
		
		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setBounds(37, 97, 124, 36);
		add(lblUnidade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboBox.getSelectedItem();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Terreo", "Cobertura"}));
		comboBox.setBounds(99, 105, 112, 20);
		add(comboBox);
		
		JLabel lblConsumo = new JLabel("Consumo");
		lblConsumo.setBounds(40, 162, 58, 20);
		add(lblConsumo);
		
		textField = new JTextField();
		textField.setBounds(111, 162, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		
		JButton btnAtualizarRestaurante = new JButton("Atualizar Restaurante");
		btnAtualizarRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					Run.hotel.getRestaurante(hospedeAtual).AdicionaNovoConsumo((String)comboBox.getSelectedItem(), Double.parseDouble(textField.getText()));
					JOptionPane.showMessageDialog(null, "Consumo adicionado com sucesso");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "0");
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
							
			}
		});
		btnAtualizarRestaurante.setBounds(409, 403, 146, 44);
		add(btnAtualizarRestaurante);
		


	}
}
