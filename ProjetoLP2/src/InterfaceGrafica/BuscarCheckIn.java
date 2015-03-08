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
	private JTextField textCPF;

	/**
	 * Create the panel.
	 */
	public BuscarCheckIn() {
		setLayout(null);
		
		JLabel lblCheckIN = new JLabel("Check in");
		lblCheckIN.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCheckIN.setBounds(38, 29, 175, 40);
		add(lblCheckIN);
		
		JLabel lblCPF = new JLabel("CPF do Hospede");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCPF.setBounds(167, 132, 152, 21);
		add(lblCPF);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textCPF.setColumns(10);
		textCPF.setBounds(329, 132, 152, 20);
		add(textCPF);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(BuscarCheckIn.class.getResource("/Icons/zoom.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				MenuPrincipal.adicionarContrato = new AdicionarContrato(Run.hotel.pesquisaHospede(textCPF.getText()));
				MenuPrincipal.panel0.add(MenuPrincipal.adicionarContrato, "3");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "3");
				textCPF.setText("");
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage());
	
				}
			}
		});
		btnBuscar.setBounds(268, 196, 104, 27);
		add(btnBuscar);

	}
}