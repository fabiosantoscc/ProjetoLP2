package classes;

public class QuartoExecutivoSimples extends Quarto {
	
	private final double VALOR_DIARIA = 360;
	
	public QuartoExecutivoSimples() throws Exception {
		
		if ( Hotel.getQuartoExecutivoSimples() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		Hotel.setQuartoExecutivoSimples(Hotel.getQuartoExecutivoSimples() - 1);
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
		return "Quarto Executivo Simples [ Quantidade de quartos diponiveis = " + Hotel.getQuartoExecutivoSimples() 
				+ ", Valor diaria = " + VALOR_DIARIA + " ]";
	}
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
