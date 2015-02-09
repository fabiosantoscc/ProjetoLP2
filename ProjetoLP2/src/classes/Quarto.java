package classes;

import java.io.Serializable;
import java.util.Calendar;

import classes.Quarto;
import excecoes.QuantidadeDePessoasInvalidaException;

/**
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Atualizacao: 14/01/2015 / Fabio Alexandre
 * Ultima atualizacao 02/02/2015 Ravi Leite
 */

public abstract class Quarto implements Servicos, Serializable  {

	private static final long serialVersionUID = 1L;
	private int quantidadeDePessoas;
	private double despesaTotal;
	private int diaInicial, mesInicial, anoInicial;
	
	/**
	 * construtor de um quarto.
	 * 
	 * @param quantidadeDePessoas - Quantidade De Pessoas a se hospedarem no quarto.
	 * @throws Exception
	 */
	
	public Quarto(int quantidadeDePessoas) {
		Calendar c = Calendar.getInstance();
		diaInicial = c.get(Calendar.DAY_OF_MONTH);
		mesInicial = c.get(Calendar.MONTH) + 1;
		anoInicial = c.get(Calendar.YEAR);
		this.quantidadeDePessoas = quantidadeDePessoas;
	}
	
//	public void calculaDespesaTotal(int diaEntrada, int diaSaida, int mesEntrada, int mesSaida, double despesaDiaria){
//		for (int i = mesEntrada; i <= mesSaida; i++){
//			for (int j = diaEntrada; j <= diaSaida; j ++){
//				boolean dataValida = calendario.verificaDataValida(j, i);
//				if (! dataValida){
//					i = 1;
//					if (j == 12) {
//						j = 1;
//					}
//					else j++;
//					break;
//				}
//			estrategia = calendario.verificaEstrategia(j, i);
//			despesaTotal += estrategia.calculaMontante(despesaDiaria);
//			System.out.println(despesaTotal);
//			}
//		}
//		despesaTotal *= quantidadeDePessoas;
//	}
	
	public int getDiaInicial() {
		return diaInicial;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getMesInicial() {
		return mesInicial;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getAnoInicial() {
		return anoInicial;
	}
	
	/**
	 * 
	 * @return Quantidade total da despesa durante o contrato por um quarto especifico
	 */
	
	public double getDespesaTotal() {
		return despesaTotal;
	}

	/**
	 * @return A quantidade de pessoas hospedadas no quarto.
	 */
	
	public int getQuantidadeDePessoas() {
		return quantidadeDePessoas;
	}

	public void setQuantidadeDePessoas(int pessoas) throws QuantidadeDePessoasInvalidaException {
		this.quantidadeDePessoas = pessoas;
	}
	
	/**
	 * Metodo que retorna uma string para representacao de um quarto.
	 * 
	 * @return A string de representacao do quarto.
	 */
	
	@Override
	public String toString() {
		return "Quantidade De Pessoas = " + quantidadeDePessoas;
	}
	
	/**
	 * Metodo que compara se dois objetos do tipo quarto sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if (!(obj instanceof Quarto))
			return false;
		
		Quarto q = (Quarto) obj;
		
		return getQuantidadeDePessoas() == q.getQuantidadeDePessoas();

	}
}
