package classes;

import java.util.Date;

public class Contrato {

	private Date dataInicial;
	private Date dataFinal;
	
	private Hospede hospede;
	private EstrategiaDeCalculoDaMontante estrategia;
	
	public Contrato( Hospede umHospede, Date dataInicial, Date dataFinal ) {	
	}
	
	public Hospede getHospede() {
		return hospede;
	}

	public EstrategiaDeCalculoDaMontante getEstrategia() {
		return estrategia;
	}
	
	public Date getDataInicial() {
		return dataInicial;
	}
	
	public Date getDataFinal() {
		return dataFinal;
	}
	
	public void setEstrategia( EstrategiaDeCalculoDaMontante estrategia ) {
		this.estrategia = estrategia;
	}
	
	@Override
	public String toString() {
		return "Contrato";
	}
	
	@Override
	public boolean equals( Object obj ) {
		return false;
	}
}
