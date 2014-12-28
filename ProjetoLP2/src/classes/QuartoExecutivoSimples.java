package classes;

public class QuartoExecutivoSimples extends Quarto {
	
	private double valorDiaria = 360;
	private static int quantidadeDeQuartos = 5;
	
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
