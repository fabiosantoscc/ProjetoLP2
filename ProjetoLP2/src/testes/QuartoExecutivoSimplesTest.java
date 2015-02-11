package testes;

import org.junit.Test;
import org.junit.Assert;
import classes.Hotel;
import classes.QuartoExecutivoSimples;

/**
 * 
 * Como so podem ser criados 5 objetos do quarto executivo simples, nao vou utilizar o 
 * before e testar tudo em um unico metodo.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 *
 */

public class QuartoExecutivoSimplesTest {
	
	@Test
	public void testTudo() throws Exception {
			
		QuartoExecutivoSimples quartoExecutivoS = new QuartoExecutivoSimples(3, 2);
		Assert.assertTrue(Hotel.getQuartoExecutivoSimples() == 4);
		
		QuartoExecutivoSimples outroQuartoExecutivoS = new QuartoExecutivoSimples(2, 1);
		Assert.assertTrue(Hotel.getQuartoExecutivoSimples() == 3);
		
		//Test construtor
		
		try {
			new QuartoExecutivoSimples(4, 2);
			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoExecutivoSimples(0, 1);
			Assert.fail("Esperava excecao, o quarto esta vazio");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoExecutivoSimples(-2, 0);
			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoExecutivoSimples(2, -1);
			Assert.fail("Esperava excecao, pois a quantidade de cama e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
		}
		
		try {
			new QuartoExecutivoSimples(2, 18);
			Assert.fail("Esperava excecao, pois a quantidade de cama e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
		}
		
		new QuartoExecutivoSimples(2, 1);
		Assert.assertTrue(Hotel.getCamaExtra() == 16);
		
		try {
			new QuartoExecutivoSimples(2, 7);
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
		}
		
		//Test getPreco()
		
		Assert.assertTrue(quartoExecutivoS.getPreco() == 360.0);
		Assert.assertTrue(outroQuartoExecutivoS.getPreco() == 360.0);
		
		//Test getQuantidadePessoas()
		
		Assert.assertTrue(quartoExecutivoS.getQuantidadeDePessoas() == 3);
		Assert.assertTrue(outroQuartoExecutivoS.getQuantidadeDePessoas() == 2);
		
		//Test setQuantidadePessoas()
		
	    quartoExecutivoS.setQuantidadeDePessoas(2);
	    Assert.assertTrue(quartoExecutivoS.getQuantidadeDePessoas() == 2);
		
	    outroQuartoExecutivoS.setQuantidadeDePessoas(3);
	    Assert.assertTrue(outroQuartoExecutivoS.getQuantidadeDePessoas() == 3);
	    
	    //Test getCamaExtra()
	    
	    Assert.assertTrue(quartoExecutivoS.getCamaExtra() == 2);
	    Assert.assertTrue(outroQuartoExecutivoS.getCamaExtra() == 1);
	    
	    //Test setcamaExtra()
	    
	    quartoExecutivoS.setCamaExtra(3);
	    Assert.assertTrue(quartoExecutivoS.getCamaExtra() == 3);
	    
	    outroQuartoExecutivoS.setCamaExtra(2);
	    Assert.assertTrue(outroQuartoExecutivoS.getCamaExtra() == 2);
	    
		//Test toString() tTO STRING TEM A DATA COMPLETA, IMPOSSIVEL TESTAR.
		
		//Test equals()
		
		Assert.assertFalse(quartoExecutivoS.equals(outroQuartoExecutivoS));
		outroQuartoExecutivoS.setQuantidadeDePessoas(2);
		outroQuartoExecutivoS.setCamaExtra(3);
		Assert.assertTrue(quartoExecutivoS.equals(outroQuartoExecutivoS));
	}
}
