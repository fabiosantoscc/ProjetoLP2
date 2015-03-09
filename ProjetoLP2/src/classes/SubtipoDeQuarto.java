package classes;

public enum SubtipoDeQuarto {

	SIMPLES(360), DUPLO(385), TRIPLO(440), SIMPLES2(520), DUPLO2(570), TRIPLO2(620);
	
	private double valorDiaria;
	
	SubtipoDeQuarto( double valorDiaria ) {
		this.valorDiaria = valorDiaria;
	}
	
	public double getValorDiaria() {
		return valorDiaria;
	}
}