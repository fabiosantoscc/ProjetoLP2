package InterfaceGrafica;

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

import Executar.Run;
import javax.swing.ImageIcon;

public class BuscarAdcQuartos extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	public BuscarAdcQuartos() {
		setLayout(null);
		
		JLabel lblAdicionarQuartos = new JLabel("Adicionar Quartos");
		lblAdicionarQuartos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAdicionarQuartos.setBounds(38, 29, 242, 40);
		add(lblAdicionarQuartos);
		
		JLabel lblCPF = new JLabel("CPF do Hospede");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCPF.setBounds(162, 148, 118, 21);
		add(lblCPF);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(312, 148, 155, 21);
		add(cpfAPesquisar);
		
		JButton textCPF = new JButton("Buscar");
		textCPF.setIcon(new ImageIcon(BuscarAdcQuartos.class.getResource("/Icons/zoom.png")));
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				MenuPrincipal.adcquartos = new AdicionarQuartos(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
				MenuPrincipal.panel0.add(MenuPrincipal.adcquartos, "18");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "18");
				cpfAPesquisar.setText("");
				}catch(Exception c){
					
				}
			}
		});
		textCPF.setBounds(262, 253, 111, 25);
		add(textCPF);
	}
}