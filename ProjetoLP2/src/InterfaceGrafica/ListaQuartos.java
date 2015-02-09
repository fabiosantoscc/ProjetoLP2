package InterfaceGrafica;

import java.awt.Font;
import java.util.List;
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
import classes.Quarto;
import classes.Servicos;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ListaQuartos extends JPanel {

	/**
	 * Create the panel.
	 */
	List<Servicos> servicosAtuais;
	ArrayList<String> nomeServicos = new ArrayList<String>();
	ArrayList<String> minhasStrings = new ArrayList<String>();
	JList meuList;
	private DefaultListModel modeling = new DefaultListModel();
	public ListaQuartos(Hospede hospedeAtual) {
		setLayout(null);
		
		
		try {
			servicosAtuais = Run.hotel.getServicosHospede(hospedeAtual);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		JLabel lblListaDeContratos = new JLabel("Lista de Serviços");
		lblListaDeContratos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListaDeContratos.setBounds(44, 49, 184, 31);
		add(lblListaDeContratos);

		JLabel lblHospede = new JLabel("Hospede:");
		lblHospede.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHospede.setBounds(47, 122, 82, 14);
		add(lblHospede);
		
		JLabel label = new JLabel(hospedeAtual.getNome());
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(139, 124, 243, 14);
		add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 241, 606, 223);
		add(scrollPane);
		
		meuList = new JList(modeling);
		scrollPane.setViewportView(meuList);
		
		System.out.println(servicosAtuais.size());
		
		for (int i = 0; i < servicosAtuais.size(); i++){
			if ( servicosAtuais.get(i) instanceof Quarto){
				minhasStrings.add(servicosAtuais.get(i).toString());
			}
		}
		
		for ( String s : minhasStrings) {
			modeling.addElement(s);
		}
	}
}
