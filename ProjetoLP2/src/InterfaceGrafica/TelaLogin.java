package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import com.sun.glass.events.WindowEvent;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import java.awt.Label;

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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 445);
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
		
		JButton entrar = new JButton("Entrar");
		entrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/Icons/lock_open.png")));
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loginField.getText().equals("admin") && isPasswordCorrect(passwordField.getPassword())){
					MenuPrincipal menuFrame = new MenuPrincipal();
					TelaLogin.this.dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
					
				}
			}
		});
		entrar.setFont(new Font("Dialog", Font.BOLD, 15));
		entrar.setBounds(116, 372, 130, 25);
		contentPane.add(entrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/Icons/180x158.png")));
		lblNewLabel.setBounds(170, 38, 192, 179);
		contentPane.add(lblNewLabel);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(TelaLogin.class.getResource("/Icons/lock_add.png")));
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCadastrar.setBounds(277, 372, 130, 25);
		contentPane.add(btnCadastrar);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaLogin.class.getResource("/Icons/key.png")));
		label.setBounds(116, 300, 36, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/Icons/status_online.png")));
		label_1.setBounds(116, 265, 36, 25);
		contentPane.add(label_1);
	}
	
	private boolean isPasswordCorrect(char[] input) {
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
    }
}