package classes;

/**
 * 
 * @author Fabio Alexandre Santos Silva Junior
 *
 */

public class QuartoPresidencial extends Quarto {

	private final double VALOR_DIARIA = 1.200;
	private int quantidadeDePessoas;
	
	/**
	 * 
	 * @param quantidadeDePessoas
	 * @throws Exception
	 */
	
	public QuartoPresidencial( int quantidadeDePessoas ) throws Exception {
		
		if ( Hotel.getQuartoPresidencial() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 4 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}
		
		this.quantidadeDePessoas = quantidadeDePessoas;
		Hotel.setQuartoPresidencial(Hotel.getQuartoPresidencial() - 1);
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getQuantidadeDePessoas() {
		return quantidadeDePessoas;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public double getValorDiaria() {
		return VALOR_DIARIA;
	}
	
	/**
	 * 
	 */
	
	@Override
	public double calculaTarifa() {
		return 0;
	}
	
	/**
	 * 
	 */
	
	@Override
	public String toString() {
		return "Quarto Presidencial [ Quantidade de quartos diponiveis = " + Hotel.getQuartoPresidencial() 
				+ ", Valor diaria = " + VALOR_DIARIA + " ]";
	}
	
	/**
	 * 
	 */
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
