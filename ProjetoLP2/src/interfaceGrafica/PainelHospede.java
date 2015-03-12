package interfaceGrafica;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import classes.dadosDoHospede.Hospede;
import excecoes.HospedeInvalidoException;
import executar.Run;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelHospede extends JPanel {

	private JLabel lblAtualizarCadastro, lblDadosPessoais, lblNome, lblCPF, lblEmail, lblCartao, lblTelefone, lblEstado, lblNumeroCasa,
	lblCepZipCode, lblCidade, lblEndereco, lblLogradouro, lblComplemento, lblBairro, lblPais, lblData;
	private JTextField textEmail, textCartao, textDDD, textNumero, textNome, textRua, textComplemento, textBairro, textPais, textCidade, 
	textCep, textNumeroCasa, textEstado, textCPF;
	private JSeparator separator;
	private Hospede hospedeAtual;
	private JButton btnCadastrar, btnAtualizarContrato;
	
	public PainelHospede(Hospede hospedeAtual) {
		setLayout(null);

		JLabel lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		lblAtualizarCadastro = CriaObjetosNaTela.criaLabel("Atualizar Hospede", new Rectangle(12, 12, 287, 29), CriaObjetosNaTela.getFontePadrao(24), null, null);
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
		
		textNome = CriaObjetosNaTela.criaTextField(hospedeAtual.getNome(), new Rectangle(119, 99, 440, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		add(textNome);
		
		textEmail = CriaObjetosNaTela.criaTextField(hospedeAtual.getEmail(), new Rectangle(119, 155, 264, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		add(textEmail);
		
		textCartao = CriaObjetosNaTela.criaTextField(hospedeAtual.getNumeroDoCartao(), new Rectangle(203, 182, 151, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		add(textCartao);
		
		lblTelefone = CriaObjetosNaTela.criaLabel("Telefone", new Rectangle(313, 129, 70, 15), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblTelefone);
		
		textDDD = CriaObjetosNaTela.criaTextField(hospedeAtual.getTelefone().getDdd(), new Rectangle(388, 128, 44, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		add(textDDD);
		
		textNumero = CriaObjetosNaTela.criaTextField(hospedeAtual.getTelefone().getNumero(), new Rectangle(445, 128, 114, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
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
		
		textRua = CriaObjetosNaTela.criaTextField(hospedeAtual.getEndereco().getNomeDaRua(), new Rectangle(144, 302, 468, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		add(textRua);
		
		textComplemento = CriaObjetosNaTela.criaTextField(hospedeAtual.getEndereco().getComplemento(), new Rectangle(167, 329, 299, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		add(textComplemento);
		
		textBairro = CriaObjetosNaTela.criaTextField(hospedeAtual.getEndereco().getBairro(), new Rectangle(119, 361, 138, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		add(textBairro);
		
		textPais = CriaObjetosNaTela.criaTextField(hospedeAtual.getEndereco().getPais(), new Rectangle(119, 394, 138, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		add(textPais);
		
		textCidade = CriaObjetosNaTela.criaTextField(hospedeAtual.getEndereco().getCidade(), new Rectangle(376, 361, 236, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		add(textCidade);
		
		textCep = CriaObjetosNaTela.criaTextField(hospedeAtual.getEndereco().getCep(), new Rectangle(436, 393, 138, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		add(textCep);
		
		textNumeroCasa = CriaObjetosNaTela.criaTextField(hospedeAtual.getEndereco().getNumeroDaCasa(), new Rectangle(542, 329, 70, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		textNumeroCasa.setBounds(542, 329, 70, 17);
		add(textNumeroCasa);
		
		textEstado = CriaObjetosNaTela.criaTextField(hospedeAtual.getEndereco().getEstado(), new Rectangle(203, 422, 180, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		add(textEstado);
		
		textCPF = CriaObjetosNaTela.criaTextField(hospedeAtual.getCpf(), new Rectangle(119, 127, 151, 17), CriaObjetosNaTela.getFontePadrao(15), false, null);
		add(textCPF);
		
		
		btnCadastrar = CriaObjetosNaTela.criaBotao("Visualizar Contratos", new Rectangle(392, 479, 182, 23), CriaObjetosNaTela.getFontePadrao(15), null, null);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Run.hotel.pesquisaHospede(textCPF.getText());
					MenuPrincipal.contratosDoHospede = new ContratosDoHospede(Run.hotel.pesquisaHospede(textCPF.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.contratosDoHospede, "19");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "19");
				} catch (HospedeInvalidoException e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		add(btnCadastrar);

		btnAtualizarContrato = CriaObjetosNaTela.criaBotao("Atualizar Cadastro", new Rectangle(119, 479, 180, 23), CriaObjetosNaTela.getFontePadrao(15), null, null);
		btnAtualizarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					Run.hotel.pesquisaHospede(textCPF.getText());
					MenuPrincipal.atualizarHospede = new AtualizarHospede(Run.hotel.pesquisaHospede(textCPF.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.atualizarHospede, "7");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "7");
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage());
				
				}
				
			}
		});
		add(btnAtualizarContrato);
	}
}
