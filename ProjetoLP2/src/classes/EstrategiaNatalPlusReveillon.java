package classes;


public class EstrategiaNatalPlusReveillon implements EstrategiaDeCalculoDaMontante {
	
	@Override
	public double calculaMontante(double total) {
		return total *= 0.30;
	}
}
