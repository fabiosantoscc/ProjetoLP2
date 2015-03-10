package interfaceGráfica;

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

public class AdicionarRestaurante extends JPanel {
	private JTextField textConsumo;

	/**
	 * Create the panel.
	 */
	public AdicionarRestaurante(Hospede hospedeAtual) {
		setLayout(null);
		
		JLabel lblAdicionarConsumo = new JLabel("Adicionar Consumo");
		lblAdicionarConsumo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblAdicionarConsumo.setBounds(40, 28, 284, 53);
		add(lblAdicionarConsumo);
		
		JLabel lblUnidade = new JLabel("Unidade");
		lblUnidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUnidade.setBounds(37, 113, 124, 20);
		add(lblUnidade);
		
		JComboBox comboUnidadeRestaurante = new JComboBox();
		comboUnidadeRestaurante.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboUnidadeRestaurante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboUnidadeRestaurante.getSelectedItem();
			}
		});
		comboUnidadeRestaurante.setModel(new DefaultComboBoxModel(new String[]{""+UnidadesDoRestaurante.TERREO, ""+UnidadesDoRestaurante.COBERTURA}));
		comboUnidadeRestaurante.setBounds(140, 113, 124, 20);
		add(comboUnidadeRestaurante);
		
		JLabel lblConsumo = new JLabel("Consumo");
		lblConsumo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConsumo.setBounds(40, 162, 96, 20);
		add(lblConsumo);
		
		textConsumo = new JTextField();
		textConsumo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textConsumo.setBounds(140, 162, 124, 20);
		add(textConsumo);
		textConsumo.setColumns(10);
		
		
		JButton btnAdicionarConsumo = new JButton("Adicionar Consumo");
		btnAdicionarConsumo.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		btnAdicionarConsumo.setBounds(409, 403, 195, 44);
		add(btnAdicionarConsumo);
	}
}
