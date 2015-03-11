package interfaceGrafica;

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

public class BuscarServicos extends JPanel {
	private JTextField textCPF;

	/**
	 * Create the panel.
	 */
	public BuscarServicos() {
		setLayout(null);
		
		JLabel lblBuscarServicos = new JLabel("Buscar Serviços do Hospede");
		lblBuscarServicos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBuscarServicos.setBounds(38, 29, 314, 40);
		add(lblBuscarServicos);
		
		JLabel lblCPF = new JLabel("CPF do Hospede");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCPF.setBounds(207, 157, 114, 21);
		add(lblCPF);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCPF.setColumns(10);
		textCPF.setBounds(346, 157, 141, 20);
		add(textCPF);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(BuscarServicos.class.getResource("/Icons/zoom.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MenuPrincipal.servicosDoHospede = new ServicosDoHospede(Run.hotel.pesquisaHospede(textCPF.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.servicosDoHospede, "22");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "22");
					textCPF.setText("");
				} catch (HospedeInvalidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e2) {
				}

			}
		});
		btnBuscar.setBounds(308, 203, 102, 29);
		add(btnBuscar);

	}
}