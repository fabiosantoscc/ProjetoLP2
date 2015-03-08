package InterfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import Executar.Run;
import classes.AluguelDeCarros;
import classes.ModelosDoCarro;
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
		
		JLabel lblAlugarVeiculo = new JLabel("Alugar Ve\u00EDculo");
		lblAlugarVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblAlugarVeiculo.setBounds(38, 43, 227, 46);
		add(lblAlugarVeiculo);
		
		JComboBox comboModelosDeCarro = new JComboBox();
		comboModelosDeCarro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboModelosDeCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboModelosDeCarro.getSelectedItem();
			}
		});
		comboModelosDeCarro.setModel(new DefaultComboBoxModel(new ModelosDoCarro[] {ModelosDoCarro.EXECUTIVO, ModelosDoCarro.LUXO}));
		comboModelosDeCarro.setBounds(80, 230, 161, 20);
		add(comboModelosDeCarro);
		
		JLabel lblModeloDoCarro = new JLabel("Modelo do Carro");
		lblModeloDoCarro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblModeloDoCarro.setBounds(59, 196, 152, 20);
		add(lblModeloDoCarro);
		
		JLabel lblHospede = new JLabel("Hospede: ");
		lblHospede.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHospede.setBounds(59, 119, 93, 23);
		add(lblHospede);
		
		JLabel lblnomeDohospede = new JLabel(hospedeAtual.getNome());
		lblnomeDohospede.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblnomeDohospede.setBounds(130, 119, 440, 23);
		add(lblnomeDohospede);
		
		JCheckBox boxTanqueCheio = new JCheckBox("Tanque Cheio");
		boxTanqueCheio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boxTanqueCheio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isTanqueCheio = true;
			}
		});
		boxTanqueCheio.setBounds(80, 278, 131, 23);
		add(boxTanqueCheio);
		
		JCheckBox boxSeguro = new JCheckBox("Seguro");
		boxSeguro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		boxSeguro.setBounds(80, 309, 131, 23);
		boxTanqueCheio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isSeguro= true;
			}
		});
		add(boxSeguro);
		
		JButton btnAdicionarServico = new JButton("Adicionar Servi\u00E7o");
		btnAdicionarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AluguelDeCarros carroAtual = new AluguelDeCarros((ModelosDoCarro) comboModelosDeCarro.getSelectedItem(), isTanqueCheio, isSeguro);
					Run.hotel.adicionaServico(hospedeAtual, carroAtual);
					JOptionPane.showMessageDialog(null, "Veículo Alugado com Sucesso!");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "0");
					Arquivos.salvaHotel(Run.hotel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnAdicionarServico.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnAdicionarServico.setBounds(409, 389, 180, 46);
		add(btnAdicionarServico);
	}
}
