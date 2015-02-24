package classes;

import excecoes.CpfInvalidoException;
import excecoes.EmailInvalidoException;
import excecoes.InputArgumentInvalidException;
import excecoes.NomeInvalidoException;
import excecoes.NumeroCartaoInvalidoException;

import java.io.Serializable;

/**
 *     Classe que representa um hospede.
 *     @author Ravi Leite
 *     @data 23/12/2014
 *     Ultima revisao: 24/02/2015 / Fabio Alexandre
 */

public class Hospede implements Serializable {

  private static final long serialVersionUID = 1L;
  private Endereco endereco;
  private String nome;
  private String cpf;
  private Telefone telefone;
  private String numeroDoCartao;
  private String email;

  /**
  * Construtor da classe Hospede.
  * @param endereco Objeto com todos os dados do endereco
  * @param nome Nome do hospede
  * @param cpf Cpf do hospede
  * @param telefone Objeto com ddd e numero do telefone de contato do hospede
  * @param cartao Numero de cartao de Credito do hospede
  * @param email E mail para contato do hospede
  * @throws Exception
  */

  public Hospede( String nome, String cpf, String cartao, String email, Telefone telefone, 
      Endereco endereco ) throws InputArgumentInvalidException {

    verificaNome(nome);
    verificaCpf(cpf);
    verificaCartao(cartao);
    verificaEmail(email);

    this.endereco = endereco;
    this.nome = nome;
    this.cpf = cpf;
    this.telefone = telefone;
    this.numeroDoCartao = cartao;
    this.email = email;
  }

  /**
  * Verifica se o cpf do hospede eh valido.
  * @param cpf do cliente
  * @throws Exception
  */

  private void verificaCpf(String cpf) throws InputArgumentInvalidException {
    if (cpf == null || cpf.equals("")) {
      throw new CpfInvalidoException("O campo do cpf nao pode ser vazio.");
    }

    for (int i = 0; i < cpf.length(); i++) {
      if (!(Character.isDigit(cpf.charAt(i)))) {
        throw new CpfInvalidoException("O cpf deve conter apenas numeros.");
      }  
    }

    if (cpf.length() != 11) {
      throw new CpfInvalidoException("Quantidade de digitos do cpf invalida.");
    }

    if ( ! (isCpf(cpf) ) ) {
      throw new CpfInvalidoException("cpf invalido");
    }
  }

  /**
  * Verifica se o cpf eh valido de acordo com o calculo do 10 e 11 digitos do cpf.
  * @param cpf do cliente
  * @return - True se o cpf for valido, false caso contratio.
  */

  private boolean isCpf( String cpf ) {

    int digito10;
    int digito11;

    digito10 = calculaDigito10(cpf);
    digito11 = calculaDigito11(cpf);

    if ( digito10 != Integer.parseInt(cpf.charAt(9) + "")
        || digito11 != Integer.parseInt(cpf.charAt(10) + "")) {
      return false;
    }
    
    return true;
  }

  /**
  * Calcula o 11 digito do cpf.
  * @param cpf do cliente
  * @return o 11° digito do CPF
  */

  private int calculaDigito11( String cpf ) {
    int digito11;
    int soma = 0;
    int digitoAtual = 0;

    for ( int i = 11; i > 1; i-- ) {
      soma += Integer.parseInt(cpf.charAt(digitoAtual) + "") * i;
      digitoAtual++;
    }

    if ( 11 - ( soma % 11 ) == 10 || 11 - ( soma % 11 ) == 11 ) {
      digito11 = 0;
    } else {
      digito11 = 11 - ( soma % 11 );
    }

    return digito11;
  }

  /**
  * Calcula o 10 digito do CPF.
  * @param cpf do cliente
  * @return o 10° digito do CPF
  */

  private int calculaDigito10( String cpf ) {
    int digito10;
    int soma = 0;
    int digitoAtual = 0;

    for ( int i = 10; i > 1; i-- ) {
      soma += Integer.parseInt(cpf.charAt(digitoAtual) + "") * i;
      digitoAtual++;
    }

    if ( 11 - ( soma % 11 ) == 10 || 11 - ( soma % 11 ) == 11 ) {
      digito10 = 0;
    } else {
      digito10 = 11 - ( soma % 11 );
    }

    return digito10;
  }

  /**
  * Verifica se o nome do cliente eh valido.
  * @param nome do cliente
  * @throws InputArgumentInvalidException
  */

  private void verificaNome( String nome ) throws InputArgumentInvalidException {

    if ( nome == null || nome.equals("") ) {
      throw new NomeInvalidoException("O nome do hospede nao pode ser vazio.");
    }

    for ( int i = 0; i < nome.length(); i++) {
      if ( (Character.isDigit(nome.charAt(i))) ) {
        throw new NomeInvalidoException("O nome do hospede deve conter apenas letras.");
      }  
    }
  }

  /**
  * Verifica se o numero do cartao eh valido.
  * @param cartao numero do cartão de credito do cliente
  * @throws InputArgumentInvalidException  
  * @throws InputArgumentInvalidException
  */

