package classes;

/**
 * 
 * Classe que representa um Quarto de luxo triplo com capacidade para até 3 pessoas
 * sem cama extra.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima atualizacao: 14/01/2015 / Fabio Alexandre
 */

public class QuartoLuxoTriplo extends Quarto {
	
	private final double VALOR_DIARIA = 620;
	
	/**
	 * construtor de um quarto de luxo triplo
	 * 
	 * @param quantidadeDePessoas - Quantidade de pessoas a serem hospedadas.
	 * @throws Exception
	 */
	
	public QuartoLuxoTriplo( int quantidadeDePessoas ) throws Exception {
		
		super(quantidadeDePessoas);
		
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 3 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}
		
		if ( Hotel.getQuartoLuxoTriplo() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoLuxoTriplo(Hotel.getQuartoLuxoTriplo() - 1);
	}
	
	/**
	 * 
	 */
	
	@Override
	public double getPreco() {
		return VALOR_DIARIA;
	}
	
	/**
	 * Metodo que retorna uma string para representacao de um quarto de luxo triplo.
	 * 
	 * @return A string de representacao do quarto de luxo triplo.
	 */
	
	@Override
	public String toString() {
		return "Quarto Luxo Triplo [ Quantidade de quartos diponiveis = " + Hotel.getQuartoLuxoTriplo() 
				+ ", Valor diaria = " + VALOR_DIARIA + ", " + super.toString() + " ]";
	}
	
	/**
	 * Metodo que compara se dois objetos do tipo quarto sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if ( !(obj instanceof QuartoLuxoTriplo))
			return false;
		
		QuartoLuxoTriplo qlt = (QuartoLuxoTriplo) obj;
		
		return super.equals(qlt) && qlt.getPreco() == VALOR_DIARIA;
	}
}
