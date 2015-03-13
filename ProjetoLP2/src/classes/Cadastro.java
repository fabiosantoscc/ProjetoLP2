package classes;

import excecoes.StringInvalidaException;

import java.io.Serializable;

  /**
  * Classe que representa um cadastro.
  * 
  * @author Fabio Alexandre
  * @since 08/03/2015
  *
  */

public class Cadastro implements Serializable {

  private static final long serialVersionUID = 1L;
  private String nome;
  private String nomeLogin;
  private String senha;
  private String pin;

  /**
  * Construtor de um cadastro.
  * 
  * @param pin - Pin de confirmacao do cadastro.
  * @param nome - Nome do Usuario.
  * @param nomeLogin - Nome usado para login.
  * @param senha - senha do cadastro.
  * @throws StringInvalidaException 
  */
  
  public Cadastro(String pin, String nome, String nomeLogin, String senha )
      throws StringInvalidaException {

    verificaNome(nome);
    verificaNomeLogin(nomeLogin);
    verificaSenha(senha);

    this.pin = pin;
    this.nome = nome;
    this.nomeLogin = nomeLogin;
    this.senha = senha;
  }

  /**
  * Recupera o nome do usuario do cadastro.
  * 
  * @return String - nome do usuario.
  */

  public String getNome() {
    return nome;
  }

  /**
  * Atribui um novo nome ao usuario do cadastro.
  * 
  * @param nome - Novo nome.
  * @throws StringInvalidaException 
  */

  public void setNome(String nome) throws StringInvalidaException {
    verificaNome(nome);
    this.nome = nome;
  }

  /**
  * Recupera o nome de login do cadastro.
  * 
  * @return String - Nome de login.
  */

  public String getNomeLogin() {
    return nomeLogin;
  }

  /**
  * Atribui um novo nome de login ao usuario do cadastro.
  * 
  * @param nomeLogin - Novo nome de login.
  * @throws StringInvalidaException 
  */

  public void setNomeLogin(String nomeLogin) throws StringInvalidaException {
    verificaNomeLogin(nomeLogin);
    this.nomeLogin = nomeLogin;
  }

  /**
  * Recupera a senha atual do cadastro.
  * 
  * @return String - Senha do cadastro.
  */

  public String getSenha() {
    return senha;
  }

  /**
  * Atribui uma nova senha ao cadastro.
  * 
  * @param senhaAntiga - Senha atual do cadastro.
  * @param novaSenha - Nova senha do cadastro.
  * @throws StringInvalidaException 
  */

  public void setSenha(String senhaAntiga, String novaSenha) throws StringInvalidaException {
    
    verificaSenha(novaSenha);

    /*
    * Verifica se a senha antiga passada eh de fato verdadeira,
    * para poder atribuir uma nova senha.
    */

    if ( ! (senhaAntiga.equals(getSenha())) ) {
      throw new StringInvalidaException("Senhas nao coincidentes.");
    }
    
    this.senha = novaSenha;
  }
  
  /**
   * Recupera o pin de verificacao do cadastro.
   * 
   * @return String - Pin do cadastro.
   */
  
  public String getPin() {
    return pin;
  }

  /* 
   * Verifica se a senha eh valida, ou seja, se for igual a null ou
   * string vazia, lanca excecao de senha invalida. 
   * 
   */
  
  private void verificaSenha(String senha) throws StringInvalidaException {
    if ( senha == null || senha.equals("") ) {
      throw new StringInvalidaException("Senha nao pode ser vazia.");
    }
  }

  /*
   * Verifica se um nome de login eh valido, ou seja, eh diferente
   * de null e string vazia.
   */

  private void verificaNomeLogin(String nomeLogin) throws StringInvalidaException {
    if ( nomeLogin == null || nomeLogin.equals("")) {
      throw new StringInvalidaException("Nome de login nao pode ser vazio.");
    }
  }
  
  /*
   * Verifica se o nome eh valido, ou seja, eh diferente
   * de null e string vazia.
   */
  
  private void verificaNome(String nome) throws StringInvalidaException {
    if ( nome == null || nome.equals("")) {
      throw new StringInvalidaException("Nome nao pode ser vazio.");
    }
  }

  /**
  * Retorna a representacao de um cadastro.
  * 
  * @return String - Representacao do cadastro.
  */
  
  @Override
  public String toString() {
    return "Cadastro [ Nome: " + getNome() + ", Nome de login: " + getNomeLogin()
        + ", Senha: " + getSenha() + " ]";
  }

  /**
  * Metodo que compara dois cadastros por dois inteiros,
  * utiliza as mesmas variaveis do equals.
  * 
  * @return int - Valor pra comparar os objetos.
  */
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    result = prime * result + ((nomeLogin == null) ? 0 : nomeLogin.hashCode());
    result = prime * result + ((senha == null) ? 0 : senha.hashCode());

    return result;
  }  
  
  /**
  * Verifica se dois cadastros sao iguais.
  * 
  * @return boolean - True se dois cadastros forem iguais, false caso contrario.
  */

  @Override
  public boolean equals( Object obj ) {
    if ( !(obj instanceof Cadastro) ) {
      return false;
    }
  
    Cadastro cads = (Cadastro) obj;

    return nome.equals(cads.getNome())
        && nomeLogin.equals(cads.getNomeLogin())
        && senha.equals(cads.getSenha());
  }
}