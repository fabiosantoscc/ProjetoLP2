package testes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import classes.Endereco;

/**
 * Classe de testes da classe Enderco
 * 
 * Author: Jaaziel Moura
 *
 */

public class EnderecoTest {
	Endereco novoEndereco, outroEndereco;
	
	@Before
	public void constroiObjetos()throws Exception{
		novoEndereco = new Endereco("Campina Grande", "Malvinas", "Rua das Umburanas", 66, "Perto da caixa d'agua", "Paraiba", "Brasil");
		outroEndereco = new Endereco("Campina Grande", "Malvinas", "Rua das Umburanas", 6, "Perto da caixa d'agua", "Paraiba", "Brasil");
	}
	
	@Test
	public void testaConstrutor()throws Exception{
		try{
			new Endereco("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", 7, "Perto da UFCG", "Paraiba", "Brasil");
			}
		catch (Exception e){
			Assert.assertEquals("Esse prompt nao deve ser mostrado se o construtor estiver correto", e.getMessage());
		}
	
		try{
			new Endereco ("", "Bodocongo", "Rua Rodrigues ALves", 7, "Perto da UFCG", "Paraiba", "Brasil");
			Assert.fail("Esperava excecao pois o campo de cidade esta vazio.");
			}
		catch (Exception e){
			Assert.assertEquals("Nome da cidade invalido", e.getMessage());
		}
		
		try{
			new Endereco (null, "Bodocongo", "Rua Rodrigues ALves", 7, "Perto da UFCG", "Paraiba", "Brasil");
			Assert.fail("Esperava excecao pois o campo de cidade esta como null.");
			}
		catch (Exception e){
			Assert.assertEquals("Nome da cidade invalido", e.getMessage());
		}
		
		try{
			new Endereco ("Campina Grande", "", "Rua Rodrigues ALves", 7, "Perto da UFCG", "Paraiba", "Brasil");
			Assert.fail("Esperava excecao pois o campo de bairro esta vazio.");
			}
		catch (Exception e){
			Assert.assertEquals("Nome do bairro invalido", e.getMessage());
		}
		
		try{
			new Endereco ("Campina Grande", null, "Rua Rodrigues ALves", 7, "Perto da UFCG", "Paraiba", "Brasil");
			Assert.fail("Esperava excecao pois o campo de bairro esta como null.");
			}
		catch (Exception e){
			Assert.assertEquals("Nome do bairro invalido", e.getMessage());
		}
		
		try{
			new Endereco ("Campina Grande", "Bodocongo", "", 7, "Perto da UFCG", "Paraiba", "Brasil");
			Assert.fail("Esperava excecao pois o campo de rua esta vazio.");
			}
		catch (Exception e){
			Assert.assertEquals("Nome da rua invalido", e.getMessage());
		}
		
		try{
			new Endereco ("Campina Grande", "Bodocongo", null, 7, "Perto da UFCG", "Paraiba", "Brasil");
			Assert.fail("Esperava excecao pois o campo de rua como null.");
			}
		catch (Exception e){
			Assert.assertEquals("Nome da rua invalido", e.getMessage());
		}
		
		try{
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", 0, "Perto da UFCG", "Paraiba", "Brasil");
			Assert.fail("Esperava excecao pois o campo de numero eh zero.");
			}
		catch (Exception e){
			Assert.assertEquals("Numero da residencia invalido", e.getMessage());
		}	
		
		try{
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", -7, "Perto da UFCG", "Paraiba", "Brasil");
			Assert.fail("Esperava excecao pois o campo de numero eh menor que zero.");
			}
		catch (Exception e){
			Assert.assertEquals("Numero da residencia invalido", e.getMessage());
		}	
		
		try{
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", 7, "", "Paraiba", "Brasil");
			}
		catch (Exception e){
			Assert.assertEquals("Esse prompt nao deve ser mostrado pois o complemento esta correto", e.getMessage());
		}
		
		try{
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", 7, null, "Paraiba", "Brasil");
			Assert.fail("Esperava excecao pois o campo de complemento esta como null");
			}
		catch (Exception e){
			Assert.assertEquals("Complemento invalido", e.getMessage());
		}
		
		try{
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", 7, "Perto da UFCG", "", "Brasil");
			Assert.fail("Esperava excecao pois o campo de estado esta vazio");
			}
		catch (Exception e){
			Assert.assertEquals("Nome do estado invalido", e.getMessage());
		}
		
		try{
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", 7, "Perto da UFCG", null, "Brasil");
			Assert.fail("Esperava excecao pois o campo de estado esta como null");
			}
		catch (Exception e){
			Assert.assertEquals("Nome do estado invalido", e.getMessage());
		}
		
		try{
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", 7, "Perto da UFCG", "Paraiba", "");
			Assert.fail("Esperava excecao pois o campo de pais esta vazio");
			}
		catch (Exception e){
			Assert.assertEquals("Nome do pais invalido", e.getMessage());
		}
		
		try{
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", 7, "Perto da UFCG", "Paraiba", null);
			Assert.fail("Esperava excecao pois o campo de pais esta vazio");
			}
		catch (Exception e){
			Assert.assertEquals("Nome do pais invalido", e.getMessage());
		}
	}
	
