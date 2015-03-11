package interfaceGráfica;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

import classes.Arquivos;
import classes.dadosDoHospede.Hospede;
import classes.servicos.AluguelDeCarros;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;

import enums.ModelosDoCarro;
import executar.Run;

import java.awt.Font;
import java.awt.Rectangle;

public class AdicionarAlugueldeCarros extends JPanel {

	/**
	 * Create the panel.
	 */
	
	boolean isTanqueCheio = false;
	boolean isSeguro= false;
	public AdicionarAlugueldeCarros(Hospede hospedeAtual) {
		
		setLayout(null);
		
		JLabel lblAlugarVeiculo = CriaObjetosNaTela.criaLabel("Alugar Ve\u00EDculo", new Rectangle(38, 43, 227, 46), fontePadrao(23), null, null);
		add(lblAlugarVeiculo);
		
		JComboBox comboModelosDeCarro = CriaObjetosNaTela.criaComboBox(new Rectangle(80, 230, 161, 20), fontePadrao(14));
		comboModelosDeCarro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboModelosDeCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String c = (String) comboModelosDeCarro.getSelectedItem();
			}
		});
		comboModelosDeCarro.setModel(new DefaultComboBoxModel(new String[] {""+ModelosDoCarro.EXECUTIVO, ""+ModelosDoCarro.LUXO}));
		add(comboModelosDeCarro);
		
		JLabel lblModeloDoCarro = CriaObjetosNaTela.criaLabel("Modelo do Carro", new Rectangle(59, 196, 152, 20), fontePadrao(16), null, null);
		add(lblModeloDoCarro);
		
		JLabel lblHospede = CriaObjetosNaTela.criaLabel("Hospede: ", new Rectangle(59, 119, 93, 23), fontePadrao(16), null, null);
		add(lblHospede);
		
		JLabel lblnomeDohospede = CriaObjetosNaTela.criaLabel(hospedeAtual.getNome(), new Rectangle(130, 119, 440, 23), fontePadrao(17), null, null);
		add(lblnomeDohospede);
		
		JCheckBox boxTanqueCheio = CriaObjetosNaTela.criaCheckBox("Tanque Cheio", new Rectangle(80, 278, 131, 23), fontePadrao(15), null);
		boxTanqueCheio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isTanqueCheio = true;
			}
		});
		add(boxTanqueCheio);
		
		JCheckBox boxSeguro = CriaObjetosNaTela.criaCheckBox("Seguro", new Rectangle(80, 309, 131, 23), fontePadrao(23), null);
		boxTanqueCheio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isSeguro= true;
			}
		});
		add(boxSeguro);
		
		JButton btnAdicionarServico = CriaObjetosNaTela.criaBotao("Adicionar Servi\u00E7o", new Rectangle(409, 389, 180, 46), fontePadrao(17), null, null);
		btnAdicionarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AluguelDeCarros carroAtual = new AluguelDeCarros(ModelosDoCarro.valueOf(comboModelosDeCarro.getSelectedItem().toString()), isTanqueCheio, isSeguro);
					Run.hotel.adicionaServico(hospedeAtual, carroAtual);
					JOptionPane.showMessageDialog(null, "Veículo Alugado com Sucesso!");
					MenuPrincipal.cl.show(MenuPrincipal.panel0,"MenuPadrao");
					Arquivos.salvaHotel(Run.hotel);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		add(btnAdicionarServico);
	}
	
	private Font fontePadrao(int tamanho){
		return new Font("Tahoma", Font.PLAIN, tamanho);
	}
}
