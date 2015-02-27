package classes;

import excecoes.*;

/**
 * 
 * Classe que representa um Quarto de luxo triplo com capacidade para ate 3 pessoas
 * com cama extra se disponivel e necessario.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima atualizacao: 14/01/2015 / Fabio Alexandre
 */

public class QuartoLuxoSimples extends QuartoComCamaExtra {

	private static final long serialVersionUID = 1L;
	private final double VALOR_DIARIA = 520.0;
	
	/**
	 * Construtor de um quarto de luxo simples.
	 * 
	 * @param quantidadeDePessoas - Quantidade de pessoas a serem hospedadas.
	 * @param camaExtra
	 * @throws Exception
	 */
	
	public QuartoLuxoSimples( int quantidadeDePessoas, int camaExtra ) throws Exception {

		super(quantidadeDePessoas, camaExtra);
		verificaQuantidadeDePessoas(quantidadeDePessoas);		
		
		if ( Hotel.getQuartoLuxoSimples() - 1 < 0 ) {
			throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoLuxoSimples(Hotel.getQuartoLuxoSimples() - 1);
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
	 * Metodo que retorna uma string para representacao de um quarto de luxo simples.
	 * 
	 * @return A string de representacao do quarto de luxo simples.
	 */
	
	@Override
	public String toString() {
		return "Quarto Luxo Simples [ Valor diaria = R$ " + VALOR_DIARIA + ", " 
				+ super.toString() + ", Camas Extras = " + getCamaExtra() + " ]";
	}

	/**
	 * Metodo que compara se dois objetos do tipo quarto de luxo simples sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if ( !(obj instanceof QuartoLuxoSimples))
			return false;
		
		QuartoLuxoSimples qls = (QuartoLuxoSimples) obj;
		
		return super.equals(qls) && qls.getCamaExtra() == getCamaExtra();
	}
}