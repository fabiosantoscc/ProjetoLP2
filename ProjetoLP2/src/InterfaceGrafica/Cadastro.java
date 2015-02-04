package InterfaceGrafica;

import excecoes.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;

import classes.Endereco;
import classes.Hospede;
import classes.Telefone;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 601);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Cliente");
		lblNewLabel.setBounds(32, 24, 287, 29);
		lblNewLabel.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 28));
		getContentPane().add(lblNewLabel);
		
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		lblDadosPessoais.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		lblDadosPessoais.setBounds(42, 65, 174, 29);
		getContentPane().add(lblDadosPessoais);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblNome.setBounds(52, 106, 70, 25);
		getContentPane().add(lblNome);
		
		JFormattedTextField nome = new JFormattedTextField();
		nome.setBounds(108, 114, 440, 17);
		getContentPane().add(nome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblCpf.setBounds(52, 143, 70, 15);
		getContentPane().add(lblCpf);
		
		JFormattedTextField cpf = new JFormattedTextField();
		cpf.setBounds(108, 143, 158, 17);
		getContentPane().add(cpf);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblEmail.setBounds(52, 170, 70, 15);
		getContentPane().add(lblEmail);
		
		JFormattedTextField email = new JFormattedTextField();
		email.setBounds(108, 168, 323, 17);
		getContentPane().add(email);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblTelefone.setBounds(338, 142, 70, 15);
		getContentPane().add(lblTelefone);
		
		JFormattedTextField ddd = new JFormattedTextField();
		ddd.setBounds(426, 142, 34, 17);
		getContentPane().add(ddd);
		
		JFormattedTextField numeroTelefone = new JFormattedTextField();
		numeroTelefone.setBounds(470, 142, 114, 17);
		getContentPane().add(numeroTelefone);
		
		JLabel lblNewLabel_1 = new JLabel("Cartao de credito");
		lblNewLabel_1.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblNewLabel_1.setBounds(52, 196, 158, 15);
		getContentPane().add(lblNewLabel_1);
		
		JFormattedTextField cartao = new JFormattedTextField();
		cartao.setBounds(211, 194, 151, 17);
		getContentPane().add(cartao);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(42, 245, 687, 2);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Endereço");
		lblNewLabel_2.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		lblNewLabel_2.setBounds(42, 279, 80, 25);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Logradouro");
		lblNewLabel_3.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblNewLabel_3.setBounds(52, 327, 138, 15);
		getContentPane().add(lblNewLabel_3);
		
		JFormattedTextField rua = new JFormattedTextField();
		rua.setBounds(172, 325, 468, 17);
		getContentPane().add(rua);
		
		JLabel lblPais = new JLabel("Bairro");
		lblPais.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblPais.setBounds(52, 386, 70, 15);
		getContentPane().add(lblPais);
		
		JFormattedTextField bairro = new JFormattedTextField();
		bairro.setBounds(108, 385, 138, 17);
		getContentPane().add(bairro);
		
		JLabel lblEstadocondado = new JLabel("Estado/Condado");
		lblEstadocondado.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblEstadocondado.setBounds(282, 386, 126, 15);
		getContentPane().add(lblEstadocondado);
		
		JFormattedTextField estado = new JFormattedTextField();
		estado.setBounds(426, 385, 138, 17);
		getContentPane().add(estado);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblComplemento.setBounds(52, 354, 114, 15);
		getContentPane().add(lblComplemento);
		
		JFormattedTextField complemento = new JFormattedTextField();
		complemento.setBounds(171, 354, 323, 17);
		getContentPane().add(complemento);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblNumero.setBounds(520, 354, 70, 15);
		getContentPane().add(lblNumero);
		
		JFormattedTextField numero = new JFormattedTextField();
		numero.setBounds(590, 352, 50, 17);
		getContentPane().add(numero);
		
		JLabel lblPas = new JLabel("Pais");
		lblPas.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblPas.setBounds(52, 419, 70, 15);
		getContentPane().add(lblPas);
		
		JFormattedTextField pais = new JFormattedTextField();
		pais.setBounds(108, 417, 138, 17);
		getContentPane().add(pais);
		
		JLabel lblCepZipeCode = new JLabel("CEP/ Zipe Code");
		lblCepZipeCode.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblCepZipeCode.setBounds(282, 419, 126, 15);
		getContentPane().add(lblCepZipeCode);
		
		JFormattedTextField cep = new JFormattedTextField();
		cep.setBounds(426, 418, 119, 17);
		getContentPane().add(cep);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Endereco e = null;
				Telefone t = null;
				
				try {
					t = new Telefone(ddd.getText(), numeroTelefone.getText());
				} catch ( Exception s ) {
					JOptionPane.showMessageDialog(null, s.getMessage());
				}
					
				try {
					e = new Endereco("Casa", bairro.getText(), rua.getText(), numero.getText(), complemento.getText(), estado.getText(), pais.getText());
				} catch ( Exception s ) {
					JOptionPane.showMessageDialog(null, s.getMessage());
				}
				
				try {
					Hospede h = new Hospede(nome.getText(), cpf.getText(), cartao.getText(), email.getText(), t, e);
				} catch ( Exception s ) {
					JOptionPane.showMessageDialog(null, s.getMessage());
				}
			}
		});
		btnCriar.setBounds(342, 500, 89, 23);
		getContentPane().add(btnCriar);
	}
}
