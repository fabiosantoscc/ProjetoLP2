package interfaceGrafica;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import classes.Arquivos;
import classes.dadosDoHospede.Hospede;
import classes.servicos.BabySitter;
import executar.Run;

public class AdicionarBabySitter extends JPanel {
	private JTextField tFHorarioInicial;
	private JTextField tFDuracao;
	private JLabel lblBabySitter, lblHorarioInicial, lblDuracaoEmHoras;
	private JButton btnAdicionarServico;
	private JSpinner spinnerDuracao, spinnerHoraInicial;
	public AdicionarBabySitter(Hospede hospedeAtual) {
		setLayout(null);
		
		JLabel lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);
		
		lblBabySitter = CriaObjetosNaTela.criaLabel("Baby Sitter", new Rectangle(29, 24, 247, 51), CriaObjetosNaTela.getFontePadrao(24), null, null);
		add(lblBabySitter);
		
		lblHorarioInicial = CriaObjetosNaTela.criaLabel("Hor\u00E1rio Inicial", new Rectangle(29, 164, 126, 23), CriaObjetosNaTela.getFontePadrao(16), null, null);
		add(lblHorarioInicial);
		
		lblDuracaoEmHoras = CriaObjetosNaTela.criaLabel("Dura\u00E7\u00E3o (em horas)", new Rectangle(29, 197, 141, 22), CriaObjetosNaTela.getFontePadrao(16), null, null);
		add(lblDuracaoEmHoras);
		
		spinnerHoraInicial = CriaObjetosNaTela.criaSpinner(new Rectangle(192, 165, 42, 20), CriaObjetosNaTela.getFontePadrao(14));
		((DefaultEditor) spinnerHoraInicial.getEditor()).getTextField().setEditable(false);
		spinnerHoraInicial.setBounds(192, 165, 42, 20);
		add(spinnerHoraInicial);
		
		spinnerDuracao = new JSpinner();
		spinnerDuracao.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spinnerDuracao.setBounds(192, 198, 42, 20);
		add(spinnerDuracao);
		
		btnAdicionarServico = CriaObjetosNaTela.criaBotao("Adicionar Servi\u00E7o", new Rectangle(306, 323, 174, 40), CriaObjetosNaTela.getFontePadrao(17), null, null);
		btnAdicionarServico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BabySitter babyAtual = new BabySitter(Integer.parseInt(spinnerHoraInicial.getValue().toString()), Integer.parseInt(spinnerDuracao.getValue().toString()));
					Run.hotel.adicionaServico(hospedeAtual, babyAtual);
					Arquivos.salvaHotel(Run.hotel);
					JOptionPane.showMessageDialog(null, "Baby Sitter adicionado com sucesso!");
					MenuPrincipal.cl.show(MenuPrincipal.panel0, "MenuPadrao");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		add(btnAdicionarServico);
	}
}
