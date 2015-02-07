package InterfaceGrafica;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import classes.Endereco;
import classes.Hospede;
import classes.Telefone;
import excecoes.EstadoInvalidoException;
import excecoes.InputArgumentInvalidException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionaHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdicionaHospede() {

		setLayout(null);
		
		JLabel lblAtualizarCadastro = new JLabel("Adicionar Hospede");
		lblAtualizarCadastro.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 28));
		lblAtualizarCadastro.setBounds(12, 12, 287, 29);
		add(lblAtualizarCadastro);
		
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
		
		JFormattedTextField nomeHospede = new JFormattedTextField();
		nomeHospede.setBounds(119, 99, 440, 17);
		add(nomeHospede);
		
		JFormattedTextField emailHospede = new JFormattedTextField();
		emailHospede.setBounds(119, 155, 264, 17);
		add(emailHospede);
		
		JFormattedTextField cartaoHospede = new JFormattedTextField();
		cartaoHospede.setBounds(203, 182, 151, 17);
		add(cartaoHospede);
		
		JLabel label_6 = new JLabel("Telefone");
		label_6.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_6.setBounds(313, 129, 70, 15);
		add(label_6);
		
		JFormattedTextField dddHospede = new JFormattedTextField();
		dddHospede.setBounds(388, 128, 44, 17);
		add(dddHospede);
		
		JFormattedTextField numeroHospede = new JFormattedTextField();
		numeroHospede.setBounds(445, 128, 114, 17);
		add(numeroHospede);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 240, 687, 2);
		add(separator);
		
		JLabel label_7 = new JLabel("Estado/Condado");
		label_7.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_7.setBounds(58, 420, 126, 15);
		add(label_7);
		
		JLabel label_14 = new JLabel("Numero");
		label_14.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_14.setBounds(476, 329, 70, 15);
		add(label_14);
		
		JLabel lblCepZipCode = new JLabel("CEP/ Zip Code");
		lblCepZipCode.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblCepZipCode.setBounds(292, 395, 126, 15);
		add(lblCepZipCode);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCidade.setBounds(292, 363, 70, 15);
		add(lblCidade);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		lblEndereo.setBounds(38, 254, 114, 25);
		add(lblEndereo);
		
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
		
		JFormattedTextField ruaHospede = new JFormattedTextField();
		ruaHospede.setBounds(144, 302, 468, 17);
		add(ruaHospede);
		
		JFormattedTextField complementoHospede = new JFormattedTextField();
		complementoHospede.setBounds(167, 329, 299, 17);
		add(complementoHospede);
		
		JFormattedTextField bairroHospede = new JFormattedTextField();
		bairroHospede.setBounds(119, 361, 138, 17);
		add(bairroHospede);
		
		JFormattedTextField paisHospede = new JFormattedTextField();
		paisHospede.setBounds(119, 394, 138, 17);
		add(paisHospede);
		
		JFormattedTextField cidadeHospede = new JFormattedTextField();
		cidadeHospede.setBounds(376, 361, 236, 17);
		add(cidadeHospede);
		
		JFormattedTextField cepHospede = new JFormattedTextField();
		cepHospede.setBounds(436, 393, 138, 17);
		add(cepHospede);
		
		JFormattedTextField numeroCasaHospede = new JFormattedTextField();
		numeroCasaHospede.setBounds(542, 329, 70, 17);
		add(numeroCasaHospede);
		
		JFormattedTextField estadoHospede = new JFormattedTextField();
		estadoHospede.setBounds(203, 422, 180, 17);
		add(estadoHospede);
		
		JFormattedTextField cpfHospede = new JFormattedTextField();
		cpfHospede.setBounds(119, 127, 151, 17);
		add(cpfHospede);
		
		
		JButton btnCadastrar = new JButton("Criar");
		btnCadastrar.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Telefone tel = new Telefone(dddHospede.getText(), numeroHospede.getText());
					Endereco end = new Endereco(cidadeHospede.getText(), bairroHospede.getText(), ruaHospede.getText(), numeroCasaHospede.getText(), 
					complementoHospede.getText(), estadoHospede.getText(), paisHospede.getText());
					Hospede h = new Hospede(nomeHospede.getText(), cpfHospede.getText(), cartaoHospede.getText(), emailHospede.getText(), tel, end);
					Run.hotel.addHospede(h);
					JOptionPane.showMessageDialog(null, "Hospede criado com sucesso!");
					ruaHospede.setText("");
					complementoHospede.setText("");
					numeroCasaHospede.setText("");
					bairroHospede.setText("");
					cidadeHospede.setText("");
					paisHospede.setText("");
					estadoHospede.setText("");
					cepHospede.setText("");
					nomeHospede.setText("");
					cpfHospede.setText("");
					emailHospede.setText("");
					cartaoHospede.setText("");
					dddHospede.setText("");
					numeroHospede.setText("");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(292, 479, 154, 23);
		add(btnCadastrar);
	}
}
