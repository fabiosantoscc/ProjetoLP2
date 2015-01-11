package classes;

public class AluguelDeCarros extends Servicos {
	private String tipoCarro;
	private boolean tanqueCheio;
	private boolean seguroDeAutomovel;
	
	public AluguelDeCarros(String tipoCarro, boolean tanqueCheio, boolean seguroAutomovel){
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
	public double calculaTarifa() {
			
		return 0;
	}

	@Override
	public String toString() {
		return "AluguelDeCarros [ Tipo de Automóvel: "+tipoCarro 
				+ ", tanqueCheio=" + tanqueCheio + ", seguroDeAutomovel="
				+ seguroDeAutomovel + "]";
	}

	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}