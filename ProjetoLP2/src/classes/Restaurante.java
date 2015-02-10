package classes;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que representa um restaurante
 * 
 * @author Ronan Souza
 * Ultima atualizacao 14/01/2015 / Fabio Alexandre
 */

public class Restaurante implements Servicos, Serializable {

	private static final long serialVersionUID = 1L;
	private EstrategiaDeCalculoDaMontante estrategia;
	private double consumoDiario, consumoUnidade1, consumoUnidade2, consumoGeral;
	private int quantUsoUnidade1, quantUsoUnidade2;
	
	public  double getConsumoUnidade1(){
		return consumoUnidade1;
	}

	public double getConsumoUnidade2() {
		return consumoUnidade2;
	}
	
	public double getCondumoDiario(){
		return  consumoDiario;
	}
	
	/**
	 * Adiciona ao valor diario e ao determinado tipo de unidade um valor de consumo
	 * @param unidade Tipo da unidade onde foi feito o consumo
	 * @param valor Gasto nessa unidade
	 */
	
	public void AdicionaNovoConsumo(String unidade, double valor) throws Exception{
		if (valor <= 0){
			throw new Exception("Valor invalido!!");
		}
		if (!((unidade.equals("Terreo")) || unidade.equals("Cobertura"))){
			throw new Exception("Unidade do restaurante invalida!!");
		}
		
		consumoDiario += valor;
		
		if (unidade.equals("Terreo")){
			quantUsoUnidade1++; 
			consumoUnidade1 += valor;
		}
		else if (unidade.equals("Cobertura")){
			quantUsoUnidade2++;
			consumoUnidade2 += valor;
		}
	}
	
	/**
	 * Adiciona ao valor geral o consumo diario de acordo com a estrategia usada naquele dia
	 * @param dia Dia do consumo
	 * @param mes Mes do consumo
	 */
	
//	public void adicionaAoConsumoGeral() throws Exception {
//		private Calendar data; 
//		if (!(calendario.verificaDataValida(data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.get(Calendar.MONTH)) + 1)))
//			throw new Exception ("Data invalida.");
//		
//		estrategia = calendario.verificaEstrategia(data.get(Calendar.DAY_OF_MONTH, data.get(Calendar.get(Calendar.MONTH)) + 1);
//		consumoGeral += estrategia.calculaMontante(consumoDiario);
//	}
	
	@Override
	public double getPreco() {
		return consumoGeral;
	}
	
	@Override
	public String toString() {
		return "Restaurante:"
				+ "\nUnidade 1 (Terreo)"
				+ "     \n Quantidade de usos: "+quantUsoUnidade1
				+ "     \n Valor consumido: "+ consumoUnidade1
				+ "\nUnidade 2 (Cobertura)"
				+ "     \n Quantidade de usos: "+quantUsoUnidade2
				+ "     \n Valor consumido: "+ consumoUnidade2
				+ "\n\nValor total: "+ consumoGeral;
	} 
	
	@Override
	public boolean equals( Object obj ) {
		if (! (obj instanceof Restaurante)){
			return false;
		}
		Restaurante novo = (Restaurante) obj;
		
		if (novo.getConsumoUnidade1() == consumoUnidade1 &&
				novo.getConsumoUnidade2() == consumoUnidade2 && novo.getPreco() == consumoGeral){
			return true;
		}
		return false;
	}
}