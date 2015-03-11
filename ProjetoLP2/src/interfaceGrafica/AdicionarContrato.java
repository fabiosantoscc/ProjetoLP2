package interfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import classes.Contrato;
import classes.dadosDoHospede.Hospede;
import excecoes.StringInvalidaException;

import java.util.Calendar;


public class AdicionarContrato extends JPanel {
	private JTextField textField;
	private Contrato contratoAtual;
	private static Calendar calendario; 
	private JLabel lblNovoContrato, lblHospede, lblNumeroDeNoites;
	private JButton btnNewButton;
		
	public AdicionarContrato(Hospede hospedeAtual) {
		
		setLayout(null);
		
		lblNovoContrato = CriaObjetosNaTela.criaLabel("Novo Contrato", new Rectangle(35, 11, 252, 38), CriaObjetosNaTela.getFontePadrao(24), null,null);
		add(lblNovoContrato);
		
		lblHospede = CriaObjetosNaTela.criaLabel("Hospede: "+hospedeAtual.getNome(), new Rectangle(55, 78, 554, 23), CriaObjetosNaTela.getFontePadrao(16), null, null);
		add(lblHospede);
		
		lblNumeroDeNoites = CriaObjetosNaTela.criaLabel("Numero de Noites", new Rectangle(55, 152, 135, 17), CriaObjetosNaTela.getFontePadrao(16), null, null);
		add(lblNumeroDeNoites);
		
		textField = CriaObjetosNaTela.criaTextField(null, new Rectangle(200, 152, 56, 18), CriaObjetosNaTela.getFontePadrao(14), true, null);
		add(textField);
		
		
		btnNewButton = CriaObjetosNaTela.criaBotao("Prosseguir", new Rectangle(483, 396, 135, 38),CriaObjetosNaTela.getFontePadrao(15), null, null);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer.parseInt(textField.getText());
					
					if ( Integer.parseInt(textField.getText()) == 0 ) {
						throw new StringInvalidaException();
					}
					
					MenuPrincipal.adcQuartoObrigatorio = new AdicionarQuartoObrigatorio(hospedeAtual, Integer.parseInt(textField.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.adcQuartoObrigatorio, "21");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "21");
					JOptionPane.showMessageDialog(null, "Para criar um contrato, é necessário adicionar um quarto.");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Digite um número de noites válido");
				}
			}
		});
		add(btnNewButton);
	}
}
