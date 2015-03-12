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

public class BuscarQuartoAtualizar extends JPanel {
	private JTextField textCPF;

	/**
	 * Create the panel.
	 */
	public BuscarQuartoAtualizar() {
		setLayout(null);
		
		JLabel lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		JLabel lblAtualizarQuartos = new JLabel("Atualizar Quartos do Hospede");
		lblAtualizarQuartos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAtualizarQuartos.setBounds(38, 29, 329, 40);
		add(lblAtualizarQuartos);
		
		JLabel lblCPF = new JLabel("CPF do Hospede");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCPF.setBounds(216, 132, 116, 21);
		add(lblCPF);
		
		textCPF = new JTextField();
		textCPF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCPF.setColumns(10);
		textCPF.setBounds(381, 132, 148, 20);
		add(textCPF);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon(BuscarQuartoAtualizar.class.getResource("/Icons/zoom.png")));
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					MenuPrincipal.listaQuartosAtualizar = new ListaQuartos(Run.hotel.pesquisaHospede(textCPF.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.listaQuartosAtualizar, "22");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "22");
					textCPF.setText("");
				} catch (HospedeInvalidoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnBuscar.setBounds(335, 191, 105, 27);
		add(btnBuscar);

	}
}