package InterfaceGrafica;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import classes.Contrato;
import classes.Hospede;

import javax.swing.JLabel;
import javax.swing.JComboBox;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class ContratosDoHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	
	
	public ContratosDoHospede(Hospede hospedeAtual) {
		setLayout(null);
		ArrayList<java.util.List<Contrato>> contratosAtuais = new ArrayList<>(Arrays.asList(Run.hotel.pesquisarContratos(hospedeAtual)));
		
		JLabel lblListaDeContratos = new JLabel("Lista de Contratos");
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
