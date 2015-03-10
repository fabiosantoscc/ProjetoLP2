package interfaceGráfica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import executar.Run;

public class BuscarAluguelDeCarros extends JPanel {
	private JTextField textCPF;

	/**
	 * Create the panel.
	 */
	public BuscarAluguelDeCarros() {
		setLayout(null);
		
		JLabel lblAluguelDeCarro = new JLabel("Aluguel de Carro");
		lblAluguelDeCarro.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAluguelDeCarro.setBounds(38, 29, 231, 40);
		add(lblAluguelDeCarro);
		
		JLabel lblCPF = new JLabel("CPF do Hospede");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCPF.setBounds(149, 157, 122, 21);
		add(lblCPF);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCPF.setColumns(10);
		textCPF.setBounds(293, 157, 153, 20);
		add(textCPF);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(BuscarAluguelDeCarros.class.getResource("/Icons/zoom.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				MenuPrincipal.adcAluguelDeCarros = new AdicionarAlugueldeCarros(Run.hotel.pesquisaHospede(textCPF.getText()));
				MenuPrincipal.panel0.add(MenuPrincipal.adcAluguelDeCarros, "painelAdcAluguelDeCarros");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "painelAdcAluguelDeCarros");
				textCPF.setText("");
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage());
				}
			}
		});
		btnBuscar.setBounds(249, 212, 101, 30);
		add(btnBuscar);

	}
}