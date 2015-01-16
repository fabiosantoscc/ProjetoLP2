package testes;

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;
import classes.Hotel;
import classes.QuartoExecutivoTriplo;

/**
 * Classe de testes da classe QuartoExecutivoTriplo
 * 
 * @author Fabio Alexandre Santos Silva Junior
 *
 */

public class QuartoExecutivoTriploTest {
	
	QuartoExecutivoTriplo q1;
	QuartoExecutivoTriplo q2;
	
	@Before
	public void criaObjetos() throws Exception {
		q1 = new QuartoExecutivoTriplo(2);
		q2 = new QuartoExecutivoTriplo(3);
	}
	
	@Test
	public void testConstrutor() throws Exception {
				
		try {
			new QuartoExecutivoTriplo(4);
			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoExecutivoTriplo(0);
			Assert.fail("Esperava excecao, o quarto esta vazio");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoExecutivoTriplo(-2);
			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		new QuartoExecutivoTriplo(2);
	}
		
	@Test
	public void testGetPreco() {
		Assert.assertTrue(q1.getPreco() == 440.0);
		Assert.assertTrue(q2.getPreco() == 440.0);
	}
		
	@Test
	public void testGetQuantidadePessoas() {
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 2);
		Assert.assertTrue(q2.getQuantidadeDePessoas() == 3);
	}
	
	@Test
	public void testSetQuantidadePessoas() {
		q1.setQuantidadeDePessoas(2);
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 2);
		
		q1.setQuantidadeDePessoas(3);
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 3);
	}
	    
	@Test
	public void testToString() {
		Assert.assertEquals(q1.toString(), "Quarto Executivo Triplo "
			+ "[ Valor diaria = R$ 440.0, Quantidade De Pessoas = 2 ]");
		Assert.assertEquals(q2.toString(), "Quarto Executivo Triplo "
			+ "[ Valor diaria = R$ 440.0, Quantidade De Pessoas = 3 ]");
	}
		
	@Test
	public void testEquals() {
		Assert.assertFalse(q1.equals(q2));
		q2.setQuantidadeDePessoas(2);
		Assert.assertTrue(q1.equals(q2));
	}
	
	@Test
	public void testImpossivelCriarMaisQuartos() throws Exception {
		
		Assert.assertTrue(Hotel.getQuartoExecutivoTriplo() == 5);
		new QuartoExecutivoTriplo(3);
		Assert.assertTrue(Hotel.getQuartoExecutivoTriplo() == 4);
		new QuartoExecutivoTriplo(1);
		Assert.assertTrue(Hotel.getQuartoExecutivoTriplo() == 3);
		new QuartoExecutivoTriplo(2);
		Assert.assertTrue(Hotel.getQuartoExecutivoTriplo() == 2);
		new QuartoExecutivoTriplo(3);
		Assert.assertTrue(Hotel.getQuartoExecutivoTriplo() == 1);
		new QuartoExecutivoTriplo(1);
		Assert.assertTrue(Hotel.getQuartoExecutivoTriplo() == 0);
		
		try {
			new QuartoExecutivoTriplo(2);
			Assert.fail("Deveria lancar excecao, nao pode criar mais quartos");
		} catch ( Exception e ) {
			Assert.assertEquals("Nao ha mais quartos livres", e.getMessage());
		}
	}
}