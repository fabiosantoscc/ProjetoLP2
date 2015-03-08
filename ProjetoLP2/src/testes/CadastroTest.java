package testes;

import classes.Cadastro;
import classes.Opiniao;
import excecoes.InputArgumentInvalidException;
import excecoes.StringInvalidaException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class CadastroTest {

  Cadastro cadastro1;
  Cadastro cadastro2;

  @Before
  public void criaObjetos() throws StringInvalidaException {
    cadastro1 = new Cadastro("123", "Fabio", "fabiosantos", "fabio123");
    cadastro2 = new Cadastro("pinDoGerente", "Fulano", "FulanoDeTal", "fulano321");
  }

  @Test
  public void testConstrutor() {
	  try {
		  new Cadastro("123", "fabio", "fabioasaadad", "123456");
	  } catch ( StringInvalidaException e ) {
		  Assert.fail("Nao deve lancar excecao, o construtor eh valido.");
	  }
	  
	  try {
		  new Cadastro("123", null, "fabioasaadad", "123456");
		  Assert.fail("Deve lancar excecao pois o nome eh invalido.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Nome nao pode ser vazio.", e.getMessage());
	  }
	  
	  try {
		  new Cadastro("123", "", "fabioasaadad", "123456");
		  Assert.fail("Deve lancar excecao pois o nome eh invalido.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Nome nao pode ser vazio.", e.getMessage());
	  }
	  
	  try {
		  new Cadastro("123", "fabio", null, "123456");
		  Assert.fail("Deve lancar excecao pois o nome do login eh invalido.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Nome de login nao pode ser vazio.", e.getMessage());
	  }
	  
	  try {
		  new Cadastro("123", "fabio", "", "123456");
		  Assert.fail("Deve lancar excecao pois o nome do login eh invalido.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Nome de login nao pode ser vazio.", e.getMessage());
	  }
	  
	  try {
		  new Cadastro("123", "fabio", "fabioa@#$", null);
		  Assert.fail("Deve lancar excecao pois a senha eh invalido.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Senha nao pode ser vazia.", e.getMessage());
	  }
	  
	  try {
		  new Cadastro("123", "fabio", "fabioa@#$", "");
		  Assert.fail("Deve lancar excecao pois a senha eh invalido.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Senha nao pode ser vazia.", e.getMessage());
	  }
  }
  
  @Test
  public void TestaGetters() {
	  Assert.assertTrue(cadastro1.getNome().equals("Fabio"));
	  Assert.assertTrue(cadastro2.getNome().equals("Fulano"));
	  Assert.assertTrue(cadastro1.getNomeLogin().equals("fabiosantos"));
	  Assert.assertTrue(cadastro2.getNomeLogin().equals("FulanoDeTal"));
	  Assert.assertTrue(cadastro1.getSenha().equals("fabio123"));
	  Assert.assertTrue(cadastro2.getSenha().equals("fulano321"));
	  Assert.assertTrue(cadastro1.getPin().equals("123"));
	  Assert.assertTrue(cadastro2.getPin().equals("pinDoGerente"));
  }
  
  @Test
  public void TestaSetters() {
	  try {
		  cadastro1.setNome("boy");
	  } catch ( StringInvalidaException e ) {
		  Assert.fail("Nao deve lancar excecao, pois o nome eh valido.");
	  }
	  
	  try {
		  cadastro1.setNome(null);
		  Assert.fail("Deve lancar excecao, pois o nome eh invalido.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Nome nao pode ser vazio.", e.getMessage());
	  }
	  
	  try {
		  cadastro1.setNome("");
		  Assert.fail("Deve lancar excecao, pois o nome eh invalido.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Nome nao pode ser vazio.", e.getMessage());
	  }
	  
	  try {
		  cadastro1.setNome(null);
		  Assert.fail("Deve lancar excecao, pois o nome eh invalido.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Nome nao pode ser vazio.", e.getMessage());
	  }
	  
	  try {
		  cadastro1.setNomeLogin("Boy123");
	  } catch ( StringInvalidaException e ) {
		  Assert.fail("Nao deve lancar excecao, pois o nome de login eh valido.");
	  }
	  
	  try {
		  cadastro1.setNomeLogin(null);
		  Assert.fail("Deve lancar excecao, pois o nome de login eh invalido.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Nome de login nao pode ser vazio.", e.getMessage());
	  }
	  
	  try {
		  cadastro1.setNomeLogin("");
		  Assert.fail("Deve lancar excecao, pois o nome de login eh invalido.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Nome de login nao pode ser vazio.", e.getMessage());
	  }
	  
	  try {
		  cadastro1.setSenha("fabio123", "fabio1");;
	  } catch ( StringInvalidaException e ) {
		  Assert.fail("Nao deve lancar excecao, pois a senha antiga eh correta"
		  		+ " e a senha atual eh valida.");
	  }
	  
	  try {
		  cadastro1.setSenha("fabio12", "fabio1");
		  Assert.fail("Deve lancar excecao, pois a senha antiga eh incorreta.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Senhas nao coincidentes.", e.getMessage());
	  }
	  
	  try {
		  cadastro1.setSenha("fabio123", null);
		  Assert.fail("Deve lancar excecao, pois a nova senha eh invalida.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Senha nao pode ser vazia.", e.getMessage());
	  }
	  
	  try {
		  cadastro1.setSenha("fabio123", "");
		  Assert.fail("Deve lancar excecao, pois a nova senha eh invalida.");
	  } catch ( StringInvalidaException e ) {
		  Assert.assertEquals("Senha nao pode ser vazia.", e.getMessage());
	  }
  }
  
  @Test
  public void TestaToString() {
	  Assert.assertEquals("Cadastro [ Nome: Fabio, Nome de login: fabiosantos, Senha: fabio123 ]", cadastro1.toString());
	  Assert.assertEquals("Cadastro [ Nome: Fulano, Nome de login: FulanoDeTal, Senha: fulano321 ]", cadastro2.toString());
  }
  
  @Test
  public void TestaHashCode() throws StringInvalidaException {
	  Assert.assertFalse(cadastro1.hashCode() == cadastro2.hashCode());
	  cadastro2.setNome("Fabio");
	  cadastro2.setNomeLogin("fabiosantos");
	  cadastro2.setSenha("fulano321", "fabio123");
	  Assert.assertTrue(cadastro2.hashCode() == cadastro1.hashCode());
  }
  
  @Test
  public void TestaEquals() throws InputArgumentInvalidException {
	  Opiniao op = new Opiniao("Bom", 10);
	  Assert.assertFalse(cadastro1.equals(op));
	  Assert.assertFalse(cadastro1.equals(cadastro2));
	  cadastro2.setNome("Fabio");
	  cadastro2.setNomeLogin("fabiosantos");
	  cadastro2.setSenha("fulano321", "fabio123");
	  Assert.assertTrue(cadastro1.equals(cadastro2));
	  cadastro1.setNome("FabiO");
	  Assert.assertFalse(cadastro1.equals(cadastro2));
	  cadastro1.setNome("Fabio");
	  cadastro1.setNomeLogin("fabiosants");
	  Assert.assertFalse(cadastro1.equals(cadastro2));
	  cadastro1.setNomeLogin("fabiosantos");
	  cadastro1.setSenha("fabio123", "outraSenha");
	  Assert.assertFalse(cadastro1.equals(cadastro2));
  }
}
