package classes;

public class QuartoLuxoDuplo extends Quarto {

	private final double VALOR_DIARIA = 570;
	
	public QuartoLuxoDuplo() throws Exception {
		
		if ( Hotel.getQuartoLuxoDuplo() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoLuxoDuplo(Hotel.getQuartoLuxoDuplo() - 1);
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
		return "Quarto Executivo Simples [ Quantidade de quartos diponiveis = " + Hotel.getQuartoLuxoDuplo() 
				+ ", Valor diaria = " + VALOR_DIARIA + " ]";
	}
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
