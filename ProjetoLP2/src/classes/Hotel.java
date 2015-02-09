package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Set;

import excecoes.*;

/**
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima alteracao: 08/02/2015 / Fabio Alexandre
 */

public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;
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
	 * @param cpf
	 * @return
	 * @throws Exception
	 */
	
	public Hospede pesquisaHospede( String cpf, String nome ) throws HospedeInvalidoException {
		Hospede h = null;
		Set <Hospede> meusHospedes = hospedes.keySet();
		
		if ( meusHospedes.size() == 0 )
			throw new HospedeInvalidoException("Hospede nao existente no hotel");
		
		for ( Hospede umHospede : meusHospedes ) {
			if ( umHospede.getCpf().equals(cpf) || umHospede.getNome().equals(nome)) {
				h = umHospede;
			}
		}
		
		if ( h == null )
			throw new HospedeInvalidoException("Hospede nao existente no hotel.");
		
		return h;
	}
	
	/**
	 * 
	 * @param esseHospede
	 * @param umServico
	 * @throws ContratoAbertoException 
	 */
	
	public void adicionaServico( Hospede esseHospede, Servicos umServico ) throws ContratoAbertoException {
		boolean isContratoAberto = false;
		
		List<Contrato> contratos = this.hospedes.get(esseHospede);
		for ( Contrato c : contratos ) {
			if ( c.isAberto() ) {
				c.adicionaServico(umServico);
				isContratoAberto = true;
			}
		}
		
		if ( !(isContratoAberto) ) {
			throw new ContratoAbertoException("Impossivel adicionar um servico\nO hospede nao possui nenhum contrato aberto.");
		}
	}
	
	// metodo que cria um contrato sem nenhum servico para o hospede
	
	public void criaContrato( String cpf, String nome, int noites ) throws Exception {
		Set <Hospede> meusHospedes = hospedes.keySet();
		boolean hospedeEncontrado = false;
		
		if ( meusHospedes.size() == 0 )
			throw new HospedeInvalidoException("Para criar um contrato eh necessario\nque exista hospede no hotel.");

		for ( Hospede umHospede :  meusHospedes ) {
			if ( umHospede.getCpf().equals(cpf) || umHospede.getNome().equals(nome) ) {
				List<Contrato> contratos = hospedes.get(umHospede);
				for ( Contrato contrato : contratos ) {
					if ( contrato.isAberto())
						throw new ContratoAbertoException("Impossivel abrir outro contrato para o cliente\nJá existe um contrato em aberto");
				}
				
				Contrato umContrato = new Contrato(noites);
				contratos.add(umContrato);
				hospedeEncontrado = true;
			}
			
			if ( !(hospedeEncontrado) ) {
				throw new HospedeInvalidoException("Hospede nao existente no hotel");
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	
	public HashMap<Hospede, List<Contrato>> getMapaDeHospedes() {
		return hospedes;
	}
	
	/**
	 * Adiciona um hospede no hotel
	 * 
	 * @param hospede - Hospede a ser adicionado no hotel
	 * @throws Exception 
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
	
	private void calculaNotaDeAceitacao( List<Opiniao> opinioes ) {
		int soma = 0;
		for ( int i = 0; i < opinioes.size(); i++) {
			soma += opinioes.get(i).getNota();
		}
		
		double nota = soma / opinioes.size();
		this.notaDeAceitacao = nota;
	}
	
	/**
	 * 
	 * Metodo que adiciona uma opiniao no hotel e toda vez que adiciona ja calcula a nota de aceitacao
	 * baseada na ultima opiniao
	 * 
	 * @param umaOpiniao - Opiniao a ser adicionada oriunda de algum hospede
	 */
	
	public void adicionaOpiniao( Opiniao umaOpiniao ) {
		this.opinioes.add(umaOpiniao);
		calculaNotaDeAceitacao(opinioes);
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
	
	public List<Opiniao> getListaOpinioes(){
		return opinioes;
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
