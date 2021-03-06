package interfaceGrafica;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import classes.Cadastro;
import executar.Run;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JButton btnEntrar, btnSair, btnCadastrar;
	private JLabel lblLogin, lblSenha, lblLogo, lblUserIcon, lblSenhaIcon;
	private JTextField loginField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 462);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(229, 300, 178, 25);
		passwordField.setToolTipText("Senha do funcionário");
		contentPane.add(passwordField);
		
		loginField = CriaObjetosNaTela.criaTextField(null, new Rectangle(229, 265, 178, 25), fontePadrao(18), true,"Digite o nome do usuário para entrar no sistema.");
		loginField.setToolTipText("Nome de login do funcionário.");
		contentPane.add(loginField);
		
		lblLogin = CriaObjetosNaTela.criaLabel("Login",new Rectangle(144, 265, 75, 25) , fontePadrao(18), null, null);
		contentPane.add(lblLogin);
		
		lblSenha = CriaObjetosNaTela.criaLabel("Senha", new Rectangle(144, 302, 70, 23), fontePadrao(18), null, null);
		contentPane.add(lblSenha);
		
		btnEntrar = CriaObjetosNaTela.criaBotao("Entrar", new Rectangle(116, 350, 130, 25), fontePadrao(15), new ImageIcon(TelaLogin.class.getResource("/Icons/lock_open.png")), null); 
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cadastro funcionarioAtual = Run.hotel.buscarCadastro(loginField.getText());
					checaSenha(funcionarioAtual.getSenha());
					MenuPrincipal menuFrame = new MenuPrincipal(funcionarioAtual);
					TelaLogin.this.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnEntrar.setToolTipText("Entrar no sistema");
		contentPane.add(btnEntrar);
		
		btnCadastrar = CriaObjetosNaTela.criaBotao("Cadastrar", new Rectangle(277, 350, 130, 25), fontePadrao(15), new ImageIcon(TelaLogin.class.getResource("/Icons/lock_add.png")), null);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					new TelaCadastro();
			}
		});

		btnCadastrar.setToolTipText("Cadastrar novo funcionário");
		contentPane.add(btnCadastrar);
		
		btnSair = CriaObjetosNaTela.criaBotao("Sair", new Rectangle(219, 389, 89, 23), fontePadrao(18), new ImageIcon(TelaLogin.class.getResource("/Icons/cancel.png")), null);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setToolTipText("Sair do sistema");
		contentPane.add(btnSair);
		
		lblLogo = CriaObjetosNaTela.criaLabel("", new Rectangle(172, 25, 192, 179), fontePadrao(18), new ImageIcon(TelaLogin.class.getResource("/Icons/180x158.png")), null);
		contentPane.add(lblLogo);
		
		lblUserIcon = CriaObjetosNaTela.criaLabel("", new Rectangle(116, 300, 36, 25), fontePadrao(18), new ImageIcon(TelaLogin.class.getResource("/Icons/key.png")), null);
		contentPane.add(lblUserIcon);
		
		lblSenhaIcon = CriaObjetosNaTela.criaLabel("", new Rectangle(116, 265, 36, 25), fontePadrao(18),new ImageIcon(TelaLogin.class.getResource("/Icons/status_online.png")), null);
		contentPane.add(lblSenhaIcon);
	}
	
	private void checaSenha(String senhaComparada) throws Exception {
		if (!(passwordField.getText().equals(senhaComparada))){
			throw new Exception("Senha incorreta!");
		}
	}
	
	private Font fontePadrao(int tamanho){
		return new Font("Liberation Sans Narrow", Font.BOLD, tamanho);
	}
}
