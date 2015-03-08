package testes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import classes.Arquivos;
import classes.Endereco;
import excecoes.*;

/**
 * Classe de testes da classe Endereco.
 * Author: Jaaziel Moura
 * Ultima atualizacao: 08/02/2015 / Fabio Alexandre
 */

public class EnderecoTest {
  Endereco novoEndereco, outroEndereco;

	@Before
	public void constroiObjetos() throws Exception {
		novoEndereco = new Endereco("Campina Grande", "Malvinas", "Rua das Umburanas", "66", "Perto da caixa d'agua", "Paraiba", "Brasil",
		"58888645");
		outroEndereco = new Endereco("Campina Grande", "Malvinas", "Rua das Umburanas", "6", "Perto da caixa d'agua", "Paraiba", "Brasil", 
		"53231234");
	}
	
	@Test
	public void testaConstrutor() throws Exception {
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "", "Paraiba", "Brasil", "32423424");
		} catch ( StringInvalidaException e ) {
			Assert.fail("Nao lanca excecao pois o construtor esta correto.");
		}
		
		try {
			new Endereco("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "42452213");
		} catch ( StringInvalidaException e ) {
			Assert.fail("Nao lanca excecao pois o construtor esta correto.");
		}
		
		try {
			new Endereco (null, "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "33445632");
			Assert.fail("Esperava excecao pois o campo de cidade esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome da cidade invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("123456", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "33445632");
			Assert.fail("Esperava excecao pois o campo de cidade esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome da cidade deve conter apenas letras.", e.getMessage());
		}
		
		try {
			new Endereco ("", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "23423423");
			Assert.fail("Esperava excecao pois o campo de cidade esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome da cidade invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "42333423");
			Assert.fail("Esperava excecao pois o campo de bairro esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do bairro invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", null, "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "42344213");
			Assert.fail("Esperava excecao pois o campo de bairro esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do bairro invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "123456", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "42344213");
			Assert.fail("Esperava excecao pois o campo de bairro esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do bairro deve conter apenas letras.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "", "7", "Perto da UFCG", "Paraiba", "Brasil", "42313412");
			Assert.fail("Esperava excecao pois o campo de rua esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome da rua invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", null, "7", "Perto da UFCG", "Paraiba", "Brasil", "32424252");
			Assert.fail("Esperava excecao pois o campo de rua como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome da rua invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "123456", "7", "Perto da UFCG", "Paraiba", "Brasil", "32424252");
			Assert.fail("Esperava excecao pois o campo de rua como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome da rua deve conter apenas letras.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "0", "Perto da UFCG", "Paraiba", "Brasil", "56745323");
			Assert.fail("Esperava excecao pois o campo de numero eh zero.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Numero da residencia deve ser um inteiro positivo.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "", "Perto da UFCG", "Paraiba", "Brasil", "56745323");
			Assert.fail("Esperava excecao pois o numero da casa eh vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Numero da residencia nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "-7", "Perto da UFCG", "Paraiba", "Brasil", "56609876");
			Assert.fail("Esperava excecao pois o campo de numero eh menor que zero.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Numero da residencia deve ser um inteiro positivo.", e.getMessage());
		}	
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", null, "Perto da UFCG", "Paraiba", "Brasil", "56609876");
			Assert.fail("Esperava excecao pois o campo de numero null");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Numero da residencia nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "asas6ss", "Perto da UFCG", "Paraiba", "Brasil", "56609876");
			Assert.fail("Esperava excecao pois o campo de numero eh menor que zero.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Numero da residencia deve ser um inteiro positivo.", e.getMessage());
		}	
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", null, "Paraiba", "Brasil", "32423424");
			Assert.fail("Esperava excecao pois o campo de complemento esta como null");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Complemento invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "", "Brasil", "87651238");
			Assert.fail("Esperava excecao pois o campo de estado esta vazio");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do estado invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", null, "Brasil", "34212122");
			Assert.fail("Esperava excecao pois o campo de estado esta como null");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do estado invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "123456", "Brasil", "34212122");
			Assert.fail("Esperava excecao pois o campo de estado esta como null");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do estado deve conter apenas letras.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "", "87463273");
			Assert.fail("Esperava excecao pois o campo de pais esta vazio");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do pais invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", null, "98345678");
			Assert.fail("Esperava excecao pois o campo de pais esta vazio");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do pais invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "1234156", "98345678");
			Assert.fail("Esperava excecao pois o campo de pais esta vazio");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do pais deve conter apenas letras.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "", "Paraiba", "Brasil", null);
			Assert.fail("O construtor esta valido, nao deve lancar excecao");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Cep nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "", "Paraiba", "Brasil", "");
			Assert.fail("Esperava excecao de cep vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Cep nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "", "Paraiba", "Brasil", "88dd99ss");
			Assert.fail("Esperava excecao de cep invalido.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Cep deve conter apenas digitos.", e.getMessage());
		}	
	}
	
	@Test
	public void testaSetters()throws StringInvalidaException {
		
		try {
			novoEndereco.setCidade("Campina");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome da cidade invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setCidade("");
			Assert.fail("Esperava excecao pois o campo de cidade esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome da cidade invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setCidade(null);
			Assert.fail("Esperava excecao pois o campo de cidade esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome da cidade invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setBairro("Prata");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do bairro invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setBairro("");
			Assert.fail("Esperava excecao pois o campo de bairro esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do bairro invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setBairro(null);
			Assert.fail("Esperava excecao pois o campo de bairro esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do bairro invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setNomeDaRua("Fura olho.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome da rua invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setNomeDaRua("");
			Assert.fail("Esperava excecao pois o campo de rua esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome da rua invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setNomeDaRua(null);
			Assert.fail("Esperava excecao pois o campo de rua como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome da rua invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setNumeroDaCasa("2");
		} catch ( StringInvalidaException e ) {
			Assert.fail("Nao lanca excecao pois o numero da residencia esta valido.");
		}	
		
		try {
			novoEndereco.setNumeroDaCasa("0");
			Assert.fail("Esperava excecao pois o campo de numero eh zero.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Numero da residencia deve ser um inteiro positivo.", e.getMessage());
		}	
		
		try {
			novoEndereco.setNumeroDaCasa("-7");
			Assert.fail("Esperava excecao pois o campo de numero eh menor que zero.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Numero da residencia deve ser um inteiro positivo.", e.getMessage());
		}	
		
		try {
			novoEndereco.setNumeroDaCasa("4a");
			Assert.fail("Esperava excecao pois o campo de numero contem letras.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Numero da residencia deve ser um inteiro positivo.", e.getMessage());
		}
		
		try {
			novoEndereco.setComplemento("");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Esse prompt nao deve ser mostrado pois o complemento esta correto", e.getMessage());
		}
		
		try {
			novoEndereco.setComplemento(null);
			Assert.fail("Esperava excecao pois o campo de complemento esta como null");
		} catch ( StringInvalidaException e ){
			Assert.assertEquals("Complemento invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setCep("56456789");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nao lanca excecao pois o cep esta valido.", e.getMessage());
		}
		
		try {
			novoEndereco.setCep("");
			Assert.fail("Esperava excecao pois o campo de numero eh menor que zero.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Cep nao pode ser vazio.", e.getMessage());
		}
		
		try {
			novoEndereco.setCep(null);
			Assert.fail("Esperava excecao pois o campo de numero eh menor que zero.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Cep nao pode ser vazio.", e.getMessage());
		}
		
		try {
			novoEndereco.setCep("43423");
			Assert.fail("Esperava excecao pois o campo de numero eh menor que zero.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Quantidade de digitos do cep invalida.", e.getMessage());
		}
		
		try {
			novoEndereco.setEstado("Paraiba");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do estado invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setEstado("");
			Assert.fail("Esperava excecao de estado invalido.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do estado invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setEstado(null);
			Assert.fail("Esperava excecao de estado invalido.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do estado invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setPais("Brasil");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do pais invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setPais("Brasil");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do pais invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setPais("");
			Assert.fail("Deveria lancar excecao de pais invalido.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do pais invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setPais(null);
			Assert.fail("Deveria lancar excecao de pais invalido.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do pais invalido.", e.getMessage());
		}
		
		try {
			novoEndereco.setPais("Brasil2");
			Assert.fail("Deveria lancar excecao de pais invalido.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Nome do pais deve conter apenas letras.", e.getMessage());
		}
	}
	
	@Test
	public void testaGetters(){
		Assert.assertTrue("Campina Grande".equals(novoEndereco.getCidade()));
		Assert.assertFalse("Joao Pessoa".equals(novoEndereco.getCidade()));
		Assert.assertTrue("Malvinas".equals(novoEndereco.getBairro()));
		Assert.assertFalse("Bodocongo".equals(novoEndereco.getBairro()));
		Assert.assertTrue("Rua das Umburanas".equals(novoEndereco.getNomeDaRua()));
		Assert.assertFalse("Rua Rodrigues Alves".equals(novoEndereco.getNomeDaRua()));
		Assert.assertTrue("66".equals(novoEndereco.getNumeroDaCasa()));
		Assert.assertFalse("7".equals(novoEndereco.getNumeroDaCasa()));
		Assert.assertTrue("Perto da caixa d'agua".equals(novoEndereco.getComplemento()));
		Assert.assertFalse("Perto da UFCG".equals(novoEndereco.getComplemento()));
		Assert.assertTrue("Paraiba".equals(novoEndereco.getEstado()));
		Assert.assertFalse("Pernanbuco".equals(novoEndereco.getEstado()));
		Assert.assertTrue("Brasil".equals(novoEndereco.getPais()));
		Assert.assertFalse("Argentina".equals(novoEndereco.getPais()));
		Assert.assertTrue("58888645".equals(novoEndereco.getCep()));
		Assert.assertFalse("32423233".equals(novoEndereco.getCep()));
	}

  @Test
  public void testaToString() {
    Assert.assertEquals(novoEndereco.toString(),"- Cidade: Campina Grande" + Arquivos.FIM_LINHA
        + "- Bairro: Malvinas" + Arquivos.FIM_LINHA + "- Rua: Rua das Umburanas"
        + Arquivos.FIM_LINHA + "- Numero: 66" + Arquivos.FIM_LINHA
        + "- Complemento: Perto da caixa d'agua" + Arquivos.FIM_LINHA
        + "- Estado: Paraiba" + Arquivos.FIM_LINHA + "- Pais: Brasil"
        + Arquivos.FIM_LINHA + "- Cep: 58888645");
  }

  @Test
  public void testaEquals() throws StringInvalidaException {
    Assert.assertFalse(novoEndereco.equals(outroEndereco));
    outroEndereco.setNumeroDaCasa("66");
    outroEndereco.setCep("58888645");
    Assert.assertTrue(novoEndereco.equals(outroEndereco));
  }
}