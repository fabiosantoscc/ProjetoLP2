package interfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;

import classes.servicos.Servico;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.ImageIcon;

import executar.Run;


public class BuscarRestaurante extends JPanel {
	private JTextField textCPF;

	/**
	 * Create the panel.
	 */
	List<Servico> servicosAtuais = null;
	public BuscarRestaurante() {
		setLayout(null);
		
		JLabel lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		JLabel lblRestaurante = new JLabel("Restaurante");
		lblRestaurante.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblRestaurante.setBounds(38, 29, 175, 40);
		add(lblRestaurante);
		
		JLabel lblCPF = new JLabel("CPF do Hospede");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCPF.setBounds(204, 136, 114, 21);
		add(lblCPF);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCPF.setColumns(10);
		textCPF.setBounds(344, 136, 136, 20);
		add(textCPF);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(BuscarRestaurante.class.getResource("/Icons/zoom.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					MenuPrincipal.adicionarRestaurante = new AdicionarRestaurante(Run.hotel.pesquisaHospede(textCPF.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.adicionarRestaurante, "28");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "28");
					textCPF.setText("");
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage());
				}
			}
		});
		btnBuscar.setBounds(297, 192, 106, 29);
		add(btnBuscar);

	}
}