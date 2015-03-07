package classes;

public enum SubtipoQuartoExecutivo {

	SIMPLES(360), DUPLO(385), TRIPLO(440);
	
	private double valorDiaria;
	
	SubtipoQuartoExecutivo( double valorDiaria ) {
		this.valorDiaria = valorDiaria;
	}
	
	public double getValorDiaria() {
		return valorDiaria;
	}
}