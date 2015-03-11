package interfaceGráfica;

import classes.Arquivos;
import classes.dadosDoHospede.Hospede;
import classes.servicos.QuartoExecutivo;
import classes.servicos.QuartoLuxo;
import classes.servicos.QuartoPresidencial;
import enums.SubtipoDeQuartoExecutivo;
import enums.SubtipoDeQuartoLuxo;
import excecoes.ContratoAbertoException;
import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;
import executar.Run;

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

public class AdicionarQuartos extends JPanel {

	/**
	 * Create the panel.
	 */
	
	ArrayList<String> quartos = new ArrayList<>(Arrays.asList("Presidencial", "Luxo Simples", "Luxo Duplo", "Luxo Triplo","Executivo Simples", "Executivo Duplo", "Executivo Triplo"));
	private JSpinner spinnerQuantidadeCamas;
	private JSpinner spinnerQuantidadePessoas;
	
	public AdicionarQuartos(Hospede hospedeAtual) {
		setLayout(null);
		
		JLabel lblAdicionarQuarto = new JLabel("Adicionar Quarto");
		lblAdicionarQuarto.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAdicionarQuarto.setBounds(22, 30, 219, 27);
		add(lblAdicionarQuarto);
		
		JLabel lblTipoQuarto = new JLabel("Tipo de quarto");
		lblTipoQuarto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTipoQuarto.setBounds(47, 94, 146, 25);
		add(lblTipoQuarto);
		
		JComboBox<String> comboTipoQuarto = new JComboBox<String>();
		comboTipoQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboTipoQuarto.getSelectedItem();
			}
		});
		
		comboTipoQuarto.setBounds(50, 156, 173, 20);
		add(comboTipoQuarto);
		
		JLabel lblQuantidadeDePessoas = new JLabel("Quantidade de Pessoas");
		lblQuantidadeDePessoas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDePessoas.setBounds(47, 288, 188, 25);
		add(lblQuantidadeDePessoas);
		
		spinnerQuantidadePessoas = new JSpinner();
		spinnerQuantidadePessoas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerQuantidadePessoas.setBounds(245, 292, 48, 20);
		add(spinnerQuantidadePessoas);
		
		JLabel lblQuantidadeDeCamas = new JLabel("Quantidade de Camas Extras");
		lblQuantidadeDeCamas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDeCamas.setBounds(47, 364, 219, 25);
		add(lblQuantidadeDeCamas);
		
		spinnerQuantidadeCamas = new JSpinner();
		spinnerQuantidadeCamas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinnerQuantidadeCamas.setBounds(268, 369, 48, 20);
		add(spinnerQuantidadeCamas);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch ((String) comboTipoQuarto.getSelectedItem()) {
				case "Presidencial":
					try {
						int pessoas = Integer.parseInt(spinnerQuantidadePessoas.getValue().toString());
						QuartoPresidencial quartoAtual = new QuartoPresidencial(pessoas);
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
						MenuPrincipal.cl.show(MenuPrincipal.panel0, "0");
						Arquivos.salvaHotel(Run.hotel);
					} catch (QuantidadeDePessoasInvalidaException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (QuartoEsgotadoNoHotelException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (ContratoAbertoException e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
					} catch (Exception e1) {
					}
					break;
				case "Luxo Simples":
					try {
						int pessoas = Integer.parseInt(spinnerQuantidadePessoas.getValue().toString());
						QuartoLuxo quartoAtual = new QuartoLuxo(pessoas, SubtipoDeQuartoLuxo.SIMPLES);
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
						JOptionPane.showMessageDialog(null, "Quarto Adicionado com Sucesso");
						Arquivos.salvaHotel(Run.hotel);
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
						int pessoas = Integer.parseInt(spinnerQuantidadePessoas.getValue().toString());
						QuartoLuxo quartoAtual = new QuartoLuxo(pessoas, SubtipoDeQuartoLuxo.DUPLO);
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com Sucesso");
						Arquivos.salvaHotel(Run.hotel);
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
						QuartoLuxo quartoAtual = new QuartoLuxo(pessoas, SubtipoDeQuartoLuxo.TRIPLO);
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com Sucesso");
						Arquivos.salvaHotel(Run.hotel);
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
						QuartoExecutivo quartoAtual = new QuartoExecutivo(pessoas, SubtipoDeQuartoExecutivo.SIMPLES);
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com Sucesso");
						Arquivos.salvaHotel(Run.hotel);
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
						QuartoExecutivo quartoAtual = new QuartoExecutivo(pessoas, SubtipoDeQuartoExecutivo.DUPLO);
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com Sucesso");
						Arquivos.salvaHotel(Run.hotel);
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
						QuartoExecutivo quartoAtual = new QuartoExecutivo(pessoas, SubtipoDeQuartoExecutivo.TRIPLO);
						Run.hotel.adicionaServico(hospedeAtual, quartoAtual);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com Sucesso");
						Arquivos.salvaHotel(Run.hotel);
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
		btnAdicionar.setBounds(482, 439, 125, 36);
		add(btnAdicionar);
		
		for(int i = 0; i < quartos.size(); i++){
			comboTipoQuarto.addItem(quartos.get(i));
		}
	}
}
