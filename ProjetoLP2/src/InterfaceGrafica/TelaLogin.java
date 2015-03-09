package InterfaceGrafica;

import java.awt.EventQueue;

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
import java.util.Arrays;

import javax.swing.ImageIcon;

import classes.Cadastro;
import Executar.Run;

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
		passwordField.setText("admin");
		contentPane.add(passwordField);
		
		JFormattedTextField loginField = new JFormattedTextField();
		loginField.setText("admin");
		loginField.setToolTipText("Digite o nome do usuário para entrar no sistema.");
		loginField.setBounds(229, 265, 178, 25);
		contentPane.add(loginField);
		
		JLabel lblLogin = new JLabel("Login");
		
		lblLogin.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		lblLogin.setBounds(144, 265, 75, 25);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		lblSenha.setBounds(144, 302, 70, 23);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/Icons/lock_open.png")));
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
		btnEntrar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnEntrar.setBounds(116, 350, 130, 25);
		contentPane.add(btnEntrar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( telaAberta == 0) {
					telaAberta++;
					new TelaCadastro();
				}
			}
		});
		btnCadastrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/Icons/lock_add.png")));
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCadastrar.setBounds(277, 350, 130, 25);
		contentPane.add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSair.setIcon(new ImageIcon(TelaLogin.class.getResource("/Icons/cancel.png")));
		btnSair.setFont(new Font("Dialog", Font.BOLD, 15));
		btnSair.setBounds(219, 389, 89, 23);
		contentPane.add(btnSair);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(TelaLogin.class.getResource("/Icons/180x158.png")));
		lblLogo.setBounds(172, 25, 192, 179);
		contentPane.add(lblLogo);
		
		JLabel lblUserIcon = new JLabel("");
		lblUserIcon.setIcon(new ImageIcon(TelaLogin.class.getResource("/Icons/key.png")));
		lblUserIcon.setBounds(116, 300, 36, 25);
		contentPane.add(lblUserIcon);
		
		JLabel lblSenhaIcon = new JLabel("");
		lblSenhaIcon.setIcon(new ImageIcon(TelaLogin.class.getResource("/Icons/status_online.png")));
		lblSenhaIcon.setBounds(116, 265, 36, 25);
		contentPane.add(lblSenhaIcon);
	}
	
	private void checaSenha(String senhaComparada)throws Exception{
		if (!(passwordField.getText().equals(senhaComparada))){
			throw new Exception("Senha incorreta!");
		}
	}
	
/*	private boolean isPasswordCorrect(char[] input) {
        boolean isCorrect = true;
        char[] correctPassword = { 'a', 'd', 'm', 'i', 'n'};
 
        if (input.length != correctPassword.length) {
            isCorrect = false;
        } else {
            isCorrect = Arrays.equals (input, correctPassword);
        }
 
        //Zero out the password.
        Arrays.fill(correctPassword,'0');
 
        return isCorrect;
    }*/
}