package classes;

/**
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima atualizacao: 10/01/2015 / Fabio Alexandre
 */

public abstract class Quarto extends Servicos {
	
	private int quantidadeDePessoas;
	
	/**
	 * construtor de um quarto.
	 * 
	 * @param quantidadeDePessoas - Quantidade De Pessoas a se hospedarem no quarto.
	 * @throws Exception
	 */
	
	public Quarto(int quantidadeDePessoas) throws Exception {
		this.quantidadeDePessoas = quantidadeDePessoas;
	}

	/**
	 * @return A quantidade de pessoas hospedadas no quarto.
	 */
	
	public int getQuantidadeDePessoas() {
		return quantidadeDePessoas;
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