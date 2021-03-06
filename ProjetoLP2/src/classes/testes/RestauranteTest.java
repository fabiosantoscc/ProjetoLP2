package classes.testes;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.Opiniao;
import classes.servicos.Restaurante;
import enums.UnidadesDoRestaurante;
import excecoes.InputArgumentInvalidException;

public class RestauranteTest {
	Restaurante restaurante1, restaurante2, restaurante3, restaurante4, restaurante5;
	
	@Before
	public void criaObjetos() throws Exception{
		restaurante1 = new Restaurante(UnidadesDoRestaurante.TERREO, 200);
		restaurante2 = new Restaurante(UnidadesDoRestaurante.COBERTURA, 400.30);
		restaurante3 = new Restaurante(UnidadesDoRestaurante.TERREO, 800.38);
		restaurante4 = new Restaurante(UnidadesDoRestaurante.COBERTURA, 800.38);
		restaurante5 = new Restaurante(UnidadesDoRestaurante.COBERTURA, 400.30);
	}
	
	@Test
	public void testaAdicionaConsumo(){
		try {
			new Restaurante(UnidadesDoRestaurante.TERREO, -20);
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido!", e.getMessage());	
		}
		
		try {
			new Restaurante(UnidadesDoRestaurante.COBERTURA, 0);
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido!", e.getMessage());	
		}
		
		try {
			new Restaurante(UnidadesDoRestaurante.TERREO, 0);
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido!", e.getMessage());	
		}
		
		try {
			new Restaurante(UnidadesDoRestaurante.COBERTURA, -1);
		} catch(Exception e) {
			Assert.assertEquals("Valor invalido!", e.getMessage());	
		}
	}
	
	@Test
	public void testaGets() {
		Assert.assertEquals(restaurante1.getDespesaTotal(), 200, 0.01);
		Assert.assertEquals(restaurante2.getDespesaTotal(), 400.30, 0.01);
		Assert.assertEquals(restaurante3.getDespesaTotal(), 800.38, 0.01);
		Assert.assertEquals(restaurante4.getDespesaTotal(), 800.38, 0.01);
		Assert.assertEquals(restaurante1.getUnidadeRestaurante(),UnidadesDoRestaurante.TERREO);
		Assert.assertEquals(restaurante2.getUnidadeRestaurante(),UnidadesDoRestaurante.COBERTURA);
		Assert.assertEquals(restaurante3.getUnidadeRestaurante(),UnidadesDoRestaurante.TERREO);
		Assert.assertEquals(restaurante4.getUnidadeRestaurante(),UnidadesDoRestaurante.COBERTURA);
	}

	@Test
	public void testaToString() {
		// Data atual para rodar os testes a qualquer momento.
		Calendar dataAtual = Calendar.getInstance();;
		
		Assert.assertEquals("Restaurante: Valor Consumido: 200.0, Unidade do Restaurante: terreo"
				+ ", Data do Consumo: " + dataAtual.get(Calendar.DAY_OF_MONTH)
				+ "/" + (dataAtual.get(Calendar.MONTH) + 1) + "/" + dataAtual.get(Calendar.YEAR), restaurante1.toString());
		Assert.assertEquals("Restaurante: Valor Consumido: 400.3, Unidade do Restaurante: cobertura"
				+ ", Data do Consumo: " + dataAtual.get(Calendar.DAY_OF_MONTH)
				+ "/" + (dataAtual.get(Calendar.MONTH) + 1) + "/" + dataAtual.get(Calendar.YEAR), restaurante2.toString());
	}
	
	@Test
	public void testaEquals() throws InputArgumentInvalidException {
		Opiniao op = new Opiniao("Genial", 10);
		Assert.assertFalse(restaurante1.equals(op));
		Assert.assertFalse(restaurante1.equals(restaurante2));
		Assert.assertFalse(restaurante1.equals(restaurante3));
		Assert.assertFalse(restaurante1.equals(restaurante4));
		Assert.assertFalse(restaurante1.equals(restaurante5));
		Assert.assertFalse(restaurante2.equals(restaurante3));
		Assert.assertFalse(restaurante2.equals(restaurante4));
		Assert.assertFalse(restaurante3.equals(restaurante4));
		Assert.assertFalse(restaurante3.equals(restaurante5));
		Assert.assertFalse(restaurante4.equals(restaurante5));
		Assert.assertTrue(restaurante2.equals(restaurante5));
	}
	

}