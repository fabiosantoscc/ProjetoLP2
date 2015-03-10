/*("Camas e Quartos disponíveis: \nCamas Extras : "+Run.hotel.getCamaExtra()
				+"\nQuartos\n Presidencial: "+Run.hotel.getQuartoPresidencial()+"\nLuxo Simples: "+Run.hotel.getQuartoLuxoSimples()
				+"\nLuxo Duplo: "+Run.hotel.getQuartoLuxoDuplo()+"\nLuxo Triplo: "+Run.hotel.getQuartoLuxoTriplo()
				+"\nExecutivo Simples: "+Run.hotel.getQuartoExecutivoSimples()+"\n Executivo Duplo: "+Run.hotel.getQuartoExecutivoDuplo()
				+"\nExecutivo Triplo: "+Run.hotel.getQuartoExecutivoTriplo());*/
package interfaceGráfica;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import classes.Arquivos;
import classes.dadosDoHospede.Hospede;
import classes.servicos.Quarto;
import classes.servicos.QuartoExecutivoDuplo;
import classes.servicos.QuartoExecutivoSimples;
import classes.servicos.QuartoExecutivoTriplo;
import classes.servicos.QuartoLuxoDuplo;
import classes.servicos.QuartoLuxoSimples;
import classes.servicos.QuartoLuxoTriplo;
import classes.servicos.QuartoPresidencial;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JButton;

import excecoes.ContratoAbertoException;
import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;
import executar.Run;

public class AtualizarQuarto extends JPanel {

	/**
	 * Create the panel.
	 */
	
	ArrayList<String> quartos = new ArrayList<>(Arrays.asList("Presidencial", "Luxo Simples", "Luxo Duplo", "Luxo Triplo","Executivo Simples", "Executivo Duplo", "Executivo Triplo"));
	
	public AtualizarQuarto(Quarto quartoAtual) {
		setLayout(null);
		
		JLabel lblAdicionarQuarto = new JLabel("Adicionar Quarto");
		lblAdicionarQuarto.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAdicionarQuarto.setBounds(22, 30, 219, 27);
		add(lblAdicionarQuarto);
		
		JLabel lblTipoQuarto = new JLabel("Tipo de quarto");
		lblTipoQuarto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoQuarto.setBounds(47, 94, 146, 25);
		add(lblTipoQuarto);
		
		JLabel lblQuantidadeDePessoas = new JLabel("Quantidade de Pessoas");
		lblQuantidadeDePessoas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantidadeDePessoas.setBounds(53, 182, 188, 25);
		add(lblQuantidadeDePessoas);
		
		JSpinner spinnerQuantidadePessoas = new JSpinner();
		spinnerQuantidadePessoas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerQuantidadePessoas.setBounds(266, 186, 48, 20);
		add(spinnerQuantidadePessoas);
		
		JLabel lblQuantidadeDeCamas = new JLabel("Quantidade de Camas Extras");
		lblQuantidadeDeCamas.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuantidadeDeCamas.setBounds(47, 238, 219, 25);
		add(lblQuantidadeDeCamas);
		
		JSpinner spinnerQuantidadeCamas = new JSpinner();
		spinnerQuantidadeCamas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerQuantidadeCamas.setBounds(266, 242, 48, 20);
		add(spinnerQuantidadeCamas);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					quartoAtual.setQuantidadeDePessoas(Integer.parseInt(spinnerQuantidadePessoas.getValue().toString()));
					JOptionPane.showMessageDialog(null, "Hospede Atualizado com Sucesso");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "MenuPadrao");
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (QuantidadeDePessoasInvalidaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e1) {
					e1.getMessage();
				}
			}
		});
		btnAtualizar.setBounds(482, 439, 119, 37);
		add(btnAtualizar);
		
	}
}
