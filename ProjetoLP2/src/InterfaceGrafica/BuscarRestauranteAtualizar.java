package InterfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import Executar.Run;
import classes.Servicos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;


public class BuscarRestauranteAtualizar extends JPanel {
	private JTextField nomeAPesquisar;
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	List<Servicos> servicosAtuais = null;
	public BuscarRestauranteAtualizar() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Restaurante");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 175, 40);
		add(lblNovoContrato);
		
		JLabel lblCpfDoHospede = new JLabel("Nome do Hospede");
		lblCpfDoHospede.setBounds(50, 123, 114, 21);
		add(lblCpfDoHospede);
		
		nomeAPesquisar = new JTextField();
		nomeAPesquisar.setBounds(190, 123, 114, 20);
		add(nomeAPesquisar);
		nomeAPesquisar.setColumns(10);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setBounds(50, 190, 95, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(190, 190, 114, 20);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					MenuPrincipal.atualizarRestaurante = new AtualizarRestaurante(Run.hotel.pesquisaHospede(cpfAPesquisar.getText(), nomeAPesquisar.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.atualizarRestaurante, "28");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "28");
					nomeAPesquisar.setText("");
					cpfAPesquisar.setText("");
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, "AA");
				}
			}
		});
		button.setBounds(454, 315, 89, 23);
		add(button);

	}
}