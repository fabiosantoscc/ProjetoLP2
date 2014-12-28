package classes;

public class QuartoLuxoDuplo extends Quarto {

	private double valorDiaria = 570;
	private static int quantidadeDeQuartos = 15;
	
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