  private void verificaCartao(String cartao) throws InputArgumentInvalidException {

    if (cartao == null || cartao.equals("")) {
      throw new NumeroCartaoInvalidoException("O campo NUMERO DO CARTAO nao pode ser vazio.");
    }

    if (cartao.length() != 16) {
      throw new NumeroCartaoInvalidoException("Quantidade de digitos do cartao invalida.");
    }
    
    for (int i = 0; i < 16; i++) {
      if ( !(Character.isDigit(cartao.charAt(i))) ) {
        throw new NumeroCartaoInvalidoException("O numero do cartao deve conter apenas numeros.");
      }
    }

    if (!(isCartao(cartao))) {
      throw new NumeroCartaoInvalidoException("Numero do cartao invalido.");
    }
  }

  /**
  * Metodo para testar se o numero do cartao informado e valido.
  * 
  * @param cartao Numero do cartao de credito do hospede.
  * @return verdadeiro se for um cartao valido
  */

  private boolean isCartao( String cartao ) {

    int somatorio = 0;
    for ( int i = 0; i < cartao.length(); i++) {
      if ( (i + 1) % 2 != 0 ) {
        if ( Integer.parseInt(cartao.charAt(i) + "") * 2 <= 9 ) {
          somatorio += Integer.parseInt(cartao.charAt(i) + "") * 2;
        } else {
          somatorio += (Integer.parseInt(cartao.charAt(i) + "") * 2) - 9;
        }

      } else {
        somatorio += Integer.parseInt(cartao.charAt(i) + "");
      }
    }

    if ( somatorio % 10 != 0 || somatorio > 150 ) {
      return false;
    }
  
    return true;
  
  }

  /**
  * Verifica e-mail do hospede.
  * @param - email do cliente
  * @throws - InputArgumentInvalidException
  */

  private void verificaEmail( String email ) throws InputArgumentInvalidException {
    if ( email == null || email.equals("") ) {
      throw new EmailInvalidoException("O campo do email nao pode ser vazio.");
    }

    if ( email.indexOf("@") == -1 ) {
      throw new EmailInvalidoException("O campo do email deve ser preenchido no formato"
          + " adequado com o @.");
    }
  }
  
  public Telefone getTelefone() {
    return telefone;
  } 

  /**
  * Recupera o numero do cartao do hospede.
  * 
  * @return O numero do cartao de credito do hospede
  */

  public String getNumeroDoCartao() {
    return numeroDoCartao;
  }

  /**
  * Atribui um novo numero do cartao de credito ao hospede.
  * 
  * @param - numeroDoCartao Numero do cartao de credito
  * @throws - InputArgumentInvalidException
  */

  public void setNumeroDoCartao( String numeroDoCartao ) throws InputArgumentInvalidException {
    verificaCartao(numeroDoCartao);
    this.numeroDoCartao = numeroDoCartao;
  }

  /**
  * Atribui um novo numero de telefone ao hospede.
  * 
  * @param - telefone Numero de telefone do hospede
  */

  public void setTelefone( Telefone telefone ) {
    this.telefone = telefone;
  }

  /**
  * Recupera o e-mail do hospede.
  * 
  * @return - E-mail do hospede.
  */

  public String getEmail() {
    return email;
  }

  /**
  * Atribui um novo e-mail ao hospede.
  * 
  * @param email - E-mail para contato.
  * @throws - InputArgumentInvalidException
  */

  public void setEmail( String email ) throws InputArgumentInvalidException {
    verificaEmail(email);
    this.email = email;
  }

  /**
  * recupera o endereco do hospede.
  * 
  * @return Endereco -  Objeto com todos os dados referentes ao endereco do hospede.
  */

  public Endereco getEndereco() {
    return endereco;
  }

  /**
  * Atribui um novo endereco ao hospede.
  * 
  * @param Endereco - Todas as informacoes do endereco do hospede.
  */

  public void setEndereco( Endereco endereco ) {
    this.endereco = endereco;
  }

  /**
  * Recupera o nome do hospede.
  * 
  * @return - Nome do hospede.
  */

  public String getNome() {
    return nome;
  }

  /**
  * Atribui um novo nome ao hospede.
  * 
  * @param nome - Nome do hospede.
  * @throws - InputArgumentInvalidException.
  */

  public void setNome( String nome ) throws InputArgumentInvalidException {
    verificaNome(nome);
    this.nome = nome;
  }

  /**
  * Recupera o cpf do hospede.
  * 
  * @return - Retorna o cpf do hospede.
  */

  public String getCpf() {
    return cpf;
  }

  /**
  * Atribui um novo cpf ao hospede.
  * 
  * @param cpf - Numero do cpf do Hospede.
  * @throws - InputArgumentInvalidException.
  */

  public void setCpf(String cpf) throws InputArgumentInvalidException {
    verificaCpf(cpf);
    this.cpf = cpf;
  }

  /**
  * Representacao do hospede em uma string.
  * 
  * @return String - Representacao do hospede.
  */

  @Override
  public String toString() {
    return "- Nome: " + nome + "\n" + "- Endereco: \n" + endereco.toString() + "\n"
        + "- CPF: " + cpf + "\n- Telefone: " + telefone + "\n"
        + "- Numero do Cartao: " + numeroDoCartao + "\n" + "- E-Mail: " + email;
  }

  /**
  * Verifica igualdade entre dois hospedes.
  * 
  * @return boolean - True se os hospede forem iguais, false caso contrario.
  *
  */

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Hospede)) {
      return false;
    }
   
    Hospede novoHospede = (Hospede)obj;

    return ( nome.equals(novoHospede.getNome()) && cpf == novoHospede.getCpf() );
  }
}