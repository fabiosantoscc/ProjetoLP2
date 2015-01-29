//package testes;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.Before;
//
//import classes.Endereco;
//
//public class EnderecoTest {
//	Endereco novoEndereco, outroEndereco;
//	
//	@Before
//	public void constroiObjetos()throws Exception{
//		novoEndereco = new Endereco("Campina Grande", "Pedregal", "Rua Fulano de Tal", 666, "Perto do posto.");
//		outroEndereco = new Endereco("Campina Grande", "Pedregal", "Rua Fulano de Tal", 7, "Perto do posto.");
//	}
//	
//	@Test
//	public void testaConstrutor()throws Exception{
//		try{
//			new Endereco("Campina Grande", "Pedregal", "Rua Fulano de Tal", 666, "Perto do posto.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Esse prompt nao deve ser mostrado se o construtor estiver correto", e.getMessage());
//		}
//	
//		try{
//			new Endereco ("", "Pedregal", "Rua Fulano de Tal", 666, "Perto do posto.");
//			Assert.fail("Esperava excecao pois o campo de cidade esta vazio.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Cidade, bairro, rua e complemento nao pode ser null ou vazio", e.getMessage());
//		}
//		
//		try{
//			new Endereco (null, "Pedregal", "Rua Fulano de Tal", 666, "Perto do posto.");
//			Assert.fail("Esperava excecao pois o campo de cidade esta como null.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Cidade, bairro, rua e complemento nao pode ser null ou vazio", e.getMessage());
//		}
//		
//		try{
//			new Endereco ("Campina Grande", "", "Rua Fulano de Tal", 666, "Perto do posto.");
//			Assert.fail("Esperava excecao pois o campo de bairro esta vazio.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Cidade, bairro, rua e complemento nao pode ser null ou vazio", e.getMessage());
//		}
//		
//		try{
//			new Endereco ("Campina Grande", null, "Rua Fulano de Tal", 666, "Perto do posto.");
//			Assert.fail("Esperava excecao pois o campo de bairro esta como null.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Cidade, bairro, rua e complemento nao pode ser null ou vazio", e.getMessage());
//		}
//		
//		try{
//			new Endereco ("Campina Grande", "Pedregal", "", 666, "Perto do posto.");
//			Assert.fail("Esperava excecao pois o campo de rua esta vazio.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Cidade, bairro, rua e complemento nao pode ser null ou vazio", e.getMessage());
//		}
//		
//		try{
//			new Endereco ("Campina Grande", "Pedregal", null, 666, "Perto do posto.");
//			Assert.fail("Esperava excecao pois o campo de rua como null.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Cidade, bairro, rua e complemento nao pode ser null ou vazio", e.getMessage());
//		}
//		
//		try{
//			new Endereco ("Campina Grande", "Pedregal", "Rua Fulano de Tal", 0, "Perto do posto.");
//			Assert.fail("Esperava excecao pois o campo de numero eh zero.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Insira um numero de residência valido!", e.getMessage());
//		}	
//		
//		try{
//			new Endereco ("Campina Grande", "Pedregal", "Rua Fulano de Tal", -1000, "Perto do posto.");
//			Assert.fail("Esperava excecao pois o campo de numero eh menor que zero.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Insira um numero de residência valido!", e.getMessage());
//		}	
//		
//		try{
//			new Endereco ("Campina Grande", "Pedregal", "Rua Fulano de Tal", 666, "");
//			Assert.fail("Esperava excecao pois o campo de complemento esta vazio.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Cidade, bairro, rua e complemento nao pode ser null ou vazio", e.getMessage());
//		}
//		
//		try{
//			new Endereco ("Campina Grande", "Pedregal", "Rua Fulano de Tal", 666, null);
//			Assert.fail("Esperava excecao pois o campo de complemento esta como null");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Cidade, bairro, rua e complemento nao pode ser null ou vazio", e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testaSetters()throws Exception{
//		try{
//			novoEndereco.setCidade("");
//			Assert.fail("Esperava excecao pois o campo de cidade esta vazio.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Cidade nao pode ser null ou vazio!", e.getMessage());
//		}
//		
//		try{
//			novoEndereco.setCidade(null);
//			Assert.fail("Esperava excecao pois o campo de cidade esta como null.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Cidade nao pode ser null ou vazio!", e.getMessage());
//		}
//		
//		try{
//			novoEndereco.setBairro("");
//			Assert.fail("Esperava excecao pois o campo de bairro esta vazio.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Bairro nao pode ser null ou vazio!", e.getMessage());
//		}
//		
//		try{
//			novoEndereco.setBairro(null);
//			Assert.fail("Esperava excecao pois o campo de bairro esta como null.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Bairro nao pode ser null ou vazio!", e.getMessage());
//		}
//		
//		try{
//			novoEndereco.setNomeDaRua("");
//			Assert.fail("Esperava excecao pois o campo de rua esta vazio.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Nome da rua nao pode ser null ou vazio", e.getMessage());
//		}
//		
//		try{
//			novoEndereco.setNomeDaRua(null);
//			Assert.fail("Esperava excecao pois o campo de rua como null.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Nome da rua nao pode ser null ou vazio", e.getMessage());
//		}
//		
//		try{
//			novoEndereco.setNumeroDaCasa(0);
//			Assert.fail("Esperava excecao pois o campo de numero eh zero.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Insira um numero de residência valido!", e.getMessage());
//		}	
//		
//		try{
//			novoEndereco.setNumeroDaCasa(-1000);
//			Assert.fail("Esperava excecao pois o campo de numero eh menor que zero.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("Insira um numero de residência valido!", e.getMessage());
//		}	
//		
//		try{
//			novoEndereco.setComplemento("");
//			Assert.fail("Esperava excecao pois o campo de complemento esta vazio.");
//			}
//		catch (Exception e){
//			Assert.assertEquals("O complemento nao pode ser null ou vazio", e.getMessage());
//		}
//		
//		try{
//			novoEndereco.setComplemento(null);
//			Assert.fail("Esperava excecao pois o campo de complemento esta como null");
//			}
//		catch (Exception e){
//			Assert.assertEquals("O complemento nao pode ser null ou vazio", e.getMessage());
//		}
//	}
//	
//	@Test
//	public void testaToString(){
//		Assert.assertEquals(novoEndereco.toString(),"- Cidade: Campina Grande\n- Bairro: Pedregal\n- "
//				+ "Rua: Rua Fulano de Tal\n- Numero: 666\n- Complemento: Perto do posto.");
//	}
//	
//	@Test
//	public void testaEquals()throws Exception{
//		Assert.assertFalse(novoEndereco.equals(outroEndereco));
//		outroEndereco.setNumeroDaCasa(666);
//		Assert.assertTrue(novoEndereco.equals(outroEndereco));
//	}
//}
