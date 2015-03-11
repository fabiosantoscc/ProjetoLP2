package interfaceGrafica;

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
import classes.dadosDoHospede.Hospede;
import classes.servicos.Servico;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import executar.Run;

public class ServicosDoHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private List<Servico> servicosAtuais;
//	private List<String> nomeServicos = new ArrayList<String>();
	private List<String> minhasStrings = new ArrayList<String>();
	private JList<String> listServicos;
	private DefaultListModel<String> modeling = new DefaultListModel<String>();
	
	public ServicosDoHospede(Hospede hospedeAtual) {
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
		
		JLabel lblNomeHospede = new JLabel(hospedeAtual.getNome());
		lblNomeHospede.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeHospede.setBounds(139, 124, 243, 14);
		add(lblNomeHospede);
		
		JScrollPane scrollPaneServicos = new JScrollPane();
		scrollPaneServicos.setBounds(44, 241, 606, 223);
		add(scrollPaneServicos);
		
		listServicos = new JList<String>(modeling);
		scrollPaneServicos.setViewportView(listServicos);

		for (int i = 0; i < servicosAtuais.size(); i++){
			minhasStrings.add(servicosAtuais.get(i).toString());
		}
		
		for ( String s : minhasStrings) {
			modeling.addElement(s);
		}
	}
}
