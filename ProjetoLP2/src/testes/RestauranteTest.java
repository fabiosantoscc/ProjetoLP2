//package testes;
//
//
//import classes.Restaurante;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.Before;
//
//public class RestauranteTest {
//	Restaurante rest1, rest2, rest3, rest4;
//	
//	@Before
//	public void criaObjetos() throws Exception{
//		rest1 = new Restaurante();
//		rest2 = new Restaurante();
//		rest3 = new Restaurante();
//		rest4 = new Restaurante();
//		rest1.AdicionaNovoConsumo("Terreo", 80);
//		rest1.AdicionaNovoConsumo("Cobertura", 500);
//		rest2.AdicionaNovoConsumo("Cobertura", 700.55);
//		rest3.AdicionaNovoConsumo("Terreo", 45.80);
//		rest4.AdicionaNovoConsumo("Terreo", 40);
//		rest4.AdicionaNovoConsumo("Cobertura", 100);
//		rest4.AdicionaNovoConsumo("Terreo", 40);
//		rest4.AdicionaNovoConsumo("Cobertura", 100);
//		rest4.AdicionaNovoConsumo("Cobertura", 100);
//		rest4.AdicionaNovoConsumo("Cobertura", 100);
//		rest4.AdicionaNovoConsumo("Cobertura", 100);
//		
//	}
//	
//	@Test
//	public void testaAdicionaConsumo(){
//		try{
//			rest1.AdicionaNovoConsumo("Outra Unidade", 0);
//			Assert.fail("Deveria ocorrer uma excecao!!");
//		}catch(Exception e){
//			Assert.assertEquals("Valor invalido!!", e.getMessage());	
//		}
//		
//		try{
//			rest1.AdicionaNovoConsumo("Outra Unidade", 20);
//			Assert.fail("Deveria ocorrer uma excecao!!");
//		}catch(Exception e){
//			Assert.assertEquals("Unidade do restaurante invalida!!", e.getMessage());	
//		}
//		
//		try{
//			rest1.AdicionaNovoConsumo("Terreo", -18);
//			Assert.fail("Deveria ocorrer uma excecao!!");
//		}catch(Exception e){
//			Assert.assertEquals("Valor invalido!!", e.getMessage());	
//		}
//		
//		try{
//			rest1.AdicionaNovoConsumo("Cobertura", 0);
//			Assert.fail("Deveria ocorrer uma excecao!!");
//		}catch(Exception e){
//			Assert.assertEquals("Valor invalido!!", e.getMessage());	
//		}
//		
//		try{
//			rest3.AdicionaNovoConsumo("Cobertura", 200);
//		}catch(Exception e){
//			Assert.fail("Nao deveria ocorrer erros!!");
//		}
//		
//		try{
//			rest1.AdicionaNovoConsumo("Terreo", 80);
//		}catch(Exception e){
//			Assert.fail("Nao deveria ocorrer erros!!");
//		}
//		
//		try{
//			rest1.AdicionaNovoConsumo("Cobertura", 150);
//		}catch(Exception e){
//			Assert.fail("Nao deveria ocorrer erros!!");
//		}
//		
//		try{
//			rest2.AdicionaNovoConsumo("Cobertura", 550);
//		}catch(Exception e){
//			Assert.fail("Nao deveria ocorrer erros!!");
//		}
//		
//		try{
//			rest2.AdicionaNovoConsumo("Terreo", 20);
//		}catch(Exception e){
//			Assert.fail("Nao deveria ocorrer erros!!");
//		}
//		
//		try{
//			rest3.AdicionaNovoConsumo("Cobertura", 500);
//		}catch(Exception e){
//			Assert.fail("Nao deveria ocorrer erros!!");
//		}
//	}
//	
//
//	@Test
//	public void testaGets(){
//		Assert.assertEquals(rest1.getConsumoUnidade1(), 80.0, 2);
//		Assert.assertEquals(rest1.getConsumoUnidade2(), 500.0, 2);
//		Assert.assertEquals(rest2.getConsumoUnidade1(), 0.0, 2);
//		Assert.assertEquals(rest2.getConsumoUnidade2(), 700.55, 2);
//		Assert.assertEquals(rest3.getConsumoUnidade1(), 45.80, 2);
//		Assert.assertEquals(rest3.getConsumoUnidade2(), 0.0, 2);
//		Assert.assertEquals(rest4.getConsumoUnidade1(), 80.0, 2);
//		Assert.assertEquals(rest4.getConsumoUnidade2(), 500.0, 2);
//	}
//	
//	@Test
//	public void testaEquals(){
//		Assert.assertFalse(rest1.equals(rest2));
//		Assert.assertFalse(rest1.equals(rest3));
//		Assert.assertFalse(rest2.equals(rest1));
//		Assert.assertFalse(rest2.equals(rest3));
//		Assert.assertFalse(rest3.equals(rest1));
//		Assert.assertFalse(rest3.equals(rest2));
//		Assert.assertTrue(rest1.equals(rest4));
//		Assert.assertTrue(rest4.equals(rest1));
//		
//	}
//	
//	@Test
//	public void testaGetPreco()throws Exception{
//		Assert.assertEquals(580.0, rest1.getPreco(), 1);
//		rest1.AdicionaNovoConsumo("Terreo", 350);
//		Assert.assertEquals(930, rest1.getPreco(), 1);
//	}
//}
