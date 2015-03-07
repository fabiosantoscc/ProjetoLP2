package classes;

import excecoes.InputArgumentInvalidException;
import excecoes.StringInvalidaException;

import java.io.Serializable;

/**
 *     Classe que manipula dados referentes ao endereco do cliente.
 *     @author Ravi Leite
 *     @data 23/12/2014
 *     Alteracoes: 06/03/2015 / Fabio Alexandre
 */

public class Endereco implements Serializable {

  private static final long serialVersionUID = 1L;
  private String cidade;
  private String bairro;
  private String nomeDaRua;
  private String numeroDaCasa;
  private String complemento;
  private String estado;
  private String pais;
  private String cep;

  /**
  * Construtor de um endereco.
  * 
  * @param cidade
  * @param bairro
  * @param rua
  * @param numero
  * @param complemento
  * @param estado
  * @param pais
  * @param cep
  * @throws InputArgumentInvalidException
  */

  public Endereco(String cidade, String bairro, String rua, String numero, String complemento, 
        String estado, String pais, String cep) throws InputArgumentInvalidException {

    checaCidade(cidade);
    checaBairro(bairro);
    checaRua(rua);
    checaNumero(numero);
    checaComplemento(complemento);
    checaEstado(estado);
    checaPais(pais);
    checaCep(cep);

    this.nomeDaRua = rua;
    this.numeroDaCasa = numero;
    this.bairro = bairro;
    this.cidade = cidade;
    this.complemento = complemento;
    this.estado = estado;
    this.pais = pais;
    this.cep = cep;
  }

  private void checaCidade( String cidade ) throws StringInvalidaException {
    if ( cidade == null || cidade.equals("") ) {
      throw new StringInvalidaException("Nome da cidade invalido.");
    }

    for (int i = 0; i < cidade.length(); i++ ) {
      if ( Character.isDigit(cidade.charAt(i))) {
        throw new StringInvalidaException("Nome da cidade deve conter apenas letras.");
      }
    }
  }

  private void checaBairro( String bairro ) throws StringInvalidaException {
    if ( bairro == null || bairro.equals("") ) {
      throw new StringInvalidaException("Nome do bairro invalido.");
    }

    for ( int i = 0; i < bairro.length(); i++ ) {
      if ( Character.isDigit(bairro.charAt(i)) ) {
        throw new StringInvalidaException("Nome do bairro deve conter apenas letras.");
      }
    }
  }

  private void checaRua( String rua ) throws StringInvalidaException {
    if ( rua == null || rua.equals("") ) {
      throw new StringInvalidaException("Nome da rua invalido.");
    }
    
    for ( int i = 0; i < rua.length(); i++ ) {
      if ( Character.isDigit(rua.charAt(i))) {
    	  throw new StringInvalidaException("Nome da rua deve conter apenas letras.");
      }
    }
  }
  
  private void checaComplemento( String complemento ) throws StringInvalidaException {
    if (complemento == null) {
      throw new StringInvalidaException("Complemento invalido.");
    }
  }

  private void checaNumero( String numero ) throws StringInvalidaException {

    if ( numero == null || numero.equals("")) {
      throw new StringInvalidaException("Numero da residencia nao pode ser vazio.");
    }
    
    for ( int i = 0; i < numero.length(); i++) {
      if ( ! (Character.isDigit(numero.charAt(i))) ) {
        throw new StringInvalidaException("Numero da residencia deve ser "
            + "um inteiro positivo.");
      }
    }

    if ( Integer.parseInt(numero) <= 0 ) {
      throw new StringInvalidaException("Numero da residencia deve ser um "
          + "inteiro positivo.");
    }
  }

  private void checaEstado( String estado ) throws StringInvalidaException {
    if ( estado == null || estado.equals("")) {
      throw new StringInvalidaException("Nome do estado invalido.");
    }

    for ( int i = 0; i < estado.length(); i++ ) {
      if ( Character.isDigit(estado.charAt(i)) ) {
        throw new StringInvalidaException("Nome do estado deve conter apenas letras.");
      }
    }
  }

  private void checaPais( String meuPais ) throws StringInvalidaException {
    if ( meuPais == null || meuPais.equals("")) {
      throw new StringInvalidaException("Nome do pais invalido.");
    }

    for ( int i = 0; i < meuPais.length(); i++ ) {
      if ( Character.isDigit(meuPais.charAt(i)) ) {
        throw new StringInvalidaException("Nome do pais deve conter apenas letras.");
      }
    }
  }

  private void checaCep( String cep ) throws StringInvalidaException {

    if ( cep == null || cep.equals("") ) {
      throw new StringInvalidaException("Cep nao pode ser vazio.");
    }

    if ( cep.length() != 8 ) {
      throw new StringInvalidaException("Quantidade de digitos do cep invalida.");
    }
    
    for ( int i = 0; i < cep.length(); i++ ) {
      if ( ! (Character.isDigit(cep.charAt(i))) ) {
        throw new StringInvalidaException("Cep deve conter apenas digitos.");
      }  
    }
  }

  /**
  * Recupera o nome da cidade do cliente.
  * 
  * @return cidade - O nome da cidade do cliente.
  */

  public String getCidade() {
    return cidade;
  }

