package interfaceGráfica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JComboBox;

import excecoes.HospedeInvalidoException;
import executar.Run;

import javax.swing.ImageIcon;

public class BuscarRemoverServicos extends JPanel {
	private JTextField textCPF;

	/**
	 * Create the panel.
	 */
	public BuscarRemoverServicos() {
		setLayout(null);
		
		JLabel lblBuscarSercicos = new JLabel("Buscar Serviços para remover");
		lblBuscarSercicos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBuscarSercicos.setBounds(38, 29, 326, 40);
		add(lblBuscarSercicos);
		
		JLabel lblCPF = new JLabel("CPF do Hospede");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCPF.setBounds(207, 145, 120, 21);
		add(lblCPF);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCPF.setColumns(10);
		textCPF.setBounds(381, 145, 114, 20);
		add(textCPF);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(BuscarRemoverServicos.class.getResource("/Icons/zoom.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MenuPrincipal.removerServicos = new RemoverServicos(Run.hotel.pesquisaHospede(textCPF.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.removerServicos, "27");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "27");
					textCPF.setText("");
				} catch (HospedeInvalidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}

			}
		});
		btnBuscar.setBounds(311, 198, 104, 27);
		add(btnBuscar);

	}
}