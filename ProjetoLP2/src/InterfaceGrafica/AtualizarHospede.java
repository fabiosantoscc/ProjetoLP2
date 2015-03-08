package InterfaceGrafica;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import Executar.Run;
import classes.Arquivos;
import classes.Hospede;
import classes.Telefone;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class AtualizarHospede extends JPanel {

	/**
	 * Create the panel.
	 */

	public AtualizarHospede(Hospede hospedeAtual) {

		setLayout(null);
						
		JLabel lblAtualizarCadastro = new JLabel("Atualizar Cadastro");
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
		textNome.setText(hospedeAtual.getNome());
		textNome.setBounds(119, 99, 440, 17);
		add(textNome);
		
		JFormattedTextField textEmail = new JFormattedTextField();
		textEmail.setText(hospedeAtual.getEmail());
		textEmail.setBounds(119, 155, 264, 17);
		add(textEmail);
		
		JFormattedTextField textCartao = new JFormattedTextField();
		textCartao.setText(hospedeAtual.getNumeroDoCartao());
		textCartao.setBounds(203, 182, 151, 17);
		add(textCartao);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelefone.setBounds(313, 129, 70, 15);
		add(lblTelefone);
		
		JFormattedTextField textDDD = new JFormattedTextField();
		textDDD.setText(hospedeAtual.getTelefone().getDdd());
		textDDD.setBounds(388, 128, 44, 17);
		add(textDDD);
		
		JFormattedTextField textNumero = new JFormattedTextField();
		textNumero.setText(hospedeAtual.getTelefone().getNumero());
		textNumero.setBounds(445, 128, 114, 17);
		add(textNumero);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 240, 687, 2);
		add(separator);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblEndereco.setBounds(38, 254, 114, 25);
		add(lblEndereco);
		
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
		textRua.setText(hospedeAtual.getEndereco().getNomeDaRua());
		textRua.setBounds(144, 302, 468, 17);
		add(textRua);
		
		JFormattedTextField textComplemento = new JFormattedTextField();
		textComplemento.setText(hospedeAtual.getEndereco().getComplemento());
		textComplemento.setBounds(167, 329, 299, 17);
		add(textComplemento);
		
		JFormattedTextField textBairro = new JFormattedTextField();
		textBairro.setText(hospedeAtual.getEndereco().getBairro());
		textBairro.setBounds(119, 361, 138, 17);
		add(textBairro);
		
		JFormattedTextField textPais = new JFormattedTextField();
		textPais.setText(hospedeAtual.getEndereco().getPais());
		textPais.setBounds(119, 394, 138, 17);
		add(textPais);
		
		JFormattedTextField textCidade = new JFormattedTextField();
		textCidade.setText(hospedeAtual.getEndereco().getCidade());
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
		textCEP.setText(hospedeAtual.getEndereco().getCep());
		textCEP.setBounds(436, 393, 138, 17);
		add(textCEP);
		
		JLabel lblNumeroCasa = new JLabel("Numero");
		lblNumeroCasa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeroCasa.setBounds(476, 329, 70, 15);
		add(lblNumeroCasa);
		
		JFormattedTextField textNumeroCasa = new JFormattedTextField();
		textNumeroCasa.setText(hospedeAtual.getEndereco().getNumeroDaCasa());
		textNumeroCasa.setBounds(542, 329, 70, 17);
		add(textNumeroCasa);
		
		JFormattedTextField textEstado = new JFormattedTextField();
		textEstado.setText(hospedeAtual.getEndereco().getEstado());
		textEstado.setBounds(203, 422, 180, 17);
		add(textEstado);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCidade.setBounds(292, 363, 70, 15);
		add(lblCidade);
		
		JFormattedTextField textCPF = new JFormattedTextField();
		textCPF.setEditable(false);
		textCPF.setText(hospedeAtual.getCpf());
		textCPF.setBounds(119, 127, 158, 17);
		add(textCPF);
		
		
		JButton btnCadastrar = new JButton("Atualizar");
		btnCadastrar.setIcon(new ImageIcon(AtualizarHospede.class.getResource("/Icons/accept.png")));
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrar.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e){
				try{
					hospedeAtual.setNome(textNome.getText());
					hospedeAtual.setEmail(textEmail.getText());
					hospedeAtual.setNumeroDoCartao(textCartao.getText());;
					hospedeAtual.getTelefone().setDdd(textDDD.getText());
					hospedeAtual.getTelefone().setNumero(textNumero.getText());
					hospedeAtual.getEndereco().setBairro(textBairro.getText());
					hospedeAtual.getEndereco().setCidade(textCidade.getText());
					hospedeAtual.getEndereco().setEstado(textEstado.getText());
					hospedeAtual.getEndereco().setComplemento(textComplemento.getText());
					hospedeAtual.getEndereco().setNomeDaRua(textRua.getText());
					hospedeAtual.getEndereco().setNumeroDaCasa(textNumeroCasa.getText());
					hospedeAtual.getEndereco().setPais(textPais.getText());
					hospedeAtual.getEndereco().setCep(textCEP.getText());
					JOptionPane.showMessageDialog(null, "Hospede atualizado com sucesso!");
					Arquivos.salvaHotel(Run.hotel);
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "0");
				}catch (Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage());
				}
			}
		});
		btnCadastrar.setBounds(313, 487, 137, 29);
		add(btnCadastrar);
		

	}
}
