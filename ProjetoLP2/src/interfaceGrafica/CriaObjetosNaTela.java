package interfaceGrafica;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.sun.org.apache.regexp.internal.recompile;

public class CriaObjetosNaTela {

	public static JLabel criaLabel(String texto, Rectangle bordas, Font fonte, ImageIcon imagem, String mensagemOpcional){
		JLabel lblAtual = new JLabel(texto);
		lblAtual.setBounds(bordas);
		lblAtual.setIcon(imagem);
		lblAtual.setFont(fonte);
		lblAtual.setToolTipText(mensagemOpcional);
		return lblAtual;
	}
	
	public static JButton criaBotao(String texto, Rectangle bordas,Font fonte, ImageIcon imagem, String mensagemOpcional){
		JButton btnAtual = new JButton(texto);
		btnAtual.setBounds(bordas);
		btnAtual.setIcon(imagem);
		btnAtual.setToolTipText(mensagemOpcional);
		btnAtual.setFont(fonte);
		return btnAtual;
	}
	
	public static JTextField criaTextField(String texto, Rectangle bordas, Font fonte, boolean editavel, String mensagemOpcional){
		JTextField textAtual = new JTextField(texto);
		textAtual.setToolTipText(mensagemOpcional);
		textAtual.setBounds(bordas);
		textAtual.setEditable(editavel);
		textAtual.setColumns(10);
		return textAtual;
	}
	
	public static JCheckBox criaCheckBox(String texto, Rectangle bordas, Font fonte, String mensagemOpcional){
		JCheckBox boxAtual = new JCheckBox(texto);
		boxAtual.setBounds(bordas);
		boxAtual.setFont(fonte);
		boxAtual.setToolTipText(mensagemOpcional);
		return boxAtual;
	}
	
	public static JComboBox criaComboBox(Rectangle bordas, Font fonte){
		JComboBox comboBoxAtual = new JComboBox();
		comboBoxAtual.setBounds(bordas);
		comboBoxAtual.setFont(fonte);
		return comboBoxAtual;
	}
	
	public static Font getFontePadrao(int tamanho){
		return new Font("Tahoma", Font.PLAIN, tamanho);
	}
}
