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
import classes.Arquivos;
import classes.Contrato;
import classes.Hospede;
import classes.Quarto;
import classes.QuartoExecutivoDuplo;
import classes.QuartoExecutivoSimples;
import classes.QuartoExecutivoTriplo;
import classes.QuartoLuxoDuplo;
import classes.QuartoLuxoSimples;
import classes.QuartoLuxoTriplo;
import classes.QuartoPresidencial;
import classes.Restaurante;
import classes.Servico;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JButton;

import jdk.nashorn.internal.scripts.JO;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import excecoes.ContratoAbertoException;
import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;

public class AdicionarQuartoObrigatorio extends JPanel {

	/**
	 * Create the panel.
	 */
	
	ArrayList<String> quartos = new ArrayList<>(Arrays.asList("Presidencial", "Luxo Simples", "Luxo Duplo", "Luxo Triplo","Executivo Simples", "Executivo Duplo", "Executivo Triplo"));
	ArrayList<Servico> servicos = new ArrayList<Servico>();
	Quarto quartoAtual;
	
	public AdicionarQuartoObrigatorio(Hospede hospedeAtual, int numNoitesAtual) {
		setLayout(null);
		JLabel lblAdicionarQuarto = new JLabel("Adicionar Quarto");
		lblAdicionarQuarto.setFont(new Font("Tahoma", Font.PLAIN, 24));
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
			
			}
		});
		
		comboBox.setBounds(50, 156, 191, 20);
		add(comboBox);
		
		JLabel lblQuantidadeDePessoas = new JLabel("Quantidade de Pessoas");
		lblQuantidadeDePessoas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDePessoas.setBounds(47, 288, 188, 25);
		add(lblQuantidadeDePessoas);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner.setBounds(245, 288, 50, 24);
		add(spinner);
		
		JLabel lblQuantidadeDeCamas = new JLabel("Quantidade de Camas Extras");
		lblQuantidadeDeCamas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDeCamas.setBounds(47, 365, 219, 25);
		add(lblQuantidadeDeCamas);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		spinner_1.setBounds(268, 365, 58, 24);
		add(spinner_1);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				switch ((String) comboBox.getSelectedItem()) {
				case "Presidencial":
					try {
						int pessoas = Integer.parseInt(spinner.getValue().toString());
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
						int pessoas = Integer.parseInt(spinner.getValue().toString());
						int camas = Integer.parseInt(spinner_1.getValue().toString());
						quartoAtual = new QuartoLuxoSimples(pessoas, camas);
						JOptionPane.showMessageDialog(null, "Quarto adicionado com sucesso");
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
						int camas = Integer.parseInt(spinner_1.getValue().toString());
						quartoAtual = new QuartoLuxoDuplo(pessoas, camas);
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
						int pessoas = Integer.parseInt(spinner.getValue().toString());
						quartoAtual = new QuartoLuxoTriplo(pessoas);
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
						int pessoas = Integer.parseInt(spinner.getValue().toString());
						int camas = Integer.parseInt(spinner_1.getValue().toString());
						quartoAtual = new QuartoExecutivoSimples(pessoas, camas);
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
						int pessoas = Integer.parseInt(spinner.getValue().toString());
						int camas = Integer.parseInt(spinner_1.getValue().toString());
						quartoAtual = new QuartoExecutivoDuplo(pessoas, camas);
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
						int pessoas = Integer.parseInt(spinner.getValue().toString());
						quartoAtual = new QuartoExecutivoTriplo(pessoas);
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
						Run.hotel.adicionaServico(hospedeAtual, new Restaurante());
						JOptionPane.showMessageDialog(null, "Contrato criado com sucesso!");
						MenuPrincipal.cl.show(MenuPrincipal.panel0, "0");
					}
					else{
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
			comboBox.addItem(quartos.get(i));
		}
	}
}