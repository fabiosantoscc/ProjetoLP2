package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import executar.Run;

public class FaturamentoMensal extends JPanel {

	JPanel panelChart;
	public FaturamentoMensal() {
		setLayout(null);
		
		panelChart= new JPanel();
		panelChart.setBackground(Color.BLUE);
		panelChart.setBounds(265, 99, 383, 341);
		add(panelChart);
		panelChart.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Faturamento Mensal");
		lblNewLabel.setBounds(39, 40, 259, 22);
		lblNewLabel.setFont(CriaObjetosNaTela.getFontePadrao(26));
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 145, 192, 295);
		add(scrollPane);
		
		JList list = new JList();
		ArrayList<String> values = new ArrayList<String>();
		Run.hotel.checaLucroMensal();
		for(String s: Run.hotel.getListaDeMeses()){
			
		}
		/*list.setModel(new AbstractListModel() {
			
			
			}
			String[] values = new String[] {"a", "a", "a"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});*/
		scrollPane.setViewportView(list);
		DefaultCategoryDataset graficoBarra = new DefaultCategoryDataset();
		for(String mes : Run.hotel.getLucroPorMes().keySet()){
			graficoBarra.setValue(Run.hotel.getLucroPorMes().get(mes), mes, mes);
		}
		
		JFreeChart grafico = ChartFactory.createBarChart("Faturamento Mensal", "Mês", "Faturamento", graficoBarra, PlotOrientation.VERTICAL, false, true, false);
		CategoryPlot grafic = grafico.getCategoryPlot();
		grafic.setRangeGridlinePaint(Color.GREEN);
		
		ChartPanel painelDoGrafico = new ChartPanel(grafico);
		panelChart.removeAll();
		panelChart.add(painelDoGrafico, BorderLayout.CENTER);
		painelDoGrafico.setLayout(null);
		panelChart.validate();
		JLabel lblListaDeValores = new JLabel("Lista de valores por m\u00EAs");
		lblListaDeValores.setBounds(52, 99, 181, 22);
		add(lblListaDeValores);

	}
}
