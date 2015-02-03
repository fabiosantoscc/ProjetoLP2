package testes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import excecoes.DddInvalidoException;
import excecoes.NumeroTelefoneInvalidoException;

import classes.Telefone;

/** Classe de testes da classe telefone
 *
 * Author: Ravi Lopes
 * 
 * Ultima revisao: 30/01/2015 / Jaaziel Moura
 */


public class TelefoneTest {
	
	Telefone telefone;
	
	@Before
	public void criaObjetos() throws Exception {
		telefone = new Telefone(83, 99999999);
	}
	
	@Test
	public void testaConstrutor() throws Exception {
		try {
			new Telefone(83, 99999999);
		} catch ( Exception e ) {
			Assert.assertEquals("Esse prompt nao deve ser mostrado caso seu construtor esteja correto.", e.getMessage());
		}
		
		try {
			new Telefone(83, 999999999);
		} catch ( Exception e ) {
			Assert.assertEquals("Esse prompt nao deve ser mostrado caso seu construtor esteja correto.", e.getMessage());
		}
		
		try {
			new Telefone(83, 0);
			Assert.fail("Esperava excecao pois o numero de telefone esta invalido.");
		} catch ( NumeroTelefoneInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos invalida.", e.getMessage());
		}
		
		try {
			new Telefone(83, 1234567890);
			Assert.fail("Esperava excecao pois o numero de telefone esta invalido.");
		} catch ( NumeroTelefoneInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos invalida.", e.getMessage());
		}
		
		try {
			new Telefone(0, 99999999);
			Assert.fail("Esperava excecao pois o numero do ddd esta invalido.");
		} catch ( DddInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos invalida.", e.getMessage());
		}
		
		try {
			new Telefone(83, 199999999);
			Assert.fail("Esperava excecao pois o primeiro digito esta invalido.");
		} catch ( Exception e ) {
			Assert.assertEquals("Primeiro digito deve ser 9(nove).", e.getMessage());
		}
	}
	
	@Test
	public void testaSetters() throws Exception {
		try {
			telefone.setNumero(9999999);
			Assert.fail("Esperava excecao pois o numero do telefone esta invalido.");
		} catch ( NumeroTelefoneInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos invalida.", e.getMessage());
		}
		
		try {
			telefone.setNumero(1234567890);
			Assert.fail("Esperava excecao pois o numero do telefone esta invalido.");
		} catch ( NumeroTelefoneInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos invalida.", e.getMessage());
		}
		
		try {
			telefone.setNumero(99999999);
		} catch ( Exception e ) {
			Assert.assertEquals("Esse prompt nao deve ser mostrado caso seu construtor esteja correto.", e.getMessage());
		}
		
		try {
			telefone.setNumero(999999999);
		} catch ( Exception e ) {
			Assert.assertEquals("Esse prompt nao deve ser mostrado caso seu metodo esteja correto.", e.getMessage());
		}
		
		try {
			telefone.setDdd(0);
			Assert.fail("Esperava excecao pois o numero do ddd esta invalido.");
		} catch ( DddInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos invalida.", e.getMessage());
		}
		
		try {
			telefone.setDdd(83);
		} catch ( Exception e ) {
			Assert.assertEquals("Esse prompt nao deve ser mostrado caso seu metodo esteja correto.", e.getMessage());
		}
	}
	
	@Test
	public void testaGetters() {
		Assert.assertTrue(83 == telefone.getDdd());
		Assert.assertFalse(81 == telefone.getDdd());
		Assert.assertTrue(99999999 == telefone.getNumero());
		Assert.assertFalse(12345678 == telefone.getNumero());
	}
	
	@Test
	public void testaToString(){
		Assert.assertEquals(telefone.toString(),"Numero: (83) 99999999");
	}
	
	@Test
	public void testaEquals() throws Exception {
		Telefone novoTelefone = new Telefone(83, 99999998);
		Assert.assertFalse(telefone.equals(novoTelefone));
		novoTelefone.setNumero(99999999);
		Assert.assertTrue(telefone.equals(novoTelefone));
	}
}