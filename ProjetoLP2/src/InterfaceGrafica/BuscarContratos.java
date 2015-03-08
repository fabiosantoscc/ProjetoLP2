package InterfaceGrafica;

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

import Executar.Run;
import excecoes.HospedeInvalidoException;
import javax.swing.ImageIcon;

public class BuscarContratos extends JPanel {
	private JTextField textCPF;

	/**
	 * Create the panel.
	 */
	public BuscarContratos() {
		setLayout(null);
		
		JLabel lblPesquisarContratos = new JLabel("Pesquisar Contratos");
		lblPesquisarContratos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPesquisarContratos.setBounds(38, 29, 277, 40);
		add(lblPesquisarContratos);
		
		JLabel lblCPF = new JLabel("CPF do Hospede");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCPF.setBounds(209, 154, 120, 21);
		add(lblCPF);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCPF.setColumns(10);
		textCPF.setBounds(354, 154, 114, 20);
		add(textCPF);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(BuscarContratos.class.getResource("/Icons/zoom.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MenuPrincipal.contratosDoHospede = new ContratosDoHospede(Run.hotel.pesquisaHospede(textCPF.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.contratosDoHospede, "19");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "19");
					textCPF.setText("");
				} catch (HospedeInvalidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
				
				
			}
		});
		btnBuscar.setBounds(296, 211, 114, 29);
		add(btnBuscar);

	}
}