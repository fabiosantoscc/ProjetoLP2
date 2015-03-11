package interfaceGráfica;

import java.awt.EventQueue;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import classes.Cadastro;
import executar.Run;

public class TelaLogin extends JFrame {

	private int telaAberta = 0;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
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
		contentPane.add(passwordField);
		
		JFormattedTextField loginField = CriaObjetosNaTela.criaTextField(null, new Rectangle(229, 265, 178, 25), fontePadrao(18), true,"Digite o nome do usuário para entrar no sistema.");
		contentPane.add(loginField);
		
		JLabel lblLogin = CriaObjetosNaTela.criaLabel("Login",new Rectangle(144, 265, 75, 25) , fontePadrao(18), null);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = CriaObjetosNaTela.criaLabel("Senha", new Rectangle(144, 302, 70, 23), fontePadrao(18), null);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = CriaObjetosNaTela.criaBotao("Entrar", new Rectangle(116, 350, 130, 25), fontePadrao(18), new ImageIcon(TelaLogin.class.getResource("/Icons/lock_open.png"))); 
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cadastro funcionarioAtual = Run.hotel.buscarCadastro(loginField.getText());
					checaSenha(funcionarioAtual.getSenha());
					MenuPrincipal menuFrame = new MenuPrincipal();
					TelaLogin.this.dispose();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		contentPane.add(btnEntrar);
		
		JButton btnCadastrar = CriaObjetosNaTela.criaBotao("Entrar", new Rectangle(277, 350, 130, 25), fontePadrao(18), new ImageIcon(TelaLogin.class.getResource("/Icons/lock_add.png")));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( telaAberta == 0) {
					//telaAberta++;
					new TelaCadastro();
				}
			}
		});
		contentPane.add(btnCadastrar);
		
		JButton btnSair = CriaObjetosNaTela.criaBotao("Sair", new Rectangle(219, 389, 89, 23), fontePadrao(18), new ImageIcon(TelaLogin.class.getResource("/Icons/cancel.png")));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		contentPane.add(btnSair);
		
		JLabel lblLogo = CriaObjetosNaTela.criaLabel("", new Rectangle(172, 25, 192, 179), fontePadrao(18), new ImageIcon(TelaLogin.class.getResource("/Icons/180x158.png")));
		contentPane.add(lblLogo);
		
		JLabel lblUserIcon = CriaObjetosNaTela.criaLabel("", new Rectangle(116, 300, 36, 25), fontePadrao(18), new ImageIcon(TelaLogin.class.getResource("/Icons/key.png")));
		contentPane.add(lblUserIcon);
		
		JLabel lblSenhaIcon = CriaObjetosNaTela.criaLabel("", new Rectangle(116, 265, 36, 25), fontePadrao(18),new ImageIcon(TelaLogin.class.getResource("/Icons/status_online.png")));
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