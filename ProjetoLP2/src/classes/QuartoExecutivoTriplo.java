package classes;

/**
 * 
 * Classe que representa um Quarto executivo triplo com capacidade para até 3 pessoas
 * sem cama extra.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima atualizacao: 11/01/2015 / Fabio Alexandre
 */

public class QuartoExecutivoTriplo extends Quarto {

	private final double VALOR_DIARIA = 440;
	
	/**
	 * Construtor de um quarto executivo triplo.
	 * 
	 * @param quantidadeDePessoas - Quantidade de pessoas hospedadas no quarto, maximo de 3.
	 * @throws Exception
	 */
	
	public QuartoExecutivoTriplo( int quantidadeDePessoas ) throws Exception {
		
		super(quantidadeDePessoas);
		
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 3 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}

		if ( Hotel.getQuartoExecutivoTriplo() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoExecutivoTriplo(Hotel.getQuartoExecutivoTriplo() - 1);
	}
	
	/**
	 * 
	 * @return
	 */
	
	@Override
	public double calculaTarifa() {
		return VALOR_DIARIA;
	}
	
	/**
	 * Metodo que compara se dois objetos do tipo quarto executivo triplo sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public String toString() {
		return "Quarto Executivo Triplo [ Quantidade de quartos diponiveis = " + Hotel.getQuartoExecutivoTriplo() 
				+ ", Valor diaria = " + VALOR_DIARIA + ", " + super.toString() + " ]";
	}
	
	/**
	 * Metodo que compara se dois objetos do tipo quarto executivo triplo sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if ( !(obj instanceof QuartoExecutivoTriplo))
			return false;
		
		QuartoExecutivoTriplo qet = (QuartoExecutivoTriplo) obj;
		
		return super.equals(qet) && qet.calculaTarifa() == VALOR_DIARIA;
	}
}
