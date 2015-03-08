package classes;

import excecoes.InputArgumentInvalidException;
import excecoes.StringInvalidaException;

import java.io.Serializable;

/**
*     Classe que contem os dados referentes ao numedo do telefone do hospede.
* 
*     @author Ravi Leite
* 
*     @data 23/12/2014
* 
*     Ultima alteracao: 18/02/2015 / Fabio Alexandre
*/

public class Telefone implements Serializable {

  private static final long serialVersionUID = 1L;
  private String numero;
  private String ddd;

  /**
  * Contrutor da classe Telefone
  * 
  * @param numero Numero do telefone.
  * @param ddd DDD do telefone.
  * @throws InputArgumentInvalidException - Pode lancar excecao de entrada de dados invalida.
  */

  public Telefone(String ddd, String numero) throws InputArgumentInvalidException {
    verificaDdd(ddd);
    verificaNumero(numero);
    this.numero = numero;
    this.ddd = ddd;
  }

  /**
  * Metodo que verifica DDD
  * 
  * @param ddd numero do DDD
  * @throws InputArgumentInvalidException - Pode lancar excecao de entrada de dados invalida.
  */

  private void verificaDdd( String ddd ) throws InputArgumentInvalidException {

    if ( ddd == null || ddd.equals("") ) {
      throw new StringInvalidaException("DDD nao pode ser vazio.");
    }
    
    for ( int i = 0; i < ddd.length(); i++ ) {
      if ( (! (Character.isDigit(ddd.charAt(i))))) {
        throw new StringInvalidaException("DDD deve conter apenas digitos.");
      }
    }

    if ( ddd.length() != 2 ) {
      throw new StringInvalidaException("Quantidade de digitos do DDD invalida.");
    }  
  }

  /**
  * Metodo que verifica numero do telefone
  * 
  * @param numero do telefone
  * @throws InputArgumentInvalidException - Pode lancar excecao de entrada de dados invalida.
  */

  private void verificaNumero( String numero ) throws InputArgumentInvalidException {

    if ( numero == null || numero.equals("") ) {
      throw new StringInvalidaException("Numero de telefone nao pode ser vazio.");
    }

    for ( int i = 0; i < numero.length(); i++ ) {
      if ( !(Character.isDigit(numero.charAt(i)) )) {
        throw new StringInvalidaException("O Numero do telefone deve conter "
        + "apenas digitos.");
      }
    }

    if ( numero.length() > 9 || numero.length() < 8 ) {
      throw new StringInvalidaException("Quantidade de digitos do telefone invalida.");
    }
  
    if ( numero.length() == 9 && numero.charAt(0) != '9' ) {
      throw new StringInvalidaException("Primeiro digito do telefone deve ser 9 (nove).");
    }
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
  * @throws InputArgumentInvalidException - Pode lancar excecao de entrada de dados invalida.
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
  * @throws InputArgumentInvalidException - Pode lancar excecao de entrada de dados invalida.
  */

  public void setDdd( String ddd ) throws InputArgumentInvalidException {
    verificaDdd(ddd);
    this.ddd = ddd;
  }

  /**
  * Retorna uma string de representacao do telefone.
  */

  @Override
  public String toString() { 
    return "(" + getDdd() + ") " + getNumero();
  }
  
  /** hash.
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
   * Verifica se dois telefones sao iguais, para isso o numero e o ddd precisam ser iguais.
   * 
   * @param obj - Telefone a ser comparado.
   */

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Telefone)) {
      return false;
    }  

    Telefone novoTelefone = (Telefone) obj;

    return (ddd.equals(novoTelefone.getDdd()) && numero.equals(novoTelefone.getNumero()));
  }
}