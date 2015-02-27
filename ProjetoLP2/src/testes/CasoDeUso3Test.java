//package testes;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//import classes.Contrato;
//import classes.Endereco;
//import classes.Hospede;
//import classes.Hotel;
//import classes.Telefone;
//
//public class CasoDeUso3Test {
//	public Hotel h;
//	public Contrato contrato;
//	public Hospede hospede;
//	public Telefone tel;
//	public Endereco end;
//	
//	@Before
//	public void criaObjetos()throws Exception{
//		h = new Hotel();
//		tel = new Telefone("83", "99457785");
//		end = new Endereco("Campina Grande", "Malvinas", "Rua das Umburanas", "66", "Perto da caixa d'agua", "Paraiba", "Brasil",
//				"58888645");
//		hospede = new Hospede("Anisio", "75265471855", "4012888888881881", "moral.legal@gmail.com", tel, end);
//	}
//	
//	@Test	
//	public void  testaFuncoesDoCasoTres()throws Exception{
//		
//		h.addHospede(hospede);
//		Assert.assertEquals(0, h.getMapaDeHospedes().get(hospede).size());
//		h.criaContrato(hospede, 200);
//		Assert.assertEquals(1, h.getMapaDeHospedes().get(hospede).size());
//		
//	}
//}