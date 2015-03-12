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

	private List<Contrato> contratosAtuais;
	private List<String> nomeServicos = new ArrayList<String>();
	private List<String> minhasStrings = new ArrayList<String>();
	private JList listContratos;
	private DefaultListModel modeling = new DefaultListModel();
	private JLabel lblLogoHotel, lblListaDeContratos, lblHospede;
	private JButton btnVisualizarServios;
	private JScrollPane scrollPaneContratos;
	
	public ContratosDoHospede(Hospede hospedeAtual) {
		setLayout(null);
		
		lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		contratosAtuais = Run.hotel.pesquisarContratos(hospedeAtual);
		
		lblListaDeContratos = CriaObjetosNaTela.criaLabel("Lista de Contratos", new Rectangle(44, 49, 270, 31), CriaObjetosNaTela.getFontePadrao(24), null, null);
		add(lblListaDeContratos);
		
		lblHospede = CriaObjetosNaTela.criaLabel("Hospede: "+hospedeAtual.getNome(), new Rectangle(47, 122, 485, 20), CriaObjetosNaTela.getFontePadrao(16), null, null);
		add(lblHospede);
		
		btnVisualizarServios = CriaObjetosNaTela.criaBotao("Visualizar Servi\u00E7os", new Rectangle(454, 416, 141, 31), CriaObjetosNaTela.getFontePadrao(14), null, null);
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
		add(btnVisualizarServios);
		
		scrollPaneContratos = new JScrollPane();
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
