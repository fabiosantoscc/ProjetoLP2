package interfaceGrafica;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import classes.Arquivos;
import classes.dadosDoHospede.Hospede;
import classes.servicos.Restaurante;
import classes.servicos.Servico;
import enums.UnidadesDoRestaurante;
import excecoes.ContratoAbertoException;
import executar.Run;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import java.awt.Font;
import java.awt.Rectangle;

public class AdicionarRestaurante extends JPanel {
	
	private JTextField textConsumo;
	private JLabel lblAdicionarConsumo, lblLogoHotel, lblUnidade, lblConsumo;
	private JComboBox<String> comboUnidadeRestaurante;
	private JButton btnAdicionarConsumo;

	public AdicionarRestaurante(Hospede hospedeAtual) {
		setLayout(null);
		
		lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		lblAdicionarConsumo = CriaObjetosNaTela.criaLabel("Adicionar Consumo", new Rectangle(40, 28, 284, 53), CriaObjetosNaTela.getFontePadrao(24), null, null);
		add(lblAdicionarConsumo);
		
		lblUnidade = CriaObjetosNaTela.criaLabel("Unidade", new Rectangle(37, 113, 124, 20), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblUnidade);
		
		comboUnidadeRestaurante = CriaObjetosNaTela.criaComboBox(new Rectangle(140, 113, 124, 20), CriaObjetosNaTela.getFontePadrao(14));
		comboUnidadeRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboUnidadeRestaurante.getSelectedItem();
			}
		});
		comboUnidadeRestaurante.setModel(new DefaultComboBoxModel(new String[]{""+UnidadesDoRestaurante.TERREO, ""+UnidadesDoRestaurante.COBERTURA}));
		add(comboUnidadeRestaurante);
		
		lblConsumo = CriaObjetosNaTela.criaLabel("Consumo", new Rectangle(40, 162, 96, 20), CriaObjetosNaTela.getFontePadrao(15), null, null);
		add(lblConsumo);
		
		textConsumo = CriaObjetosNaTela.criaTextField(null, new Rectangle(140, 162, 96, 20), CriaObjetosNaTela.getFontePadrao(14), true, null);
		add(textConsumo);
		
		btnAdicionarConsumo = CriaObjetosNaTela.criaBotao("Adicionar Consumo", new Rectangle(409, 403, 195, 44), CriaObjetosNaTela.getFontePadrao(14), null, null);
		btnAdicionarConsumo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try {
					Run.hotel.adicionaServico(hospedeAtual, new Restaurante(UnidadesDoRestaurante.valueOf(comboUnidadeRestaurante.getSelectedItem().toString()), Double.parseDouble(textConsumo.getText())));
					JOptionPane.showMessageDialog(null, "Consumo adicionado com sucesso");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "MenuPadrao");
					Arquivos.salvaHotel(Run.hotel);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (ContratoAbertoException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				} 
							
			}
		});
		add(btnAdicionarConsumo);
	}
}
