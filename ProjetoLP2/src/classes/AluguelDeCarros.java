package classes;

/**
 * 
 * @author -
 * Ultima atualizacao 14/01/2014 / Fabio Alexandre
 */

public class AluguelDeCarros implements Servicos {
	private String tipoCarro;
	private boolean tanqueCheio;
	private boolean seguroDeAutomovel;
	
	public AluguelDeCarros(String tipoCarro, boolean tanqueCheio, boolean seguroAutomovel) {
		this.tipoCarro = tipoCarro;
		this.tanqueCheio = tanqueCheio;
		this.seguroDeAutomovel = seguroAutomovel;
		
	}	
	
	public String tipoCarro(){ return tipoCarro;}
	
	public boolean isTanqueCheio() {
		return tanqueCheio;
	}

	public boolean isSeguroDeAutomovel() {
		return seguroDeAutomovel;
	}

	@Override
	public double getPreco() {
		return 0;
	}

	@Override
	public String toString() {
		return "Aluguel De Carros [ Tipo de Automovel: " + tipoCarro 
				+ ", tanque Cheio = " + tanqueCheio + ", seguroDeAutomovel = "
				+ seguroDeAutomovel + " ]";
	}

	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}