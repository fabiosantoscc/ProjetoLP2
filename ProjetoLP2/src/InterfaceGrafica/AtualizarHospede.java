package InterfaceGrafica;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import classes.Hospede;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AtualizarHospede extends JPanel {

	/**
	 * Create the panel.
	 */
	Hospede hospedeAtual;
	public AtualizarHospede(Hospede hospedeAtual) {

		setLayout(null);
		this.hospedeAtual = hospedeAtual;
		
		JLabel lblAtualizarCadastro = new JLabel("Atualizar Cadastro");
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
		
		JFormattedTextField frmtdtxtfldNome = new JFormattedTextField();
		frmtdtxtfldNome.setText(hospedeAtual.getNome());
		frmtdtxtfldNome.setBounds(119, 99, 440, 17);
		add(frmtdtxtfldNome);
		
		JFormattedTextField frmtdtxtfldEmail = new JFormattedTextField();
		frmtdtxtfldEmail.setText(hospedeAtual.getEmail());
		frmtdtxtfldEmail.setBounds(119, 155, 264, 17);
		add(frmtdtxtfldEmail);
		
		JFormattedTextField frmtdtxtfldCartaoCredito = new JFormattedTextField();
		frmtdtxtfldCartaoCredito.setText(hospedeAtual.getNumeroDoCartao());
		frmtdtxtfldCartaoCredito.setBounds(203, 182, 151, 17);
		add(frmtdtxtfldCartaoCredito);
		
		JLabel label_6 = new JLabel("Telefone");
		label_6.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_6.setBounds(313, 129, 70, 15);
		add(label_6);
		
		JFormattedTextField frmtdtxtfldDdd = new JFormattedTextField();
		frmtdtxtfldDdd.setText(hospedeAtual.getDDD());
		frmtdtxtfldDdd.setBounds(388, 128, 44, 17);
		add(frmtdtxtfldDdd);
		
		JFormattedTextField frmtdtxtfldTelefone = new JFormattedTextField();
		frmtdtxtfldTelefone.setText(hospedeAtual.getNumeroTelefone());
		frmtdtxtfldTelefone.setBounds(445, 128, 114, 17);
		add(frmtdtxtfldTelefone);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(38, 240, 687, 2);
		add(separator);
		
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
		
		JFormattedTextField frmtdtxtfldRua = new JFormattedTextField();
		frmtdtxtfldRua.setText(hospedeAtual.getNomeDaRua());
		frmtdtxtfldRua.setBounds(144, 302, 468, 17);
		add(frmtdtxtfldRua);
		
		JFormattedTextField frmtdtxtfldComplemento = new JFormattedTextField();
		frmtdtxtfldComplemento.setText(hospedeAtual.getComplemento());
		frmtdtxtfldComplemento.setBounds(167, 329, 299, 17);
		add(frmtdtxtfldComplemento);
		
		JFormattedTextField frmtdtxtfldBairro = new JFormattedTextField();
		frmtdtxtfldBairro.setText(hospedeAtual.getBairro());
		frmtdtxtfldBairro.setBounds(119, 361, 138, 17);
		add(frmtdtxtfldBairro);
		
		JFormattedTextField frmtdtxtfldPais = new JFormattedTextField();
		frmtdtxtfldPais.setText(hospedeAtual.getPais());
		frmtdtxtfldPais.setBounds(119, 394, 138, 17);
		add(frmtdtxtfldPais);
		
		JFormattedTextField frmtdtxtfldCidade = new JFormattedTextField();
		frmtdtxtfldCidade.setText(hospedeAtual.getCidade());
		frmtdtxtfldCidade.setBounds(376, 361, 198, 17);
		add(frmtdtxtfldCidade);
		
		JLabel label_7 = new JLabel("Estado/Condado");
		label_7.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_7.setBounds(58, 420, 126, 15);
		add(label_7);
		
		JLabel lblCepZipCode = new JLabel("CEP/ Zip Code");
		lblCepZipCode.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblCepZipCode.setBounds(292, 395, 126, 15);
		add(lblCepZipCode);
		
		JFormattedTextField frmtdtxtfldCep = new JFormattedTextField();
		frmtdtxtfldCep.setText("cep");
		frmtdtxtfldCep.setBounds(436, 393, 138, 17);
		add(frmtdtxtfldCep);
		
		JLabel label_14 = new JLabel("Numero");
		label_14.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		label_14.setBounds(476, 329, 70, 15);
		add(label_14);
		
		JFormattedTextField frmtdtxtfldNumero = new JFormattedTextField();
		frmtdtxtfldNumero.setText(hospedeAtual.getNumeroDaCasa());
		frmtdtxtfldNumero.setBounds(542, 329, 70, 17);
		add(frmtdtxtfldNumero);
		
		JButton btnCadastrar = new JButton("Atualizar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					
				}catch (Exception c){
					
				}
			}
		});
		btnCadastrar.setBounds(292, 479, 154, 23);
		add(btnCadastrar);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(203, 422, 180, 17);
		add(formattedTextField);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCidade.setBounds(292, 363, 70, 15);
		add(lblCidade);
		
		JFormattedTextField frmtdtxtfldCpf = new JFormattedTextField();
		frmtdtxtfldCpf.setEditable(false);
		frmtdtxtfldCpf.setText("cpf");
		frmtdtxtfldCpf.setBounds(119, 127, 158, 17);
		add(frmtdtxtfldCpf);
		
	}
}
