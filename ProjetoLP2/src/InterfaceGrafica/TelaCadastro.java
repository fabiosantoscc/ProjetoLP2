package InterfaceGrafica;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

import classes.Arquivos;
import classes.Cadastro;
import Executar.Run;

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
		passwordField.setBounds(109, 163, 195, 20);
		contentPane.add(passwordField);
		
		ConfirmPasswordField = new JPasswordField();
		ConfirmPasswordField.setBounds(157, 194, 147, 20);
		contentPane.add(ConfirmPasswordField);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLogin.setBounds(32, 131, 67, 20);
		contentPane.add(lblLogin);
		
		textLogin = new JTextField();
		textLogin.setColumns(10);
		textLogin.setBounds(109, 133, 195, 20);
		contentPane.add(textLogin);
		
		JLabel lblPIN = new JLabel("PIN");
		lblPIN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPIN.setBounds(32, 225, 84, 20);
		contentPane.add(lblPIN);
		
		textPIN = new JTextField();
		textPIN.setColumns(10);
		textPIN.setBounds(109, 227, 58, 20);
		contentPane.add(textPIN);
		
		JButton btnCancelar = new JButton("Cancelar");
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
		btnCancelar.setBounds(233, 290, 107, 23);
		contentPane.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Run.hotel.adicionarCadastro(new Cadastro(textPIN.getText(), textNome.getText(), textLogin.getText(), passwordField.getText()), textPIN.getText());
					textNome.setText("");
					passwordField.setText("");
					ConfirmPasswordField.setText("");
					JOptionPane.showMessageDialog(null, "Funcionario cadastrado com sucesso");
					//Arquivos.salvaHotel(Run.hotel);
					TelaCadastro.this.dispose();
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		
		btnCadastrar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/Icons/accept.png")));
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCadastrar.setBounds(109, 290, 107, 23);
		contentPane.add(btnCadastrar);
	}
	
}
