package classes;

/**
 * 
 * @author Fabio Alexandre Santos Silva Junior
 *
 */

public class QuartoExecutivoTriplo extends Quarto {

	private final double VALOR_DIARIA = 440;
	private int quantidadeDePessoas;
	
	/**
	 * 
	 * @param quantidadeDePessoas
	 * @throws Exception
	 */
	
	public QuartoExecutivoTriplo( int quantidadeDePessoas ) throws Exception {
		
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 3 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}
		
		if ( Hotel.getQuartoExecutivoTriplo() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		this.quantidadeDePessoas = quantidadeDePessoas;
		Hotel.setQuartoExecutivoTriplo(Hotel.getQuartoExecutivoTriplo() - 1);
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
	 * @return
	 */
	
	@Override
	public double calculaTarifa() {
		return 0;
	}
	
	/**
	 * 
	 * @return
	 */
	
	@Override
	public String toString() {
		return "Quarto Executivo Triplo [ Quantidade de quartos diponiveis = " + Hotel.getQuartoExecutivoTriplo() 
				+ ", Valor diaria = " + VALOR_DIARIA + " ]";
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
