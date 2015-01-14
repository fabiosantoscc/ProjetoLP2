package classes;

/**
 * Classe que representa um restaurante
 * 
 * @author -
 * Ultima atualizacao 14/01/2015 / Fabio Alexandre
 */

public class Restaurante implements Servicos {

	private double valorConsumido;

	public double getValorConsumido() {
		return valorConsumido;
	}

	public void setValorConsumido(double valorConsumido) {
		this.valorConsumido = valorConsumido;
	}

	@Override
	public double getPreco() {
		return 0;
	}
	
	public String toStrig() {
		return "Restaurante [ valorConsumido = " + valorConsumido + " ]";
	}
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
