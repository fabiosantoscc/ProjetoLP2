package interfaceGrafica;

import classes.Arquivos;
import classes.dadosDoHospede.Hospede;
import classes.servicos.Quarto;
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
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AdicionarQuartos extends JPanel {


	private String selecionada;
	private QuartoLuxo quarto;
	private JLabel lblAdicionarQuarto, lblTipoQuarto, lblQuantidadeDePessoas;
	private JSpinner spinnerQuantidadePessoas;
	private JButton btnAdicionar;
	private ArrayList<String> quartos = new ArrayList<>(Arrays.asList("Presidencial", "Luxo Simples", "Luxo Duplo", "Luxo Triplo","Executivo Simples", "Executivo Duplo", "Executivo Triplo"));
	private Quarto umQuarto;
	
	public AdicionarQuartos(Hospede hospedeAtual) {
		setLayout(null);
		
		JLabel lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		lblAdicionarQuarto = CriaObjetosNaTela.criaLabel("Adicionar Quarto", new Rectangle(22, 30, 219, 27), CriaObjetosNaTela.getFontePadrao(24), null, null);
		add(lblAdicionarQuarto);
		
		lblTipoQuarto = CriaObjetosNaTela.criaLabel("Tipo de Quarto", new Rectangle(65, 202, 146, 25), CriaObjetosNaTela.getFontePadrao(16), null, null);
		add(lblTipoQuarto);
		
		JComboBox<String> comboTipoQuarto = new JComboBox<String>();
		comboTipoQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				selecionada = (String) comboTipoQuarto.getSelectedItem();
			}
		});
		
		comboTipoQuarto.setBounds(62, 258, 191, 20);
		add(comboTipoQuarto);
		
		lblQuantidadeDePessoas = CriaObjetosNaTela.criaLabel("Quantidade de Pessoas", new Rectangle(65, 402, 188, 25), CriaObjetosNaTela.getFontePadrao(16), null, null);
		add(lblQuantidadeDePessoas);
		
		spinnerQuantidadePessoas = CriaObjetosNaTela.criaSpinner(new Rectangle(269, 403, 50, 24), CriaObjetosNaTela.getFontePadrao(14));
		spinnerQuantidadePessoas.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		add(spinnerQuantidadePessoas);
		
		btnAdicionar = CriaObjetosNaTela.criaBotao("Adicionar Quarto", new Rectangle(482, 439, 125, 36), CriaObjetosNaTela.getFontePadrao(12), null, null);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (selecionada) {
				case "Presidencial":
					try {
						int pessoas = Integer.parseInt(spinnerQuantidadePessoas.getValue().toString());
						Quarto umQuarto = new QuartoPresidencial(pessoas);
						Run.hotel.getContratoAberto(hospedeAtual).adicionaServico(umQuarto);
						JOptionPane.showMessageDialog(null, "Quarto Adicionado com Sucesso");
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
						Quarto umQuarto = new QuartoLuxo(pessoas, SubtipoDeQuartoLuxo.SIMPLES);
						Run.hotel.getContratoAberto(hospedeAtual).adicionaServico(umQuarto);
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
						Quarto umQuarto = new QuartoLuxo(pessoas, SubtipoDeQuartoLuxo.DUPLO);
						Run.hotel.adicionaServico(hospedeAtual, umQuarto);
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
						Quarto umQuarto = new QuartoLuxo(pessoas, SubtipoDeQuartoLuxo.TRIPLO);
						Run.hotel.adicionaServico(hospedeAtual, umQuarto);
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
						Quarto umQuarto = new QuartoExecutivo(pessoas, SubtipoDeQuartoExecutivo.SIMPLES);
						Run.hotel.adicionaServico(hospedeAtual, umQuarto);
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
						Quarto umQuarto = new QuartoExecutivo(pessoas, SubtipoDeQuartoExecutivo.DUPLO);
						Run.hotel.adicionaServico(hospedeAtual, umQuarto);
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
						Quarto umQuarto = new QuartoExecutivo(pessoas, SubtipoDeQuartoExecutivo.TRIPLO);
						Run.hotel.adicionaServico(hospedeAtual, umQuarto);
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
		add(btnAdicionar);
		
		for(int i = 0; i < quartos.size(); i++){
			comboTipoQuarto.addItem(quartos.get(i));
		}
	}
}
