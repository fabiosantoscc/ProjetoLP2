package testes;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import classes.Contrato;
import excecoes.NumeroDeNoitesInvalidoException;

/**
 * Classe de testes da classe Contrato.
 * 
 * @author Jaaziel Moura
 * 
 * Criação: 05/02/2015
 */

public class ContratoTest {
	
	Contrato contrato, novoContrato;
	Calendar c = Calendar.getInstance();
	private Calendar data = c;
	
	@Before
	public void constroiObjetos()throws NumeroDeNoitesInvalidoException {
		contrato = new Contrato(3);
		novoContrato = new Contrato(3);
	}
	
	@Test
	public void testaConstrutor() throws NumeroDeNoitesInvalidoException {
		try {
			new Contrato(3);
		} catch (NumeroDeNoitesInvalidoException e) {
			Assert.assertEquals( e.getMessage(), "Esse prompt nao deve ser mostrado, construtor esta correto");
		}
		
		try {
			new Contrato(0);
			Assert.fail("Esperava excecao pois numero de dias esta igual a zero.");
		} catch ( NumeroDeNoitesInvalidoException e) {
			Assert.assertEquals("Numero de dias deve ser maior que zero.", e.getMessage());
		}
		
		try {
			new Contrato(-4);
			Assert.fail("Esperava excecao pois numero de dias esta menor que zero.");
		} catch (Exception e) {
			Assert.assertEquals("Numero de dias deve ser maior que zero.", e.getMessage());
		}
	}
	
	@Test
	public void testaGettersAndSetters() throws Exception {
		contrato.setAberto(true);
		Assert.assertEquals(true, contrato.isAberto());
		contrato.setAberto(false);
		Assert.assertEquals(false, contrato.isAberto());
		
		Assert.assertEquals(contrato.getDiaInicial(), c.get(Calendar.DAY_OF_MONTH));
		Assert.assertEquals(contrato.getMesInicial(), c.get(Calendar.MONTH) + 1);
		Assert.assertEquals(contrato.getAnoInicial(), c.get(Calendar.YEAR));
		
		Assert.assertEquals(contrato.getNumeroDeNoites(), 3);
		
		//valorAPagar ainda não foi usado, teste deverá ser refeito quando a variavel estiver sendo calculada.
		Assert.assertEquals(contrato.getValorAPagar(), 0.0, 2);
	}
	
	@Test
	public void testaToString(){
		contrato.setAberto(true);
		Assert.assertEquals(contrato.toString(), "Contrato [ Criado em " + c.get(Calendar.DAY_OF_MONTH) + "/" 
				+ (c.get(Calendar.MONTH) + 1) + "/" +  c.get(Calendar.YEAR) + " as " + data.get(Calendar.HOUR_OF_DAY)
				+ ":" + data.get(Calendar.MINUTE) + ":" + data.get(Calendar.SECOND) + "\nContrato aberto"
				+ ", Noites de hospedagem: " + 3 + " ]");
		
		contrato.setAberto(false);
		Assert.assertEquals(contrato.toString(), "Contrato [ Criado em " + c.get(Calendar.DAY_OF_MONTH) + "/" 
				+ (c.get(Calendar.MONTH) + 1) + "/" +  c.get(Calendar.YEAR) + " as " + data.get(Calendar.HOUR_OF_DAY)
				+ ":" + data.get(Calendar.MINUTE) + ":" + data.get(Calendar.SECOND) + "\nContrato fechado"
				+ ", Noites de hospedagem: " + 3 + " ]");
	}
	
	@Test
	public void testaEquals() {
		contrato.setAberto(false);
		novoContrato.setAberto(true);
		Assert.assertFalse(contrato.equals(novoContrato));
		contrato.setAberto(true);
		novoContrato.setAberto(true);
		Assert.assertTrue(contrato.equals(novoContrato));
	}
}