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

public class MenuPrincipal {

	JFrame frame = new JFrame();
	JPanel panel0 = new JPanel();
	AdicionarHospede adicionarHospede = new AdicionarHospede();
	BuscarHospede buscarHospede = new BuscarHospede();
	CardLayout cl = new CardLayout();
	private final JMenuBar menuBar = new JMenuBar();
	private final JMenuItem mntmAtualizar = new JMenuItem("Atualizar ");

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
		panel0.add(adicionarHospede, "1");
		panel0.add(buscarHospede, "2");
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		panel0.add(mntmNewMenuItem_2, "name_4226480899595");
		frame.setResizable(false);
		
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Hospedes");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Buscar");
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
		
		mnNewMenu.add(mntmAtualizar);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame.getContentPane().add(panel0);
		frame.setBounds(100, 100, 781, 601);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
			  
			  javax.swing.JFrame frame_1 = new javax.swing.JFrame();
			  __wbp_panel.add(frame_1);
		}
	}
}
