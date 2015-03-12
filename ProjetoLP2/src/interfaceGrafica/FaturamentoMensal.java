package interfaceGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultListModel;
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

import java.awt.Font;

public class FaturamentoMensal extends JPanel {

	private JPanel panelChart;
	private Calendar dataAtual = Calendar.getInstance();
	private DefaultListModel<String> modeling = new DefaultListModel<String>();
	private ArrayList<String> minhasStrings = new ArrayList<String>();
	private JLabel lblFaturamentoMensal;
	private JScrollPane scrollPane;
	
	public FaturamentoMensal() {
		setLayout(null);
		
		panelChart= new JPanel();
		panelChart.setBackground(Color.BLUE);
		panelChart.setBounds(265, 99, 479, 427);
		add(panelChart);
		panelChart.setLayout(new BorderLayout(0, 0));
		
		lblFaturamentoMensal = CriaObjetosNaTela.criaLabel("Faturamento Mensal", new Rectangle(39, 40, 259, 22), CriaObjetosNaTela.getFontePadrao(26), null, null);
		add(lblFaturamentoMensal);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 145, 192, 381);
		add(scrollPane);
		
		Run.hotel.checaLucroMensal();
		for(String s: Run.hotel.getLucroPorMes().keySet()){
			minhasStrings.add("Mes: "+s+", Faturamento R$"+Run.hotel.getLucroPorMes().get(s));
		}
		
		for ( String s : minhasStrings) {
			modeling.addElement(s);
        }
		JList list = new JList(modeling);

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
		lblListaDeValores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblListaDeValores.setBounds(52, 99, 181, 22);
		add(lblListaDeValores);

	}
}
