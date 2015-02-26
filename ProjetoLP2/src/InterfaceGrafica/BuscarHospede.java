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

public class BuscarHospede extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	public BuscarHospede() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Pesquisar Hospede");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 266, 40);
		add(lblNovoContrato);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setBounds(55, 156, 95, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(175, 156, 114, 20);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.setBounds(376, 256, 89, 23);
		add(button);
		button.setToolTipText("Digite um nome ou um cpf para buscar o hospede.");
		button.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MenuPrincipal.telaHospede = new PainelHospede(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.telaHospede, "8");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "8");
					cpfAPesquisar.setText("");
				} catch (HospedeInvalidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});		
	}
}