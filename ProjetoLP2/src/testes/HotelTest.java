package testes;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import classes.Hotel;
import classes.Hospede;
import classes.Endereco;
import classes.Telefone;

public class HotelTest {
	private Hotel h1;
	private Hospede hospede;
	private Endereco endereco;
	private Telefone telefone;
	
	@Before
	public void criaObjetos()throws Exception{
	h1 = new Hotel();
	endereco = new Endereco("Campina Grande", "Bodocongo", "Rodrigues Alves", "500", "-", "Paraiba", "Brasil");
	telefone = new Telefone ("83", "99999999");
	hospede = new Hospede("Arnold Schwarzenegger", "77788899901", "4521235687548956", "arnold.schwarzenegger@ccc.ufcg.edu.br", telefone,
			endereco);
	}
}