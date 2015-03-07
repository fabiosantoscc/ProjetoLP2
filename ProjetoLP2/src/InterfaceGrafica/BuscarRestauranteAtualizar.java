package InterfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import Executar.Run;
import classes.Servico;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.ImageIcon;


public class BuscarRestauranteAtualizar extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	List<Servico> servicosAtuais = null;
	public BuscarRestauranteAtualizar() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Restaurante");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 175, 40);
		add(lblNovoContrato);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(204, 136, 114, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(344, 136, 136, 20);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.setIcon(new ImageIcon(BuscarRestauranteAtualizar.class.getResource("/Icons/zoom.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					MenuPrincipal.atualizarRestaurante = new AtualizarRestaurante(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.atualizarRestaurante, "28");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "28");
					cpfAPesquisar.setText("");
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, "AA");
				}
			}
		});
		button.setBounds(297, 192, 106, 29);
		add(button);

	}
}