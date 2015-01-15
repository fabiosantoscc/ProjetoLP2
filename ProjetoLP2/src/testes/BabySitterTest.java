package testes;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import classes.BabySitter;

public class BabySitterTest {
	
	BabySitter baby1, baby2, baby3, baby4, baby5;
	
	@Before
	public void iniciaObjetos() throws Exception{
		baby1 = new BabySitter(2, new Date());
		baby2 = new BabySitter(10, 15);
		baby3 = new BabySitter(9, 14);
		baby4 = new BabySitter(16, 2);
		baby5 = new BabySitter(16, 7);
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testaConstrutor(){
		try{
			new BabySitter(-1, new Date());
			Assert.fail("Deveria ocorrer uma exceção!!");
		}catch(Exception e){
			Assert.assertEquals("O numero de horas tem que ser maior que zero.", e.getMessage());	
		}
		
		try{
			new BabySitter(0, new Date());
			Assert.fail("Deveria ocorrer uma exceção!!");
		}catch(Exception e){
			Assert.assertEquals("O numero de horas tem que ser maior que zero.", e.getMessage());	
		}
		
		try{
			new BabySitter(10, new Date());
		}catch(Exception e){
			//Assert.fail("Não deveria ocorrer erros");	
		}
		
		try{
			new BabySitter(0, 18);
			Assert.fail("Deveria ocorrer uma exceção!!");
		}catch(Exception e){
			Assert.assertEquals("O numero de horas tem que ser maior que zero.", e.getMessage());	
		}
		
		try{
			new BabySitter(-1, 16);
			Assert.fail("Deveria ocorrer uma exceção!!");
		}catch(Exception e){
			Assert.assertEquals("O numero de horas tem que ser maior que zero.", e.getMessage());	
		}
		
		try{
			new BabySitter(4, -1);
			Assert.fail("Deveria ocorrer uma exceção!!");
		}catch(Exception e){
			Assert.assertEquals("Hora inicial do serviço inválida.", e.getMessage());	
		}	
		
		try{
			new BabySitter(4, 24);
			Assert.fail("Deveria ocorrer uma exceção!!");
		}catch(Exception e){
			Assert.assertEquals("Hora inicial do serviço inválida.", e.getMessage());	
		}
	
		try{
			new BabySitter(6, 14);
		}catch(Exception e){
			Assert.fail("Não deveria ocorrer erros!!");	
		}
	}

	
	@SuppressWarnings("deprecation")
	@Test
	public void testaGets(){
		Assert.assertEquals(2, baby1.getQuantidadeHoras());
		Assert.assertEquals(10, baby2.getQuantidadeHoras());
		Assert.assertEquals(9, baby3.getQuantidadeHoras());
		Assert.assertEquals(16, baby4.getQuantidadeHoras());
		Assert.assertEquals(16, baby5.getQuantidadeHoras());
		Assert.assertEquals(7, baby2.getQuantidadeHorasDobradas());
		Assert.assertEquals(5, baby3.getQuantidadeHorasDobradas());
		Assert.assertEquals(5, baby4.getQuantidadeHorasDobradas());
		Assert.assertEquals(5, baby5.getQuantidadeHorasDobradas());
	}
	
	@Test
	public void testaCalculaTarifa(){
		Assert.assertEquals(600.0, baby2.getPreco());
		Assert.assertEquals(475.0, baby3.getPreco());
		Assert.assertEquals(650.0, baby4.getPreco());
	}
	
	@Test
	public void testaToString(){
		Assert.assertEquals("Baby Sitter \n"
				+ "Horario de inicio do serviço: 15"
				+"\nQuantidade de Horas Normais: 10"
				+ "\nQuantidade de Horas Dobradas: 7", baby2.toString());
		Assert.assertEquals("Baby Sitter \n"
				+ "Horario de inicio do serviço: 14"
				+"\nQuantidade de Horas Normais: 9"
				+ "\nQuantidade de Horas Dobradas: 5", baby3.toString());
		Assert.assertEquals("Baby Sitter \n"
				+ "Horario de inicio do serviço: 2"
				+"\nQuantidade de Horas Normais: 16"
				+ "\nQuantidade de Horas Dobradas: 5", baby4.toString());
	}
	
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
