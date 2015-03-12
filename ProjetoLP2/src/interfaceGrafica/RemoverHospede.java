package interfaceGrafica;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import classes.Contrato;
import classes.dadosDoHospede.Hospede;
import classes.servicos.Quarto;
import classes.servicos.Servico;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import executar.Run;

public class RemoverHospede extends JPanel {

	private HashMap<Hospede, List<Contrato>> hospedesAtuais;
	private ArrayList<String> nomeServicos = new ArrayList<String>();
	private ArrayList<String> minhasStrings = new ArrayList<String>();
	private JList meuList;
	private DefaultListModel modeling = new DefaultListModel();
	private JLabel lblLogoHotel, lblListaDeHospedes;
	private JScrollPane scrollPane;
	private JButton btnRemoverHospede;
	
	public RemoverHospede() {
		setLayout(null);
		
		lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		try {
			hospedesAtuais = Run.hotel.getHospedes();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		lblListaDeHospedes = CriaObjetosNaTela.criaLabel("Hospedes Atuais", new Rectangle(44, 49, 201, 31), CriaObjetosNaTela.getFontePadrao(24), null, null);
		add(lblListaDeHospedes);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 241, 606, 202);
		add(scrollPane);
		
		meuList = new JList(modeling);
		scrollPane.setViewportView(meuList);
		
		btnRemoverHospede = CriaObjetosNaTela.criaBotao("Remover Hospede", new Rectangle(531, 486, 137, 41), CriaObjetosNaTela.getFontePadrao(15), null, null);
		btnRemoverHospede.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					for (Hospede hospede : hospedesAtuais.keySet()) {
						if ( ((String) meuList.getSelectedValue()).equals("Nome: "+hospede.getNome()+" e CPF: "+hospede.getCpf()) ) {
							minhasStrings.remove(meuList.getSelectedValue() + "");
							modeling.removeAllElements();
							for ( String s : minhasStrings) {
								modeling.addElement(s);
							}
							JOptionPane.showMessageDialog(null, "Hospede Removido");
							Run.hotel.removeHospede(hospede.getCpf());
						}
					}
				} catch (Exception e) {
					e.getMessage();
				}
			}
		});
		add(btnRemoverHospede);
		

		
		for (Hospede h : hospedesAtuais.keySet()){
			minhasStrings.add("Nome: "+h.getNome()+" e CPF: "+h.getCpf());
		}
		for ( String s : minhasStrings) {
			modeling.addElement(s);
		}
	}
}
