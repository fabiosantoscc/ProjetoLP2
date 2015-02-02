package InterfaceGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JToolBar;
import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JSeparator;

public class CadastrarCliente extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarCliente frame = new CadastrarCliente();
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
	public CadastrarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 601);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Cliente");
		lblNewLabel.setBounds(32, 24, 287, 29);
		lblNewLabel.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 28));
		getContentPane().add(lblNewLabel);
		
		JLabel lblDadosPessoais = new JLabel("Dados Pessoais");
		lblDadosPessoais.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		lblDadosPessoais.setBounds(42, 65, 174, 29);
		getContentPane().add(lblDadosPessoais);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblNome.setBounds(52, 106, 70, 25);
		getContentPane().add(lblNome);
		
		JFormattedTextField nomeDoClienteTextField = new JFormattedTextField();
		nomeDoClienteTextField.setBounds(108, 114, 440, 17);
		getContentPane().add(nomeDoClienteTextField);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblCpf.setBounds(52, 143, 70, 15);
		getContentPane().add(lblCpf);
		
		JFormattedTextField cpfTextField = new JFormattedTextField();
		cpfTextField.setBounds(108, 143, 158, 17);
		getContentPane().add(cpfTextField);
		
		JLabel lblRg = new JLabel("RG");
		lblRg.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblRg.setBounds(298, 143, 70, 15);
		getContentPane().add(lblRg);
		
		JFormattedTextField rgTextField_2 = new JFormattedTextField();
		rgTextField_2.setBounds(336, 141, 158, 17);
		getContentPane().add(rgTextField_2);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblEmail.setBounds(52, 170, 70, 15);
		getContentPane().add(lblEmail);
		
		JFormattedTextField emailTextField_3 = new JFormattedTextField();
		emailTextField_3.setBounds(108, 168, 323, 17);
		getContentPane().add(emailTextField_3);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblTelefone.setBounds(459, 170, 70, 15);
		getContentPane().add(lblTelefone);
		
		JFormattedTextField dddTextField_4 = new JFormattedTextField();
		dddTextField_4.setBounds(544, 168, 34, 17);
		getContentPane().add(dddTextField_4);
		
		JFormattedTextField telefoneTextField_5 = new JFormattedTextField();
		telefoneTextField_5.setBounds(590, 168, 114, 17);
		getContentPane().add(telefoneTextField_5);
		
		JLabel lblNewLabel_1 = new JLabel("Cartão de Crédito *");
		lblNewLabel_1.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblNewLabel_1.setBounds(52, 196, 158, 15);
		getContentPane().add(lblNewLabel_1);
		
		JFormattedTextField cartaoCreditoTextField_6 = new JFormattedTextField();
		cartaoCreditoTextField_6.setBounds(211, 194, 158, 17);
		getContentPane().add(cartaoCreditoTextField_6);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(42, 245, 687, 2);
		getContentPane().add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("Endereço");
		lblNewLabel_2.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 18));
		lblNewLabel_2.setBounds(42, 279, 80, 25);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Logradouro");
		lblNewLabel_3.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblNewLabel_3.setBounds(52, 327, 138, 15);
		getContentPane().add(lblNewLabel_3);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(172, 325, 468, 17);
		getContentPane().add(formattedTextField);
		
		JLabel lblPais = new JLabel("Bairro");
		lblPais.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblPais.setBounds(52, 386, 70, 15);
		getContentPane().add(lblPais);
		
		JFormattedTextField formattedTextField_1 = new JFormattedTextField();
		formattedTextField_1.setBounds(108, 385, 138, 17);
		getContentPane().add(formattedTextField_1);
		
		JLabel lblEstadocondado = new JLabel("Estado/Condado");
		lblEstadocondado.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblEstadocondado.setBounds(282, 386, 126, 15);
		getContentPane().add(lblEstadocondado);
		
		JFormattedTextField formattedTextField_2 = new JFormattedTextField();
		formattedTextField_2.setBounds(426, 385, 138, 17);
		getContentPane().add(formattedTextField_2);
		
		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblComplemento.setBounds(52, 354, 114, 15);
		getContentPane().add(lblComplemento);
		
		JFormattedTextField formattedTextField_3 = new JFormattedTextField();
		formattedTextField_3.setBounds(171, 354, 323, 17);
		getContentPane().add(formattedTextField_3);
		
		JLabel lblNumero = new JLabel("Numero");
		lblNumero.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblNumero.setBounds(520, 354, 70, 15);
		getContentPane().add(lblNumero);
		
		JFormattedTextField formattedTextField_4 = new JFormattedTextField();
		formattedTextField_4.setBounds(590, 352, 50, 17);
		getContentPane().add(formattedTextField_4);
		
		JLabel lblPas = new JLabel("País");
		lblPas.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblPas.setBounds(52, 419, 70, 15);
		getContentPane().add(lblPas);
		
		JFormattedTextField formattedTextField_5 = new JFormattedTextField();
		formattedTextField_5.setBounds(108, 417, 138, 17);
		getContentPane().add(formattedTextField_5);
		
		JLabel lblCepZipeCode = new JLabel("CEP/ Zipe Code");
		lblCepZipeCode.setFont(new Font("Liberation Sans Narrow", Font.BOLD, 14));
		lblCepZipeCode.setBounds(282, 419, 126, 15);
		getContentPane().add(lblCepZipeCode);
		
		JFormattedTextField formattedTextField_6 = new JFormattedTextField();
		formattedTextField_6.setBounds(426, 418, 119, 17);
		getContentPane().add(formattedTextField_6);
	}
}
