package testes;

import org.junit.Test;
import org.junit.Assert;
import classes.Hotel;
import classes.QuartoPresidencial;
import excecoes.QuartoEsgotadoException;

/* Classe de testes da classe QuartoPresidencial
 * 
 * 
 * Como so podem ser criados 5 objetos do quarto presidencial, nao vou utilizar o before e testar
 * tudo em um unico metodo.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima alteracao: 26/01/2015
 *
 */

public class QuartoPresidencialTest {
	
	@Test
	public void testTudo() throws Exception {
			
		QuartoPresidencial quartoPresidencial = new QuartoPresidencial(3);
		Assert.assertTrue(Hotel.getQuartoPresidencial() == 4);
		
		QuartoPresidencial outroQuartoPresidencial = new QuartoPresidencial(2);
		Assert.assertTrue(Hotel.getQuartoPresidencial() == 3);
		
		//Test construtor
		
		try {
			new QuartoPresidencial(5);
			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoPresidencial(0);
			Assert.fail("Esperava excecao, o quarto esta vazio");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		try {
			new QuartoPresidencial(-2);
			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
		} catch ( Exception e ) {
			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
		}
		
		new QuartoPresidencial(1);
		Assert.assertTrue(Hotel.getQuartoPresidencial() == 2);
		
		new QuartoPresidencial(3);
		Assert.assertTrue(Hotel.getQuartoPresidencial() == 1);
		
		new QuartoPresidencial(2);
		Assert.assertTrue(Hotel.getQuartoPresidencial() == 0);
		
		try {
			new QuartoPresidencial(4);
		} catch ( QuartoEsgotadoException e ) {
			Assert.assertEquals("Nao ha mais quartos livres", e.getMessage());
		}
		
		//Test getPreco()
		
		Assert.assertTrue(quartoPresidencial.getPreco() == 1200.0);
		Assert.assertTrue(outroQuartoPresidencial.getPreco() == 1200.0);
		
		//Test getQuantidadePessoas()
		
		Assert.assertTrue(quartoPresidencial.getQuantidadeDePessoas() == 3);
		Assert.assertTrue(outroQuartoPresidencial.getQuantidadeDePessoas() == 2);
		
		//Test setQuantidadePessoas()
		
	    quartoPresidencial.setQuantidadeDePessoas(4);
	    Assert.assertTrue(quartoPresidencial.getQuantidadeDePessoas() == 4);
		
	    outroQuartoPresidencial.setQuantidadeDePessoas(3);
	    Assert.assertTrue(outroQuartoPresidencial.getQuantidadeDePessoas() == 3);
	    
		//Test toString()
		
		Assert.assertEquals(quartoPresidencial.toString(), "Quarto Presidencial "
				+ "[ Valor diaria = R$ 1200.0, Quantidade De Pessoas = 4 ]");
		Assert.assertEquals(outroQuartoPresidencial.toString(), "Quarto Presidencial "
				+ "[ Valor diaria = R$ 1200.0, Quantidade De Pessoas = 3 ]");
		
		//Test equals()
		
		Assert.assertFalse(quartoPresidencial.equals(outroQuartoPresidencial));
		outroQuartoPresidencial.setQuantidadeDePessoas(4);
		Assert.assertTrue(quartoPresidencial.equals(outroQuartoPresidencial));
	}
}
