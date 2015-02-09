package InterfaceGrafica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import classes.Contrato;
import classes.Hospede;
import classes.Servicos;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ServicosDoHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	ArrayList<java.util.List<Servicos>> servicosAtuais;
	ArrayList<String> nomeServicos = new ArrayList<String>();
	ArrayList<String> minhasStrings = new ArrayList<String>();
	JList meuList;
	private DefaultListModel modeling = new DefaultListModel();
	public ServicosDoHospede(Hospede hospedeAtual) {
		setLayout(null);
		
		
		try {
			servicosAtuais = new ArrayList<>(Arrays.asList(Run.hotel.getServicosHospede(hospedeAtual)));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		JLabel lblListaDeContratos = new JLabel("Lista de Serviços");
		lblListaDeContratos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListaDeContratos.setBounds(44, 49, 184, 31);
		add(lblListaDeContratos);
		
		JComboBox <String>comboBox = new JComboBox<String>();
		comboBox.setBounds(44, 197, 551, 23);
		
		add(comboBox);
		for(int i = 0; i < servicosAtuais.size(); i++){
			nomeServicos.add(servicosAtuais.get(i).toString());
			comboBox.addItem(nomeServicos.get(i));
		}

		JLabel lblHospede = new JLabel("Hospede:");
		lblHospede.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHospede.setBounds(47, 122, 82, 14);
		add(lblHospede);
		
		JLabel label = new JLabel(hospedeAtual.getNome());
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(139, 124, 243, 14);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 241, 529, 223);
		add(scrollPane);
		
		meuList = new JList(modeling);
		scrollPane.setViewportView(meuList);
		
		System.out.println(servicosAtuais.size());
		
		for (int i = 0; i < servicosAtuais.size(); i++){
			minhasStrings.add(servicosAtuais.get(i).get(i).toString());
		}
		
		for ( String s : minhasStrings) {
			System.out.println(s);
			modeling.addElement(s);
		}
	}
}
