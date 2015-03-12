package classes.testes;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import classes.Contrato;
import classes.Hotel;
import classes.dadosDoHospede.Endereco;
import classes.dadosDoHospede.Hospede;
import classes.dadosDoHospede.Telefone;
import classes.servicos.BabySitter;
import classes.servicos.Quarto;
import classes.servicos.QuartoExecutivo;
import enums.SubtipoDeQuartoExecutivo;

public class CasoDeUso2Test {
	public Contrato cont;
	public Hotel h;
	public Hospede hospede;
	public Quarto quarto;
	public BabySitter baby;
	public Telefone tel;
	public Endereco end;
	
	
	@Before
	public void criaObjetos()throws Exception{
		h = new Hotel("123");
		tel = new Telefone("83", "99457785");
		end = new Endereco("Campina Grande", "Malvinas", "Rua das Umburanas", "66", "Perto da caixa d'agua", "Paraiba", "Brasil",
				"58888645");
		Calendar data = Calendar.getInstance();
		hospede = new Hospede("Anisio", "75265471855", "4012888888881881", "moral.legal@gmail.com", tel, end, data);
		baby = new BabySitter(12, 2);
		quarto = new QuartoExecutivo(2, SubtipoDeQuartoExecutivo.SIMPLES);
	}
	
	@Test
	public void testaFuncoesDoCasoDois()throws Exception{
		
		// Adicao de servicos ao contrato criado de um determinado hospede
		
		h.addHospede(hospede);
		h.criaContrato(hospede, 200);
		h.adicionaServico(hospede, baby);
		Assert.assertEquals(1,h.getServicosHospede(hospede).size());
		h.adicionaServico(hospede, quarto);
		Assert.assertEquals(2, h.getServicosHospede(hospede).size());
		
		//Pesquisa de Servicos em um contrato de um determinado hospede (neste caso, Anisio)
		
		Assert.assertTrue(h.getServicosHospede(hospede).get(0).equals(baby));
		
		//Atualizacao de servicos pertencentes a um contrato
		
		Quarto auxiliar = (Quarto)h.getServicosHospede(hospede).get(1);
		Assert.assertEquals( 2, auxiliar.getQuantidadeDePessoas());
		auxiliar.setQuantidadeDePessoas(3);
		Quarto verifica = (Quarto)h.getServicosHospede(hospede).get(1);
		Assert.assertEquals(3, verifica.getQuantidadeDePessoas());
		
		//Remocao de servicos pertencentes a um contrato
		
		Assert.assertEquals(2 ,h.getServicosHospede(hospede).size());
		h.getServicosHospede(hospede).remove(quarto);
		h.getServicosHospede(hospede).remove(baby);
	}
	
}
