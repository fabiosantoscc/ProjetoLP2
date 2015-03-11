package interfaceGrafica;

import java.awt.Font;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import classes.Arquivos;
import classes.Contrato;
import classes.dadosDoHospede.Hospede;
import classes.servicos.Servico;

import javax.swing.JList;
import javax.swing.JScrollPane;

import executar.Run;

public class RemoverServicos extends JPanel {

	/**
	 * Cria um painel para remocao de servicos.
	 */
	
	private List<Servico> servicosAtuais;
	private ArrayList<String> nomeServicos = new ArrayList<String>();
	private ArrayList<String> minhasStrings = new ArrayList<String>();
	private JList listServicos;
	private DefaultListModel modeling = new DefaultListModel();
	public RemoverServicos(Hospede hospedeAtual) {
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
		scrollPaneServicos.setBounds(44, 241, 606, 170);
		add(scrollPaneServicos);
		
		listServicos = new JList(modeling);
		scrollPaneServicos.setViewportView(listServicos);
		
		for (int i = 0; i < servicosAtuais.size(); i++){
			minhasStrings.add(servicosAtuais.get(i).toString());
		}
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  if ( servicosAtuais.size() > 0) {	
				for ( Servico servico : servicosAtuais ) {
					if ( ((String) listServicos.getSelectedValue()).equals(servico.toString()) ) {
						servicosAtuais.remove(servico);
						minhasStrings.remove((String)listServicos.getSelectedValue());
						for ( String s : minhasStrings) {
							modeling.addElement(s);
						}
						JOptionPane.showMessageDialog(null, "Serviço removido");
						try {
							Arquivos.salvaHotel(Run.hotel);
						} catch (Exception e1) {
							e1.getMessage();
						}
					}
				}
			  }
			}
			  
		});
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemover.setBounds(320, 458, 162, 40);
		add(btnRemover);
		
		for ( String s : minhasStrings) {
			modeling.addElement(s);
		}
	}
}
