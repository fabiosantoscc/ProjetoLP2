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

public class BuscarCheckIn extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public BuscarCheckIn() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Check in");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 175, 40);
		add(lblNovoContrato);
		
		JLabel lblCpfDoHospede = new JLabel("Nome do Hospede");
		lblCpfDoHospede.setBounds(50, 123, 114, 21);
		add(lblCpfDoHospede);
		
		textField = new JTextField();
		textField.setBounds(190, 123, 114, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setBounds(50, 190, 95, 21);
		add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(190, 190, 114, 20);
		add(textField_1);
		
		JButton button = new JButton("Buscar");
		button.setBounds(454, 315, 89, 23);
		add(button);

	}
}