package gui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Color;

public class TelaInicial {
	
	private JTextField login;
	private JPasswordField senha;
	
	public TelaInicial() {
		
		JFrame frame = new JFrame("Hotel Rivieira");
		frame.getContentPane().setEnabled(false);
		frame.setForeground(Color.BLACK);
		frame.setResizable(false);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JButton entrar = new JButton("Entrar");
		entrar.setForeground(Color.WHITE);
		entrar.setBackground(Color.BLUE);
		entrar.setToolTipText("Entrar no gerenciador do hotel");
		
		entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( login.getText().equals("fabio") && senha.getText().equals("123") ) {
					JOptionPane.showMessageDialog(null, "Acesso permitido");
				} else {
					login.setText("");
					senha.setText("");
					JOptionPane.showMessageDialog(null, "Acesso negado");
				}
			}
		});
		
		entrar.setBounds(140, 342, 89, 23);
		frame.getContentPane().add(entrar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setForeground(Color.WHITE);
		cancelar.setBackground(Color.BLUE);
		cancelar.setToolTipText("Sair do sistema");
		
		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		cancelar.setBounds(313, 342, 89, 23);
		frame.getContentPane().add(cancelar);
		
		JButton esqueciSenha = new JButton("Esqueci a senha");
		esqueciSenha.setForeground(Color.WHITE);
		esqueciSenha.setBackground(Color.BLUE);
		esqueciSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "A senha foi enviada para seu e-mail.\n"
						+ "Tenha mais cuidado com sua senha!");
			}
		});
		esqueciSenha.setBounds(202, 293, 139, 23);
		frame.getContentPane().add(esqueciSenha);
		
		JLabel usuario = new JLabel("Usu\u00E1rio:");
		usuario.setFont(new Font("Consolas", Font.BOLD, 14));
		usuario.setBounds(140, 186, 69, 50);
		frame.getContentPane().add(usuario);
		
		login = new JTextField();
		login.setFont(new Font("Consolas", Font.BOLD, 13));
		login.setToolTipText("Digite o nome do usuário");
		login.setBounds(230, 201, 86, 20);
		frame.getContentPane().add(login);
		login.setColumns(10);
		
		JLabel labelSenha = new JLabel("Senha:");
		labelSenha.setFont(new Font("Consolas", Font.BOLD, 14));
		labelSenha.setBounds(139, 232, 69, 50);
		frame.getContentPane().add(labelSenha);
		
		senha = new JPasswordField();
		senha.setToolTipText("Digite a senha");
		senha.setBounds(230, 247, 86, 20);
		frame.getContentPane().add(senha);
	}

	public static void main(String[] args) {
		new TelaInicial();
	}
}