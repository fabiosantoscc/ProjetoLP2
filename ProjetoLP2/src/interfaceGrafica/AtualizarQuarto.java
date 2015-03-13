package interfaceGrafica;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import classes.servicos.Quarto;

import javax.swing.JLabel;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JSpinner;
import javax.swing.JButton;

import excecoes.QuantidadeDePessoasInvalidaException;

import javax.swing.SpinnerNumberModel;

public class AtualizarQuarto extends JPanel {
	
	private ArrayList<String> quartos = new ArrayList<>(Arrays.asList("Presidencial", "Luxo Simples", "Luxo Duplo", "Luxo Triplo","Executivo Simples", "Executivo Duplo", "Executivo Triplo"));
	private JLabel lblLogoHotel, lblAdicionarQuarto, lblQuantidadeDePessoas;
	private JSpinner spinnerQuantidadePessoas; 
	private JButton btnAtualizar;
	
	public AtualizarQuarto(Quarto quartoAtual) {
		setLayout(null);
		
		lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		lblAdicionarQuarto = CriaObjetosNaTela.criaLabel("Atualizar Quarto", new Rectangle(22, 30, 219, 27), CriaObjetosNaTela.getFontePadrao(24), null, null);
		add(lblAdicionarQuarto);
		
		lblQuantidadeDePessoas = CriaObjetosNaTela.criaLabel("Quantidade de Pessoas", new Rectangle(53, 182, 188, 25), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblQuantidadeDePessoas);
		
		spinnerQuantidadePessoas = CriaObjetosNaTela.criaSpinner(new Rectangle(266, 186, 48, 20), CriaObjetosNaTela.getFontePadrao(14));
		spinnerQuantidadePessoas.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		add(spinnerQuantidadePessoas);
		
		btnAtualizar = CriaObjetosNaTela.criaBotao("Atualizar", new Rectangle(482, 439, 119, 37), CriaObjetosNaTela.getFontePadrao(15), null, null);
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
		add(btnAtualizar);
		
	}
}
