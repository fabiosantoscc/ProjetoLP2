package interfaceGrafica;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

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
	
	private Calendar dataNascimento;
	private JLabel lblAtualizarCadastro, lblDadosPessoais, lblNome, lblCPF, lblEmail, lblCartao, lblTelefone, lblEstado, lblNumeroCasa,
	lblCepZipCode, lblCidade, lblEndereco, lblLogradouro, lblComplemento, lblBairro, lblPais, lblData;
	private JTextField textEmail, txtCartao, textDDD, textNumero, textNome, textRua, textComplemento, textBairro, textPais, textCidade, 
	textCep, textNumeroCasa, textEstado, textCPF;
	private JSeparator separator;
	private JButton btnCadastrar;
	
	public AdicionarHospede() {

		setLayout(null);
		
		lblAtualizarCadastro = CriaObjetosNaTela.criaLabel("Adicionar Hospede", new Rectangle(12, 12, 287, 29), CriaObjetosNaTela.getFontePadrao(24), null, null);
		add(lblAtualizarCadastro);
		
		lblDadosPessoais = CriaObjetosNaTela.criaLabel("Dados Pessoais", new Rectangle(38, 53, 174, 29), CriaObjetosNaTela.getFontePadrao(17), null, null);
		add(lblDadosPessoais);
		
		lblNome = CriaObjetosNaTela.criaLabel("Nome", new Rectangle(68, 91, 70, 25), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblNome);
		
		lblCPF = CriaObjetosNaTela.criaLabel("CPF", new Rectangle(68, 128, 70, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblCPF);
		
		lblEmail = CriaObjetosNaTela.criaLabel("Email", new Rectangle(68, 155, 70, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblEmail);
		
		
		lblCartao = CriaObjetosNaTela.criaLabel("Cartao de credito", new Rectangle(68, 182, 158, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblCartao);
		
		textNome = CriaObjetosNaTela.criaTextField(null, new Rectangle(119, 99, 440, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textNome);
		
		textEmail = CriaObjetosNaTela.criaTextField(null, new Rectangle(119, 155, 264, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textEmail);
		
		txtCartao = CriaObjetosNaTela.criaTextField(null, new Rectangle(203, 182, 151, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(txtCartao);
		
		lblTelefone = CriaObjetosNaTela.criaLabel("Telefone", new Rectangle(313, 129, 70, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblTelefone);
		
		textDDD = CriaObjetosNaTela.criaTextField(null, new Rectangle(388, 128, 44, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textDDD);
		
		textNumero = CriaObjetosNaTela.criaTextField(null, new Rectangle(445, 128, 114, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textNumero);
		
		separator = CriaObjetosNaTela.criaSeparator(new Rectangle(38, 240, 687, 2));
		add(separator);
		
		lblEstado = CriaObjetosNaTela.criaLabel("Estado/Condado", new Rectangle(58, 420, 126, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblEstado);
		
		lblNumeroCasa = CriaObjetosNaTela.criaLabel("Numero", new Rectangle(476, 329, 70, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblNumeroCasa);
		
		lblCepZipCode = CriaObjetosNaTela.criaLabel("CEP/ Zip Code", new Rectangle(292, 395, 126, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblCepZipCode);
		
		lblCidade = CriaObjetosNaTela.criaLabel("Cidade", new Rectangle(292, 363, 70, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblCidade);
		
		lblEndereco = CriaObjetosNaTela.criaLabel("Endere\u00E7o", new Rectangle(38, 254, 114, 25), CriaObjetosNaTela.getFontePadrao(17), null, null);
		add(lblEndereco);
		
		lblLogradouro = CriaObjetosNaTela.criaLabel("Logradouro", new Rectangle(58, 302, 138, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblLogradouro);
		
		lblComplemento = CriaObjetosNaTela.criaLabel("Complemento", new Rectangle(58, 329, 114, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblComplemento);
		
		lblBairro = CriaObjetosNaTela.criaLabel("Bairro", new Rectangle(58, 361, 70, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblBairro);
		
		lblPais = CriaObjetosNaTela.criaLabel("Pais", new Rectangle(58, 394, 70, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblPais);
		
		textRua = CriaObjetosNaTela.criaTextField(null, new Rectangle(144, 302, 468, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textRua);
		
		textComplemento = CriaObjetosNaTela.criaTextField(null, new Rectangle(167, 329, 299, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textComplemento);
		
		textBairro = CriaObjetosNaTela.criaTextField(null, new Rectangle(119, 361, 138, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textBairro);
		
		textPais = CriaObjetosNaTela.criaTextField(null , new Rectangle(119, 394, 138, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textPais);
		
		textCidade = CriaObjetosNaTela.criaTextField(null, new Rectangle(376, 361, 236, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textCidade);
		
		textCep = CriaObjetosNaTela.criaTextField(null, new Rectangle(436, 393, 138, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textCep);
		
		textNumeroCasa = CriaObjetosNaTela.criaTextField(null, new Rectangle(542, 329, 70, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		textNumeroCasa.setBounds(542, 329, 70, 17);
		add(textNumeroCasa);
		
		textEstado = CriaObjetosNaTela.criaTextField(null, new Rectangle(203, 422, 180, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textEstado);
		
		textCPF = CriaObjetosNaTela.criaTextField(null, new Rectangle(119, 127, 151, 17), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textCPF);
		
		
		btnCadastrar = CriaObjetosNaTela.criaBotao("Criar", new Rectangle(334, 497, 138, 29), CriaObjetosNaTela.getFontePadrao(17),new ImageIcon(AdicionarHospede.class.getResource("/Icons/accept.png")), null);
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
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "MenuPadrao");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		add(btnCadastrar);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dataNascimento = dateChooser.getCalendar();
			}
		});
		dateChooser.setBounds(445, 182, 114, 17);
		add(dateChooser);
		
		lblData = CriaObjetosNaTela.criaLabel("Data de nascimento", new Rectangle(421, 155, 138, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblData);
	}
}

