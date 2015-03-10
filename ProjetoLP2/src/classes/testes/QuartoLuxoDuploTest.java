package classes.testes;
//package testes;
//
//import org.junit.Test;
//
//import excecoes.QuartoEsgotadoNoHotelException;
//
//import org.junit.Assert;
//
//import classes.Hotel;
//import classes.QuartoLuxoDuplo;
//
///*
// * Classe de testes de um quarto luxo duplo, sem uso do before porque a quantidade de
// * criacao de objetos e limitada.
// * 
// * @author Fabio Alexandre Santos Silva Junior
// * Ultima alteracao: 26/01/2015
// */
//
//public class QuartoLuxoDuploTest {
//	QuartoLuxoDuplo q1;
//	QuartoLuxoDuplo q2;
//	
//	@Test
//	public void testaTudo() throws Exception {
//	
//		q1 = new QuartoLuxoDuplo(2, 0);
//					
//		Assert.assertTrue(Hotel.getCamaExtra() == 20);
//			
//		try {
//			new QuartoLuxoDuplo(4, 1);
//			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
//		} catch ( Exception e ) {
//			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
//		}
//			
//		try {
//			new QuartoLuxoDuplo(0, 2);
//			Assert.fail("Esperava excecao, o quarto esta vazio");
//		} catch ( Exception e ) {
//			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
//		}
//			
//		try {
//			new QuartoLuxoDuplo(-2, 0);
//			Assert.fail("Esperava excecao, pois a quantidade de pessoas e invalida");
//		} catch ( Exception e ) {
//			Assert.assertEquals("Quantidade de pessoas do quarto invalida", e.getMessage());
//		}
//			
//		try {
//			new QuartoLuxoDuplo(2, -2);
//			Assert.fail("Esperava excecao, pois a quantidade de quartos e invalida");
//		} catch ( Exception e ) {
//			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
//		}
//			
//		try {
//			new QuartoLuxoDuplo(2, 21);
//			Assert.fail("Esperava excecao, pois a quantidade de quartos e invalida");
//		} catch ( Exception e ) {
//			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
//		}
//			
//		Assert.assertTrue(Hotel.getCamaExtra() == 20);
//			
//		// Test getPreco()
//	
//		Assert.assertTrue(q1.getPreco() == 570.0);
//			
//		// Test getQuantidadeDePessoas()
//		
//		Assert.assertTrue(q1.getQuantidadeDePessoas() == 2);
//		
//		// Test setQuantidadeDePessoas()
//		
//		q1.setQuantidadeDePessoas(1);
//		Assert.assertTrue(q1.getQuantidadeDePessoas() == 1);
//			
//		q1.setQuantidadeDePessoas(3);
//		Assert.assertTrue(q1.getQuantidadeDePessoas() == 3);
//		
//		// Test getCama()
//		
//		Assert.assertTrue(q1.getCamaExtra() == 0);
//		
//		// Test setCama()
//	
//		try {
//			q1.setCamaExtra(-1);
//			Assert.fail("Esperava excecao, quantidade de camas invalida");
//		} catch ( Exception e ) {
//			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
//		}
//			
//		try {
//			q1.setCamaExtra(21);
//			Assert.fail("Esperava excecao, quantidade de camas invalida");
//		} catch ( Exception e ) {
//			Assert.assertEquals("Quantidade de camas extras invalida", e.getMessage());
//		}
//			
//		q1.setCamaExtra(2);
//		Assert.assertTrue(q1.getCamaExtra() == 2);
//		    
//		// Test toString()IMPOSSIVEL TESTAR TO STRING, POIS ELE TEM A DATA COMPLETA, ATE OS SEGUNDOS.
//			
//		// Test equals()
//		
//		q2 = new QuartoLuxoDuplo(3, 0);
//		Assert.assertFalse(q1.equals(q2));
//		q2.setCamaExtra(2);
//		Assert.assertTrue(q1.equals(q2));
//	
//		// Test impossivelcriarquartos
//		
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 13);
//		new QuartoLuxoDuplo(3, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 12);
//		new QuartoLuxoDuplo(1, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 11);
//		new QuartoLuxoDuplo(2, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 10);
//		new QuartoLuxoDuplo(1, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 9);
//		new QuartoLuxoDuplo(1, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 8);
//		new QuartoLuxoDuplo(1, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 7);
//		new QuartoLuxoDuplo(2, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 6);
//		new QuartoLuxoDuplo(1, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 5);
//		new QuartoLuxoDuplo(1, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 4);
//		new QuartoLuxoDuplo(1, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 3);
//		new QuartoLuxoDuplo(2, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 2);
//		new QuartoLuxoDuplo(1, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 1);
//		new QuartoLuxoDuplo(1, 0);
//		Assert.assertTrue(Hotel.getQuartoLuxoDuplo() == 0);
//		
//		try {
//			q1 = new QuartoLuxoDuplo(2, 1);
//			Assert.fail("Deve lancar excecao, quantidade de quartos invalida");
//		} catch ( QuartoEsgotadoNoHotelException e ) {
//			Assert.assertEquals("Nao ha mais quartos livres", e.getMessage());
//		}
//		
//		try {
//			q1.setCamaExtra(17);
//			Assert.fail("Deve lancar excecao, quantidade de camas invalida");
//		} catch ( Exception e ) {
//			Assert.assertEquals("Quantidade de camas extras invalida",e.getMessage());
//		}
//	}
//}