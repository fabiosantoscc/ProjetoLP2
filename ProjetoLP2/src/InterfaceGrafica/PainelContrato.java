package InterfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;

import classes.Hospede;

public class PainelContrato extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelContrato(Hospede hospedeAtual) {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(hospedeAtual.toString());
		lblNewLabel.setBounds(0, 0, 585, 517);
		add(lblNewLabel);

	}

}
