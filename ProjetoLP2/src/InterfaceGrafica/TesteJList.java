package InterfaceGrafica;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JList;

public class TesteJList {

	JList meuList;
	private DefaultListModel modeling = new DefaultListModel();
	private List<String> nomes = new ArrayList<String>();
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteJList window = new TesteJList();
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
	public TesteJList() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 84, 370, 130);
		frame.getContentPane().add(scrollPane);
		
		meuList = new JList<>(modeling);
		scrollPane.setViewportView(meuList);
		
		nomes.add("Fabio");
		nomes.add("Fabio");
		nomes.add("Fabio");
		nomes.add("Fabio");
		nomes.add("Fabio");
		nomes.add("Fabio");
		nomes.add("Fabio");
		nomes.add("Fabio");
		nomes.add("Fabio");
		
		for ( String nome : nomes ) {
			modeling.addElement(nome);
		}
	}
}