  /**
  * Atribui um novo nome de cidade.
  * 
  * @param cidade - nova cidade onde reside o cliente.
  * @throws StringInvalidaException
  */

  public void setCidade(String cidade) throws StringInvalidaException {
    checaCidade(cidade);
    this.cidade = cidade;
  }

  /**
  * Recupera o bairro do cliente.
  * 
  * @return bairro - O bairro onde reside o cliente.
  */

  public String getBairro() {
    return bairro;
  }

  /**
  * Atribui um novo bairro ao endereco do cliente.
  * 
  * @param bairro - novo bairro de localizacao da rua do cliente.
  * @throws StringInvalidaException
  */

  public void setBairro(String bairro) throws StringInvalidaException {
    checaBairro(bairro);
    this.bairro = bairro;
  }

  /**
  * Recupera O nome da rua do cliente.
  * 
  * @return nomeDaRua - O nome da rua do cliente.
  */

  public String getNomeDaRua() {
    return nomeDaRua;
  }

  /**
  * Atribui um novo nome de rua para o cliente.
  * 
  * @param nomeDaRua - Nome da nova rua onde se localiza a residencia do cliente.
  * @throws StringInvalidaException
  */

  public void setNomeDaRua(String nomeDaRua) throws StringInvalidaException {
    checaRua(nomeDaRua);
    this.nomeDaRua = nomeDaRua;
  }

  /**
  * Recupera o numero da residencia do cliente.
  * 
  * @return numeroDaCasa - O numero da residencia do cliente.
  */

  public String getNumeroDaCasa() {
    return numeroDaCasa;
  }

  /**
  * Atribui um novo numero de casa do cliente.
  * 
  * @param numeroDaCasa - novo numero da residencia.
  * @throws NumeroDaResidenciaInvalidoException
  */

  public void setNumeroDaCasa(String numeroDaCasa) throws StringInvalidaException {
    checaNumero(numeroDaCasa);
    this.numeroDaCasa = numeroDaCasa;
  }

  /**
  * Recupera o complemento deo endereco do cliente.
  * 
  * @return complemento - complemento do endereco do cliente.
  */

  public String getComplemento() {
    return complemento;
  }

  /**
  * Atribui um novo complemento ao endereco do cliente.
  * 
  * @param complemento - novo complemento do endereco do cliente.
  * @throws ComplementoInvalidoException 
  */

  public void setComplemento(String complemento) throws StringInvalidaException {
    checaComplemento(complemento);
    this.complemento = complemento;
  }

  /**
  * 
  * Recupera o estado do endereco do cliente.
  * 
  * @return estado - Estado do endereco do cliente.
  */

  public String getEstado() {
    return estado;
  }

  /**
  * 
  * Atribui um novo estado no endereco do cliente.
  * 
  * @param estado - novo estado do cliente.
  * @throws EstadoInvalidoException 
  */

  public void setEstado(String estado) throws StringInvalidaException {
    checaEstado(estado);
    this.estado = estado;
  }

  /**
  * Recupera o nome do pais do cliente.
  * 
  * @return pais - pais do endereco do cliente.
  */

  public String getPais() {
    return pais;
  }

  /**
  * Atribui um novo pais no endereco do cliente.
  * 
  * @param pais - novo pais do endereco do cliente.
  * @throws PaisInvalidoException 
  */

  public void setPais(String pais) throws StringInvalidaException {
    checaPais(pais);
    this.pais = pais;
  }

  /**
  * Recupera o cep do endereco do cliente.
  * 
  * @return cep - cep da rua do endereco do cliente.
  */

  public String getCep() {
    return cep;
  }
  
  /**
  * Atribui um novo cep no endereco do cliente.
  * 
  * @param cep - novo cep do endereco do cliente.
  * @throws CepInvalidoException  
  */

  public void setCep(String cep) throws StringInvalidaException {
    checaCep(cep);
    this.cep = cep;
  }

  /**
  * Retorna uma String com a representação do endereço do cliente.
  */

  @Override
  public String toString() {
    return "- Cidade: " + getCidade() + Arquivos.FIM_LINHA+ "- Bairro: " + getBairro() + Arquivos.FIM_LINHA+"- Rua: " + getNomeDaRua()
            + Arquivos.FIM_LINHA +"- Numero: " + getNumeroDaCasa() + Arquivos.FIM_LINHA+"- Complemento: " + getComplemento()
            + Arquivos.FIM_LINHA+"- Estado: " + getEstado() + Arquivos.FIM_LINHA+"- Pais: " + getPais() + Arquivos.FIM_LINHA+"- Cep: " + getCep();
  }

  /**
  * Verifica se dois enderecos sao iguais. Para isso a cidade, o bairro, a rua, o numero
  * da residencia, o complemento, o estado, o pais e o cep precisam ser os mesmos.
  */

  @Override
  public boolean equals( Object obj ) {

    if (! (obj instanceof Endereco) ) {
      return false;
    }

    Endereco novoEndereco = (Endereco) obj;

    return (cidade.equals(novoEndereco.getCidade())
           && bairro.equals(novoEndereco.getBairro()) 
           && nomeDaRua.equals(novoEndereco.getNomeDaRua()) 
           && numeroDaCasa == novoEndereco.getNumeroDaCasa()
           && pais.equals(getPais()))
           && estado.equals(getEstado())
           && cep.equals(getCep());
  }
}