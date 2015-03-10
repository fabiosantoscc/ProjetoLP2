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
import javax.swing.ImageIcon;

import executar.Run;

public class BuscarAdcBabySitter extends JPanel {
	private JTextField textCPF;

	/**
	 * Create the panel.
	 */
	public BuscarAdcBabySitter() {
		setLayout(null);
		
		JLabel lblBabySitter = new JLabel("BabySitter");
		lblBabySitter.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBabySitter.setBounds(38, 29, 175, 40);
		add(lblBabySitter);
		
		JLabel lblCPF = new JLabel("CPF do Hospede");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCPF.setBounds(151, 153, 142, 21);
		add(lblCPF);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCPF.setColumns(10);
		textCPF.setBounds(303, 153, 178, 21);
		add(textCPF);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(BuscarAdcBabySitter.class.getResource("/Icons/zoom.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				MenuPrincipal.painelBabySitter = new AdicionarBabySitter(Run.hotel.pesquisaHospede(textCPF.getText()));
				MenuPrincipal.panel0.add(MenuPrincipal.painelBabySitter, "painelBabySitter");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "painelBabySitter");
				textCPF.setText("");
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage());
				}
			}
		});
		btnBuscar.setBounds(260, 269, 107, 32);
		add(btnBuscar);

	}
}