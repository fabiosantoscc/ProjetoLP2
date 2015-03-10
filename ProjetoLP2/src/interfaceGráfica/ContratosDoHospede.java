package interfaceGráfica;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;

import classes.Contrato;
import classes.dadosDoHospede.Hospede;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import executar.Run;

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
		lblListaDeContratos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblListaDeContratos.setBounds(44, 49, 270, 31);
		add(lblListaDeContratos);
		
		JLabel lblHospede = new JLabel("Hospede:");
		lblHospede.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHospede.setBounds(47, 122, 82, 14);
		add(lblHospede);
		
		JLabel lblNomeHospede = new JLabel(hospedeAtual.getNome());
		lblNomeHospede.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeHospede.setBounds(139, 124, 243, 14);
		add(lblNomeHospede);
		
		JButton btnVisualizarServios = new JButton("Visualizar Servi\u00E7os");
		btnVisualizarServios.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVisualizarServios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPrincipal.servicosDoHospede = new ServicosDoHospede(hospedeAtual);
				MenuPrincipal.panel0.add(MenuPrincipal.servicosDoHospede, "22");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "22");
			}
		});
		btnVisualizarServios.setBounds(512, 417, 141, 31);
		add(btnVisualizarServios);
		
		JScrollPane scrollPaneContratos = new JScrollPane();
		scrollPaneContratos.setBounds(44, 185, 551, 201);
		add(scrollPaneContratos);
		
		JList listContratos = new JList<>(modeling);
		scrollPaneContratos.setViewportView(listContratos);
		for ( int i = 0; i < contratosAtuais.size(); i++) {
			modeling.addElement(contratosAtuais.get(i).toString());
		}
	}
}
