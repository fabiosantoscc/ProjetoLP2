package classes;

import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import excecoes.*;

/**
 * Classe que manipula os dados referentes ao contrato do hospede
 * @author Ravi Leite
 * @data 12/01/2015
 * Ultima alteracao: 05/02/2015 / Fabio Alexandre
 */

public class Contrato {
	
	private List<Servicos> servicos = new ArrayList<Servicos>();
	private boolean fechado;
	private double valorAPagar;
	private int numeroDeNoites;
	private int diaInicial, mesInicial, anoInicial;
	private Calendar data;
	private EstrategiaDeCalculoDaMontante e;
	
	public Contrato( int numeroDeNoites ) throws NumeroDeNoitesInvalidoException {
		Calendar c = Calendar.getInstance();
		this.data = c;
		diaInicial = c.get(Calendar.DAY_OF_MONTH);
		mesInicial = c.get(Calendar.MONTH) + 1;
		anoInicial = c.get(Calendar.YEAR);
		
		if ( numeroDeNoites <= 0)
			throw new NumeroDeNoitesInvalidoException("");
		
		this.numeroDeNoites = numeroDeNoites;
		this.fechado = false;
	}
	
	/**
	 * 
	 * @param servico
	 */
	
	public void adicionaServico( Servicos servico ) {
		servicos.add(servico);
	}

	/**
	 * 
	 * @return
	 */
	
	public int getDiaInicial() {
		return diaInicial;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getMesInicial() {
		return mesInicial;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getAnoInicial() {
		return anoInicial;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public boolean isFechado() {
		return fechado;
	}
	
	/**
	 * 
	 * @param fechado
	 */
	
	public void setFechado(boolean fechado) {
		this.fechado = fechado;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getNumeroDeNoites() {
		return numeroDeNoites;
	}
	
	/**
	 * @return Todo o valor gasto durante o periodo
	 */
	
	public double getValorAPagar(){
		return valorAPagar;
	}
	
	/**
	 * 
	 */
	
	public void calculaTotalAPagar() {
	}
	
	/**
	 * 
	 */
	
	@Override
	public String toString() {
		String representacao = "Contrato [ Criado em " + getDiaInicial() + "/" + getMesInicial() + "/" +
				getAnoInicial() + " as " + data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE)
				+ ":" + data.get(Calendar.SECOND);
		
		if ( isFechado() )
			representacao += "\nContrato fechado";
		else {
			representacao += "\nContrato aberto";
		}
		
		representacao += ", Noites de hospedagem: " + getNumeroDeNoites() + " ]";
		
		return representacao;
	}
	
	/**
	 * 
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if (!(obj instanceof Contrato))
			return false;
		
		Contrato c = (Contrato) obj;
		
		return getNumeroDeNoites() == c.getNumeroDeNoites() && getDiaInicial() == c.getDiaInicial()
				&& getMesInicial() == c.getMesInicial() && getAnoInicial() == c.getAnoInicial()
				&& getValorAPagar() == c.getValorAPagar() && isFechado() == c.isFechado();			
	}
}