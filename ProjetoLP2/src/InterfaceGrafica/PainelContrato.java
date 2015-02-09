package InterfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;

import classes.Contrato;
import classes.Hospede;

public class PainelContrato extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelContrato(Hospede hospedeAtual, Contrato contratoAtual) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(0, 0, 595, 272);
		lblNewLabel.setText(contratoAtual.toString());
		add(lblNewLabel);
		
		JLabel label = new JLabel();
		label.setText(hospedeAtual.toString());
		label.setBounds(0, 283, 595, 234);
		add(label);

	}

}
