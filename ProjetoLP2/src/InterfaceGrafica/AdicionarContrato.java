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

import classes.Hospede;

import java.util.Date;
import java.util.Calendar;
import javax.swing.JCheckBox;

public class AdicionarContrato extends JPanel {
	private JTextField textField;

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
		
		JLabel lblDataDeEntrada = new JLabel("Data de Entrada");
		lblDataDeEntrada.setBounds(55, 134, 90, 23);
		add(lblDataDeEntrada);
		
		JLabel lblDataDeSada = new JLabel("Data de Sa\u00EDda");
		lblDataDeSada.setBounds(55, 168, 90, 14);
		add(lblDataDeSada);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerDateModel(new Date(1423360800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner.setBounds(155, 137, 112, 20);
		add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerDateModel(new Date(1423360800000L), null, null, Calendar.DAY_OF_YEAR));
		spinner_1.setBounds(155, 165, 112, 20);
		add(spinner_1);
		
		JLabel lblNumeroDeNoites = new JLabel("Numero de Noites");
		lblNumeroDeNoites.setBounds(55, 221, 104, 14);
		add(lblNumeroDeNoites);
		
		textField = new JTextField();
		textField.setBounds(155, 219, 56, 17);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Criar Contrato");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(448, 353, 135, 38);
		add(btnNewButton);

		
		
	}
}
