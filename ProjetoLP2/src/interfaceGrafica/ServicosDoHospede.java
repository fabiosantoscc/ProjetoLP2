package interfaceGrafica;

import java.awt.Font;
import java.awt.Rectangle;
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

	private JLabel lblListaDeContratos, lblHospede;
	private List<Servico> servicosAtuais;
	private List<String> nomeServicos = new ArrayList<String>();
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
		
		lblListaDeContratos = CriaObjetosNaTela.criaLabel("Lista de Serviços", new Rectangle(44, 49, 184, 31), CriaObjetosNaTela.getFontePadrao(20), null, null);
		add(lblListaDeContratos);

		lblHospede = CriaObjetosNaTela.criaLabel("Hospede: "+hospedeAtual.getNome(), new Rectangle(47, 122, 501, 14), CriaObjetosNaTela.getFontePadrao(16), null, null);
		add(lblHospede);
		
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
