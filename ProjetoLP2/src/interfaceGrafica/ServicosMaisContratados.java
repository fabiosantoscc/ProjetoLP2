package interfaceGrafica;

import javax.swing.JPanel;
import javax.swing.JLabel;

import executar.Run;

import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.junit.experimental.categories.Categories;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;

public class ServicosMaisContratados extends JPanel {
	public ServicosMaisContratados() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Relat\u00F3rio sobre os Servicos do Hotel");
		lblNewLabel.setFont(CriaObjetosNaTela.getFontePadrao(26));
		lblNewLabel.setBounds(24, 38, 502, 38);
		add(lblNewLabel);
		
		JLabel lblOServicoMais = new JLabel("O servico mais contratado do hotel \u00E9 :");
		lblOServicoMais.setFont(CriaObjetosNaTela.getFontePadrao(17));
		lblOServicoMais.setBounds(403, 405, 322, 23);
		add(lblOServicoMais);
		
		JLabel lblNewLabel_1 = new JLabel(Run.hotel.servicoPopular());
		lblNewLabel_1.setFont(CriaObjetosNaTela.getFontePadrao(15));
		lblNewLabel_1.setBounds(474, 453, 294, 37);
		add(lblNewLabel_1);
		
		
		

	}
}
