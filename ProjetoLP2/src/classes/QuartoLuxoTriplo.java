package classes;

public class QuartoLuxoTriplo extends Quarto {
	
	private double valorDiaria = 620;
	
	public double getValorDiaria() {
		return valorDiaria;
	}
	
	@Override
	public double calculaTarifa() {
		return 0;
	}
}
