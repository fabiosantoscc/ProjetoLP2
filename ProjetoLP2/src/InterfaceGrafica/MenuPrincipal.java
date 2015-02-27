package InterfaceGrafica;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import classes.Hospede;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPrincipal {

	public static CardLayout cl = new CardLayout();
	JFrame frame = new JFrame();
	static public JPanel panel0 = new JPanel();
	DefaultMenu menuPadrao = new DefaultMenu();
	AdicionarHospede adicionarHospede = new AdicionarHospede();
	BuscarHospede buscarHospede = new BuscarHospede();
	public static PainelHospede telaHospede;
	public static AdicionarContrato adicionarContrato;
	BuscarContratos buscarContratos = new BuscarContratos();
	FecharContrato fecharContrato = new FecharContrato();
	AgendarContrato agendarContrato = new AgendarContrato();
	public static AtualizarHospede atualizarHospede;
	BuscarCheckIn buscarCheckIn = new BuscarCheckIn();
	BuscarCheckOut buscarCheckOut = new BuscarCheckOut();
	BuscarHospedeAtualizar buscarHospedeAtualizar = new BuscarHospedeAtualizar();
	public static ContratosDoHospede contratosDoHospede;
	BuscarAdcQuartos buscarAdcQuarto = new BuscarAdcQuartos();
	BuscarAluguelDeCarros buscarAluguelDeCarros = new BuscarAluguelDeCarros();
	BuscarAdcBabySitter buscarBabySitter = new BuscarAdcBabySitter();
	public static AdicionarBabySitter painelBabySitter;
	public static AdicionarQuartos adcquartos;
	public static AdicionarAlugueldeCarros adcAluguelDeCarros;
	public static AdicionarQuartoObrigatorio adcQuartoObrigatorio;
	BuscarQuartoAtualizar buscarQuartoAtualizar = new BuscarQuartoAtualizar();
	public static ListaQuartos listaQuartosAtualizar;
	public static ServicosDoHospede servicosDoHospede;
	BuscarServicos buscarServicos = new BuscarServicos();
	BuscarRemoverServicos buscarRemoverServicos = new BuscarRemoverServicos();
	public static RemoverServicos removerServicos;
	BuscarRestauranteAtualizar buscarRestauranteAtualizar = new BuscarRestauranteAtualizar();
	public static AtualizarRestaurante atualizarRestaurante;
	public static CheckOut checkOut;
	public static AtualizarQuarto atualizarQuarto;
	public static NotaEComentario notaEComentario;
	
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnContratos = new JMenu("Contratos");
	private final JMenuItem mntmNewMenuItem_3 = new JMenuItem("Check in");
	private final JMenuItem mntmNewMenuItem_4 = new JMenuItem("Pesquisar");
	private final JMenuItem mntmNewMenuItem_5 = new JMenuItem("Check out");
	private final JMenuItem mntmAgendar = new JMenuItem("Agendar");
	private final JLabel lblInicio = new JLabel("  Inicio   ");
	private final JMenuItem mntmNewMenuItem_2 = new JMenuItem("Atualizar");
	private final JMenu mnServios = new JMenu("Servi\u00E7os");
	private final JMenuItem mntmBabySitter = new JMenuItem("Baby Sitter");
	private final JMenuItem mntmAluguelDeVeculo = new JMenuItem("Aluguel de Ve\u00EDculo");
	private final JMenu mnAdicionar = new JMenu("Adicionar");
	private final JMenuItem mntmQuartos = new JMenuItem("Quartos");
	private final JMenu mnAtualizar = new JMenu("Atualizar");
	private final JMenuItem mntmPesquisar = new JMenuItem("Pesquisar");
	private final JMenuItem mntmQuartos_1 = new JMenuItem("Quartos");
	private final JMenuItem mntmRemover = new JMenuItem("Remover");
	private final JMenuItem mntmRestaurante = new JMenuItem("Restaurante");
	private final JMenu mnNewMenu_1 = new JMenu("Mais Op\u00E7\u00F5es");
	private final JMenuItem mntmNewMenuItem_6 = new JMenuItem("Sobre");
	private final JMenuItem mntmNotaDeAceitao = new JMenuItem("Nota de Aceita\u00E7\u00E3o e Coment\u00E1rios");

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
		panel0.setLayout(cl);
		panel0.add(menuPadrao, "0");
		panel0.add(adicionarHospede, "1");
		panel0.add(buscarHospede, "2");
		panel0.add(buscarContratos, "4");
		panel0.add(fecharContrato, "5");
		panel0.add(agendarContrato, "6");
		panel0.add(buscarHospedeAtualizar, "9");
		panel0.add(buscarCheckIn, "10");
		panel0.add(buscarCheckOut, "11");
		panel0.add(buscarAdcQuarto, "14");
		panel0.add(buscarAluguelDeCarros, "15");
		panel0.add(buscarBabySitter, "16");
		panel0.add(buscarQuartoAtualizar, "25");
		panel0.add(buscarServicos, "23");
		panel0.add(buscarRemoverServicos, "26");
		panel0.add(buscarRestauranteAtualizar, "27");
		panel0.add(notaEComentario, "30");
		frame.setResizable(false);
		
		
		
		frame.setJMenuBar(menuBar);
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.show(panel0, "0");
			}
		});
		
		menuBar.add(lblInicio);
		
		JMenu mnNewMenu = new JMenu("Hospedes");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pesquisar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "2");
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Adicionar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "1");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "9");
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_2);
		
		menuBar.add(mnContratos);
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "4");
			}
		});
		
		mnContratos.add(mntmNewMenuItem_4);
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "10");
			}
		});
		
		mnContratos.add(mntmNewMenuItem_3);
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "11");
			}
		});
		
		mnContratos.add(mntmNewMenuItem_5);
		mntmAgendar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "6");
			}
		});
		
		mnContratos.add(mntmAgendar);
		
		menuBar.add(mnServios);
		mntmPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			cl.show(panel0, "23");	
			}
		});
		
		mnServios.add(mntmPesquisar);
		
		mnServios.add(mnAdicionar);
		mnAdicionar.add(mntmBabySitter);
		mntmQuartos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "14");	
			}
		});
		
		mnAdicionar.add(mntmQuartos);
		mnAdicionar.add(mntmAluguelDeVeculo);
		
		mnServios.add(mnAtualizar);
		mntmQuartos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "25");
			}
		});
		
		mnAtualizar.add(mntmQuartos_1);
		mntmRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panel0, "27");
			}
		});
		
		mnAtualizar.add(mntmRestaurante);
		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "26");	
			}
		});
		
		mnServios.add(mntmRemover);
		
		menuBar.add(mnNewMenu_1);
		
		mnNewMenu_1.add(mntmNewMenuItem_6);
		mntmNotaDeAceitao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				notaEComentario = new NotaEComentario();
				cl.show(panel0, "30");
			}
		});
		
		mnNewMenu_1.add(mntmNotaDeAceitao);
		mntmAluguelDeVeculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "15");
			}
		});
		mntmBabySitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "16");
			}
		});
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().add(panel0);
		frame.setBounds(100, 100, 781, 601);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
			  
			  javax.swing.JFrame frame_1 = new javax.swing.JFrame();
			  __wbp_panel.add(frame_1);
		}
	}
}
