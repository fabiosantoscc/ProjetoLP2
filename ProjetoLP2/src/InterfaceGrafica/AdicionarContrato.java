package InterfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import classes.Contrato;
import classes.Hospede;

import java.util.Date;
import java.util.Calendar;

import javax.swing.JCheckBox;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;

import excecoes.NumeroDeNoitesInvalidoException;

public class AdicionarContrato extends JPanel {
	private JTextField textField;
	private Contrato contratoAtual;
	private static Calendar calendario; 

	/**
	 * Create the panel.
	 */
	public AdicionarContrato(Hospede hospedeAtual) {
		
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("Novo Contrato");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(35, 11, 252, 38);
		add(lblNovoContrato);
		
		JLabel lblHospede = new JLabel("Hospede: "+hospedeAtual.getNome());
		lblHospede.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHospede.setBounds(55, 78, 333, 23);
		add(lblHospede);
		
		JLabel lblNumeroDeNoites = new JLabel("Numero de Noites");
		lblNumeroDeNoites.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumeroDeNoites.setBounds(55, 152, 115, 14);
		add(lblNumeroDeNoites);
		
		textField = new JTextField();
		textField.setBounds(180, 152, 56, 17);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Prosseguir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MenuPrincipal.adcQuartoObrigatorio = new AdicionarQuartoObrigatorio(hospedeAtual, Integer.parseInt(textField.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.adcQuartoObrigatorio, "21");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "21");
					JOptionPane.showMessageDialog(null, "Para criar um contrato, é necessário adicionar um quarto.");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				//hospedeAtual.
				catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(483, 396, 135, 38);
		add(btnNewButton);

		
		
	}
}
