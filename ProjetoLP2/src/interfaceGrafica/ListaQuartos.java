package interfaceGrafica;

import java.awt.Rectangle;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import classes.dadosDoHospede.Hospede;
import classes.servicos.Quarto;
import classes.servicos.Servico;

import javax.swing.JList;
import javax.swing.JScrollPane;

import executar.Run;

public class ListaQuartos extends JPanel {

	private List<Servico> servicosAtuais;
	private List<Quarto> quartosAtuais;
	private ArrayList<String> nomeServicos = new ArrayList<String>();
	private ArrayList<String> minhasStrings = new ArrayList<String>();
	private JList meuList;
	private DefaultListModel modeling = new DefaultListModel();
	private JLabel lblLogoHotel, lblListaDeContratos, lblHospede;
	private JScrollPane scrollPane;
	private JButton btnAtualizarQuarto;
	
	public ListaQuartos(Hospede hospedeAtual) {
		setLayout(null);
		
		lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		try {
			servicosAtuais = Run.hotel.getServicosHospede(hospedeAtual);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		lblListaDeContratos = CriaObjetosNaTela.criaLabel("Quartos", new Rectangle(44, 49, 201, 31), CriaObjetosNaTela.getFontePadrao(24), null, null);
		add(lblListaDeContratos);

		lblHospede = CriaObjetosNaTela.criaLabel("Hospede: "+hospedeAtual.getNome(), new Rectangle(47, 122, 527, 20), CriaObjetosNaTela.getFontePadrao(16), null, null);
		add(lblHospede);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 241, 606, 202);
		add(scrollPane);
		
		meuList = new JList(modeling);
		scrollPane.setViewportView(meuList);
		
		btnAtualizarQuarto = CriaObjetosNaTela.criaBotao("Atualizar Quarto", new Rectangle(531, 486, 137, 41), CriaObjetosNaTela.getFontePadrao(15), null, null);
		btnAtualizarQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for ( Servico servico : servicosAtuais ) {
					if ( ((String) meuList.getSelectedValue()).equals(servico.toString()) ) {
						MenuPrincipal.atualizarQuarto = new AtualizarQuarto((Quarto) servico);
						MenuPrincipal.panel0.add(MenuPrincipal.atualizarQuarto, "30");
						MenuPrincipal.cl.show(MenuPrincipal.panel0, "30");
					}
				}
				
			}
		});
		add(btnAtualizarQuarto);
		
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
