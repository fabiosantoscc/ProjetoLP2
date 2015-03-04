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
import javax.swing.ImageIcon;

public class BuscarAdcBabySitter extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	public BuscarAdcBabySitter() {
		setLayout(null);
		
		JLabel lblNovoContrato = new JLabel("BabySitter");
		lblNovoContrato.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNovoContrato.setBounds(38, 29, 175, 40);
		add(lblNovoContrato);
		
		JLabel label = new JLabel("CPF do Hospede");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(151, 153, 142, 21);
		add(label);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(303, 153, 178, 21);
		add(cpfAPesquisar);
		
		JButton button = new JButton("Buscar");
		button.setIcon(new ImageIcon(BuscarAdcBabySitter.class.getResource("/Icons/zoom.png")));
		button.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				MenuPrincipal.painelBabySitter = new AdicionarBabySitter(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
				MenuPrincipal.panel0.add(MenuPrincipal.painelBabySitter, "17");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "17");
				cpfAPesquisar.setText("");
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage());
				}
			}
		});
		button.setBounds(260, 269, 107, 32);
		add(button);

	}
}