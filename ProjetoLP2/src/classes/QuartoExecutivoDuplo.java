package classes;

public class QuartoExecutivoDuplo extends Quarto {
	
	private final double VALOR_DIARIA = 385;
	
	
	public QuartoExecutivoDuplo() throws Exception {
		
		if ( Hotel.getQuartoExecutivoDuplo() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoExecutivoDuplo(Hotel.getQuartoExecutivoDuplo() - 1);
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
		return "Quarto Executivo Simples [ Quantidade de quartos diponiveis = " + Hotel.getQuartoExecutivoDuplo() 
				+ ", Valor diaria = " + VALOR_DIARIA + " ]";
	}
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}