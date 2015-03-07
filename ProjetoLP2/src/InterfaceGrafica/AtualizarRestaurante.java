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
import classes.Arquivos;
import classes.Hospede;
import classes.Restaurante;
import classes.Servico;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.Font;

public class AtualizarRestaurante extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AtualizarRestaurante(Hospede hospedeAtual) {
		setLayout(null);
		
		JLabel lblAdicionarConsumo = new JLabel("Adicionar Consumo");
		lblAdicionarConsumo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAdicionarConsumo.setBounds(40, 28, 284, 53);
		add(lblAdicionarConsumo);
		
		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnidade.setBounds(37, 113, 124, 20);
		add(lblUnidade);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboBox.getSelectedItem();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Terreo", "Cobertura"}));
		comboBox.setBounds(140, 113, 124, 20);
		add(comboBox);
		
		JLabel lblConsumo = new JLabel("Consumo");
		lblConsumo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConsumo.setBounds(40, 162, 96, 20);
		add(lblConsumo);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(140, 162, 124, 20);
		add(textField);
		textField.setColumns(10);
		
		
		JButton btnAtualizarRestaurante = new JButton("Adicionar Consumo");
		btnAtualizarRestaurante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizarRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					Run.hotel.getRestaurante(hospedeAtual).AdicionaNovoConsumo((String)comboBox.getSelectedItem(), Double.parseDouble(textField.getText()));
					JOptionPane.showMessageDialog(null, "Consumo adicionado com sucesso");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "0");
					Arquivos.salvaHotel(Run.hotel);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
							
			}
		});
		btnAtualizarRestaurante.setBounds(409, 403, 195, 44);
		add(btnAtualizarRestaurante);
	}
}
