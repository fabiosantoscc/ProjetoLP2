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
import javax.swing.ImageIcon;

public class BuscarCheckIn extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	public BuscarCheckIn() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Check in");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 175, 40);
		add(lblNovoContrato);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(167, 132, 152, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(329, 132, 152, 20);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.setIcon(new ImageIcon(BuscarCheckIn.class.getResource("/Icons/zoom.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				MenuPrincipal.adicionarContrato = new AdicionarContrato(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
				MenuPrincipal.panel0.add(MenuPrincipal.adicionarContrato, "3");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "3");
				cpfAPesquisar.setText("");
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage());
	
				}
			}
		});
		button.setBounds(268, 196, 104, 27);
		add(button);

	}
}