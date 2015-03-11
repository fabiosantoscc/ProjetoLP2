/*("Camas e Quartos disponíveis: \nCamas Extras : "+Run.hotel.getCamaExtra()
				+"\nQuartos\n Presidencial: "+Run.hotel.getQuartoPresidencial()+"\nLuxo Simples: "+Run.hotel.getQuartoLuxoSimples()
				+"\nLuxo Duplo: "+Run.hotel.getQuartoLuxoDuplo()+"\nLuxo Triplo: "+Run.hotel.getQuartoLuxoTriplo()
				+"\nExecutivo Simples: "+Run.hotel.getQuartoExecutivoSimples()+"\n Executivo Duplo: "+Run.hotel.getQuartoExecutivoDuplo()
				+"\nExecutivo Triplo: "+Run.hotel.getQuartoExecutivoTriplo());*/
package interfaceGráfica;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import classes.Arquivos;
import classes.dadosDoHospede.Hospede;
import classes.servicos.Quarto;
import classes.servicos.QuartoExecutivo;
import classes.servicos.QuartoLuxo;
import classes.servicos.QuartoPresidencial;
import classes.servicos.Servico;
import enums.SubtipoDeQuartoExecutivo;
import enums.SubtipoDeQuartoLuxo;
import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;
import executar.Run;

public class AdicionarQuartoObrigatorio extends JPanel {

	/**
	 * Create the panel.
	 */

	ArrayList<String> quartos = new ArrayList<>(Arrays.asList("Presidencial", "Luxo Simples", "Luxo Duplo", "Luxo Triplo","Executivo Simples", "Executivo Duplo", "Executivo Triplo"));
	ArrayList<Servico> servicos = new ArrayList<Servico>();
	private Quarto quartoAtual;
	String comboSelecionado;
	
	public AdicionarQuartoObrigatorio(Hospede hospedeAtual, int numNoitesAtual) {
		setLayout(null);
		JLabel lblAdicionarQuarto = new JLabel("Adicionar Quarto");
		lblAdicionarQuarto.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAdicionarQuarto.setBounds(22, 30, 219, 27);
		add(lblAdicionarQuarto);
		
		JLabel lblTipoQuarto = new JLabel("Tipo de quarto");
		lblTipoQuarto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoQuarto.setBounds(65, 202, 146, 25);
		add(lblTipoQuarto);
		
		JComboBox<String> comboTipoQuarto = new JComboBox<String>();
		comboTipoQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboSelecionado = (String) comboTipoQuarto.getSelectedItem();
			}
		});
		
		comboTipoQuarto.setBounds(62, 258, 191, 20);
		add(comboTipoQuarto);
		
		JLabel lblQuantidadeDePessoas = new JLabel("Quantidade de Pessoas");
		lblQuantidadeDePessoas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDePessoas.setBounds(65, 402, 188, 25);
		add(lblQuantidadeDePessoas);
		
		JSpinner spinnerQuantidadePessoas = new JSpinner();
		spinnerQuantidadePessoas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerQuantidadePessoas.setBounds(269, 403, 50, 24);
		add(spinnerQuantidadePessoas);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch (comboSelecionado) {
				case "Presidencial":
					try {
						int pessoas = Integer.parseInt(spinnerQuantidadePessoas.getValue().toString());
						quartoAtual = new QuartoPresidencial(pessoas);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com sucesso");
					} catch (QuantidadeDePessoasInvalidaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (QuartoEsgotadoNoHotelException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					}
					
					break;
				case "Luxo Simples":
					try {
						int pessoas = Integer.parseInt(spinnerQuantidadePessoas.getValue().toString());
						quartoAtual = new QuartoLuxo(pessoas, SubtipoDeQuartoLuxo.SIMPLES);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com sucesso");
					} catch ( QuantidadeDePessoasInvalidaException e1 ) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (QuartoEsgotadoNoHotelException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage());
					} catch (Exception e3) {
						JOptionPane.showMessageDialog(null, e3.getMessage());
					}
					
					break;
				case "Luxo Duplo":
					try {
						int pessoas = Integer.parseInt(spinnerQuantidadePessoas.getValue().toString());
						quartoAtual = new QuartoLuxo(pessoas, SubtipoDeQuartoLuxo.DUPLO);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com sucesso");
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
						int pessoas = Integer.parseInt(spinnerQuantidadePessoas.getValue().toString());
						quartoAtual = new QuartoLuxo(pessoas, SubtipoDeQuartoLuxo.TRIPLO);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com sucesso");
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
						int pessoas = Integer.parseInt(spinnerQuantidadePessoas.getValue().toString());
						quartoAtual = new QuartoExecutivo(pessoas, SubtipoDeQuartoExecutivo.SIMPLES);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com sucesso");
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
						int pessoas = Integer.parseInt(spinnerQuantidadePessoas.getValue().toString());
						quartoAtual = new QuartoExecutivo(pessoas, SubtipoDeQuartoExecutivo.DUPLO);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com sucesso");
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
						int pessoas = Integer.parseInt(spinnerQuantidadePessoas.getValue().toString());
						quartoAtual = new QuartoExecutivo(pessoas, SubtipoDeQuartoExecutivo.TRIPLO);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com sucesso");
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
				servicos.add(quartoAtual);
			}
		});
		btnAdicionar.setBounds(468, 402, 137, 27);
		add(btnAdicionar);
		
		JButton btnCriarContrato = new JButton("Criar Contrato");
		btnCriarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (servicos.size() > 0){
						Run.hotel.criaContrato(hospedeAtual, numNoitesAtual);
						for ( Servico s : servicos ) {
							Run.hotel.adicionaServico(hospedeAtual, s);
						}

						JOptionPane.showMessageDialog(null, "Contrato criado com sucesso!");
						MenuPrincipal.cl.show(MenuPrincipal.panel0, "MenuPadrao");
					}
					else {
						JOptionPane.showMessageDialog(null, "O contrato de ter pelo menos um quarto!");
					}
					Arquivos.salvaHotel(Run.hotel);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage());
				}
			}
		});
		btnCriarContrato.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCriarContrato.setBounds(468, 458, 146, 53);
		add(btnCriarContrato);
		
		for(int i = 0; i < quartos.size(); i++){
			comboTipoQuarto.addItem(quartos.get(i));
		}
	}
}