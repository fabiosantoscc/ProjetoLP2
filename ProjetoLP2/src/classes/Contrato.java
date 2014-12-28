package classes;

public class Contrato {

	private Hospede hospede;
	private EstrategiaDeCalculoDaMontante estrategia;
	
	public Contrato( Hospede umHospede ) {	
	}
	
	public Hospede getHospede() {
		return hospede;
	}

	public EstrategiaDeCalculoDaMontante getEstrategia() {
		return estrategia;
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
