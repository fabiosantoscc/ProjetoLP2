package classes;

public class QuartoExecutivoTriplo extends Quarto {

	private final double VALOR_DIARIA = 440;
	
	public QuartoExecutivoTriplo() throws Exception {
		
		if ( Hotel.getQuartoExecutivoTriplo() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoExecutivoTriplo(Hotel.getQuartoExecutivoTriplo() - 1);
	}
	
	public double getValorDiaria() {
		return VALOR_DIARIA;
	}
	
	@Override
	public double calculaTarifa() {
		return 0;
	}
	
	@Override
	public String toString() {
		return "Quarto Executivo Simples [ Quantidade de quartos diponiveis = " + Hotel.getQuartoExecutivoTriplo() 
				+ ", Valor diaria = " + VALOR_DIARIA + " ]";
	}
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
