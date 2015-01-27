package classes;

import excecoes.QuartoEsgotadoException;

/**
 * 
 * Classe que representa um Quarto de luxo duplo com capacidade para at� 3 pessoas
 * com cama extra.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima atualizacao: 14/01/2015 / Fabio Alexandre
 */

public class QuartoLuxoDuplo extends Quarto {

	private final double VALOR_DIARIA = 570.0;
	private int camaExtra;
	
	/**
	 * Construtor de um quarto de luxo duplo.
	 * 
	 * @param quantidadeDePessoas - Quantidade de pessoas hospedadas no quarto, maximo de 3.
	 * @param camaExtra - Quantidade de camas extras do quarto.
	 * @throws Exception
	 */
	
	public QuartoLuxoDuplo( int quantidadeDePessoas, int camaExtra ) throws Exception {
		
		super(quantidadeDePessoas);
		
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 3 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}
		
		if ( camaExtra < 0 || camaExtra > Hotel.getCamaExtra()) {
			throw new IllegalArgumentException("Quantidade de camas extras invalida");
		}
		
		if ( Hotel.getQuartoLuxoDuplo() - 1 < 0 ) {
			throw new QuartoEsgotadoException("Nao ha mais quartos livres");
		}
		
		this.camaExtra = camaExtra;
		Hotel.setCamaExtra(Hotel.getCamaExtra() - this.camaExtra);
		Hotel.setQuartoLuxoDuplo(Hotel.getQuartoLuxoDuplo() - 1);
	}
	
	/**
	 * @return - A quantidade de camas extras do quarto.
	 */
	
	public int getCamaExtra() {
		return camaExtra;
	}
	
	/**
	 * 
	 * @param cama
	 */
	
	public void setCamaExtra( int cama) {
		if ( cama < 0 || cama > Hotel.getCamaExtra()) {
			throw new IllegalArgumentException("Quantidade de camas extras invalida");
		}
		
		Hotel.setCamaExtra(Hotel.getCamaExtra() + camaExtra);
		Hotel.setCamaExtra(Hotel.getCamaExtra() - cama);
		this.camaExtra = cama;
	}
	
	/**
	 * 
	 */
	
	@Override
	public double getPreco() {
		return VALOR_DIARIA;
	}
	
	public void setQuantidadeDePessoas(int pessoas) {
		if ( pessoas <= 0 || pessoas > 3 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}
		
		super.setQuantidadeDePessoas(pessoas);
	}
	
	/**
	 * Metodo que retorna uma string para representacao de um quarto de luxo duplo.
	 * 
	 * @return A string de representacao do quarto de luxo duplo.
	 */
	
	@Override
	public String toString() {
		return "Quarto Luxo Duplo [ Valor diaria = R$ " + VALOR_DIARIA + ", " 
				+ super.toString() + ", Camas Extras = " + getCamaExtra() + " ]";
	}
	
	/**
	 * Metodo que compara se dois objetos do tipo quarto de luxo simples sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if ( !(obj instanceof QuartoLuxoDuplo))
			return false;
		
		QuartoLuxoDuplo qld = (QuartoLuxoDuplo) obj;
		
		return super.equals(qld) && qld.getPreco() == VALOR_DIARIA &&
				qld.getCamaExtra() == getCamaExtra();
	}
}
