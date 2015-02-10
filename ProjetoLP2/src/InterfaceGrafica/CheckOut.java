package InterfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import classes.Hospede;

public class CheckOut extends JPanel {

	/**
	 * Create the panel.
	 */
	public CheckOut(Hospede hospedeAtual) {
		setLayout(null);
		
		JLabel lblRealizarChekOut = new JLabel("Realizar check out");
		lblRealizarChekOut.setBounds(37, 41, 199, 35);
		add(lblRealizarChekOut);
		
		JLabel label = new JLabel("");
		try {
			label.setText(Run.hotel.getContratoAberto(hospedeAtual).toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		label.setBounds(47, 121, 558, 102);
		add(label);

	}

}
