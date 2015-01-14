package classes;

/**
 * Classe que representa um Quarto executivo simples com capacidade para até 3 pessoas
 * com cama extra.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima atualizacao: 11/01/2015 / Fabio Alexandre
 */

public class QuartoExecutivoSimples extends Quarto {
	
	private final double VALOR_DIARIA = 360;
	private int camaExtra;
	
	/**
	 * Construtor de um quarto executivo simples.
	 * 
	 * @param quantidadeDePessoas - Quantidade de pessoas hospedadas no quarto, maximo de 3.
	 * @param camaExtra - Quantidade de camas extras no quarto, depende da disponibilidade.
	 * @throws Exception
	 */
	
	public QuartoExecutivoSimples( int quantidadeDePessoas, int camaExtra ) throws Exception {
		
		super(quantidadeDePessoas);
		
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 3 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}
		
		if ( camaExtra < 0 || camaExtra > Hotel.getCamaExtra()) {
			throw new IllegalArgumentException("Quantidade de camas extras invalida");
		}
		
		if ( Hotel.getQuartoExecutivoSimples() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		this.camaExtra = camaExtra;
		Hotel.setCamaExtra(Hotel.getCamaExtra() - this.camaExtra);
		Hotel.setQuartoExecutivoSimples(Hotel.getQuartoExecutivoSimples() - 1);
	}
	
	/**
	 * @return - A quantidade de camas extras do quarto.
	 */
	
	public int getCamaExtra() {
		return camaExtra;
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
	 * Metodo que compara se dois objetos do tipo quarto executivo simples sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public String toString() {
		return "Quarto Executivo Simples [ Quantidade de quartos diponiveis = " + Hotel.getQuartoExecutivoSimples() 
				+ ", Valor diaria = " + VALOR_DIARIA + ", " + super.toString() + " ]";
	}
	
	/**
	 * Metodo que compara se dois objetos do tipo quarto de luxo simples sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if ( !(obj instanceof QuartoExecutivoSimples))
			return false;
		
		QuartoExecutivoSimples qes = (QuartoExecutivoSimples) obj;
		
		return super.equals(qes) && qes.calculaTarifa() == VALOR_DIARIA &&
			   qes.getCamaExtra() == getCamaExtra();
	}
}
