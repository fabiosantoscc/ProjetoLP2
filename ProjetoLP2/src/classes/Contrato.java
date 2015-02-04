package classes;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import excecoes.*;

/**
 * Classe que manipula os dados referentes ao contrato do hospede
 * @author Ravi Leite
 * @data 12/01/2015
 * Ultima alteracao: 16/01/2015 / Fabio Alexandre
 */

public class Contrato {
	
	private List<Servicos> servicos = new ArrayList<Servicos>();
	private boolean fechado;
	private double valorAPagar;
	private int numeroDeNoites;
	private int diaInicial, mesInicial, anoInicial;
	private EstrategiaDeCalculoDaMontante e;
	
	public Contrato(Hospede hospede, int numeroDeNoites) throws NumeroDeNoitesInvalidoException {
		Calendar c = Calendar.getInstance();
		diaInicial = c.get(Calendar.DAY_OF_MONTH);
		mesInicial = c.get(Calendar.MONTH) + 1;
		anoInicial = c.get(Calendar.YEAR);
		
		if ( numeroDeNoites <= 0)
			throw new NumeroDeNoitesInvalidoException("");
		
		this.fechado = false;
	}
	
	public void adicionaServico( Servicos servico ) {
		servicos.add(servico);
	}

	public boolean isfechado() {
		return fechado;
	}
	
	public void SetFechado(boolean fechado) {
		this.fechado = fechado;
	}
	
	public int getNumeroDeNoites() {
		return numeroDeNoites;
	}
	
	/**
	 * @return Todo o valor gasto durante o periodo
	 */
	
	public double getValorAPagar(){
		return valorAPagar;
	}
	
	public void calculaTotalAPagar() {
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public boolean equals( Object obj ) {
		if (!(obj instanceof Contrato))
			return false;
		
		return true;
	}
}

