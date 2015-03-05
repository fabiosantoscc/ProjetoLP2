package classes;

import java.io.Serializable;

import excecoes.PinInvalidoException;
import excecoes.SenhasNaoCoincidentesException;

public class Cadastro implements Serializable {

  private static final long serialVersionUID = 1L;
  private String nome;
  private String nomeLogin;
  private String senha;

  /**
  * Construtor de um cadastro.
  * 
  * @param pin
  * @param nome
  * @param nomeLogin
  * @param senha
  * @param confirmacaoSenha
  * @throws PinInvalidoException
  * @throws SenhasNaoCoincidentesException
  */
  
  public Cadastro(String pin, String nome, String nomeLogin, String senha,
      String confirmacaoSenha) throws PinInvalidoException, SenhasNaoCoincidentesException {
	  
	if ( !(pin.equals(Hotel.PIN)) ) {
      throw new PinInvalidoException("Pin de verificacao invalido.");
	}
    
    if ( !(senha.equals(confirmacaoSenha)) ) {
      throw new SenhasNaoCoincidentesException("Senhas nao coincidentes.");
    }

    this.nome = nome;
    this.nomeLogin = nomeLogin;
    this.senha = senha;
    
  }

  /**
  * 
  * @return
  */

  public String getNome() {
    return nome;
  }

  /**
  * 
  * @param nome
  */

  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
  * 
  * @return
  */

  public String getNomeLogin() {
    return nomeLogin;
  }

  /**
  * 
  * @param nomeLogin
  */

  public void setNomeLogin(String nomeLogin) {
   this.nomeLogin = nomeLogin;
  }

  /**
  * 
  * @return
  */

  public String getSenha() {
    return senha;
  }

  /**
  * 
  * @param senhaAntiga
  * @param novaSenha
  */

  public void setSenha(String senhaAntiga, String novaSenha) {
    if ( senhaAntiga.equals(getSenha()) ) {
      this.senha = novaSenha;
    }
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
	  return false;
  }
}