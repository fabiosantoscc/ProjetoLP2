package InterfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;

import classes.Contrato;
import classes.Hospede;
import javax.swing.JTextField;

public class PainelContrato extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PainelContrato(Hospede hospedeAtual, Contrato contratoAtual) {
		setLayout(null);
		
		JLabel lblContrato = new JLabel("Contrato");
		lblContrato.setBounds(32, 32, 46, 14);
		add(lblContrato);
		
		JLabel lblHospede = new JLabel("Hospede");
		lblHospede.setBounds(47, 93, 46, 14);
		add(lblHospede);
		
		textField = new JTextField();
		textField.setBounds(114, 90, 163, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(47, 131, 46, 14);
		add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(47, 158, 46, 14);
		add(lblNewLabel);

	}
}
