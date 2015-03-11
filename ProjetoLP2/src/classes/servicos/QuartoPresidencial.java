package classes.servicos;

import classes.Hotel;
import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;

  /**
  * 
  * Classe que representa um Quarto de luxo triplo com capacidade para ate 4 pessoas
  * sem cama extra.
  * 
  * @author Fabio Alexandre Santos Silva Junior
  * Ultima atualizacao: 04/02/2015 / Fabio Alexandre
  */

public class QuartoPresidencial extends Quarto {

  private static final long serialVersionUID = 8803978738161881465L;
  private final double VALOR_DIARIA = 1200.0;

	/**
	 * construtor de um quarto presidencial
	 * 
	 * @param quantidadeDePessoas - Quantidade De Pessoas a se hospedarem no quarto.
	 * @throws Exception
	 */
	
	public QuartoPresidencial( int quantidadeDePessoas ) throws QuantidadeDePessoasInvalidaException, QuartoEsgotadoNoHotelException {

		super(quantidadeDePessoas);
		
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 4 ) {
		  throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas do quarto invalida");
		}
		
		if ( Hotel.getQuartoPresidencial() == 0 ) {
			throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
		}
		int cont = Hotel.getMapaDeQuartos().get("Quarto Presidencial");
	    Hotel.getMapaDeQuartos().put("Quarto  Presidencial", cont++);
		Hotel.setQuartoPresidencial(Hotel.getQuartoPresidencial() - 1);
	}
	
	/**
	 * Metodo que retorna uma string para representacao de um quarto presidencial.
	 * 
	 * @return A string de representacao do quarto presidencial.
	 */
	
	
	@Override
	public String toString() {
		return "QuartoPresidencial - Valor da diaria = R$ " + VALOR_DIARIA + ", " + super.toString();
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
		
		return super.equals(qp);
	}
}
