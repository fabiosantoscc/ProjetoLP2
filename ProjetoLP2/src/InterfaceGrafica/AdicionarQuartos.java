/*("Camas e Quartos disponíveis: \nCamas Extras : "+Run.hotel.getCamaExtra()
				+"\nQuartos\n Presidencial: "+Run.hotel.getQuartoPresidencial()+"\nLuxo Simples: "+Run.hotel.getQuartoLuxoSimples()
				+"\nLuxo Duplo: "+Run.hotel.getQuartoLuxoDuplo()+"\nLuxo Triplo: "+Run.hotel.getQuartoLuxoTriplo()
				+"\nExecutivo Simples: "+Run.hotel.getQuartoExecutivoSimples()+"\n Executivo Duplo: "+Run.hotel.getQuartoExecutivoDuplo()
				+"\nExecutivo Triplo: "+Run.hotel.getQuartoExecutivoTriplo());*/
package InterfaceGrafica;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import classes.Hospede;
import classes.QuartoExecutivoDuplo;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JButton;

public class AdicionarQuartos extends JPanel {

	/**
	 * Create the panel.
	 */
	
	ArrayList<String> quartos = new ArrayList<>(Arrays.asList("Presidencial", "Luxo Simples", "Luxo Duplo", "Luxo Triplo","Executivo Simples", "Executivo Duplo", "Executivo Triplo"));
	
	public AdicionarQuartos(Hospede hospedeAtual) {
		setLayout(null);
		
		JLabel lblAdicionarQuarto = new JLabel("Adicionar Quarto");
		lblAdicionarQuarto.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAdicionarQuarto.setBounds(22, 30, 219, 27);
		add(lblAdicionarQuarto);
		
		JLabel lblNewLabel = new JLabel("Tipo de quarto");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(47, 94, 146, 25);
		add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboBox.getSelectedItem();
				//textField.setText(c);

				
			}
		});
		
		comboBox.setBounds(50, 156, 173, 20);
		add(comboBox);
		
		JLabel lblQuantidadeDePessoas = new JLabel("Quantidade de Pessoas");
		lblQuantidadeDePessoas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDePessoas.setBounds(47, 288, 188, 25);
		add(lblQuantidadeDePessoas);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(245, 292, 48, 20);
		add(spinner);
		
		JLabel lblQuantidadeDeCamas = new JLabel("Quantidade de Camas Extras");
		lblQuantidadeDeCamas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDeCamas.setBounds(47, 364, 219, 25);
		add(lblQuantidadeDeCamas);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(268, 369, 48, 20);
		add(spinner_1);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
			}
		});
		btnAdicionar.setBounds(481, 439, 89, 23);
		add(btnAdicionar);
		

		

		
		for(int i = 0; i < quartos.size(); i++){
			comboBox.addItem(quartos.get(i));
		}

	}
}
