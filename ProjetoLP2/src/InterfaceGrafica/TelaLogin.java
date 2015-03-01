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
		setBounds(100, 100, 781, 601);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(348, 300, 178, 25);
		passwordField.setText("admin");
		contentPane.add(passwordField);
		
		JFormattedTextField loginField = new JFormattedTextField();
		loginField.setText("admin");
		loginField.setBounds(348, 265, 178, 25);
		contentPane.add(loginField);
		
		JLabel lblLogin = new JLabel("Login");
		
		lblLogin.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		lblLogin.setBounds(233, 269, 75, 20);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		lblSenha.setBounds(233, 302, 70, 15);
		contentPane.add(lblSenha);
		
		JButton entrar = new JButton("Entrar");
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
		entrar.setFont(new Font("Dialog", Font.BOLD, 18));
		entrar.setBounds(294, 390, 192, 51);
		contentPane.add(entrar);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/Icons/180x158.png")));
		lblNewLabel.setBounds(294, 47, 192, 179);
		contentPane.add(lblNewLabel);
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