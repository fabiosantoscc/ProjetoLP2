package InterfaceGrafica;

import java.util.ArrayList;

import javax.swing.JPanel;

import classes.Hospede;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ContratosDoHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	ArrayList<String> list = new ArrayList<String>(); 
	public ContratosDoHospede(Hospede hospedeAtual) {
		setLayout(null);
		
		list.add("Fabio");
		list.add("Ronan");
		list.add("Ravi");
		list.add("Jaziel");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		list.add("Projeto");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"ronan", "souza"}));
		comboBox.setBounds(137, 76, 110, 20);
		add(comboBox);

	}

}
