package classes;

import excecoes.PinInvalidoException;
import excecoes.SenhasNaoCoincidentesException;

public class Cadastro {

  private String nome;
  private String nomeLogin;
  private String senha;

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

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNomeLogin() {
    return nomeLogin;
  }

 public void setNomeLogin(String nomeLogin) {
   this.nomeLogin = nomeLogin;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senhaAntiga, String novaSenha) {
    if ( senhaAntiga.equals(getSenha()) ) {
      this.senha = novaSenha;
    }
  }
  
  @Override
  public String toString() {
    return "";
  }
  
  @Override
  public boolean equals( Object obj ) {
	  return false;
  }
}