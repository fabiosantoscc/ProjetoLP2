package testes;

import org.junit.Test;
import org.junit.Assert;
import classes.Hotel;
import classes.QuartoExecutivoDuplo;
import excecoes.QuartoEsgotadoException;

/*
 * Classe de testes de um quarto luxo duplo, sem uso do before porque a quantidade de
 * criacao de objetos e limitada.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima alteracao: 26/01/2015
 */

public class QuartoExecutivoDuploTest {
	QuartoExecutivoDuplo q1;
	QuartoExecutivoDuplo q2;
	
	@Test
	public void testaTudo() throws Exception {
	
		q1 = new QuartoExecutivoDuplo(2, 0);
					
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
			
		// Test getPreco()
	
		Assert.assertTrue(q1.getPreco() == 385.0);
			
		// Test getQuantidadeDePessoas()
		
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 2);
		
		// Test setQuantidadeDePessoas()
		
		q1.setQuantidadeDePessoas(1);
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 1);
			
		q1.setQuantidadeDePessoas(3);
		Assert.assertTrue(q1.getQuantidadeDePessoas() == 3);
		
		// Test getCama()
		
		Assert.assertTrue(q1.getCamaExtra() == 0);
		
		// Test setCama()
	
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
		    
		// Test toString()
		
		Assert.assertEquals(q1.toString(), "Quarto Executivo Duplo "
			+ "[ Valor diaria = R$ 385.0, Quantidade De Pessoas = 3, Camas Extras = 2 ]");
			
		// Test equals()
		
		q2 = new QuartoExecutivoDuplo(3, 0);
		Assert.assertFalse(q1.equals(q2));
		q2.setCamaExtra(2);
		Assert.assertTrue(q1.equals(q2));
	
		// Test impossivelcriarquartos
		
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 13);
		new QuartoExecutivoDuplo(3, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 12);
		new QuartoExecutivoDuplo(1, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 11);
		new QuartoExecutivoDuplo(2, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 10);
		new QuartoExecutivoDuplo(1, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 9);
		new QuartoExecutivoDuplo(1, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 8);
		new QuartoExecutivoDuplo(1, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 7);
		new QuartoExecutivoDuplo(2, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 6);
		new QuartoExecutivoDuplo(1, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 5);
		new QuartoExecutivoDuplo(1, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 4);
		new QuartoExecutivoDuplo(1, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 3);
		new QuartoExecutivoDuplo(2, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 2);
		new QuartoExecutivoDuplo(1, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 1);
		new QuartoExecutivoDuplo(1, 0);
		Assert.assertTrue(Hotel.getQuartoExecutivoDuplo() == 0);
		
		try {
			q1 = new QuartoExecutivoDuplo(2, 1);
			Assert.fail("Deve lancar excecao, quantidade de quartos invalida");
		} catch ( QuartoEsgotadoException e ) {
			Assert.assertEquals("Nao ha mais quartos livres", e.getMessage());
		}
		
		try {
			q1.setCamaExtra(q1.getCamaExtra() + 7);
			Assert.fail("Deve lancar excecao, quantidade de camas invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida",e.getMessage());
		}
	}
	
	@Test
	public void testaCalculaDespesa()throws Exception{
		q1 = new QuartoExecutivoDuplo(2, 0); 
		
		q1.calculaDespesaTotal(1, 5, 1,1, q1.getPreco());
		Assert.assertEquals(4697.0, q1.getDespesaTotal(),1);
	}
}
