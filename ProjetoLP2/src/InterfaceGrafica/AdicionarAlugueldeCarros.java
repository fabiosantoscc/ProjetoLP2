package InterfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import Executar.Run;
import classes.AluguelDeCarros;
import classes.Arquivos;
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
		lblAlugarVeculo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAlugarVeculo.setBounds(38, 43, 227, 46);
		add(lblAlugarVeculo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboBox.getSelectedItem();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Executivo", "Luxo"}));
		comboBox.setBounds(80, 230, 161, 20);
		add(comboBox);
		
		JLabel lblModeloDoCarro = new JLabel("Modelo do Carro");
		lblModeloDoCarro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModeloDoCarro.setBounds(59, 196, 152, 20);
		add(lblModeloDoCarro);
		
		JLabel lblHospede = new JLabel("Hospede: ");
		lblHospede.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHospede.setBounds(59, 119, 93, 23);
		add(lblHospede);
		
		JLabel lblNewLabel = new JLabel(hospedeAtual.getNome());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(130, 119, 440, 23);
		add(lblNewLabel);
		
		JCheckBox chckbxTanqueCheio = new JCheckBox("Tanque Cheio");
		chckbxTanqueCheio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxTanqueCheio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isTanqueCheio = true;
			}
		});
		chckbxTanqueCheio.setBounds(80, 278, 131, 23);
		add(chckbxTanqueCheio);
		
		JCheckBox chckbxSeguro = new JCheckBox("Seguro");
		chckbxSeguro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxSeguro.setBounds(80, 309, 131, 23);
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
					Arquivos.salvaHotel(Run.hotel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnAdicionarServio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAdicionarServio.setBounds(409, 389, 180, 46);
		add(btnAdicionarServio);
	}
}
