package InterfaceGrafica;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.AdjustmentEvent;


public class ContratosDoHospede extends JFrame {

	ArrayList<String> list = new ArrayList<String>();
	private JPanel contentPane;
	private JTextField texto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteJComboBox frame = new TesteJComboBox();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContratosDoHospede() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String c = (String) comboBox.getSelectedItem();
				texto.setText(c);
			}
		});
		comboBox.setBounds(40, 58, 354, 20);
		contentPane.add(comboBox);
		
		texto = new JTextField();
		texto.setBounds(175, 135, 86, 20);
		contentPane.add(texto);
		texto.setColumns(10);
		comboBox.removeAllItems();
		for(int i = 0; i < list.size(); i++){
			comboBox.addItem(list.get(i));
		}
	}
}
