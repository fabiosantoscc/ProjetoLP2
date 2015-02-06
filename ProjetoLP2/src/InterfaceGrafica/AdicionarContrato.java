package InterfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarContrato extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public AdicionarContrato() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Novo Contrato");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 175, 40);
		add(lblNovoContrato);
		
		JLabel lblCpfDoHospede = new JLabel("CPF do Hospede");
		lblCpfDoHospede.setBounds(50, 123, 95, 21);
		add(lblCpfDoHospede);
		
		textField = new JTextField();
		textField.setBounds(147, 123, 114, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (false){
					
				}
				else{
					JOptionPane.showMessageDialog(null, "CPF não Cadastrado");
				}
			}
		});
		btnBuscar.setBounds(299, 122, 89, 23);
		add(btnBuscar);

	}
}
