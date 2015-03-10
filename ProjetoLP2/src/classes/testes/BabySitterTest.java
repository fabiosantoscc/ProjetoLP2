package classes.testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import classes.BabySitter;

public class BabySitterTest {
	
	BabySitter baby2, baby3, baby4, baby5;
	
	@Before
	public void iniciaObjetos() throws Exception{
		baby2 = new BabySitter(6, 15);
		baby3 = new BabySitter(9, 14);
		baby4 = new BabySitter(16, 2);
		baby5 = new BabySitter(16, 7);
		
	}
	
	@Test
	public void testaConstrutor(){
		try{
			new BabySitter(0, 18);
			Assert.fail("Deveria ocorrer uma excecao!!");
		}catch(Exception e){
			Assert.assertEquals("O numero de horas tem que ser maior que zero.", e.getMessage());	
		}
		
		try{
			new BabySitter(-1, 16);
			Assert.fail("Deveria ocorrer uma excecao!!");
		}catch(Exception e){
			Assert.assertEquals("O numero de horas tem que ser maior que zero.", e.getMessage());	
		}
		
		try{
			new BabySitter(4, -1);
			Assert.fail("Deveria ocorrer uma excecao!!");
		}catch(Exception e){
			Assert.assertEquals("Hora inicial do servico invalida.", e.getMessage());	
		}	
		
		try{
			new BabySitter(4, 24);
			Assert.fail("Deveria ocorrer uma excecao!!");
		}catch(Exception e){
			Assert.assertEquals("Hora inicial do servico invalida.", e.getMessage());	
		}
	
		try{
			new BabySitter(6, 14);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");	
		}
	}
		
	@Test
	public void testaGets(){
		baby2.checaHorasDobradas(baby2.getQuantidadeHoras(), baby2.getHoraInicial());
		baby3.checaHorasDobradas(baby3.getQuantidadeHoras(), baby3.getHoraInicial());
		baby4.checaHorasDobradas(baby4.getQuantidadeHoras(), baby4.getHoraInicial());
		baby5.checaHorasDobradas(baby5.getQuantidadeHoras(), baby5.getHoraInicial());
		Assert.assertEquals(6, baby2.getQuantidadeHoras());
		Assert.assertEquals(9, baby3.getQuantidadeHoras());
		Assert.assertEquals(16, baby4.getQuantidadeHoras());
		Assert.assertEquals(16, baby5.getQuantidadeHoras());
		Assert.assertEquals(3, baby2.getQuantidadeHorasDobradas());
		Assert.assertEquals(5, baby3.getQuantidadeHorasDobradas());
		Assert.assertEquals(5, baby4.getQuantidadeHorasDobradas());
		Assert.assertEquals(5, baby5.getQuantidadeHorasDobradas());
	}
	
	// Test toString()IMPOSSIVEL TESTAR TO STRING, POIS ELE TEM A DATA COMPLETA, ATE OS SEGUNDOS.
	
	@Test
	public void testaEquals(){
		Assert.assertFalse(baby2.equals(baby3));
		Assert.assertFalse(baby2.equals(baby4));
		Assert.assertFalse(baby3.equals(baby2));
		Assert.assertFalse(baby3.equals(baby4));
		Assert.assertFalse(baby4.equals(baby2));
		Assert.assertFalse(baby4.equals(baby3));
		Assert.assertTrue(baby4.equals(baby5));
		Assert.assertTrue(baby5.equals(baby4));
	}
}
