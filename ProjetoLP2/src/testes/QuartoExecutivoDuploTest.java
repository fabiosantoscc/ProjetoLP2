package testes;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import classes.Hotel;
import classes.QuartoExecutivoDuplo;

public class QuartoExecutivoDuploTest {

	QuartoExecutivoDuplo q1;
	QuartoExecutivoDuplo q2;
	
	@Before
	public void criaObjetos() throws Exception {
		q1 = new QuartoExecutivoDuplo(2, 0);
	}
	
	@Test
	public void testConstrutor() throws Exception {
				
		Assert.assertTrue(Hotel.getCamaExtra() == 10);
		
		try {
			new QuartoExecutivoDuplo(4, 1);
			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoExecutivoDuplo(0, 2);
			Assert.fail("Esperava excecao, o quarto esta vazio");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoExecutivoDuplo(-2, 0);
			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoExecutivoDuplo(2, -2);
			Assert.fail("Esperava excecao, pois a quantidade de quartos e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
		}
		
		try {
			new QuartoExecutivoDuplo(2, 11);
			Assert.fail("Esperava excecao, pois a quantidade de quartos e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
		}
		
		Assert.assertTrue(Hotel.getCamaExtra() == 10);
	}
		
	@Test
	public void testGetPreco() {
		Assert.assertTrue(q1.getPreco() == 385.0);
	}
		
	@Test
	public void testGetQuantidadePessoas() {
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 2);
	}
	
	@Test
	public void testSetQuantidadePessoas() {
		q1.setQuantidadeDePessoas(1);
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 1);
		
		q1.setQuantidadeDePessoas(3);
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 3);
	}
	
	@Test
	public void testGetCamaExtra() {
		Assert.assertTrue(q1.getCamaExtra() == 0);
	}
	
	@Test
	public void testSetCamaExtra() {
		try {
			q1.setCamaExtra(-1);
			Assert.fail("Esperava excecao, quantidade de camas invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
		}
		
		try {
			q1.setCamaExtra(11);
			Assert.fail("Esperava excecao, quantidade de camas invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
		}
		
		q1.setCamaExtra(2);
		Assert.assertTrue(q1.getCamaExtra() == 2);
	}
	    
	@Test
	public void testToString() {
		Assert.assertEquals(q1.toString(), "Quarto Executivo Duplo "
			+ "[ Valor diaria = R$ 385.0, Quantidade De Pessoas = 2, Camas Extras = 0 ]");
	}
		
	@Test
	public void testEquals() throws Exception {
		QuartoExecutivoDuplo q2 = new QuartoExecutivoDuplo(3, 0);
		Assert.assertFalse(q1.equals(q2));
		q2.setQuantidadeDePessoas(2);
		Assert.assertTrue(q1.equals(q2));
	}
	
//	@Test
//	public void testImpossivelCriarMaisQuartos() throws Exception {
//		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 5);
//		new QuartoExecutivoDuplo(3, 0);
//		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 4);
//		new QuartoExecutivoDuplo(1, 0);
//		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 3);
//		new QuartoExecutivoDuplo(2, 0);
//		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 2);
//		new QuartoExecutivoDuplo(1, 0);
//		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 1);
//		new QuartoExecutivoDuplo(1, 0);
//		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 0);
//	}
	
	@Test
	public void testImpossivelCamaExtra() throws Exception {
		Assert.assertTrue(Hotel.getCamaExtra() == 10);
		q1.setCamaExtra(5);
		
		try {
			q2 = new QuartoExecutivoDuplo(2, 6);
			Assert.fail("Deve lancar excecao, quantidade de camas invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
		}
	}
}	
