package interfaceGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import sun.security.provider.VerificationProvider;
import classes.Arquivos;
import classes.Cadastro;
import excecoes.StringInvalidaException;
import executar.Run;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JPasswordField passwordField;
	private JPasswordField ConfirmPasswordField;
	private JTextField textLogin;
	private JTextField textPIN;

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 441, 392);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoCadastro = new JLabel("Novo cadastro");
		lblNovoCadastro.setForeground(Color.BLACK);
		lblNovoCadastro.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNovoCadastro.setBounds(162, 11, 118, 50);
		contentPane.add(lblNovoCadastro);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(32, 98, 67, 20);
		contentPane.add(lblNome);
		
		textNome = new JTextField();
		textNome.setToolTipText("Nome do Funcion\u00E1rio");
		textNome.setBounds(109, 100, 195, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(32, 163, 84, 20);
		contentPane.add(lblSenha);
		
		JLabel lblRepetirSenha = new JLabel("Confirmar Senha");
		lblRepetirSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRepetirSenha.setBounds(32, 194, 107, 20);
		contentPane.add(lblRepetirSenha);
		
		passwordField = new JPasswordField();
		passwordField.setToolTipText("Senha");
		passwordField.setBounds(109, 163, 195, 20);
		contentPane.add(passwordField);
		
		ConfirmPasswordField = new JPasswordField();
		ConfirmPasswordField.setToolTipText("Confirmacao de senha");
		ConfirmPasswordField.setBounds(157, 194, 147, 20);
		contentPane.add(ConfirmPasswordField);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(32, 131, 67, 20);
		contentPane.add(lblLogin);
		
		textLogin = new JTextField();
		textLogin.setToolTipText("Nome de login");
		textLogin.setColumns(10);
		textLogin.setBounds(109, 133, 195, 20);
		contentPane.add(textLogin);
		
		JLabel lblPIN = new JLabel("PIN");
		lblPIN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPIN.setBounds(32, 225, 84, 20);
		contentPane.add(lblPIN);
		
		textPIN = new JTextField();
		textPIN.setToolTipText("Pin do gerente");
		textPIN.setColumns(10);
		textPIN.setBounds(109, 227, 58, 20);
		contentPane.add(textPIN);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setToolTipText("Cancelar cadastramento.");
		btnCancelar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/Icons/cancel.png")));
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textNome.setText("");
				passwordField.setText("");
				ConfirmPasswordField.setText("");
				TelaCadastro.this.dispose();
			}
		});
		btnCancelar.setBounds(233, 290, 118, 23);
		contentPane.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setToolTipText("Cadastrar funcion\u00E1rio.");
		btnCadastrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				Cadastro c = null;
				try {
					if ( !(passwordField.getText().equals(ConfirmPasswordField.getText())) ) {
						throw new StringInvalidaException("Senhas nao coincidem.");
					}
					
					c = new Cadastro(textPIN.getText(), textNome.getText(), textLogin.getText(), passwordField.getText());
					Run.hotel.adicionarCadastro(c, textPIN.getText());
					JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso");
					textNome.setText("");
					passwordField.setText("");
					ConfirmPasswordField.setText("");
					textPIN.setText("");
					textLogin.setText("");
					Arquivos.salvaHotel(Run.hotel);
					TelaCadastro.this.dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		btnCadastrar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/Icons/accept.png")));
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCadastrar.setBounds(98, 290, 118, 23);
		contentPane.add(btnCadastrar);
	}
	
}
