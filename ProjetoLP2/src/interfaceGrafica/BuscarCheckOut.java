package interfaceGrafica;

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

import classes.Arquivos;

import java.awt.Color;

import javax.swing.ImageIcon;

import executar.Run;

public class BuscarCheckOut extends JPanel {
	private JTextField textCPF;

	/**
	 * Create the panel.
	 */
	
	public BuscarCheckOut() {
		setLayout(null);
		
		JLabel lblCheckOUT = new JLabel("Check out");
		lblCheckOUT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCheckOUT.setBounds(38, 29, 175, 40);
		add(lblCheckOUT);
		
		JLabel lblCPF = new JLabel("CPF do Hospede");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCPF.setBounds(172, 145, 119, 21);
		add(lblCPF);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCPF.setColumns(10);
		textCPF.setBounds(320, 145, 114, 20);
		add(textCPF);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(BuscarCheckOut.class.getResource("/Icons/zoom.png")));
		btnBuscar.setBackground(new Color(0, 204, 255));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MenuPrincipal.checkOut = new CheckOut(Run.hotel.pesquisaHospede(textCPF.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.checkOut, "painelCheckOut");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "painelCheckOut");
					textCPF.setText("");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnBuscar.setBounds(268, 198, 107, 27);
		add(btnBuscar);

	}
}