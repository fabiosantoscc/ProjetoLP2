package classes;

import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;

/**
 * 
 * Classe que representa um Quarto executivo triplo com capacidade para at� 3 pessoas
 * sem cama extra.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima atualizacao: 14/01/2015 / Fabio Alexandre
 */

public class QuartoExecutivoTriplo extends Quarto {

	private final double VALOR_DIARIA = 440.0;
	
	/**
	 * Construtor de um quarto executivo triplo.
	 * 
	 * @param quantidadeDePessoas - Quantidade de pessoas hospedadas no quarto, maximo de 3.
	 * @throws Exception
	 */
	
	public QuartoExecutivoTriplo( int quantidadeDePessoas ) throws Exception {
		
		super(quantidadeDePessoas);
		verificaQuantidadeDePessoas(quantidadeDePessoas);

		if ( Hotel.getQuartoExecutivoTriplo() == 0 ) {
			throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoExecutivoTriplo(Hotel.getQuartoExecutivoTriplo() - 1);
	}
	
	/**
	 * 
	 * @return
	 */
	
	@Override
	public double getPreco() {
		return VALOR_DIARIA;
	}
	
	public void setQuantidadeDePessoas(int pessoas) throws QuantidadeDePessoasInvalidaException {
		verificaQuantidadeDePessoas(pessoas);
		super.setQuantidadeDePessoas(pessoas);
	}
	
	private void verificaQuantidadeDePessoas(int quantidadeDePessoas) throws QuantidadeDePessoasInvalidaException {
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 3 ) {
			throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas do quarto invalida");
		}
	}
	
	/**
	 * Metodo que compara se dois objetos do tipo quarto executivo triplo sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public String toString() {
		return "Quarto Executivo Triplo [ Valor diaria = R$ " + VALOR_DIARIA + ", " 
				+ super.toString() + " ]";
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
		
		return super.equals(qet) && qet.getPreco() == VALOR_DIARIA;
	}
}
