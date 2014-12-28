package classes;

public class QuartoPresidencial extends Quarto {

	private double valorDiaria = 1.200;
	private static int quantidadeDeQuartos = 5;
	
	public static int getQuantidadeDeQuartos() {
		return quantidadeDeQuartos;
	}

	public double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	@Override
	public double calculaTarifa() {
		// TODO Auto-generated method stub
		return 0;
	}
}
