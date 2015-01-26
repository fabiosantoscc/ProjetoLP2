package classes;


public class EstrategiaSaoJoao implements EstrategiaDeCalculoDaMontante{

	@Override
	public double calculaMontante(double total) {
		return total *= 0.5;
	}
}
