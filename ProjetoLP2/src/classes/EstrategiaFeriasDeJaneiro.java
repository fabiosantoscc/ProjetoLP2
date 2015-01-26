package classes;


public class EstrategiaFeriasDeJaneiro implements EstrategiaDeCalculoDaMontante{
	
	@Override
	public double calculaMontante(double total) {
		return total *= 0.20;
	}
}
