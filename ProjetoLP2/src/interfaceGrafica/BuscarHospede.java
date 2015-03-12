package interfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Rectangle;

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

public class BuscarHospede extends JPanel {
	private JTextField cpfAPesquisar;

	/**
	 * Create the panel.
	 */
	public BuscarHospede() {
		setLayout(null);
		
		JLabel lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		JLabel lblBuscarHospede = new JLabel("Pesquisar Hospede");
		lblBuscarHospede.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBuscarHospede.setBounds(38, 29, 266, 40);
		add(lblBuscarHospede);
		
		JLabel textCPF = new JLabel("CPF do Hospede");
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCPF.setBounds(192, 160, 112, 21);
		add(textCPF);
		
		cpfAPesquisar = new JTextField();
		cpfAPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cpfAPesquisar.setColumns(10);
		cpfAPesquisar.setBounds(354, 160, 147, 20);
		add(cpfAPesquisar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(BuscarHospede.class.getResource("/Icons/zoom.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.setBounds(297, 221, 99, 31);
		add(btnBuscar);
		btnBuscar.setToolTipText("Digite um nome ou um cpf para buscar o hospede.");
		btnBuscar.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MenuPrincipal.telaHospede = new PainelHospede(Run.hotel.pesquisaHospede(cpfAPesquisar.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.telaHospede, "8");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "8");
					cpfAPesquisar.setText("");
				} catch (HospedeInvalidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});		
	}
}