package classes;

public class AluguelDeCarros implements Servicos {

	private boolean luxo = false;
	private boolean executivo = false;
	private boolean tanqueCheio = false;
	private boolean seguroDeAutomovel = false;
	
	
	public boolean isLuxo() {
		return luxo;
	}

	public void setLuxo(boolean luxo) {
		this.luxo = luxo;
	}

	public boolean isExecutivo() {
		return executivo;
	}

	public void setExecutivo(boolean executivo) {
		this.executivo = executivo;
	}

	public boolean isTanqueCheio() {
		return tanqueCheio;
	}

	public void setTanqueCheio(boolean tanqueCheio) {
		this.tanqueCheio = tanqueCheio;
	}

	public boolean isSeguroDeAutomovel() {
		return seguroDeAutomovel;
	}

	public void setSeguroDeAutomovel(boolean seguroDeAutomovel) {
		this.seguroDeAutomovel = seguroDeAutomovel;
	}

	@Override
	public double calculaTarifa() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return "AluguelDeCarros [luxo=" + luxo + ", executivo=" + executivo
				+ ", tanqueCheio=" + tanqueCheio + ", seguroDeAutomovel="
				+ seguroDeAutomovel + "]";
	}

	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}