	@Test
	public void testaSetters()throws Exception{
		try{
			novoEndereco.setCidade("");
			Assert.fail("Esperava excecao pois o campo de cidade esta vazio.");
			}
		catch (Exception e){
			Assert.assertEquals("Nome da cidade invalido", e.getMessage());
		}
		
		try{
			novoEndereco.setCidade(null);
			Assert.fail("Esperava excecao pois o campo de cidade esta como null.");
			}
		catch (Exception e){
			Assert.assertEquals("Nome da cidade invalido", e.getMessage());
		}
		
		try{
			novoEndereco.setBairro("");
			Assert.fail("Esperava excecao pois o campo de bairro esta vazio.");
			}
		catch (Exception e){
			Assert.assertEquals("Nome do bairro invalido", e.getMessage());
		}
		
		try{
			novoEndereco.setBairro(null);
			Assert.fail("Esperava excecao pois o campo de bairro esta como null.");
			}
		catch (Exception e){
			Assert.assertEquals("Nome do bairro invalido", e.getMessage());
		}
		
		try{
			novoEndereco.setNomeDaRua("");
			Assert.fail("Esperava excecao pois o campo de rua esta vazio.");
			}
		catch (Exception e){
			Assert.assertEquals("Nome da rua invalido", e.getMessage());
		}
		
		try{
			novoEndereco.setNomeDaRua(null);
			Assert.fail("Esperava excecao pois o campo de rua como null.");
			}
		catch (Exception e){
			Assert.assertEquals("Nome da rua invalido", e.getMessage());
		}
		
		try{
			novoEndereco.setNumeroDaCasa(0);
			Assert.fail("Esperava excecao pois o campo de numero eh zero.");
			}
		catch (Exception e){
			Assert.assertEquals("Numero da residencia invalido", e.getMessage());
		}	
		
		try{
			novoEndereco.setNumeroDaCasa(-7);
			Assert.fail("Esperava excecao pois o campo de numero eh menor que zero.");
			}
		catch (Exception e){
			Assert.assertEquals("Numero da residencia invalido", e.getMessage());
		}	
		
		try{
			novoEndereco.setComplemento("");
			}
		catch (Exception e){
			Assert.assertEquals("Esse prompt nao deve ser mostrado pois o complemento esta correto", e.getMessage());
		}
		
		try{
			novoEndereco.setComplemento(null);
			Assert.fail("Esperava excecao pois o campo de complemento esta como null");
			}
		catch (Exception e){
			Assert.assertEquals("Complemento invalido", e.getMessage());
		}
	}
	
	@Test
	public void testaGetters(){
		Assert.assertTrue("Campina Grande" == novoEndereco.getCidade());
		Assert.assertFalse("João Pessoa" == novoEndereco.getCidade());
		Assert.assertTrue("Malvinas" == novoEndereco.getBairro());
		Assert.assertFalse("Bodocongo" == novoEndereco.getBairro());
		Assert.assertTrue("Rua das Umburanas" == novoEndereco.getNomeDaRua());
		Assert.assertFalse("Rua Rodrigues Alves" == novoEndereco.getNomeDaRua());
		Assert.assertTrue(66 == novoEndereco.getNumeroDaCasa());
		Assert.assertFalse(7 == novoEndereco.getNumeroDaCasa());
		Assert.assertTrue("Perto da caixa d'agua" == novoEndereco.getComplemento());
		Assert.assertFalse("Perto da UFCG" == novoEndereco.getComplemento());
		Assert.assertTrue("Paraiba" == novoEndereco.getEstado());
		Assert.assertFalse("Pernanbuco" == novoEndereco.getEstado());
		Assert.assertTrue("Brasil" == novoEndereco.getPais());
		Assert.assertFalse("Argentina" == novoEndereco.getPais());
	}
	
	@Test
	public void testaToString(){
		Assert.assertEquals(novoEndereco.toString(),"- Cidade: Campina Grande\n- Bairro: Malvinas\n- "
				+ "Rua: Rua das Umburanas\n- Numero: 66\n- Complemento: Perto da caixa d'agua\n- Estado: Paraiba\n- Pais: Brasil");
	}
	
	@Test
	public void testaEquals()throws Exception{
		Assert.assertFalse(novoEndereco.equals(outroEndereco));
		outroEndereco.setNumeroDaCasa(66);
		Assert.assertTrue(novoEndereco.equals(outroEndereco));
	}
}