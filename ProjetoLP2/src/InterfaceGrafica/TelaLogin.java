package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;

public class TelaLogin extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeHotel = new JLabel("Hotel Riviera Campina");
		lblNomeHotel.setFont(new Font("Liberation Sans Narrow", Font.PLAIN, 50));
		lblNomeHotel.setBounds(196, 54, 438, 45);
		contentPane.add(lblNomeHotel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(305, 300, 178, 25);
		contentPane.add(passwordField);
		
		JFormattedTextField loginField = new JFormattedTextField();
		loginField.setBounds(305, 263, 178, 25);
		contentPane.add(loginField);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		lblLogin.setBounds(212, 264, 75, 20);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		lblSenha.setBounds(212, 305, 70, 15);
		contentPane.add(lblSenha);
		
		JCheckBox salvarSenha = new JCheckBox("Salvar Senha");
		salvarSenha.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 16));
		salvarSenha.setBounds(315, 333, 129, 23);
		contentPane.add(salvarSenha);
		
		JButton entrar = new JButton("Entrar");
		entrar.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 16));
		entrar.setBounds(453, 382, 117, 25);
		contentPane.add(entrar);
		
		JLabel lblEsqueceuASenha = new JLabel("Esqueceu a Senha?");
		lblEsqueceuASenha.setForeground(Color.BLUE);
		lblEsqueceuASenha.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		lblEsqueceuASenha.setBounds(212, 428, 154, 25);
		contentPane.add(lblEsqueceuASenha);
	}
}