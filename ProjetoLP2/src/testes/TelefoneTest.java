package testes;

import classes.QuartoPresidencial;
import classes.Telefone;
import excecoes.DddInvalidoException;
import excecoes.InputArgumentInvalidException;
import excecoes.NumeroTelefoneInvalidoException;
import excecoes.QuartoEsgotadoNoHotelException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

 /**Classe de testes da classe telefone.
  * Author: Ravi Lopes
  * Ultima revisao: 07/03/2015 / Fabio Alexandre
  */

public class TelefoneTest {

  Telefone telefone;

  @Before
  public void criaObjetos() throws InputArgumentInvalidException {
    telefone = new Telefone("83", "99999999");
  }

  @Test
  public void testaConstrutor() throws InputArgumentInvalidException {
    
    try {
      new Telefone("83", "99999999");
    } catch ( InputArgumentInvalidException e ) {
      Assert.assertEquals(e.getMessage(), "Esse prompt nao deve ser mostrado "
            + "caso seu construtor esteja correto.");
    }

    try {
      new Telefone("83", "999999999");
    } catch ( InputArgumentInvalidException e ) {
      Assert.assertEquals("Esse prompt nao deve ser mostrado caso seu construtor esteja correto.",
          e.getMessage());
    }

    try {
      new Telefone(null, "999999999");
    } catch ( InputArgumentInvalidException e ) {
      Assert.assertEquals("DDD nao pode ser vazio.", e.getMessage());
    }
    
    try {
      new Telefone("", "999999999");
    } catch ( InputArgumentInvalidException e ) {
      Assert.assertEquals("DDD nao pode ser vazio.", e.getMessage());
    }
    
    try {
      new Telefone("83", null);
      Assert.fail("Esperava excecao pois o numero de telefone esta invalido.");
    } catch ( NumeroTelefoneInvalidoException e ) {
      Assert.assertEquals("Numero de telefone nao pode ser vazio.", e.getMessage());
    }
    
    try {
      new Telefone("83", "");
      Assert.fail("Esperava excecao pois o numero de telefone esta invalido.");
    } catch ( NumeroTelefoneInvalidoException e ) {
      Assert.assertEquals("Numero de telefone nao pode ser vazio.", e.getMessage());
    }
        
    try {
      new Telefone("83", "0");
      Assert.fail("Esperava excecao pois o numero de telefone esta invalido.");
    } catch ( NumeroTelefoneInvalidoException e ) {
      Assert.assertEquals("Quantidade de digitos do telefone invalida.", e.getMessage());
    }

    try {
      new Telefone("83", "1234567890");
      Assert.fail("Esperava excecao pois o numero de telefone esta invalido.");
    } catch ( NumeroTelefoneInvalidoException e ) {
      Assert.assertEquals("Quantidade de digitos do telefone invalida.", e.getMessage());
    }

    try {
      new Telefone("043", "99999999");
      Assert.fail("Esperava excecao pois o numero do ddd esta invalido.");
    } catch ( DddInvalidoException e ) {
      Assert.assertEquals("Quantidade de digitos do DDD invalida.", e.getMessage());
    }

    try {
      new Telefone("83", "199999999");
      Assert.fail("Esperava excecao pois o primeiro digito esta invalido.");
    } catch ( NumeroTelefoneInvalidoException e ) {
      Assert.assertEquals("Primeiro digito do telefone deve ser 9 (nove).", e.getMessage());
    }

    try {
      new Telefone("-3", "99999999");
      Assert.fail("Esperava excecao pois o ddd eh negativo.");
    } catch ( DddInvalidoException e ) {
      Assert.assertEquals("DDD deve conter apenas digitos.", e.getMessage());
    }

    try {
      new Telefone("73", "-9999999");
      Assert.fail("Esperava excecao pois o numero do telefone eh negativo.");
    } catch ( Exception e ) {
      Assert.assertEquals("O Numero do telefone deve conter apenas digitos.", e.getMessage());
    }
  }

  @Test
  public void testaSetters() throws InputArgumentInvalidException {

    try {
      telefone.setNumero("9999999");
      Assert.fail("Esperava excecao pois o numero do telefone esta invalido.");
    } catch ( NumeroTelefoneInvalidoException e ) {
      Assert.assertEquals("Quantidade de digitos do telefone invalida.", e.getMessage());
    }

    try {
      telefone.setNumero("1234567890");
      Assert.fail("Esperava excecao pois o numero do telefone esta invalido.");
    } catch ( NumeroTelefoneInvalidoException e ) {
      Assert.assertEquals("Quantidade de digitos do telefone invalida.", e.getMessage());
    }

    try {
      telefone.setNumero("99999999");
    } catch ( InputArgumentInvalidException e ) {
      Assert.assertEquals("Esse prompt nao deve ser mostrado caso seu construtor esteja correto.",
            e.getMessage());
    }

    try {
      telefone.setNumero("999999999");
    } catch ( InputArgumentInvalidException e ) {
      Assert.assertEquals("Esse prompt nao deve ser mostrado caso seu metodo esteja correto.",
            e.getMessage());
    }

    try {
      telefone.setNumero("-8888888");
    } catch ( NumeroTelefoneInvalidoException e ) {
      Assert.assertEquals("O Numero do telefone deve conter apenas digitos.", e.getMessage());
    }

    try {
      telefone.setDdd("0");
      Assert.fail("Esperava excecao pois o numero do ddd esta invalido.");
    } catch ( DddInvalidoException e ) {
      Assert.assertEquals("Quantidade de digitos do DDD invalida.", e.getMessage());
    }

    try {
      telefone.setDdd("83");
    } catch ( Exception e ) {
      Assert.assertEquals("Esse prompt nao deve ser mostrado caso seu metodo esteja correto.",
            e.getMessage());
    }

    try {
      telefone.setDdd("-3");
    } catch ( DddInvalidoException e ) {
      Assert.assertEquals("DDD deve conter apenas digitos.", e.getMessage());
    }
  }

  @Test
  public void testaGetters() {
    Assert.assertTrue("83".equals(telefone.getDdd()));
    Assert.assertFalse("81".equals(telefone.getDdd()));
    Assert.assertTrue("99999999".equals(telefone.getNumero()));
    Assert.assertFalse("12345678".equals(telefone.getNumero()));
  }

  @Test
  public void testaToString() {
    Assert.assertEquals(telefone.toString(),"(83) 99999999");
  }

  @Test
  public void testaHashCode() throws InputArgumentInvalidException {
    Telefone novoTelefone = new Telefone("83", "99999998");
    Assert.assertFalse(telefone.hashCode() == novoTelefone.hashCode());
    novoTelefone.setNumero("99999999");
    Assert.assertTrue(telefone.hashCode() == novoTelefone.hashCode());
  }
  
  @Test
  public void testaEquals() throws InputArgumentInvalidException, QuartoEsgotadoNoHotelException {
    QuartoPresidencial qp = new QuartoPresidencial(2);
    Telefone novoTelefone = new Telefone("83", "99999998");
    Assert.assertFalse(telefone.equals(novoTelefone));
    Assert.assertFalse(novoTelefone.equals(qp));
    novoTelefone.setNumero("99999999");
    Assert.assertTrue(telefone.equals(novoTelefone));
  }
}