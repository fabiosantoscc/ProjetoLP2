package interfaceGrafica;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import excecoes.HospedeInvalidoException;
import executar.Run;

import javax.swing.ImageIcon;

public class BuscarHospede extends JPanel {
	
	private JButton btnBuscar;
	private JTextField textCPF;
	private JLabel lblLogoHotel,lblBabySitter, lblCPF;
	
	public BuscarHospede() {
		setLayout(null);
		
		lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		lblBabySitter = CriaObjetosNaTela.criaLabel("Hospede", new Rectangle(38, 29, 329, 40), CriaObjetosNaTela.getFontePadrao(24), null, null);
		add(lblBabySitter);
		
		lblCPF = CriaObjetosNaTela.criaLabel("CPF do Hospede", new Rectangle(216, 132, 116, 21), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblCPF);
		
		textCPF = CriaObjetosNaTela.criaTextField(null, new Rectangle(381, 132, 148, 20), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textCPF);
		
		btnBuscar = CriaObjetosNaTela.criaBotao("Buscar", new Rectangle(335, 191, 105, 27), CriaObjetosNaTela.getFontePadrao(15),new ImageIcon(BuscarAdcBabySitter.class.getResource("/Icons/zoom.png")) , "Digite um CPF para buscar o hospede.");
		btnBuscar.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent arg0) {
				try {
					MenuPrincipal.telaHospede = new PainelHospede(Run.hotel.pesquisaHospede(textCPF.getText()));
					MenuPrincipal.panel0.add(MenuPrincipal.telaHospede, "8");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "8");
					textCPF.setText("");
				} catch (HospedeInvalidoException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		add(btnBuscar);
	}
}