package classes;

public class QuartoLuxoSimples extends Quarto {

	private final double VALOR_DIARIA = 520;
	
	public QuartoLuxoSimples() throws Exception {
		
		if ( Hotel.getQuartoLuxoSimples() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoLuxoSimples(Hotel.getQuartoLuxoSimples() - 1);
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
		return "Quarto Executivo Simples [ Quantidade de quartos diponiveis = " + Hotel.getQuartoLuxoSimples() 
				+ ", Valor diaria = " + VALOR_DIARIA + " ]";
	}

	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
