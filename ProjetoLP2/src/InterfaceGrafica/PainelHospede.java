package InterfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class PainelHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	public PainelHospede() {
		setLayout(null);
		
		JLabel lblHospede = new JLabel("Hospede");
		lblHospede.setBounds(34, 11, 60, 30);
		add(lblHospede);

	}

}
