package classes;

public class QuartoLuxoTriplo extends Quarto {
	
	private double valorDiaria = 620;
	private static int quantidadeDeQuartos = 20;
	
	public double getValorDiaria() {
		return valorDiaria;
	}

	public static int getQuantidadeDeQuartos() {
		return quantidadeDeQuartos;
	}
	
	@Override
	public double calculaTarifa() {
		return 0;
	}
}
