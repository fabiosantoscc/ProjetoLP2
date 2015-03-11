package interfaceGráfica;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

public class CriaObjetosNaTela {

	public static JLabel criaLabel(String texto, Rectangle bordas, Font fonte, ImageIcon imagem){
		JLabel lblAtual = new JLabel(texto);
		lblAtual.setBounds(bordas);
		lblAtual.setIcon(imagem);
		lblAtual.setFont(fonte);
		return lblAtual;
	}
	
	public static JButton criaBotao(String texto, Rectangle bordas,Font fonte, ImageIcon imagem){
		JButton btnAtual = new JButton(texto);
		btnAtual.setBounds(bordas);
		btnAtual.setIcon(imagem);
		btnAtual.setFont(fonte);
		return btnAtual;
	}
	
	public static JFormattedTextField criaTextField(String texto, Rectangle bordas, Font fonte, boolean editavel, String mensagemOpcional){
		JFormattedTextField textAtual = new JFormattedTextField(texto);
		textAtual.setToolTipText(mensagemOpcional);
		textAtual.setBounds(bordas);
		textAtual.setEditable(editavel);
		return textAtual;
		
	}
}
