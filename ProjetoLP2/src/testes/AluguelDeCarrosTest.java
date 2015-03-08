package testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.AluguelDeCarros;
import classes.ModelosDoCarro;

public class AluguelDeCarrosTest {
	AluguelDeCarros carro1, carro2, carro3;
	
	@Before
	public void CriaObjetos() throws Exception{
		carro1 = new AluguelDeCarros(ModelosDoCarro.LUXO, true, false);
		carro2 = new AluguelDeCarros(ModelosDoCarro.EXECUTIVO, false, true);
		carro3 = new AluguelDeCarros(ModelosDoCarro.LUXO, true, false);
	}
	
	@Test
	public void tse(){
		try{
			new AluguelDeCarros(ModelosDoCarro.EXECUTIVO, true, true);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
	}
	
	@Test
	public void testaConstrutor(){
		try{
			new AluguelDeCarros(ModelosDoCarro.EXECUTIVO, true, true);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros(ModelosDoCarro.LUXO, true, true);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros(ModelosDoCarro.LUXO, false, true);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros(ModelosDoCarro.EXECUTIVO, true, false);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
		try{
			new AluguelDeCarros(ModelosDoCarro.EXECUTIVO, false, false);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");
		}
		
	}

	@Test
	public void testaGets(){
		Assert.assertEquals(ModelosDoCarro.LUXO, carro1.getModeloCarro());
		Assert.assertEquals(ModelosDoCarro.EXECUTIVO, carro2.getModeloCarro());
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
	
	// Test toString()IMPOSSIVEL TESTAR TO STRING, POIS ELE TEM A DATA COMPLETA, ATE OS SEGUNDOS.
	
	@Test
	public void testaEquals(){
		Assert.assertFalse(carro1.equals(carro2));
		Assert.assertFalse(carro2.equals(carro1));
		Assert.assertTrue(carro1.equals(carro3));
		Assert.assertFalse(carro2.equals(carro3));
		Assert.assertTrue(carro3.equals(carro1));
	}
}
