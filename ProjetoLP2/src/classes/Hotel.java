package classes;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

	private static int quartoPresidencial = 5;
	private static int quartoExecutivoSimples = 5;
	private static int quartoExecutivoDuplo = 15;
	private static int quartoExecutivoTriplo = 20;
	private static int quartoLuxoSimples = 5;
	private static int quartoLuxoDuplo = 15;
	private static int quartoLuxoTriplo = 20;
	private List<Contrato> contratos = new ArrayList<Contrato>();
	
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
}
