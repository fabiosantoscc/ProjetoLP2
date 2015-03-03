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

import classes.Arquivos;
import Executar.Run;

public class BuscarCheckOut extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	
	public BuscarCheckOut() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Check out");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 175, 40);
		add(lblNovoContrato);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(172, 145, 119, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(320, 145, 114, 20);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MenuPrincipal.checkOut = new CheckOut(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.checkOut, "31");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "31");
					cpfAPesquisar.setText("");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button.setBounds(268, 198, 94, 27);
		add(button);

	}
}