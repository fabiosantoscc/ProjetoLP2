package classes;

import excecoes.DddInvalidoException;
import excecoes.InputArgumentInvalidException;
import excecoes.NumeroTelefoneInvalidoException;

/**    Classe que contem os dados referentes ao numedo do telefone do hospede
 * 
 *     @author Ravi Leite
 * 
 *     @data 23/12/2014
 * 
 *     Ultima alteracao: 07/02/2015 / Fabio Alexandre
 */

public class Telefone {

  private String numero;
  private String ddd;

    /**
	 * Contrutor da classe Telefone
	 * 
	 * @param numero Numero do telefone
	 * @param ddd DDD do telefone
	 * @throws InputArgumentInvalidException
	 */
	
  public Telefone(String ddd, String numero) throws InputArgumentInvalidException {
    verificaDDD(ddd);
    verificaNumero(numero);
    this.numero = numero;
    this.ddd = ddd;
	}
	
	/**
	 * Metodo que verifica DDD
	 * 
	 * @param ddd numero do DDD
	 * @throws InputArgumentInvalidException
	 */
	
	private void verificaDDD( String ddd ) throws InputArgumentInvalidException {
		
		if ( ddd == null || ddd.equals("") )
			throw new DddInvalidoException("DDD nao pode ser vazio.");
		
		for ( int i = 0; i < ddd.length(); i++ ) {
			if ( (! (Character.isDigit(ddd.charAt(i)))))
				throw new DddInvalidoException("DDD deve conter apenas digitos.");
		}
		
		if ( ddd.length() != 2 )
			throw new DddInvalidoException("Quantidade de digitos do DDD invalida.");
			
	}
  
	/**
	 * Metodo que verifica numero do telefone
	 * 
	 * @param numero do telefone
	 * @throws InputArgumentInvalidException
	 */
	
	private void verificaNumero( String numero ) throws InputArgumentInvalidException {
		
		if ( numero == null || numero.equals(""))
			throw new NumeroTelefoneInvalidoException("Numero de telefone nao pode ser vazio.");
		
		// falta testar nos testes
		for ( int i = 0; i < numero.length(); i++ ) {
			if ( !(Character.isDigit(numero.charAt(i)) ))
				throw new NumeroTelefoneInvalidoException("O Numero do telefone deve conter apenas digitos.");
		}
		
		
		if ( numero.length() > 9 || numero.length() < 8 )
			throw new NumeroTelefoneInvalidoException("Quantidade de digitos do telefone invalida.");
		
		 
		if ( numero.length() == 9 && numero.charAt(0) != '9' )
			throw new NumeroTelefoneInvalidoException("Primeiro digito do telefone deve ser 9 (nove).");
	}
	
	/**
	 * Recupera o Numero do telefone.
	 * 
	 * @return Retorna o numero do telefone do hospede
	 */
	
	public String getNumero() {
		return numero;
	}
	
	/**
	 * Atribui um novo numero de telefone.
	 * 
	 * @param numero Numero do telefone
	 * @throws InputArgumentInvalidException
	 */
	
	public void setNumero( String numero ) throws InputArgumentInvalidException {
		verificaNumero(numero);
		this.numero = numero;
	}
	
	/**
	 * recupera O DDD do telefone.
	 * 
	 * @return Retorna o ddd do telefone
	 */
	
    public String getDdd() {
        return ddd;
	}
	
	/**
	 * Atribui um novo DDD ao telefone.
	 * 
	 * @param ddd DDD do numero do telefone
	 * @throws InputArgumentInvalidException
	 */
	
	public void setDdd( String ddd ) throws InputArgumentInvalidException {
		verificaDDD(ddd);
		this.ddd = ddd;
	}
	
	/**
	 * Retorna uma string de representacao do telefone.
	 */
	
	@Override
	public String toString() { 
		return "(" + getDdd() + ") " + getNumero();
	}
	
	/**
	 * 
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
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