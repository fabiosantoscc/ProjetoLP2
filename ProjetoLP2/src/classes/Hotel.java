package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Fabio
 *
 */


public class Hotel {

	private int quartoPresidencial = 5;
	private int quartoExecutivoSimples = 5;
	private int quartoExecutivoDuplo = 15;
	private int quartoExecutivoTriplo = 20;
	private int quartoLuxoSimples = 5;
	private int quartoLuxoDuplo = 15;
	private int quartoLuxoTriplo = 20;
	private List<Contrato> contratos = new ArrayList<Contrato>();
	
	/**
	 * 
	 * @param contrato
	 */
	
	public void adicionaContrato( Contrato contrato ) {
		contratos.add(contrato);
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getQuartoPresidencial() {
		return quartoPresidencial;
	}
	
	/**
	 * 
	 * @param quartoPresidencial
	 */
	
	public void setQuartoPresidencial( int quartoPresidencial ) {
		this.quartoPresidencial = quartoPresidencial;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getQuartoExecutivoSimples() {
		return quartoExecutivoSimples;
	}
	
	/**
	 * 
	 * @param quartoExecutivoSimples
	 */
	
	public void setQuartoExecutivoSimples( int quartoExecutivoSimples ) {
		this.quartoExecutivoSimples = quartoExecutivoSimples;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getQuartoExecutivoDuplo() {
		return quartoExecutivoDuplo;
	}
	
	/**
	 * 
	 * @param quartoExecutivoDuplo
	 */
	
	public void setQuartoExecutivoDuplo( int quartoExecutivoDuplo ) {
		this.quartoExecutivoDuplo = quartoExecutivoDuplo;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getQuartoExecutivoTriplo() {
		return quartoExecutivoTriplo;
	}
	
	/**
	 * 
	 * @param quartoExecutivoTriplo
	 */
	
	public void setQuartoExecutivoTriplo( int quartoExecutivoTriplo ) {
		this.quartoExecutivoTriplo = quartoExecutivoTriplo;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getQuartoLuxoSimples() {
		return quartoLuxoSimples;
	}
	
	/**
	 * 
	 * @param quartoLuxoSimples
	 */
	
	public void setQuartoLuxoSimples( int quartoLuxoSimples ) {
		this.quartoLuxoSimples = quartoLuxoSimples;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getQuartoLuxoDuplo() {
		return quartoLuxoDuplo;
	}
	
	/**
	 * 
	 * @param quartoLuxoDuplo
	 */
	
	public void setQuartoLuxoDuplo( int quartoLuxoDuplo ) {
		this.quartoLuxoDuplo = quartoLuxoDuplo;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public int getQuartoLuxoTriplo() {
		return quartoLuxoTriplo;
	}
	
	/**
	 * 
	 * @param quartoLuxoTriplo
	 */
	
	public void setQuartoLuxoTriplo( int quartoLuxoTriplo ) {
		this.quartoLuxoTriplo = quartoLuxoTriplo;
	}

	/**
	 * 
	 */
	
	@Override
	public String toString() {
		return "Hotel [ quartoPresidencial = " + quartoPresidencial
				+ ", quartoExecutivoSimples = " + quartoExecutivoSimples
				+ ", quartoExecutivoDuplo = " + quartoExecutivoDuplo
				+ ", quartoExecutivoTriplo = " + quartoExecutivoTriplo
				+ ", quartoLuxoSimples = " + quartoLuxoSimples
				+ ", quartoLuxoDuplo = " + quartoLuxoDuplo
				+ ", quartoLuxoTriplo = " + quartoLuxoTriplo
				+ contratos.toString() + " ]";
	}
	
	/**
	 * 
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if ( !( obj instanceof Hotel ) ) {
			return false;
		}
		
		return true;
	}
}
