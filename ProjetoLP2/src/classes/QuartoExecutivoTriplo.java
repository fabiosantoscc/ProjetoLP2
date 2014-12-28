package classes;

public class QuartoExecutivoTriplo extends Quarto {

	private double valorDiaria = 440;
	private static int quantidadeDeQuartos = 20;
	
	public double getValorDiaria() {
		return valorDiaria;
	}

	public static int getQuantidadeDeQuartos() {
		return quantidadeDeQuartos;
	}
	
	@Override
	public double calculaTarifa() {
		// TODO Auto-generated method stub
		return 0;
	}
}
