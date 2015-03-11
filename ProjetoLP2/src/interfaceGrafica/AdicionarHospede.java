package interfaceGrafica;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import classes.Arquivos;
import classes.dadosDoHospede.Endereco;
import classes.dadosDoHospede.Hospede;
import classes.dadosDoHospede.Telefone;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import com.toedter.calendar.JDateChooser;

import executar.Run;

import javax.swing.ImageIcon;

public class AdicionarHospede extends JPanel {
	
	Calendar dataNascimento;
	
	/**
	 * Create the panel.
	 */
	public AdicionarHospede() {

		setLayout(null);
		
		JLabel lblAtualizarCadastro = new JLabel("Adicionar Hospede");
		lblAtualizarCadastro.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAtualizarCadastro.setBounds(12, 12, 287, 29);
		add(lblAtualizarCadastro);
		
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		lblDadosPessoais.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDadosPessoais.setBounds(38, 53, 174, 29);
		add(lblDadosPessoais);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNome.setBounds(68, 91, 70, 25);
		add(lblNome);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCPF.setBounds(68, 128, 70, 15);
		add(lblCPF);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(68, 155, 70, 15);
		add(lblEmail);
		
		
		JLabel lblCartao = new JLabel("Cartao de credito");
		lblCartao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCartao.setBounds(68, 182, 158, 15);
		add(lblCartao);
		
		JFormattedTextField textNome = new JFormattedTextField();
		textNome.setBounds(119, 99, 440, 17);
		add(textNome);
		
		JFormattedTextField textEmail = new JFormattedTextField();
		textEmail.setBounds(119, 155, 264, 17);
		add(textEmail);
		
		JFormattedTextField txtCartao = new JFormattedTextField();
		txtCartao.setBounds(203, 182, 151, 17);
		add(txtCartao);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefone.setBounds(313, 129, 70, 15);
		add(lblTelefone);
		
		JFormattedTextField textDDD = new JFormattedTextField();
		textDDD.setBounds(388, 128, 44, 17);
		add(textDDD);
		
		JFormattedTextField textNumero = new JFormattedTextField();
		textNumero.setBounds(445, 128, 114, 17);
		add(textNumero);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 240, 687, 2);
		add(separator);
		
		JLabel lblEstado = new JLabel("Estado/Condado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstado.setBounds(58, 420, 126, 15);
		add(lblEstado);
		
		JLabel lblNumeroCasa = new JLabel("Numero");
		lblNumeroCasa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroCasa.setBounds(476, 329, 70, 15);
		add(lblNumeroCasa);
		
		JLabel lblCepZipCode = new JLabel("CEP/ Zip Code");
		lblCepZipCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCepZipCode.setBounds(292, 395, 126, 15);
		add(lblCepZipCode);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCidade.setBounds(292, 363, 70, 15);
		add(lblCidade);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEndereo.setBounds(38, 254, 114, 25);
		add(lblEndereo);
		
		JLabel lblLogradouro = new JLabel("Logradouro");
		lblLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblLogradouro.setBounds(58, 302, 138, 15);
		add(lblLogradouro);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblComplemento.setBounds(58, 329, 114, 15);
		add(lblComplemento);
		
		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBairro.setBounds(58, 361, 70, 15);
		add(lblBairro);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPais.setBounds(58, 394, 70, 15);
		add(lblPais);
		
		JFormattedTextField textRua = new JFormattedTextField();
		textRua.setBounds(144, 302, 468, 17);
		add(textRua);
		
		JFormattedTextField textComplemento = new JFormattedTextField();
		textComplemento.setBounds(167, 329, 299, 17);
		add(textComplemento);
		
		JFormattedTextField textBairro = new JFormattedTextField();
		textBairro.setBounds(119, 361, 138, 17);
		add(textBairro);
		
		JFormattedTextField textPais = new JFormattedTextField();
		textPais.setBounds(119, 394, 138, 17);
		add(textPais);
		
		JFormattedTextField textCidade = new JFormattedTextField();
		textCidade.setBounds(376, 361, 236, 17);
		add(textCidade);
		
		JFormattedTextField textCep = new JFormattedTextField();
		textCep.setBounds(436, 393, 138, 17);
		add(textCep);
		
		JFormattedTextField textNumeroCasa = new JFormattedTextField();
		textNumeroCasa.setBounds(542, 329, 70, 17);
		add(textNumeroCasa);
		
		JFormattedTextField textEstado = new JFormattedTextField();
		textEstado.setBounds(203, 422, 180, 17);
		add(textEstado);
		
		JFormattedTextField textCPF = new JFormattedTextField();
		textCPF.setBounds(119, 127, 151, 17);
		add(textCPF);
		
		
		JButton btnCadastrar = new JButton("Criar");
		btnCadastrar.setIcon(new ImageIcon(AdicionarHospede.class.getResource("/Icons/accept.png")));
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnCadastrar.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Telefone tel = new Telefone(textDDD.getText(), textNumero.getText());
					Endereco end = new Endereco(textCidade.getText(), textBairro.getText(), textRua.getText(), textNumeroCasa.getText(), 
					textComplemento.getText(), textEstado.getText(), textPais.getText(), textCep.getText());
					Hospede h = new Hospede(textNome.getText(), textCPF.getText(), txtCartao.getText(), textEmail.getText(), tel, end, dataNascimento);
					Run.hotel.addHospede(h);
					Arquivos.salvaHotel(Run.hotel);
					JOptionPane.showMessageDialog(null, "Hospede criado com sucesso!");
					textRua.setText("");
					textComplemento.setText("");
					textNumeroCasa.setText("");
					textBairro.setText("");
					textCidade.setText("");
					textPais.setText("");
					textEstado.setText("");
					textCep.setText("");
					textNome.setText("");
					textCPF.setText("");
					textEmail.setText("");
					txtCartao.setText("");
					textDDD.setText("");
					textNumero.setText("");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "MenuPadrao");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(334, 497, 138, 29);
		add(btnCadastrar);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataNascimento = dateChooser.getCalendar();
			}
		});
		dateChooser.setBounds(445, 182, 114, 17);
		add(dateChooser);
		
		JLabel lblData = new JLabel("Data de nascimento");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblData.setBounds(421, 155, 138, 15);
		add(lblData);
	}
}

