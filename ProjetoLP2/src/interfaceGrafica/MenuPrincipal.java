package interfaceGrafica;

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

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;

public class MenuPrincipal {

	JFrame frame = new JFrame();
	protected static CardLayout cl = new CardLayout();
	protected static JPanel panel0 = new JPanel();
	protected static PainelHospede telaHospede;
	protected static AdicionarContrato adicionarContrato;
	protected static AtualizarHospede atualizarHospede;
	protected static AdicionarBabySitter painelBabySitter;
	protected static AdicionarQuartos adcquartos;
	protected static AdicionarAlugueldeCarros adcAluguelDeCarros;
	protected static AdicionarQuartoObrigatorio adcQuartoObrigatorio;
	protected static ContratosDoHospede contratosDoHospede;
	protected static ListaQuartos listaQuartosAtualizar;
	protected static ServicosDoHospede servicosDoHospede;
	protected static RemoverServicos removerServicos;
	protected static AdicionarRestaurante adicionarRestaurante;
	protected static CheckOut checkOut;
	protected static AtualizarQuarto atualizarQuarto;
	protected static NotaEComentario notaEComentario;
	private DefaultMenu menuPadrao = new DefaultMenu();
	private AdicionarHospede adicionarHospede = new AdicionarHospede();
	private BuscarHospede buscarHospede = new BuscarHospede();
	private BuscarContratos buscarContratos = new BuscarContratos();
	private BuscarCheckIn buscarCheckIn = new BuscarCheckIn();
	private BuscarCheckOut buscarCheckOut = new BuscarCheckOut();
	private BuscarHospedeAtualizar buscarHospedeAtualizar = new BuscarHospedeAtualizar();
	private BuscarAdcQuartos buscarAdcQuarto = new BuscarAdcQuartos();
	private BuscarAluguelDeCarros buscarAluguelDeCarros = new BuscarAluguelDeCarros();
	private BuscarAdcBabySitter buscarBabySitter = new BuscarAdcBabySitter();
	private BuscarQuartoAtualizar buscarQuartoAtualizar = new BuscarQuartoAtualizar();
	private BuscarServicos buscarServicos = new BuscarServicos();
	private BuscarRemoverServicos buscarRemoverServicos = new BuscarRemoverServicos();
	private BuscarRestaurante buscarRestauranteAtualizar = new BuscarRestaurante();
	private TelaSobre telaSobre = new TelaSobre();
	
	
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnContratos = new JMenu("Contratos");
	private final JMenuItem mntmNewMenuItem_3 = new JMenuItem("Check in");
	private final JMenuItem mntmNewMenuItem_4 = new JMenuItem("Pesquisar");
	private final JMenuItem mntmNewMenuItem_5 = new JMenuItem("Check out");
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
	private final JMenu mnNewMenu_1 = new JMenu("Mais Op\u00E7\u00F5es");
	private final JMenuItem mntmNewMenuItem_6 = new JMenuItem("Sobre");
	private final JMenuItem mntmNotaDeAceitao = new JMenuItem("Nota de Aceita\u00E7\u00E3o e Coment\u00E1rios");
	private final JLabel lblSair = new JLabel("Sair");

	/**
	 * Create the application.
	 */
	
