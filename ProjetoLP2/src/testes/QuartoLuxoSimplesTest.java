package testes;

import org.junit.Test;
import org.junit.Assert;

import classes.Hotel;
import classes.QuartoLuxoSimples;

public class QuartoLuxoSimplesTest {

	@Test
	public void testTudo() throws Exception {
			
		QuartoLuxoSimples q1 = new QuartoLuxoSimples(3, 0);
		Assert.assertTrue(Hotel.getQuartoLuxoSimples() == 4);
		
		QuartoLuxoSimples q2 = new QuartoLuxoSimples(2, 0);
		Assert.assertTrue(Hotel.getQuartoLuxoSimples() == 3);
		
		//Test construtor
		
		try {
			new QuartoLuxoSimples(5, 0);
			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoLuxoSimples(0, 1);
			Assert.fail("Esperava excecao, o quarto esta vazio");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoLuxoSimples(-2, 2);
			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		new QuartoLuxoSimples(1, 2);
		Assert.assertTrue(Hotel.getQuartoLuxoSimples() == 2);
		
		new QuartoLuxoSimples(3, 1);
		Assert.assertTrue(Hotel.getQuartoLuxoSimples() == 1);
		
		new QuartoLuxoSimples(2, 0);
		Assert.assertTrue(Hotel.getQuartoLuxoSimples() == 0);
		
		try {
			new QuartoLuxoSimples(3, 0);
		} catch ( Exception e ) {
			Assert.assertEquals("Nao ha mais quartos livres", e.getMessage());
		}
		
		//Test getPreco()
		
		Assert.assertTrue(q1.getPreco() == 520.0);
		Assert.assertTrue(q2.getPreco() == 520.0);
		
		//Test getQuantidadePessoas()
		
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 3);
		Assert.assertTrue(q2.getQuantidadeDePessoas() == 2);
		
		//Test setQuantidadePessoas()
		
	    q1.setQuantidadeDePessoas(2);
	    Assert.assertTrue(q1.getQuantidadeDePessoas() == 2);
		
	    q2.setQuantidadeDePessoas(1);
	    Assert.assertTrue(q2.getQuantidadeDePessoas() == 1);
	    
	    // Test getCamaExtra()
	    
	    Assert.assertTrue(q1.getCamaExtra() == 0);
	    Assert.assertTrue(q2.getCamaExtra() == 0);
	    
		// Test setCamaExtra()
	    
	    q1.setCamaExtra(5);
	    Assert.assertTrue(q1.getCamaExtra() == 5);
	    q2.setCamaExtra(5);
	    Assert.assertTrue(q1.getCamaExtra() == 5);
	    
	    try {
	    	q1.setCamaExtra(6);
	    	Assert.fail("Deveria lancar excecao, quantidade de camas extras invalida");
	    } catch ( Exception e ) {
	    	Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
	    }
	    
	    //Test toString()
		
		Assert.assertEquals(q1.toString(), "Quarto Luxo Simples "
				+ "[ Valor diaria = R$ 520.0, Quantidade De Pessoas = 2, Camas Extras = 5 ]");
		Assert.assertEquals(q2.toString(), "Quarto Luxo Simples "
				+ "[ Valor diaria = R$ 520.0, Quantidade De Pessoas = 1, Camas Extras = 5 ]");
		
		//Test equals()
		
		Assert.assertFalse(q1.equals(q2));
		q2.setQuantidadeDePessoas(2);
		Assert.assertTrue(q1.equals(q2));
	}
}

