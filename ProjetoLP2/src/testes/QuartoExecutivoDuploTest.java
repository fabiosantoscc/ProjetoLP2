package testes;

import org.junit.Test;
import org.junit.Assert;
import classes.Hotel;
import classes.QuartoExecutivoDuplo;
import excecoes.QuartoEsgotadoNoHotelException;

/*
 * Classe de testes de um quarto luxo duplo, sem uso do before porque a quantidade de
 * criacao de objetos e limitada.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima alteracao: 26/01/2015
 */

public class QuartoExecutivoDuploTest {
	QuartoExecutivoDuplo q1, q2, q3;
	
	@Test
	public void testaCalculo()throws Exception{
		q3 = new QuartoExecutivoDuplo(3,0);
		q3.setValorDiario(385.0);
		q3.calculaDespesaTotal(1,1, 5, 2, 2015, 2015);
		System.out.println(q3.getDespesaTotal());
		Assert.assertEquals(16285.5, q3.getDespesaTotal() ,1);
		System.out.println(q3.calculaDespesaTotal(1, 1, 1, 2, 2015, 2016));
	}
	/*
	@Test
	public void testaTudo() throws Exception {
	
		q1 = new QuartoExecutivoDuplo(2, 1);
		
		Assert.assertTrue(Hotel.getCamaExtra() == 19);
			
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
			new QuartoExecutivoDuplo(2, 20);
			Assert.fail("Esperava excecao, pois a quantidade de quartos e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
		}
			
		Assert.assertTrue(Hotel.getCamaExtra() == 19);
			
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
		
		Assert.assertTrue(q1.getCamaExtra() == 1);
		
		// Test setCama()
	
		try {
			q1.setCamaExtra(-1);
			Assert.fail("Esperava excecao, quantidade de camas invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
		}
			
		try {
			q1.setCamaExtra(20);
			Assert.fail("Esperava excecao, quantidade de camas invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
		}
			
		q1.setCamaExtra(2);
		Assert.assertTrue(q1.getCamaExtra() == 2);
		    
		// Test toString() TO STRING TEM A DATA COMPLETA, NAO DA PRA TESTAR PEGANDO O SEGUNDO EXATO.
			
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
		} catch ( QuartoEsgotadoNoHotelException e ) {
			Assert.assertEquals("Nao ha mais quartos livres", e.getMessage());
		}
		
		try {
			q1.setCamaExtra(17);
			Assert.fail("Deve lancar excecao, quantidade de camas invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida",e.getMessage());
		}
	}*/
}
