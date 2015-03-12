package interfaceGrafica;

import classes.Arquivos;
import classes.Contrato;
import classes.dadosDoHospede.Hospede;
import classes.servicos.Servico;
import executar.Run;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;

import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContratosDoHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	
	List<Servico> contratosAtuais;
	List<String> nomeServicos = new ArrayList<String>();
	List<String> minhasStrings = new ArrayList<String>();
	JList listContratos;
	private DefaultListModel modeling = new DefaultListModel();

	
	public ContratosDoHospede(Hospede hospedeAtual) {
		setLayout(null);
		
		JLabel lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		List<Contrato> contratosAtuais = Run.hotel.pesquisarContratos(hospedeAtual);
		
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
				try{
					MenuPrincipal.servicosDoHospede = new ServicosDoHospede(hospedeAtual);
					MenuPrincipal.panel0.add(MenuPrincipal.servicosDoHospede, "22");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "22");
				}catch(Exception e){
					e.getMessage();
				}
			}
		});
		btnVisualizarServios.setBounds(454, 416, 141, 31);
		add(btnVisualizarServios);
		
		JScrollPane scrollPaneContratos = new JScrollPane();
		scrollPaneContratos.setBounds(44, 185, 551, 201);
		add(scrollPaneContratos);
		
		listContratos = new JList<>(modeling);
		scrollPaneContratos.setViewportView(listContratos);
		
		for (int i = 0; i < contratosAtuais.size(); i++){
			minhasStrings.add(contratosAtuais.get(i).toString());
		}
		
		for ( String contrato : minhasStrings) {
			modeling.addElement(contrato);
		}
	}
}
