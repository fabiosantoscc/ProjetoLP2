package classes;

/**
 * 
 * Classe que representa um Quarto de luxo triplo com capacidade para até 4 pessoas
 * sem cama extra.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima atualizacao: 10/01/2015 / Fabio Alexandre
 */

public class QuartoPresidencial extends Quarto {

	private final double VALOR_DIARIA = 1.200;
	
	/**
	 * construtor de um quarto presidencial
	 * 
	 * @param quantidadeDePessoas - Quantidade De Pessoas a se hospedarem no quarto.
	 * @throws Exception
	 */
	
	public QuartoPresidencial( int quantidadeDePessoas ) throws Exception {
		
		super(quantidadeDePessoas);
		
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 4 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}
		
		if ( Hotel.getQuartoPresidencial() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoPresidencial(Hotel.getQuartoPresidencial() - 1);
	}
	
	/**
	 * 
	 */
	
	@Override
	public double calculaTarifa() {
		return VALOR_DIARIA;
	}
	
	/**
	 * Metodo que retorna uma string para representacao de um quarto presidencial.
	 * 
	 * @return A string de representacao do quarto presidencial.
	 */
	
	@Override
	public String toString() {
		return "Quarto Presidencial [ Quantidade de quartos diponiveis = " + Hotel.getQuartoPresidencial() 
				+ ", Valor diaria = " + VALOR_DIARIA + ", " + super.toString() + " ]";
	}
	
	/**
	 * Metodo que compara se dois objetos do tipo quarto presidencial sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if ( !(obj instanceof QuartoPresidencial))
			return false;
		
		QuartoPresidencial qp = (QuartoPresidencial) obj;
		
		return super.equals(qp) && qp.calculaTarifa() == VALOR_DIARIA;
	}
}
