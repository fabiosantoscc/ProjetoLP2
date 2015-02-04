package classes;

import excecoes.*;

/**
 * 
 * Classe que representa um Quarto de luxo triplo com capacidade para ate 4 pessoas
 * sem cama extra.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima atualizacao: 04/02/2015 / Fabio Alexandre
 */

public class QuartoPresidencial extends Quarto {

	private final double VALOR_DIARIA = 1200.0;
	
	/**
	 * construtor de um quarto presidencial
	 * 
	 * @param quantidadeDePessoas - Quantidade De Pessoas a se hospedarem no quarto.
	 * @throws Exception
	 */
	
	public QuartoPresidencial( int quantidadeDePessoas ) throws QuantidadeDePessoasInvalidaException, QuartoEsgotadoException {
		
		super(quantidadeDePessoas);
		verificaQuantidadeDePessoas(quantidadeDePessoas);
		
		if ( Hotel.getQuartoPresidencial() == 0 ) {
			throw new QuartoEsgotadoException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoPresidencial(Hotel.getQuartoPresidencial() - 1);
	}
	
	/**
	 * Recupera o preco da diaria de um quarto presidencial.
	 * 
	 * @return
	 */
	
	@Override
	public double getPreco() {
		return VALOR_DIARIA;
	}
	
	/**
	 * Altera a quantidade de pessoas do quarto presidencial.
	 * 
	 * @param pessoas - Quantidade de pessoas atual do quarto presidencial, deve ser entre 1 e 4.
	 * @throws QuantidadeDePessoasInvalidaException 
	 */
	
	public void setQuantidadeDePessoas(int pessoas) throws QuantidadeDePessoasInvalidaException {
		verificaQuantidadeDePessoas(pessoas);
		super.setQuantidadeDePessoas(pessoas);
	}
	
	private void verificaQuantidadeDePessoas(int quantidadeDePessoas) throws QuantidadeDePessoasInvalidaException {
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 4 ) {
			throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas do quarto invalida");
		}
	}
	
	/**
	 * Metodo que retorna uma string para representacao de um quarto presidencial.
	 * 
	 * @return A string de representacao do quarto presidencial.
	 */
	
	
	@Override
	public String toString() {
		return "Quarto Presidencial [ Valor diaria = R$ " + VALOR_DIARIA + ", " + super.toString() + " ]";
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
		
		return super.equals(qp) && qp.getPreco() == VALOR_DIARIA;
	}
}
