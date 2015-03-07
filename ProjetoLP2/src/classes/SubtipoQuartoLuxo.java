package classes;

public enum SubtipoQuartoLuxo {

	SIMPLES(520), DUPLO(570), TRIPLO(620);
	
	private double valorDiaria;
	
	SubtipoQuartoLuxo( double valorDiaria ) {
		this.valorDiaria = valorDiaria;
	}
	
	public double getValorDiaria() {
		return valorDiaria;
	}
}