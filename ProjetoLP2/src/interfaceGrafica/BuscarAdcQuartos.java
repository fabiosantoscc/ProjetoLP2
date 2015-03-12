package interfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

import executar.Run;

public class BuscarAdcQuartos extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	public BuscarAdcQuartos() {
		setLayout(null);
		
		JLabel lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
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
				MenuPrincipal.panel0.add(MenuPrincipal.adcquartos, "painelAdcQuartos");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "painelAdcQuartos");
				cpfAPesquisar.setText("");
				}catch(Exception c){
					
				}
			}
		});
		textCPF.setBounds(262, 253, 111, 25);
		add(textCPF);
	}
}