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

import Executar.Run;
import classes.Arquivos;
import classes.Contrato;
import classes.dadosDoHospede.Hospede;
import classes.servicos.Servico;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class RemoverServicos extends JPanel {

	/**
	 * Create the panel.
	 */
	List<Servico> servicosAtuais;
	ArrayList<String> nomeServicos = new ArrayList<String>();
	ArrayList<String> minhasStrings = new ArrayList<String>();
	JList listServicos;
	private DefaultListModel modeling = new DefaultListModel();
	public RemoverServicos(Hospede hospedeAtual) {
		setLayout(null);
		
		
		try {
			servicosAtuais = Run.hotel.getServicosHospede(hospedeAtual);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		JLabel lblListaDeContratos = new JLabel("Lista de Servi�os");
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
		scrollPaneServicos.setBounds(44, 241, 606, 170);
		add(scrollPaneServicos);
		
		listServicos = new JList(modeling);
		scrollPaneServicos.setViewportView(listServicos);
		
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for ( Servico servico : servicosAtuais ) {
					if ( ((String) listServicos.getSelectedValue()).equals(servico.toString()) ) {
						servicosAtuais.remove(servico);
						try {
							Arquivos.salvaHotel(Run.hotel);
						} catch (Exception e1) {
							e1.getMessage();
						}
					}
				}
				
			}
		});
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemover.setBounds(320, 458, 162, 40);
		add(btnRemover);
		
		System.out.println(servicosAtuais.size());
		
		for (int i = 0; i < servicosAtuais.size(); i++){
			minhasStrings.add(servicosAtuais.get(i).toString());
		}
		
		for ( String s : minhasStrings) {
			System.out.println(s);
			modeling.addElement(s);
		}
	}
}
