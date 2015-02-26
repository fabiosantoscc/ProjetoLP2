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

public class BuscarAdcQuartos extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	public BuscarAdcQuartos() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Adicionar Quartos");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 175, 40);
		add(lblNovoContrato);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setBounds(38, 148, 95, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(166, 148, 114, 20);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				MenuPrincipal.adcquartos = new AdicionarQuartos(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
				MenuPrincipal.panel0.add(MenuPrincipal.adcquartos, "18");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "18");
				cpfAPesquisar.setText("");
				}catch(Exception c){
					
				}
			}
		});
		button.setBounds(312, 242, 89, 23);
		add(button);
	}
}