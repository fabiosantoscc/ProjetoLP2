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

public class BuscarServicos extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	public BuscarServicos() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Buscar Serviços do Hospede");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 314, 40);
		add(lblNovoContrato);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setBounds(53, 137, 95, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(192, 137, 114, 20);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MenuPrincipal.servicosDoHospede = new ServicosDoHospede(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.servicosDoHospede, "22");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "22");
					cpfAPesquisar.setText("");
				} catch (HospedeInvalidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		});
		button.setBounds(374, 225, 89, 23);
		add(button);

	}
}