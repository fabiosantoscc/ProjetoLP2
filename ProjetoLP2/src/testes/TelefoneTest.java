package testes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import excecoes.DddInvalidoException;
import excecoes.NumeroTelefoneInvalidoException;

import classes.Telefone;

/* Classe de testes da classe telefone
 *
 * Author: Ravi Lopes
 * 
 * Ultima revisao: 07/01/2015 / Fabio Alexandre
 */


public class TelefoneTest {
	
	Telefone telefone;
	
	@Before
	public void criaObjetos() throws Exception {
		telefone = new Telefone(99999999, 87);
	}
	
	@Test
	public void testaConstrutor() throws Exception {
		try {
			new Telefone(99999999, 87);
		} catch ( Exception e ) {
			Assert.assertEquals("Esse prompt nao deve ser mostrado caso seu construtor"
					+ " esteja correto.", e.getMessage());
		}
		
		try {
			new Telefone(0, 87);
			Assert.fail("Esperava excecao pois o numero de telefone esta invalido.");
		} catch ( NumeroTelefoneInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos invalida.", e.getMessage());
		}
		
		try {
			new Telefone(1234567890, 87);
			Assert.fail("Esperava excecao pois o numero de telefone esta invalido.");
		} catch ( NumeroTelefoneInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos invalida.", e.getMessage());
		}
		
		try {
			new Telefone(99999999, 0);
			Assert.fail("Esperava excecao pois o numero do ddd esta invalido.");
		} catch ( DddInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos invalida.", e.getMessage());
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
			telefone.setDdd(0);
			Assert.fail("Esperava excecao pois o numero do ddd esta invalido.");
		} catch ( DddInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos invalida.", e.getMessage());
		}
	}
	
	@Test
	public void testaGetters() {
		Assert.assertTrue(87 == telefone.getDdd());
		Assert.assertTrue(99999999 == telefone.getNumero());
	}
	
	@Test
	public void testaToString(){
		Assert.assertEquals(telefone.toString(),"Numero: 87-99999999");
	}
	
	@Test
	public void testaEquals() throws Exception {
		Telefone novoTelefone = new Telefone(99999998,87);
		Assert.assertFalse(telefone.equals(novoTelefone));
		novoTelefone.setNumero(99999999);
		Assert.assertTrue(telefone.equals(novoTelefone));
	}
}