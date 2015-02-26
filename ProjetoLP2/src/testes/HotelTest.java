//package testes;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.Test;
//
//import classes.Hotel;
//import classes.Hospede;
//import classes.Endereco;
//import classes.Telefone;
//import excecoes.HospedeInvalidoException;
//import classes.Opiniao;
//
//public class HotelTest {
//	private Hotel h1;
//	private Hospede hospede;
//	private Endereco endereco;
//	private Telefone telefone;
//	private Opiniao op1, op2, op3;
//	
//	@Before
//	public void criaObjetos()throws Exception{
//	h1 = new Hotel();
//	endereco = new Endereco("Campina Grande", "Bodocongo", "Rodrigues Alves", "500", "-", "Paraiba", "Brasil", "58145000");
//	telefone = new Telefone ("83", "99999999");
//	hospede = new Hospede("Arnold Schwarzenegger", "75265471855", "4012888888881881", "arnold.schwarzenegger@ccc.ufcg.edu.br", telefone,
//			endereco);
//	op1 = new Opiniao("Hotel bom danado!", 10);
//	op2 = new Opiniao("Rasoavel...", 7.3);
//	op3 = new Opiniao("Nao vale nada! So o restaurante presta...", 1);
//	}
//	
//	@Test
//	public void testaAdicionaHospede() throws HospedeInvalidoException{
//		Assert.assertEquals(0, h1.getMapaDeHospedes().size());
//		h1.addHospede(hospede);
//		Assert.assertEquals(1, h1.getMapaDeHospedes().size());
//	}
//	
//	@Test
//	public void testaPesquisaHospede()throws Exception{
//		try{
//			h1.pesquisaHospede("75265471855","Arnold Schwarzenegger");
//			Assert.fail("Esperava excecao pois o hospede nao existe no hotel.");
//		}
//		catch(HospedeInvalidoException e){
//			Assert.assertEquals("Hospede nao existente no hotel", e.getLocalizedMessage());
//		}
//		
//		h1.addHospede(hospede);
//		
//		Assert.assertEquals(hospede, h1.pesquisaHospede("75265471855",""));
//		Assert.assertEquals(hospede, h1.pesquisaHospede("","Arnold Schwarzenegger"));
//		Assert.assertEquals(hospede, h1.pesquisaHospede("75265471855","Arnold Schwarzenegger"));
//	}
//	
//	@Test
//	public void testaListaOpinioes(){
//		Assert.assertEquals(0, h1.getListaOpinioes().size());
//		h1.adicionaOpiniao(op1);
//		Assert.assertEquals(1, h1.getListaOpinioes().size());
//		h1.adicionaOpiniao(op2);
//		Assert.assertEquals(2, h1.getListaOpinioes().size());
//		h1.adicionaOpiniao(op3);
//		Assert.assertEquals(3, h1.getListaOpinioes().size());
//	}
//	
//	@Test
//	public void testaNotaDeAceitacao(){
//		Assert.assertEquals(0, h1.getNotaDeAceitacao(), 2);
//		h1.adicionaOpiniao(op1);
//		Assert.assertEquals(10, h1.getNotaDeAceitacao(), 2);
//		h1.adicionaOpiniao(op2);
//		Assert.assertEquals(8.65, h1.getNotaDeAceitacao(), 2);
//		h1.adicionaOpiniao(op3);
//		Assert.assertEquals(6.1, h1.getNotaDeAceitacao(), 2);
//	}
//}