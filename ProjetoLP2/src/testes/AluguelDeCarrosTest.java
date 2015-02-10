package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.AluguelDeCarros;

public class AluguelDeCarrosTest {
	AluguelDeCarros carro1, carro2, carro3;
	
	@Before
	public void CriaObjetos() throws Exception{
		carro1 = new AluguelDeCarros("Luxo", true, false);
		carro2 = new AluguelDeCarros("Executivo", false, true);
		carro3 = new AluguelDeCarros("Luxo", true, false);
	}
	
	@Test
	public void tse(){
		try{
			new AluguelDeCarros("Executivo", true, true);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
	}
	
	@Test
	public void testaConstrutor(){
		try{
			new AluguelDeCarros("Executivo", true, true);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros("Luxo", true, true);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros("Luxo", false, true);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros("Executivo", true, false);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros("Executivo", false, false);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros("Outro Tipo", true, true);
			Assert.fail("Deveria ocorrer uma exceção nesse momento!!");
		}catch(Exception e){
			Assert.assertEquals("Modelo de Automóvel Invalido", e.getMessage());
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
	public void testaVerificaTipo(){
		carro1.verificaTipo();
		Assert.assertEquals(100, carro1.getValorDiaria(), 1);
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
