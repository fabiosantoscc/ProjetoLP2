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
	private JTextField nomeAPesquisar;
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
		
		JLabel lblCpfDoHospede = new JLabel("Nome do Hospede");
		lblCpfDoHospede.setBounds(50, 123, 114, 21);
		add(lblCpfDoHospede);
		
		nomeAPesquisar = new JTextField();
		nomeAPesquisar.setBounds(190, 123, 114, 20);
		add(nomeAPesquisar);
		nomeAPesquisar.setColumns(10);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setBounds(50, 190, 95, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(190, 190, 114, 20);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				Run.hotel.pesquisaHospede(cpfAPesquisar.getText(), nomeAPesquisar.getText());
				MenuPrincipal.adcquartos = new AdicionarQuartos(Run.hotel.pesquisaHospede(cpfAPesquisar.getText(), nomeAPesquisar.getText()));
				MenuPrincipal.panel0.add(MenuPrincipal.adcquartos, "18");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "18");
				nomeAPesquisar.setText("");
				cpfAPesquisar.setText("");
				}catch(Exception c){
					
				}
			}
		});
		button.setBounds(454, 315, 89, 23);
		add(button);
	}
}