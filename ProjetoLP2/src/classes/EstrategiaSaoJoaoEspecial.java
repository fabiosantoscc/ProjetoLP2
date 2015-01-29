package classes;

public class EstrategiaSaoJoaoEspecial implements EstrategiaDeCalculoDaMontante {
	
	@Override
	public double calculaMontante(double total) {
		return total *= 0.50;
	}
}
