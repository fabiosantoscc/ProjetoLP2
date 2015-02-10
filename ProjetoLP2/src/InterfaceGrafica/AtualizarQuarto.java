/*("Camas e Quartos disponíveis: \nCamas Extras : "+Run.hotel.getCamaExtra()
				+"\nQuartos\n Presidencial: "+Run.hotel.getQuartoPresidencial()+"\nLuxo Simples: "+Run.hotel.getQuartoLuxoSimples()
				+"\nLuxo Duplo: "+Run.hotel.getQuartoLuxoDuplo()+"\nLuxo Triplo: "+Run.hotel.getQuartoLuxoTriplo()
				+"\nExecutivo Simples: "+Run.hotel.getQuartoExecutivoSimples()+"\n Executivo Duplo: "+Run.hotel.getQuartoExecutivoDuplo()
				+"\nExecutivo Triplo: "+Run.hotel.getQuartoExecutivoTriplo());*/
package InterfaceGrafica;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Executar.Run;
import classes.Hospede;
import classes.Quarto;
import classes.QuartoExecutivoDuplo;
import classes.QuartoExecutivoSimples;
import classes.QuartoExecutivoTriplo;
import classes.QuartoLuxoDuplo;
import classes.QuartoLuxoSimples;
import classes.QuartoLuxoTriplo;
import classes.QuartoPresidencial;

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

public class AtualizarQuarto extends JPanel {

	/**
	 * Create the panel.
	 */
	
	ArrayList<String> quartos = new ArrayList<>(Arrays.asList("Presidencial", "Luxo Simples", "Luxo Duplo", "Luxo Triplo","Executivo Simples", "Executivo Duplo", "Executivo Triplo"));
	
	public AtualizarQuarto(Quarto quartoAtual) {
		setLayout(null);
		
		JLabel lblAdicionarQuarto = new JLabel("Adicionar Quarto");
		lblAdicionarQuarto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdicionarQuarto.setBounds(22, 30, 219, 27);
		add(lblAdicionarQuarto);
		
		JLabel lblNewLabel = new JLabel("Tipo de quarto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(47, 94, 146, 25);
		add(lblNewLabel);
		
		JLabel lblQuantidadeDePessoas = new JLabel("Quantidade de Pessoas");
		lblQuantidadeDePessoas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDePessoas.setBounds(53, 182, 188, 25);
		add(lblQuantidadeDePessoas);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(266, 186, 48, 20);
		add(spinner);
		
		JLabel lblQuantidadeDeCamas = new JLabel("Quantidade de Camas Extras");
		lblQuantidadeDeCamas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDeCamas.setBounds(47, 238, 219, 25);
		add(lblQuantidadeDeCamas);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(266, 242, 48, 20);
		add(spinner_1);
		
		JButton btnAdicionar = new JButton("Atualizar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					quartoAtual.setQuantidadeDePessoas(Integer.parseInt(spinner.getValue().toString()));
					JOptionPane.showMessageDialog(null, "HospedeAtualizado com Sucesso");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "0");
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (QuantidadeDePessoasInvalidaException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnAdicionar.setBounds(482, 439, 89, 23);
		add(btnAdicionar);
		
	}
}
