package classes;

public class Restaurante implements Servicos {

	private double valorConsumido;

	public double getValorConsumido() {
		return valorConsumido;
	}

	public void setValorConsumido(double valorConsumido) {
		this.valorConsumido = valorConsumido;
	}

	@Override
	public double calculaTarifa() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return "Restaurante [valorConsumido=" + valorConsumido + "]";
	}
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
