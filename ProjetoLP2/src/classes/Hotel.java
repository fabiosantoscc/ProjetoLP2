package classes;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Fabio Alexandre Santos Silva Junior
 *
 */

public class Hotel {

	private static int camaExtra = 10;
	private static int quartoPresidencial = 5;
	private static int quartoExecutivoSimples = 5;
	private static int quartoExecutivoDuplo = 15;
	private static int quartoExecutivoTriplo = 20;
	private static int quartoLuxoSimples = 5;
	private static int quartoLuxoDuplo = 15;
	private static int quartoLuxoTriplo = 20;
	private List<Hospede> hospedes = new ArrayList<Hospede>();
	
	/**
	 * 
	 * @param contrato
	 */
	
	public void adicionaHospede( Hospede hospede ) {
		hospedes.add(hospede);
	}
	
	public static int getCamaExtra() {
		return camaExtra;
	}
	
	public static void setCamaExtra(int camaExtra) {
		Hotel.camaExtra = camaExtra;
	}
	
	public static int getQuartoPresidencial() {
		return quartoPresidencial;
	}

	public static void setQuartoPresidencial(int quartoPresidencial) {
		Hotel.quartoPresidencial = quartoPresidencial;
	}

	public static int getQuartoExecutivoSimples() {
		return quartoExecutivoSimples;
	}

	public static void setQuartoExecutivoSimples(int quartoExecutivoSimples) {
		Hotel.quartoExecutivoSimples = quartoExecutivoSimples;
	}

	public static int getQuartoExecutivoDuplo() {
		return quartoExecutivoDuplo;
	}

	public static void setQuartoExecutivoDuplo(int quartoExecutivoDuplo) {
		Hotel.quartoExecutivoDuplo = quartoExecutivoDuplo;
	}

	public static int getQuartoExecutivoTriplo() {
		return quartoExecutivoTriplo;
	}

	public static void setQuartoExecutivoTriplo(int quartoExecutivoTriplo) {
		Hotel.quartoExecutivoTriplo = quartoExecutivoTriplo;
	}

	public static int getQuartoLuxoSimples() {
		return quartoLuxoSimples;
	}

	public static void setQuartoLuxoSimples(int quartoLuxoSimples) {
		Hotel.quartoLuxoSimples = quartoLuxoSimples;
	}

	public static int getQuartoLuxoDuplo() {
		return quartoLuxoDuplo;
	}

	public static void setQuartoLuxoDuplo(int quartoLuxoDuplo) {
		Hotel.quartoLuxoDuplo = quartoLuxoDuplo;
	}

	public static int getQuartoLuxoTriplo() {
		return quartoLuxoTriplo;
	}

	public static void setQuartoLuxoTriplo(int quartoLuxoTriplo) {
		Hotel.quartoLuxoTriplo = quartoLuxoTriplo;
	}

	@Override
	public String toString() {
		return "";
	}
	
	@Override
	public boolean equals( Object obj ) {
		if ( !( obj instanceof Hotel ) ) {
			return false;
		}
		
		return true;
	}
}
