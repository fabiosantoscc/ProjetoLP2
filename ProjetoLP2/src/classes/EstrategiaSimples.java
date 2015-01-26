package classes;


public class EstrategiaSimples implements EstrategiaDeCalculoDaMontante{
	
	@Override
	public double calculaMontante(double total) {
		return total;
	}
}