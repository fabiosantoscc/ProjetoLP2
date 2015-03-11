package classes.testes;

import classes.Hotel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import excecoes.StringInvalidaException;

public class HotelTest {
	
	Hotel h;
	
	@Before
	public void criaObjeto() throws StringInvalidaException {
		h = new Hotel("senhaSecreta");
	}
	
	
}