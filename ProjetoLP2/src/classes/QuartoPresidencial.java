package classes;

public class QuartoPresidencial extends Quarto {

	private final double VALOR_DIARIA = 1.200;
	
	public QuartoPresidencial() throws Exception {
		
		if ( Hotel.getQuartoPresidencial() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoPresidencial(Hotel.getQuartoPresidencial() - 1);
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
		return "Quarto Executivo Simples [ Quantidade de quartos diponiveis = " + Hotel.getQuartoPresidencial() 
				+ ", Valor diaria = " + VALOR_DIARIA + " ]";
	}
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
