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

public class QuartoAtualizar extends JPanel {

	/**
	 * Create the panel.
	 */
	
	ArrayList<String> quartos = new ArrayList<>(Arrays.asList("Presidencial", "Luxo Simples", "Luxo Duplo", "Luxo Triplo","Executivo Simples", "Executivo Duplo", "Executivo Triplo"));
	
	public QuartoAtualizar(Hospede hospedeAtual) {
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
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboBox.getSelectedItem();
				//textField.setText(c);

				
			}
		});
		
		comboBox.setBounds(50, 149, 173, 27);
		add(comboBox);
		
		JLabel lblQuantidadeDePessoas = new JLabel("Quantidade de Pessoas");
		lblQuantidadeDePessoas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDePessoas.setBounds(47, 288, 188, 25);
		add(lblQuantidadeDePessoas);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinner.setBounds(245, 292, 48, 20);
		add(spinner);
		
		JLabel lblQuantidadeDeCamas = new JLabel("Quantidade de Camas Extras");
		lblQuantidadeDeCamas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDeCamas.setBounds(47, 364, 219, 25);
		add(lblQuantidadeDeCamas);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		spinner_1.setBounds(268, 369, 48, 20);
		add(spinner_1);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch ((String) comboBox.getSelectedItem()) {
				case "Presidencial":
					try {
						int pessoas = Integer.parseInt(spinner.getValue().toString());
						QuartoPresidencial quartoAtual = new QuartoPresidencial(pessoas);
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
						JOptionPane.showMessageDialog(null, "Quarto Adicionado com Sucesso");
						MenuPrincipal.cl.show(MenuPrincipal.panel0, "0");
					} catch (QuantidadeDePessoasInvalidaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (QuartoEsgotadoNoHotelException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (ContratoAbertoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					break;
				case "Luxo Simples":
					try {
						int pessoas = Integer.parseInt(spinner.getValue().toString());
						QuartoLuxoSimples quartoAtual = new QuartoLuxoSimples(pessoas, 1);
						JOptionPane.showMessageDialog(null, "Quarto Adicionado com Sucesso");
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
					} catch (QuantidadeDePessoasInvalidaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (QuartoEsgotadoNoHotelException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					break;
				case "Luxo Duplo":
					try {
						int pessoas = Integer.parseInt(spinner.getValue().toString());
						QuartoLuxoDuplo quartoAtual = new QuartoLuxoDuplo(pessoas, 1);
						JOptionPane.showMessageDialog(null, "Quarto Adicionado com Sucesso");
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
					} catch (QuantidadeDePessoasInvalidaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (QuartoEsgotadoNoHotelException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					break;
				case "Luxo Triplo":
					try {
						int pessoas = Integer.parseInt(spinner.getValue().toString());
						QuartoLuxoTriplo quartoAtual = new QuartoLuxoTriplo(pessoas);
						JOptionPane.showMessageDialog(null, "Quarto Adicionado com Sucesso");
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
					} catch (QuantidadeDePessoasInvalidaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (QuartoEsgotadoNoHotelException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					break;
				case "Executivo Simples":
					try {
						int pessoas = Integer.parseInt(spinner.getValue().toString());
						QuartoExecutivoSimples quartoAtual = new QuartoExecutivoSimples(pessoas, 1);
						JOptionPane.showMessageDialog(null, "Quarto Adicionado com Sucesso");
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
					} catch (QuantidadeDePessoasInvalidaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (QuartoEsgotadoNoHotelException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					break;
				case "Executivo Duplo":
					try {
						int pessoas = Integer.parseInt(spinner.getValue().toString());
						QuartoExecutivoDuplo quartoAtual = new QuartoExecutivoDuplo(pessoas, 1);
						JOptionPane.showMessageDialog(null, "Quarto Adicionado com Sucesso");
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
					} catch (QuantidadeDePessoasInvalidaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (QuartoEsgotadoNoHotelException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					break;
				case "Executivo Triplo":
					try {
						int pessoas = Integer.parseInt(spinner.getValue().toString());
						QuartoExecutivoTriplo quartoAtual = new QuartoExecutivoTriplo(pessoas);
						JOptionPane.showMessageDialog(null, "Quarto Adicionado com Sucesso");
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
					} catch (QuantidadeDePessoasInvalidaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (QuartoEsgotadoNoHotelException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Erro?");
					break;
				}
			}
		});
		btnAdicionar.setBounds(472, 426, 99, 36);
		add(btnAdicionar);
		

		for(int i = 0; i < quartos.size(); i++){
			comboBox.addItem(quartos.get(i));
		}
	}
}
