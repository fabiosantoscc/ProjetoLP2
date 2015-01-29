package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

/**
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima alteracao: 29/01/2015 / Fabio Alexandre
 */

public class Hotel {

	private double notaDeAceitacao = 0;
	private static int camaExtra = 20;
	private static int quartoPresidencial = 5;
	private static int quartoExecutivoSimples = 5;
	private static int quartoExecutivoDuplo = 15;
	private static int quartoExecutivoTriplo = 20;
	private static int quartoLuxoSimples = 5;
	private static int quartoLuxoDuplo = 15;
	private static int quartoLuxoTriplo = 20;
	
	private List<Opiniao> opinioes = new ArrayList<Opiniao>();
	
	// map com um hospede como chave, e um List<Contrato> como valor
	
	HashMap<Hospede, List<Contrato>> hospedes = new HashMap<Hospede, List<Contrato>>();
	
	/**
	 * 
	 */
	
	public void checkin() {
	}
	
	/**
	 * 
	 */
	
	public void checkout() {
	}
	
	/**
	 * Adiciona um hospede no hotel
	 * 
	 * @param hospede - Hospede a ser adicionado no hotel
	 */
	
	public void addHospede( Hospede hospede ) {
		List<Contrato> contratos = new ArrayList<Contrato>();
		hospedes.put(hospede, contratos);
	}
	
	/**
	 * 
	 * @return
	 */
	
	public double getNotaDeAceitacao() {
		return notaDeAceitacao;
	}
	
	/**
	 * 
	 * @param opinioes
	 */
	
	public void calculaNotaDeAceitacao( List<Opiniao> opinioes ) {
		int soma = 0;
		for ( int i = 0; i < opinioes.size(); i++) {
			soma += opinioes.get(i).getNota();
		}
		
		double nota = soma / opinioes.size();
		this.notaDeAceitacao = nota;
	}
	
	/**
	 * 
	 * @param umaOpiniao
	 */
	
	public void adicionaOpiniao( Opiniao umaOpiniao ) {
		this.opinioes.add(umaOpiniao);
	}
	
	/**
	 * 
	 * @return
	 */
	
	public static int getCamaExtra() {
		return camaExtra;
	}
	
	/**
	 * 
	 * @param camaExtra
	 */
	
	public static void setCamaExtra(int camaExtra) {
		Hotel.camaExtra = camaExtra;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoPresidencial() {
		return quartoPresidencial;
	}

	/**
	 * 
	 * @param quartoPresidencial
	 */
	
	public static void setQuartoPresidencial(int quartoPresidencial) {
		Hotel.quartoPresidencial = quartoPresidencial;
	}

	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoExecutivoSimples() {
		return quartoExecutivoSimples;
	}

	/**
	 * 
	 * @param quartoExecutivoSimples
	 */
	
	public static void setQuartoExecutivoSimples(int quartoExecutivoSimples) {
		Hotel.quartoExecutivoSimples = quartoExecutivoSimples;
	}

	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoExecutivoDuplo() {
		return quartoExecutivoDuplo;
	}

	/**
	 * 
	 * @param quartoExecutivoDuplo
	 */
	
	public static void setQuartoExecutivoDuplo(int quartoExecutivoDuplo) {
		Hotel.quartoExecutivoDuplo = quartoExecutivoDuplo;
	}

	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoExecutivoTriplo() {
		return quartoExecutivoTriplo;
	}

	/**
	 * 
	 * @param quartoExecutivoTriplo
	 */
	
	public static void setQuartoExecutivoTriplo(int quartoExecutivoTriplo) {
		Hotel.quartoExecutivoTriplo = quartoExecutivoTriplo;
	}

	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoLuxoSimples() {
		return quartoLuxoSimples;
	}

	/**
	 * 
	 * @param quartoLuxoSimples
	 */
	
	public static void setQuartoLuxoSimples(int quartoLuxoSimples) {
		Hotel.quartoLuxoSimples = quartoLuxoSimples;
	}

	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoLuxoDuplo() {
		return quartoLuxoDuplo;
	}

	/**
	 * 
	 * @param quartoLuxoDuplo
	 */
	
	public static void setQuartoLuxoDuplo(int quartoLuxoDuplo) {
		Hotel.quartoLuxoDuplo = quartoLuxoDuplo;
	}

	/**
	 * 
	 * @return
	 */
	
	public static int getQuartoLuxoTriplo() {
		return quartoLuxoTriplo;
	}

	/**
	 * 
	 * @param quartoLuxoTriplo
	 */
	
	public static void setQuartoLuxoTriplo(int quartoLuxoTriplo) {
		Hotel.quartoLuxoTriplo = quartoLuxoTriplo;
	}

	/**
	 * 
	 */
	
	@Override
	public String toString() {
		return "";
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
