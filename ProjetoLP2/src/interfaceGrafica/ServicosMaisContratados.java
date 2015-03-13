package interfaceGrafica;

import executar.Run;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Rectangle;

public class ServicosMaisContratados extends JPanel {
	JPanel panelChart;
	public ServicosMaisContratados() {
		setLayout(null);

		JLabel lblLogoHotel = CriaObjetosNaTela.criaLabel(null, new Rectangle(694, 11, 66, 70), CriaObjetosNaTela.getFontePadrao(20),new ImageIcon(TelaSobre.class.getResource("/Icons/60x53.png")), null);
		add(lblLogoHotel);

		JLabel lblNewLabel = new JLabel("Relat\u00F3rio sobre os Servicos do Hotel");
		lblNewLabel.setFont(CriaObjetosNaTela.getFontePadrao(26));
		lblNewLabel.setBounds(24, 38, 502, 38);
		add(lblNewLabel);

		JLabel lblOServicoMais = new JLabel("O servico mais contratado do hotel \u00E9 :");
		lblOServicoMais.setFont(CriaObjetosNaTela.getFontePadrao(17));
		lblOServicoMais.setBounds(446, 405, 307, 23);
		add(lblOServicoMais);

		JLabel lblNewLabel_1 = new JLabel(Run.hotel.servicoPopular());
		lblNewLabel_1.setFont(CriaObjetosNaTela.getFontePadrao(15));
		lblNewLabel_1.setBounds(474, 453, 294, 37);
		add(lblNewLabel_1);

		panelChart= new JPanel();
		panelChart.setBackground(Color.BLUE);
		panelChart.setBounds(24, 87, 354, 429);
		add(panelChart);
		panelChart.setLayout(new BorderLayout(0, 0));

		DefaultCategoryDataset graficoBarra = new DefaultCategoryDataset();
		for(String servico : Run.hotel.ServicosContratados().keySet()){
			graficoBarra.setValue(Run.hotel.ServicosContratados().get(servico), servico, servico);
		}

		JFreeChart grafico = ChartFactory.createBarChart("Contratação de Servicos", "Servicos", "Numero de contratações", graficoBarra, PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot grafic = grafico.getCategoryPlot();
		grafic.setRangeGridlinePaint(Color.GREEN);
		
		ChartPanel painelDoGrafico = new ChartPanel(grafico);
		panelChart.removeAll();
		panelChart.add(painelDoGrafico, BorderLayout.CENTER);
		painelDoGrafico.setLayout(null);
		panelChart.validate();
		
	}
}
