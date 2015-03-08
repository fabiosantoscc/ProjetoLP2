package InterfaceGrafica;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import Executar.Run;
import classes.Hospede;
import excecoes.HospedeInvalidoException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PainelHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	private Hospede hospedeAtual;
	public PainelHospede(Hospede hospedeAtual) {
		setLayout(null);
		this.hospedeAtual = hospedeAtual;
		
		JLabel lblHospede = new JLabel("Hospede");
		lblHospede.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHospede.setBounds(12, 12, 287, 29);
		add(lblHospede);
		
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		lblDadosPessoais.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		textNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNome.setText(hospedeAtual.getNome());
		textNome.setEditable(false);
		textNome.setBounds(119, 99, 440, 17);
		add(textNome);
		
		JFormattedTextField textEmail = new JFormattedTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEmail.setText(hospedeAtual.getEmail());
		textEmail.setEditable(false);
		textEmail.setBounds(119, 155, 264, 17);
		add(textEmail);
		
		JFormattedTextField textCartao = new JFormattedTextField();
		textCartao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCartao.setText(hospedeAtual.getNumeroDoCartao());
		textCartao.setEditable(false);
		textCartao.setBounds(203, 182, 151, 17);
		add(textCartao);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefone.setBounds(313, 129, 70, 15);
		add(lblTelefone);
		
		JFormattedTextField textDDD = new JFormattedTextField();
		textDDD.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textDDD.setText(hospedeAtual.getTelefone().getDdd());
		textDDD.setEditable(false);
		textDDD.setBounds(388, 128, 44, 17);
		add(textDDD);
		
		JFormattedTextField textNumero = new JFormattedTextField();
		textNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNumero.setText(hospedeAtual.getTelefone().getNumero());
		textNumero.setEditable(false);
		textNumero.setBounds(445, 128, 114, 17);
		add(textNumero);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 240, 687, 2);
		add(separator);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 20));
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
		
		JFormattedTextField textLogradouro = new JFormattedTextField();
		textLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textLogradouro.setText(hospedeAtual.getEndereco().getNomeDaRua());
		textLogradouro.setEditable(false);
		textLogradouro.setBounds(144, 302, 468, 17);
		add(textLogradouro);
		
		JFormattedTextField textComplemento = new JFormattedTextField();
		textComplemento.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textComplemento.setText(hospedeAtual.getEndereco().getComplemento());
		textComplemento.setEditable(false);
		textComplemento.setBounds(167, 329, 299, 17);
		add(textComplemento);
		
		JFormattedTextField textBairro = new JFormattedTextField();
		textBairro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textBairro.setText(hospedeAtual.getEndereco().getBairro());
		textBairro.setEditable(false);
		textBairro.setBounds(119, 361, 138, 17);
		add(textBairro);
		
		JFormattedTextField textPais = new JFormattedTextField();
		textPais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textPais.setText(hospedeAtual.getEndereco().getPais());
		textPais.setEditable(false);
		textPais.setBounds(119, 394, 138, 17);
		add(textPais);
		
		JFormattedTextField textCidade = new JFormattedTextField();
		textCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCidade.setText(hospedeAtual.getEndereco().getCidade());
		textCidade.setEditable(false);
		textCidade.setBounds(376, 361, 198, 17);
		add(textCidade);
		
		JLabel lblEstado = new JLabel("Estado/Condado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEstado.setBounds(58, 420, 126, 15);
		add(lblEstado);
		
		JLabel lblCepZipCode = new JLabel("CEP/ Zip Code");
		lblCepZipCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCepZipCode.setBounds(292, 395, 126, 15);
		add(lblCepZipCode);
		
		JFormattedTextField textCEP = new JFormattedTextField();
		textCEP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCEP.setText(hospedeAtual.getEndereco().getCep());
		textCEP.setEditable(false);
		textCEP.setBounds(436, 393, 138, 17);
		add(textCEP);
		
		JLabel lblNumeroCasa = new JLabel("Numero");
		lblNumeroCasa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroCasa.setBounds(476, 329, 70, 15);
		add(lblNumeroCasa);
		
		JFormattedTextField textNumeroCasa = new JFormattedTextField();
		textNumeroCasa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textNumeroCasa.setText(hospedeAtual.getEndereco().getNumeroDaCasa());
		textNumeroCasa.setEditable(false);
		textNumeroCasa.setBounds(542, 329, 70, 17);
		add(textNumeroCasa);
		
		JFormattedTextField textEstado = new JFormattedTextField();
		textEstado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textEstado.setText(hospedeAtual.getEndereco().getEstado());
		textEstado.setEditable(false);
		textEstado.setBounds(203, 422, 180, 17);
		add(textEstado);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCidade.setBounds(292, 363, 70, 15);
		add(lblCidade);
		
		JFormattedTextField textCPF = new JFormattedTextField();
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textCPF.setText(hospedeAtual.getCpf());
		textCPF.setEditable(false);
		textCPF.setBounds(119, 127, 151, 17);
		add(textCPF);
		
		
		JButton btnCadastrar = new JButton("Visualizar Contratos");
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Run.hotel.pesquisaHospede(textCPF.getText());
					MenuPrincipal.contratosDoHospede = new ContratosDoHospede(Run.hotel.pesquisaHospede(textCPF.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.contratosDoHospede, "19");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "19");
					textNome.setText("");
					textCPF.setText("");
				} catch (HospedeInvalidoException e) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		
		btnCadastrar.setBounds(392, 479, 182, 23);
		add(btnCadastrar);

		JButton btnAtualizarContrato = new JButton("Atualizar Cadastro");
		btnAtualizarContrato.setFont(new Font("Tahoma", Font.PLAIN, 15));
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

		btnAtualizarContrato.setBounds(119, 479, 180, 23);
		add(btnAtualizarContrato);
	}
}
