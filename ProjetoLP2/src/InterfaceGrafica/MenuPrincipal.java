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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuPrincipal {

	public static CardLayout cl = new CardLayout();
	JFrame frame = new JFrame();
	static public JPanel panel0 = new JPanel();
	DefaultMenu menuPadrao = new DefaultMenu();
	AdicionaHospede adicionarHospede = new AdicionaHospede();
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
	
	

	
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenu mnContratos = new JMenu("Contratos");
	private final JMenuItem mntmNewMenuItem_3 = new JMenuItem("Check in");
	private final JMenuItem mntmNewMenuItem_4 = new JMenuItem("Pesquisar");
	private final JMenuItem mntmNewMenuItem_5 = new JMenuItem("Check out");
	private final JMenuItem mntmAgendar = new JMenuItem("Agendar");
	private final JLabel lblInicio = new JLabel("  Inicio   ");
	private final JMenuItem mntmNewMenuItem_2 = new JMenuItem("Atualizar");

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
