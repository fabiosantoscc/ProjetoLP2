package classes;

import excecoes.*;

/**
 * Classe que contem os dados referentes ao numedo do telefone do hospede
 * @author Ravi Leite
 * 
 * @data 23/12/2014
 * Ultima alteracao: 03/02/2015 / Fabio Alexandre
 */

public class Telefone {
	
	String numero;
	String ddd;
	
	/**
	 * Contrutor da classe Telefone
	 * 
	 * @param numero Numero do telefone
	 * @param ddd DDD do telefone
	 * @throws Exception
	 */
	
	public Telefone(String ddd, String numero) throws Exception {
		verificaNumero(numero);
		verificaDDD(ddd);
		this.numero = numero;
		this.ddd = ddd;
	}
	
	/**
	 * Metodo que verifica numero do telefone
	 * @param numero do telefone
	 * @throws Exception
	 */
	
	private void verificaNumero( String numero ) throws Exception {
		if ( numero.length() > 9 || numero.length() < 8 )
			throw new NumeroTelefoneInvalidoException("Quantidade de digitos invalida.");
		
		if ( Integer.parseInt(numero) < 0 )
			throw new NumeroTelefoneInvalidoException("Numero do telefone e um numero positivo.");
		
		for ( int i = 0; i < 9; i++ ) {
			if ( !(Character.isDigit(numero.charAt(0)) ))
				throw new NumeroTelefoneInvalidoException("O Numero do telefone deve conter apenas digitos.");
		}
		 
		if ( numero.length() == 9 && numero.charAt(0) != '9' )
			throw new NumeroTelefoneInvalidoException("Primeiro digito deve ser 9 (nove).");
	}
	
	/**
	 * Metodo que verifica DDD
	 * @param ddd numero do DDD
	 * @throws Exception
	 */
	
	private void verificaDDD( String ddd ) throws Exception {
		if ( ddd.length() != 2 )
			throw new DddInvalidoException("Quantidade de digitos invalida.");
		
		if ( Integer.parseInt(ddd) < 0 )
			throw new DddInvalidoException("O DDD e um numero positivo.");
		
		if ( (! (Character.isDigit(ddd.charAt(0)))) || (! (Character.isDigit(ddd.charAt(1)))) )
				throw new DddInvalidoException("DDD deve conter apenas digitos.");
			
	}
	
	/**
	 * @return Retorna o numero do telefone do hospede
	 */
	
	public String getNumero() {
		return numero;
	}
	
	/**
	 * Recebe o numero do telefone do hospede
	 * @param numero Numero do telefone
	 * @throws Exception
	 */
	
	public void setNumero( String numero ) throws Exception {
		verificaNumero(numero);
		this.numero = numero;
	}
	
	/**
	 * @return Retorna o ddd do telefone
	 */
	
	public String getDdd() {
		return ddd;
	}
	
	/**
	 * Recebe o DDD to telefone
	 * @param ddd DDD do numero do telefone
	 * @throws Exception
	 */
	
	public void setDdd( String ddd ) throws Exception {
		verificaDDD(ddd);
		this.ddd = ddd;
	}
	
	/**
	 * Retorna os atributos da classe telefone como uma string  em formato de lista
	 */
	
	@Override
	public String toString() { 
		return "Numero: " + "(" + getDdd() + ") " + getNumero();
	}
	
	/**
	 * Verifica se dois telefone sao iguais, para isso o numero e o ddd precisam ser iguais
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Telefone))
			return false;
		
		Telefone novoTelefone = (Telefone) obj;
		
		return (ddd.equals(novoTelefone.getDdd()) && numero.equals(novoTelefone.getNumero()));
	}
}