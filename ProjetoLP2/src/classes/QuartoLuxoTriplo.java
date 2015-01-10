package classes;

public class QuartoLuxoTriplo extends Quarto {
	
	private final double VALOR_DIARIA = 620;
	
	public QuartoLuxoTriplo() throws Exception {
		
		if ( Hotel.getQuartoLuxoTriplo() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoLuxoTriplo(Hotel.getQuartoLuxoTriplo() - 1);
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
		return "Quarto Executivo Simples [ Quantidade de quartos diponiveis = " + Hotel.getQuartoLuxoTriplo() 
				+ ", Valor diaria = " + VALOR_DIARIA + " ]";
	}
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
