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

public class BuscarContratos extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	public BuscarContratos() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Pesquisar Contratos");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 277, 40);
		add(lblNovoContrato);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setBounds(53, 119, 95, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(173, 119, 114, 20);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MenuPrincipal.contratosDoHospede = new ContratosDoHospede(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.contratosDoHospede, "19");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "19");
					cpfAPesquisar.setText("");
				} catch (HospedeInvalidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				
			}
		});
		button.setBounds(357, 216, 89, 23);
		add(button);

	}
}