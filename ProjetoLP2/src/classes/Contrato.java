package classes;

import java.util.List;
import java.util.ArrayList;


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
	
	public Contrato( Hospede hospede ) {
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
	
	/**
	 * @return Todo o valor gasto durante o periodo
	 */
	
	public double getValorAPagar(){
		return valorAPagar;
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

