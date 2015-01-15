package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.AluguelDeCarros;

public class AluguelDeCarrosTest {
	AluguelDeCarros carro1, carro2, carro3;
	
	@Before
	public void CriaObjetos() throws Exception{
		carro1 = new AluguelDeCarros("Luxo", true, false, 10);
		carro2 = new AluguelDeCarros("Executivo", false, true, 5);
		carro3 = new AluguelDeCarros("Luxo", true, false, 20);
	}
	
	@Test
	public void tse(){
		try{
			new AluguelDeCarros("Executivo", true, true, 10);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
	}
	@Test
	public void testaConstrutor(){
		try{
			new AluguelDeCarros("Executivo", true, true, 10);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros("Luxo", true, true, 1);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros("Luxo", false, true, 1);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros("Executivo", true, false, 200);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros("Executivo", false, false, 365);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros("Outro Tipo", true, true, 1);
			Assert.fail("Deveria ocorrer uma exceção nesse momento!!");
		}catch(Exception e){
			Assert.assertEquals("Modelo de Automóvel Inválido (\"Luxo\" ou \"Executivo\")", e.getMessage());
		}
		
		try{
			new AluguelDeCarros("Executivo", true, true, -1);
			Assert.fail("Deveria ocorrer uma exceção nesse momento!!");
		}catch(Exception e){
			Assert.assertEquals("O número de dias deve ser maior que zero", e.getMessage());
		}
		
		try{
			new AluguelDeCarros("Luxo", true, true, 0);
			Assert.fail("Deveria ocorrer uma exceção nesse momento!!");
		}catch(Exception e){
			Assert.assertEquals("O número de dias deve ser maior que zero", e.getMessage());
		}
	}

	@Test
	public void testaGets(){
		Assert.assertEquals("Luxo", carro1.getTipoCarro());
		Assert.assertEquals("Executivo", carro2.getTipoCarro());
		Assert.assertEquals(true , carro1.isTanqueCheio());
		Assert.assertEquals(false, carro1.isSeguroDeAutomovel());
		Assert.assertEquals(false, carro2.isTanqueCheio());
		Assert.assertEquals(true, carro2.isSeguroDeAutomovel());
		
		
	}
	
	@Test
	public void testaCalculaTarifa(){
		Assert.assertEquals(carro1.getPreco(), 1150, 1);
		Assert.assertEquals(carro2.getPreco(), 400.0, 1);
		Assert.assertEquals(carro3.getPreco(), 2150.0, 1);
	}
	
	@Test
	public void testaToString(){
		Assert.assertEquals("AluguelDeCarros\nModelo do Automóvel: Luxo\nTanque Cheio: true\n"
						+ "Automóvel Assegurado: false\nQuantidade de dias do aluguel: 10", carro1.toString());
		Assert.assertEquals("AluguelDeCarros\nModelo do Automóvel: Executivo\nTanque Cheio: false\n"
				+ "Automóvel Assegurado: true\nQuantidade de dias do aluguel: 5", carro2.toString());
		Assert.assertEquals("AluguelDeCarros\nModelo do Automóvel: Luxo\nTanque Cheio: true\n"
				+ "Automóvel Assegurado: false\nQuantidade de dias do aluguel: 20", carro3.toString());
	}
	
	@Test
	public void testaEquals(){
		Assert.assertFalse(carro1.equals(carro2));
		Assert.assertFalse(carro2.equals(carro1));
		Assert.assertTrue(carro1.equals(carro3));
		Assert.assertFalse(carro2.equals(carro3));
		Assert.assertTrue(carro3.equals(carro1));
	}
	
}
