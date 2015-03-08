package InterfaceGrafica;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 441, 431);
		setVisible(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNovoCadastro = new JLabel("Novo cadastro");
		lblNovoCadastro.setForeground(Color.BLACK);
		lblNovoCadastro.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNovoCadastro.setBounds(163, 11, 118, 50);
		contentPane.add(lblNovoCadastro);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNome.setBounds(35, 83, 67, 50);
		contentPane.add(lblNome);
		
		textField = new JTextField();
		textField.setBounds(84, 99, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/Icons/cancel.png")));
		btnCancelar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastro.this.dispose();
			}
		});
		btnCancelar.setBounds(237, 348, 107, 23);
		contentPane.add(btnCancelar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/Icons/accept.png")));
		btnCadastrar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCadastrar.setBounds(110, 348, 107, 23);
		contentPane.add(btnCadastrar);
	}
}
