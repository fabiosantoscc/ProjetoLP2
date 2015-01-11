package classes;

public class BabySitter extends Servicos {
	
	private int minInicial, horaInicial, quantHoras, horas, quantHorasDobradas;
		
	public BabySitter(int horaInicial, int minInicial, int quantHoras){
		this.horaInicial = horaInicial;
		this.minInicial = minInicial;
		this.quantHoras = quantHoras;
	}
	
	public int getQuantidadeHoras() {
		return quantHoras;
	}
	
	public int getQuantidadeHorasDobradas() {
		horas = horaInicial;
		for (int i = 0; i <= quantHoras; i++){
			if (horas == 24){
				horas = 0;
			}
			if (horas >= 18 || horas <= 23 || horas >= 0 || horas <= 7){
				quantHorasDobradas++;
			}
		}
		return quantHorasDobradas;
	}
	
	@Override
	public double calculaTarifa() {
		return (quantHorasDobradas * 50) + ((quantHoras - quantHorasDobradas) * 25);
	}

	@Override
	public String toString() {
		return "BabySitter [quantidadeHoras=" + quantHoras
				+ ", quantidadeHorasDobradas=" + quantHorasDobradas + "]";
	}
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
