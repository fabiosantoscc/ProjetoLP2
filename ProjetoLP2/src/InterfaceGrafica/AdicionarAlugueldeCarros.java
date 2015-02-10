package InterfaceGrafica;

import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import Executar.Run;
import classes.AluguelDeCarros;
import classes.BabySitter;
import classes.Hospede;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.Font;

public class AdicionarAlugueldeCarros extends JPanel {

	/**
	 * Create the panel.
	 */
	boolean isTanqueCheio = false;
	boolean isSeguro= false;
	public AdicionarAlugueldeCarros(Hospede hospedeAtual) {
		setLayout(null);
		
		
		JLabel lblAlugarVeculo = new JLabel("Alugar Ve\u00EDculo");
		lblAlugarVeculo.setBounds(38, 43, 67, 14);
		add(lblAlugarVeculo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboBox.getSelectedItem();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Executivo", "Luxo"}));
		comboBox.setBounds(80, 230, 161, 20);
		add(comboBox);
		
		JLabel lblModeloDoCarro = new JLabel("Modelo do Carro");
		lblModeloDoCarro.setBounds(59, 196, 93, 14);
		add(lblModeloDoCarro);
		
		JLabel lblHospede = new JLabel("Hospede: ");
		lblHospede.setBounds(59, 119, 61, 14);
		add(lblHospede);
		
		JLabel lblNewLabel = new JLabel(hospedeAtual.getNome());
		lblNewLabel.setBounds(130, 119, 267, 14);
		add(lblNewLabel);
		
		JCheckBox chckbxTanqueCheio = new JCheckBox("Tanque Cheio");
		chckbxTanqueCheio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isTanqueCheio = true;
			}
		});
		chckbxTanqueCheio.setBounds(80, 278, 97, 23);
		add(chckbxTanqueCheio);
		
		JCheckBox chckbxSeguro = new JCheckBox("Seguro");
		chckbxSeguro.setBounds(80, 309, 97, 23);
		chckbxTanqueCheio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isSeguro= true;
			}
		});
		add(chckbxSeguro);
		
		JButton btnAdicionarServio = new JButton("Adicionar Servi\u00E7o");
		btnAdicionarServio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AluguelDeCarros carroAtual = new AluguelDeCarros((String) comboBox.getSelectedItem(), isTanqueCheio, isSeguro);
					Run.hotel.adicionaServico(hospedeAtual, carroAtual);
					JOptionPane.showMessageDialog(null, "Veículo Alugado com Sucesso!");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "0");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnAdicionarServio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionarServio.setBounds(437, 389, 152, 46);
		add(btnAdicionarServio);


	}
}
