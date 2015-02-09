package InterfaceGrafica;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import classes.Contrato;
import classes.Hospede;

public class ListaQuartos extends JPanel {

	/**
	 * Create the panel.
	 */
	public ListaQuartos(Hospede hospedeAtual) {

		setLayout(null);
		ArrayList<java.util.List<Contrato>> contratosAtuais = new ArrayList<>(Arrays.asList(Run.hotel.pesquisarContratos(hospedeAtual)));
		
		JLabel lblListaDeContratos = new JLabel("Lista de Quartos do Hospede");
		lblListaDeContratos.setBounds(44, 49, 184, 31);
		add(lblListaDeContratos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 174, 585, 40);
		add(comboBox);
		for(int i = 0; i < contratosAtuais.size(); i++){
			comboBox.addItem(contratosAtuais.get(i));
		}
	}

}
