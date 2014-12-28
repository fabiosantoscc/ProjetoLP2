package classes;

public class BabySitter implements Servicos {

	private int quantidadeHoras;
	private int quantidadeHorasDobradas;
	
	public int getQuantidadeHoras() {
		return quantidadeHoras;
	}
	
	public void setQuantidadeHoras(int quantidadeHoras) {
		this.quantidadeHoras = quantidadeHoras;
	}
	
	public int getQuantidadeHorasDobradas() {
		return quantidadeHorasDobradas;
	}
	
	public void setQuantidadeHorasDobradas(int quantidadeHorasDobradas) {
		this.quantidadeHorasDobradas = quantidadeHorasDobradas;
	}

	@Override
	public double calculaTarifa() {
		return 0;
	}

	@Override
	public String toString() {
		return "BabySitter [quantidadeHoras=" + quantidadeHoras
				+ ", quantidadeHorasDobradas=" + quantidadeHorasDobradas + "]";
	}
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
