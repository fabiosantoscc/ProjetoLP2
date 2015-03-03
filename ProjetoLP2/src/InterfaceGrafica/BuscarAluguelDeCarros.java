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

public class BuscarAluguelDeCarros extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	public BuscarAluguelDeCarros() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Aluguel de Carro");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 231, 40);
		add(lblNovoContrato);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(149, 157, 122, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(293, 157, 153, 20);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				MenuPrincipal.adcAluguelDeCarros = new AdicionarAlugueldeCarros(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
				MenuPrincipal.panel0.add(MenuPrincipal.adcAluguelDeCarros, "20");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "20");
				cpfAPesquisar.setText("");
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage());
				}
			}
		});
		button.setBounds(249, 212, 101, 30);
		add(button);

	}
}