	public MenuPrincipal() {
		initialize();
		panel0.setLayout(cl);
		panel0.add(menuPadrao, "MenuPadrao");
		panel0.add(adicionarHospede, "adicionarHospede");
		panel0.add(buscarHospede, "buscarHospede");
		panel0.add(buscarContratos, "buscarContratos");
		panel0.add(buscarHospedeAtualizar, "9");
		panel0.add(buscarCheckIn, "buscarCheckIn");
		panel0.add(buscarCheckOut, "buscarCheckOut");
		panel0.add(buscarAdcQuarto, "buscarAdcQuarto");
		panel0.add(buscarAluguelDeCarros, "buscarAluguelDeCarros");
		panel0.add(buscarBabySitter, "buscarBabySitter");
		panel0.add(buscarQuartoAtualizar, "buscarQuartoAtualizar");
		panel0.add(buscarServicos, "buscarServicos");
		panel0.add(buscarRemoverServicos, "buscarRemoverServicos");
		panel0.add(buscarRestauranteAtualizar, "buscarRestauranteAtualizar");
		panel0.add(telaSobre, "telaSobre");
		frame.setResizable(false);
		
		
		
		frame.setJMenuBar(menuBar);
		lblInicio.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/house.png")));
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				cl.show(panel0, "MenuPadrao");
			}
		});
		
		menuBar.add(lblInicio);
		
		JMenu mnNewMenu = new JMenu("Hospedes");
		mnNewMenu.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/group.png")));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Pesquisar");
		mntmNewMenuItem.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/user_go.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "buscarHospede");
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Adicionar");
		mntmNewMenuItem_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/user_add.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "adicionarHospede");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		mntmNewMenuItem_2.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/user_edit.png")));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "9");
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_2);
		mnContratos.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/report.png")));
		
		menuBar.add(mnContratos);
		mntmNewMenuItem_4.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/report_go.png")));
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "buscarContratos");
			}
		});
		
		mnContratos.add(mntmNewMenuItem_4);
		mntmNewMenuItem_3.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/report_add.png")));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "buscarCheckIn");
			}
		});
		
		mnContratos.add(mntmNewMenuItem_3);
		mntmNewMenuItem_5.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/report_delete.png")));
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "buscarCheckOut");
			}
		});
		
		mnContratos.add(mntmNewMenuItem_5);
		mnServios.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/cart.png")));
		
		menuBar.add(mnServios);
		mntmPesquisar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/cart_go.png")));
		mntmPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			cl.show(panel0, "buscarServicos");	
			}
		});
		
		mnServios.add(mntmPesquisar);
		mnAdicionar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/cart_add.png")));
		
		mnServios.add(mnAdicionar);
		mnAdicionar.add(mntmBabySitter);
		mntmQuartos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "buscarAdcQuarto");	
			}
		});
		
		mnAdicionar.add(mntmQuartos);
		mnAdicionar.add(mntmAluguelDeVeculo);
		
		JMenuItem mntmRestaurante_1 = new JMenuItem("Restaurante");
		mntmRestaurante_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "buscarRestauranteAtualizar");
			}
		});
		mnAdicionar.add(mntmRestaurante_1);
		mnAtualizar.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/cart_edit.png")));
		
		mnServios.add(mnAtualizar);
		mntmQuartos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "buscarQuartoAtualizar");
			}
		});
		
		mnAtualizar.add(mntmQuartos_1);
		mntmRemover.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/cart_delete.png")));
		mntmRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "buscarRemoverServicos");	
			}
		});
		
		mnServios.add(mntmRemover);
		mnNewMenu_1.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/cog.png")));
		
		menuBar.add(mnNewMenu_1);
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cl.show(panel0, "telaSobre");
			}
		});
		mntmNewMenuItem_6.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/help.png")));
		
		mnNewMenu_1.add(mntmNewMenuItem_6);
		mntmNotaDeAceitao.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/comment.png")));
		mntmNotaDeAceitao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				notaEComentario = new NotaEComentario();
				panel0.add(notaEComentario, "notaEComentario");
				cl.show(panel0, "notaEComentario");
			}
		});
		
		mnNewMenu_1.add(mntmNotaDeAceitao);
		
		JMenuItem mntmServicosMaisContratados = new JMenuItem("Servi\u00E7os mais contratados");
		mntmServicosMaisContratados.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/chart_bar.png")));
		mnNewMenu_1.add(mntmServicosMaisContratados);
		lblSair.setIcon(new ImageIcon(MenuPrincipal.class.getResource("/Icons/cancel.png")));
		lblSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaLogin t = new TelaLogin();
				frame.dispose();
				t.setVisible(true);
			}
		});
		menuBar.add(lblSair);
		mntmAluguelDeVeculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "buscarAluguelDeCarros");
			}
		});
		mntmBabySitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(panel0, "buscarBabySitter");
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
}
