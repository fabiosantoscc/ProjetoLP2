package testes;

import org.junit.Test;
import org.junit.Assert;

import classes.QuartoLuxoTriplo;

import org.junit.Before;

import classes.Hotel;
import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;

/*
 * Classe de testes da classe QuartoExecutivoTriplo
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima alteracao: 08/02/2015 / Fabio Alexandre
 *
 */

public class QuartoLuxoTriploTest {
	
	QuartoLuxoTriplo q1;
	QuartoLuxoTriplo q2;
	
	@Before
	public void criaObjetos() throws Exception {
		q1 = new QuartoLuxoTriplo(2);
		q2 = new QuartoLuxoTriplo(3);
	}
	
	@Test
	public void testConstrutor() throws Exception {

		try {
			new QuartoLuxoTriplo(4);
			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoLuxoTriplo(0);
			Assert.fail("Esperava excecao, o quarto esta vazio");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoLuxoTriplo(-2);
			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		new QuartoLuxoTriplo(2);
	}
		
	@Test
	public void testGetPreco() {
		Assert.assertTrue(q1.getPreco() == 620.0);
		Assert.assertTrue(q2.getPreco() == 620.0);
	}
		
	@Test
	public void testGetQuantidadePessoas() {
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 2);
		Assert.assertTrue(q2.getQuantidadeDePessoas() == 3);
	}
	
	@Test
	public void testSetQuantidadePessoas() throws QuantidadeDePessoasInvalidaException {
		q1.setQuantidadeDePessoas(2);
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 2);
		
		q1.setQuantidadeDePessoas(3);
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 3);
	}
	    
	@Test
	public void testToString() {
		Assert.assertEquals(q1.toString(), "Quarto Luxo Triplo "
			+ "[ Valor diaria = R$ 620.0, Quantidade De Pessoas = 2 ]");
		Assert.assertEquals(q2.toString(), "Quarto Luxo Triplo "
			+ "[ Valor diaria = R$ 620.0, Quantidade De Pessoas = 3 ]");
	}
		
	@Test
	public void testEquals() throws QuantidadeDePessoasInvalidaException {
		Assert.assertFalse(q1.equals(q2));
		q2.setQuantidadeDePessoas(2);
		Assert.assertTrue(q1.equals(q2));
	}
	
	@Test
	public void testImpossivelCriarMaisQuartos() throws Exception {
		
		Assert.assertTrue(Hotel.getQuartoLuxoTriplo() == 5);
		new QuartoLuxoTriplo(3);
		Assert.assertTrue(Hotel.getQuartoLuxoTriplo() == 4);
		new QuartoLuxoTriplo(1);
		Assert.assertTrue(Hotel.getQuartoLuxoTriplo() == 3);
		new QuartoLuxoTriplo(2);
		Assert.assertTrue(Hotel.getQuartoLuxoTriplo() == 2);
		new QuartoLuxoTriplo(3);
		Assert.assertTrue(Hotel.getQuartoLuxoTriplo() == 1);
		new QuartoLuxoTriplo(1);
		Assert.assertTrue(Hotel.getQuartoLuxoTriplo() == 0);
		
		try {
			new QuartoLuxoTriplo(2);
			Assert.fail("Deveria lancar excecao, nao pode criar mais quartos");
		} catch ( QuartoEsgotadoNoHotelException e ) {
			Assert.assertEquals("Nao ha mais quartos livres", e.getMessage());
		}
	}
}

