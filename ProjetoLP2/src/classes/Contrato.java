package classes;

/**
 * Classe que representa um contrato
 * 
 * @author Fabio Alexandre Santos Silva Júnior
 * @date 02/02/2015
 * Ultima alteracao: 08/02/2015
 * 
 */

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;

import excecoes.*;

/**
 * Classe que manipula os dados referentes ao contrato do hospede.
 * @author Ravi Leite
 * @data 12/01/2015
 * Ultima alteracao: 05/02/2015 / Jaaziel Moura
 */

public class Contrato implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private List<Servicos> servicos = new ArrayList<Servicos>();
	private boolean aberto;
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
			throw new NumeroDeNoitesInvalidoException("Numero de dias deve ser maior que zero.");
		
		this.numeroDeNoites = numeroDeNoites;
		this.aberto = true;
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
	
	public boolean isAberto() {
		return aberto;
	}
	
	/**
	 * 
	 * @param fechado
	 */
	
	public void setAberto(boolean aberto) {
		this.aberto = aberto;
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
		
		if ( isAberto() )
			representacao += "\nContrato aberto";
		else {
			representacao += "\nContrato fechado";
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
				&& getValorAPagar() == c.getValorAPagar() && isAberto() == c.isAberto();			
	}
}