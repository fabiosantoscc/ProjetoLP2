package classes;

/**
 * 
 * @author Fabio Alexandre Santos Silva Junior
 *
 */

public class QuartoLuxoTriplo extends Quarto {
	
	private final double VALOR_DIARIA = 620;
	private int quantidadeDePessoas;
	
	/**
	 * 
	 * @param quantidadeDePessoas
	 * @throws Exception
	 */
	
	public QuartoLuxoTriplo( int quantidadeDePessoas ) throws Exception {
		
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 3 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}
		
		if ( Hotel.getQuartoLuxoTriplo() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		this.quantidadeDePessoas = quantidadeDePessoas;
		Hotel.setQuartoLuxoTriplo(Hotel.getQuartoLuxoTriplo() - 1);
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
		return "Quarto Luxo Triplo [ Quantidade de quartos diponiveis = " + Hotel.getQuartoLuxoTriplo() 
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
