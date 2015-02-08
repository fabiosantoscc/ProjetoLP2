package testes;


import classes.Restaurante;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class RestauranteTest {
	Restaurante rest1, rest2, rest3, rest4;
	
	@Before
	public void criaObjetos() throws Exception{
		rest1 = new Restaurante();
		rest2 = new Restaurante();
		rest3 = new Restaurante();
		rest4 = new Restaurante();
		rest1.AdicionaNovoConsumo("Terreo", 80);
		rest1.AdicionaNovoConsumo("Cobertura", 500);
		rest2.AdicionaNovoConsumo("Cobertura", 700.55);
		rest3.AdicionaNovoConsumo("Terreo", 45.80);
		rest4.AdicionaNovoConsumo("Terreo", 40);
		rest4.AdicionaNovoConsumo("Cobertura", 100);
		rest4.AdicionaNovoConsumo("Terreo", 40);
		rest4.AdicionaNovoConsumo("Cobertura", 100);
		rest4.AdicionaNovoConsumo("Cobertura", 100);
		rest4.AdicionaNovoConsumo("Cobertura", 100);
		rest4.AdicionaNovoConsumo("Cobertura", 100);
		
	}
	
	@Test
	public void testaAdicionaConsumo(){
		try{
			rest1.AdicionaNovoConsumo("Outra Unidade", 0);
			Assert.fail("Deveria ocorrer uma excecao!!");
		}catch(Exception e){
			Assert.assertEquals("Valor invalido!!", e.getMessage());	
		}
		
		try{
			rest1.AdicionaNovoConsumo("Outra Unidade", 20);
			Assert.fail("Deveria ocorrer uma excecao!!");
		}catch(Exception e){
			Assert.assertEquals("Unidade do restaurante invalida!!", e.getMessage());	
		}
		
		try{
			rest1.AdicionaNovoConsumo("Terreo", -18);
			Assert.fail("Deveria ocorrer uma excecao!!");
		}catch(Exception e){
			Assert.assertEquals("Valor invalido!!", e.getMessage());	
		}
		
		try{
			rest1.AdicionaNovoConsumo("Cobertura", 0);
			Assert.fail("Deveria ocorrer uma excecao!!");
		}catch(Exception e){
			Assert.assertEquals("Valor invalido!!", e.getMessage());	
		}
		
		try{
			rest3.AdicionaNovoConsumo("Cobertura", 200);
		}catch(Exception e){
			Assert.fail("Nao deveria ocorrer erros!!");
		}
		
		try{
			rest1.AdicionaNovoConsumo("Terreo", 80);
		}catch(Exception e){
			Assert.fail("Nao deveria ocorrer erros!!");
		}
		
		try{
			rest1.AdicionaNovoConsumo("Cobertura", 150);
		}catch(Exception e){
			Assert.fail("Nao deveria ocorrer erros!!");
		}
		
		try{
			rest2.AdicionaNovoConsumo("Cobertura", 550);
		}catch(Exception e){
			Assert.fail("Nao deveria ocorrer erros!!");
		}
		
		try{
			rest2.AdicionaNovoConsumo("Terreo", 20);
		}catch(Exception e){
			Assert.fail("Nao deveria ocorrer erros!!");
		}
		
		try{
			rest3.AdicionaNovoConsumo("Cobertura", 500);
		}catch(Exception e){
			Assert.fail("Nao deveria ocorrer erros!!");
		}
	}
	

	@Test
	public void testaGets(){
		Assert.assertEquals(rest1.getConsumoUnidade1(), 80.0, 2);
		Assert.assertEquals(rest1.getConsumoUnidade2(), 500.0, 2);
		Assert.assertEquals(rest1.getCondumoDiario(), 580.0, 2);
		Assert.assertEquals(rest2.getConsumoUnidade1(), 0.0, 2);
		Assert.assertEquals(rest2.getConsumoUnidade2(), 700.55, 2);
		Assert.assertEquals(rest2.getCondumoDiario(), 700.55, 2);
		Assert.assertEquals(rest3.getConsumoUnidade1(), 45.80, 2);
		Assert.assertEquals(rest3.getConsumoUnidade2(), 0.0, 2);
		Assert.assertEquals(rest3.getCondumoDiario(), 45.80, 2);
		Assert.assertEquals(rest4.getConsumoUnidade1(), 80.0, 2);
		Assert.assertEquals(rest4.getConsumoUnidade2(), 500.0, 2);
		Assert.assertEquals(rest4.getCondumoDiario(), 580.0, 2);
	}

	@Test
	public void testaToString(){
		Assert.assertEquals("Restaurante:"
				+ "\nUnidade 1 (Terreo)"
				+ "     \n Quantidade de usos: 1"
				+ "     \n Valor consumido: 80.0" 
				+ "\nUnidade 2 (Cobertura)"
				+ "     \n Quantidade de usos: 1"
				+ "     \n Valor consumido: 500.0" 
				+ "\n\nValor total: 0.0", rest1.toString());
		
		Assert.assertEquals("Restaurante:"
				+ "\nUnidade 1 (Terreo)"
				+ "     \n Quantidade de usos: 0"
				+ "     \n Valor consumido: 0.0" 
				+ "\nUnidade 2 (Cobertura)"
				+ "     \n Quantidade de usos: 1"
				+ "     \n Valor consumido: 700.55" 
				+ "\n\nValor total: 0.0", rest2.toString());
		
		Assert.assertEquals("Restaurante:"
				+ "\nUnidade 1 (Terreo)"
				+ "     \n Quantidade de usos: 1"
				+ "     \n Valor consumido: 45.8" 
				+ "\nUnidade 2 (Cobertura)"
				+ "     \n Quantidade de usos: 0"
				+ "     \n Valor consumido: 0.0" 
				+ "\n\nValor total: 0.0", rest3.toString());
	}
	
	@Test
	public void testaAdicionaNovoConsumo() throws Exception {
		Assert.assertEquals(870, rest1.getPreco(), 1);
	}
	
	@Test
	public void testaEquals(){
		Assert.assertFalse(rest1.equals(rest2));
		Assert.assertFalse(rest1.equals(rest3));
		Assert.assertFalse(rest2.equals(rest1));
		Assert.assertFalse(rest2.equals(rest3));
		Assert.assertFalse(rest3.equals(rest1));
		Assert.assertFalse(rest3.equals(rest2));
		Assert.assertTrue(rest1.equals(rest4));
		Assert.assertTrue(rest4.equals(rest1));
		
	}
}
