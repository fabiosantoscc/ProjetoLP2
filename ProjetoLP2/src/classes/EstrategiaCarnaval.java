package classes;


public class EstrategiaCarnaval implements EstrategiaDeCalculoDaMontante {
	
	@Override
	public double calculaMontante(double total) {
		return total *= 0.25;
	}
}
