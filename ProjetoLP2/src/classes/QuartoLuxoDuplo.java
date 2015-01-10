package classes;

/**
 * 
 * @author Fabio Alexandre Santos Silva Junior
 *
 */

public class QuartoLuxoDuplo extends Quarto {

	private final double VALOR_DIARIA = 570;
	private int quantidadeDePessoas;
	private int camaExtra;
	
	/**
	 * 
	 * @param quantidadeDePessoas
	 * @param camaExtra
	 * @throws Exception
	 */
	
	public QuartoLuxoDuplo( int quantidadeDePessoas, int camaExtra ) throws Exception {
		
		if ( camaExtra < 0 || camaExtra > Hotel.getCamaExtra()) {
			throw new IllegalArgumentException("Quantidade de camas extras invalida");
		}
		
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 3 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}
		
		if ( Hotel.getQuartoLuxoDuplo() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		this.camaExtra = camaExtra;
		Hotel.setCamaExtra(Hotel.getCamaExtra() - this.camaExtra);
		this.quantidadeDePessoas = quantidadeDePessoas;
		Hotel.setQuartoLuxoDuplo(Hotel.getQuartoLuxoDuplo() - 1);
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getCamaExtra() {
		return camaExtra;
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
		return "Quarto Luxo Duplo [ Quantidade de quartos diponiveis = " + Hotel.getQuartoLuxoDuplo() 
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
