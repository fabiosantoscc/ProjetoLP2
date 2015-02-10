package InterfaceGrafica;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import Executar.Run;
import classes.Contrato;
import classes.Hospede;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JScrollPane;
import javax.swing.JList;

public class ContratosDoHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public ContratosDoHospede(Hospede hospedeAtual) {
		setLayout(null);
		ArrayList<java.util.List<Contrato>> contratosAtuais = new ArrayList<>(Arrays.asList(Run.hotel.pesquisarContratos(hospedeAtual)));
		DefaultListModel modeling = new DefaultListModel();
		
		JLabel lblListaDeContratos = new JLabel("Lista de Contratos");
		lblListaDeContratos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListaDeContratos.setBounds(44, 49, 184, 31);
		add(lblListaDeContratos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(44, 197, 551, 23);
		add(comboBox);
		
		JLabel lblHospede = new JLabel("Hospede:");
		lblHospede.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHospede.setBounds(47, 122, 82, 14);
		add(lblHospede);
		
		JLabel label = new JLabel(hospedeAtual.getNome());
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(139, 124, 243, 14);
		add(label);
		
		JButton btnVisualizarServios = new JButton("Visualizar Servi\u00E7os");
		btnVisualizarServios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.servicosDoHospede = new ServicosDoHospede(hospedeAtual);
				MenuPrincipal.panel0.add(MenuPrincipal.servicosDoHospede, "22");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "22");
			}
		});
		btnVisualizarServios.setBounds(512, 425, 141, 23);
		add(btnVisualizarServios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 274, 551, 112);
		add(scrollPane);
		
		JList list = new JList<>(modeling);
		scrollPane.setViewportView(list);
		for ( int i = 0; i < contratosAtuais.size(); i++) {
			modeling.addElement(contratosAtuais.get(i).toString());
		}
		
		
		for(int i = 0; i < contratosAtuais.size(); i++){
			comboBox.addItem(contratosAtuais.get(i).toString());
		}

	}
}
