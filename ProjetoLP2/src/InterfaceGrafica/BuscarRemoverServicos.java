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

public class BuscarRemoverServicos extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	public BuscarRemoverServicos() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Buscar Serviços para remover");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 236, 40);
		add(lblNovoContrato);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setBounds(56, 145, 95, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(191, 145, 114, 20);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MenuPrincipal.removerServicos = new RemoverServicos(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.removerServicos, "27");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "27");
					cpfAPesquisar.setText("");
				} catch (HospedeInvalidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		});
		button.setBounds(406, 228, 89, 23);
		add(button);

	}
}