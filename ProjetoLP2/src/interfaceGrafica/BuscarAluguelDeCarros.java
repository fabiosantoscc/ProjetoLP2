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
import javax.swing.ImageIcon;

import executar.Run;

public class BuscarAluguelDeCarros extends JPanel {
	
	private JButton btnBuscar;
	private JTextField textCPF;
	private JLabel lblLogoHotel,lblBabySitter, lblCPF;
	
	public BuscarAluguelDeCarros() {
		setLayout(null);
		
		lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		lblBabySitter = CriaObjetosNaTela.criaLabel("Adicionar Aluguel de Veiculos", new Rectangle(38, 29, 329, 40), CriaObjetosNaTela.getFontePadrao(24), null, null);
		add(lblBabySitter);
		
		lblCPF = CriaObjetosNaTela.criaLabel("CPF do Hospede", new Rectangle(216, 132, 116, 21), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblCPF);
		
		textCPF = CriaObjetosNaTela.criaTextField(null, new Rectangle(381, 132, 148, 20), CriaObjetosNaTela.getFontePadrao(15), true, null);
		add(textCPF);
		
		btnBuscar = CriaObjetosNaTela.criaBotao("Buscar", new Rectangle(335, 191, 105, 27), CriaObjetosNaTela.getFontePadrao(15),new ImageIcon(BuscarAdcBabySitter.class.getResource("/Icons/zoom.png")) , null);
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				MenuPrincipal.adcAluguelDeCarros = new AdicionarAlugueldeCarros(Run.hotel.pesquisaHospede(textCPF.getText()));
				MenuPrincipal.panel0.add(MenuPrincipal.adcAluguelDeCarros, "painelAdcAluguelDeCarros");
				MenuPrincipal.cl.show(MenuPrincipal.panel0, "painelAdcAluguelDeCarros");
				textCPF.setText("");
				}catch(Exception c){
					JOptionPane.showMessageDialog(null, c.getMessage());
				}
			}
		});
		add(btnBuscar);

	}
}