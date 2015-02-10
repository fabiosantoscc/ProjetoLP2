package classes;

/**
 * Classe que implementa a estrategia principal, retorna o total gasto em um dia multiplicado
 * pelo valor da estrategia em uma referente data durante o periodo das ferias de janeiro
 * 
 * @author Ravi Leite
 */

public class EstrategiaFeriasDeJaneiro implements EstrategiaDeCalculoDaMontante{
	
	/**
	 * Calcula o montante naquele dia e mes, multiplicando o total por um valor pre-determinado pelo hotel
	 */
	
	
	@Override
	public double calculaMontante(double total) {
		return total *= 1.20;
	}
}

