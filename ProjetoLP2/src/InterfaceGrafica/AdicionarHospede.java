package InterfaceGrafica;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;

public class AdicionarHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdicionarHospede() {
		setLayout(null);
		
		JLabel label = new JLabel("Cadastrar Cliente");
		label.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 28));
		label.setBounds(12, 12, 287, 29);
		add(label);
		
		JLabel label_1 = new JLabel("Dados Pessoais");
		label_1.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		label_1.setBounds(38, 53, 174, 29);
		add(label_1);
		
		JLabel label_2 = new JLabel("Nome");
		label_2.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_2.setBounds(68, 91, 70, 25);
		add(label_2);
		
		JLabel label_3 = new JLabel("CPF");
		label_3.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_3.setBounds(68, 128, 70, 15);
		add(label_3);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_4.setBounds(68, 155, 70, 15);
		add(label_4);
		
		JLabel label_5 = new JLabel("Cartao de credito");
		label_5.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_5.setBounds(68, 182, 158, 15);
		add(label_5);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(119, 99, 440, 17);
		add(formattedTextField);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(119, 128, 158, 17);
		add(formattedTextField_1);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(119, 155, 323, 17);
		add(formattedTextField_2);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setBounds(174, 182, 151, 17);
		add(formattedTextField_3);
		
		JLabel label_6 = new JLabel("Telefone");
		label_6.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_6.setBounds(313, 129, 70, 15);
		add(label_6);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setBounds(376, 128, 44, 17);
		add(formattedTextField_4);
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setBounds(432, 128, 114, 17);
		add(formattedTextField_5);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 240, 687, 2);
		add(separator);
		
		JLabel label_8 = new JLabel("Endereço");
		label_8.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		label_8.setBounds(38, 254, 80, 25);
		add(label_8);
		
		JLabel label_9 = new JLabel("Logradouro");
		label_9.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_9.setBounds(58, 302, 138, 15);
		add(label_9);
		
		JLabel label_10 = new JLabel("Complemento");
		label_10.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_10.setBounds(58, 329, 114, 15);
		add(label_10);
		
		JLabel label_11 = new JLabel("Bairro");
		label_11.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_11.setBounds(58, 361, 70, 15);
		add(label_11);
		
		JLabel label_12 = new JLabel("Pais");
		label_12.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_12.setBounds(58, 394, 70, 15);
		add(label_12);
		
		JFormattedTextField formattedTextField_6 = new JFormattedTextField();
		formattedTextField_6.setBounds(144, 302, 468, 17);
		add(formattedTextField_6);
		
		JFormattedTextField formattedTextField_7 = new JFormattedTextField();
		formattedTextField_7.setBounds(144, 329, 323, 17);
		add(formattedTextField_7);
		
		JFormattedTextField formattedTextField_8 = new JFormattedTextField();
		formattedTextField_8.setBounds(105, 361, 138, 17);
		add(formattedTextField_8);
		
		JFormattedTextField formattedTextField_9 = new JFormattedTextField();
		formattedTextField_9.setBounds(105, 394, 138, 17);
		add(formattedTextField_9);
		
		JFormattedTextField formattedTextField_10 = new JFormattedTextField();
		formattedTextField_10.setBounds(436, 361, 138, 17);
		add(formattedTextField_10);
		
		JLabel label_7 = new JLabel("Estado/Condado");
		label_7.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_7.setBounds(292, 362, 126, 15);
		add(label_7);
		
		JLabel label_13 = new JLabel("CEP/ Zipe Code");
		label_13.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_13.setBounds(292, 395, 126, 15);
		add(label_13);
		
		JFormattedTextField formattedTextField_11 = new JFormattedTextField();
		formattedTextField_11.setBounds(436, 393, 138, 17);
		add(formattedTextField_11);
		
		JLabel label_14 = new JLabel("Numero");
		label_14.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_14.setBounds(492, 331, 70, 15);
		add(label_14);
		
		JFormattedTextField formattedTextField_12 = new JFormattedTextField();
		formattedTextField_12.setBounds(562, 329, 50, 17);
		add(formattedTextField_12);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(292, 479, 154, 23);
		add(btnCadastrar);
		
	

	}
}
