package classes;

import java.io.Serializable;

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
  */
  
  public Cadastro(String pin, String nome, String nomeLogin, String senha ) {

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
  */

  public void setNome(String nome) {
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
  */

  public void setNomeLogin(String nomeLogin) {
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
  */

  public void setSenha(String senhaAntiga, String novaSenha) {
    if ( senhaAntiga.equals(getSenha()) ) {
      this.senha = novaSenha;
    }
  }
  
  /**
   * Recupera o pin de verificacao do cadastro.
   * 
   * @return String - Pin do cadastro.
   */
  
  public String getPin() {
    return pin;
  }

  /**
  * Retorna a representacao de um cadastro.
  * 
  * @return String - Representacao do cadastro.
  */

  @Override
  public String toString() {
    return "";
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