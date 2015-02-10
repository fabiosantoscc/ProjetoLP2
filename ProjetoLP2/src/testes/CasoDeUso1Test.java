package testes;

import classes.*;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

import excecoes.BairroInvalidoException;
import excecoes.CepInvalidoException;
import excecoes.CidadeInvalidaException;
import excecoes.ComplementoInvalidoException;
import excecoes.CpfInvalidoException;
import excecoes.DddInvalidoException;
import excecoes.EmailInvalidoException;
import excecoes.HospedeInvalidoException;
import excecoes.InputArgumentInvalidException;
import excecoes.NomeInvalidoException;
import excecoes.NomeRuaInvalidaException;
import excecoes.NumeroCartaoInvalidoException;
import excecoes.NumeroDaResidenciaInvalidoException;
import excecoes.NumeroTelefoneInvalidoException;

public class CasoDeUso1Test {
	Hotel hotel;
	Endereco endereco, endereco2;
	Telefone telefone, telefone2;
	Hospede hospede, hospede2;
	
	@Before
	public void CriaObjetos() throws Exception{
			hotel = new Hotel();
			endereco = new Endereco("Campina Grande", "Bodocongo", "Rodrigues Alves", "500", "-", "Paraiba", "Brasil", "58145000");
			telefone = new Telefone ("83", "99999999");
			hospede= new Hospede("Arnold Schwarzenegger", "75265471855", "4012888888881881", "arnold.schwarzenegger@ccc.ufcg.edu.br", telefone, endereco);
			endereco2 = new Endereco("Campina Grande", "Bodocongo", "Rodrigues Alves", "500", "-", "Paraiba", "Brasil", "54232323");
			telefone2 = new Telefone ("83", "99999999");
			hospede2 = new Hospede ("Anisio", "75265471855", "4012888888881881", "moral.legal@gmail.com", telefone, endereco);
	}

	@Test
	public void testaCriaHospede() throws InputArgumentInvalidException{
		try {
			new Hospede("Anisio", "75265471855", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
		} catch( InputArgumentInvalidException e ) {
			Assert.assertEquals("Esse prompt nao deve aparecer caso o construtor esteja correto.", e.getMessage());
		}
		
		try {
			new Hospede ("", "75265471855", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o nome do hospede esta vazio.");
		} catch ( NomeInvalidoException e ) {
			Assert.assertEquals("O nome do hospede nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede (null, "75265471855", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o nome do hospede esta como null.");
		} catch ( NomeInvalidoException e ) {
			Assert.assertEquals("O nome do hospede nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("An1s1o", "75265471855", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o nome do hospede esta como null.");
		} catch ( NomeInvalidoException e ) {
			Assert.assertEquals("O nome do hospede deve conter apenas letras.", e.getMessage());
		}
		
		try{
			new Hospede ("Anisio", "", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o cpf do hospede esta vazio.");
		} catch ( CpfInvalidoException e ) {
			Assert.assertEquals("O campo do cpf nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", null, "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o cpf do hospede esta como null.");
		} catch ( CpfInvalidoException e ) {
			Assert.assertEquals("O campo do cpf nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "123456789", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o cpf esta com a quantidade de digitos invalida.");
		} catch ( CpfInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos do cpf invalida.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "abc12345678", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o cpf deve conter apenas numeros.");
		} catch ( CpfInvalidoException e ) {
			Assert.assertEquals("O cpf deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "75265471856", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o cpf nao possui digitos validados");
		} catch ( CpfInvalidoException e ) {
			Assert.assertEquals("cpf invalido", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "54797034807", "", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta vazio.");
		} catch ( NumeroCartaoInvalidoException e ) {
			Assert.assertEquals("O campo NUMERO DO CARTAO nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "11651145261", null, "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta como null.");
		} catch ( NumeroCartaoInvalidoException e ) {
			Assert.assertEquals("O campo NUMERO DO CARTAO nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "35764553709", "1234567890", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o numero do cartao esta com a quantidade de digitos invalida.");
		} catch ( NumeroCartaoInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos do cartao invalida.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "37863877709", "1111111111111111", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o numero do cartao deve conter apenas numeros.");
		} catch ( NumeroCartaoInvalidoException e ) {
			Assert.assertEquals("Numero do cartao invalido.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "37863877709", "11112222a3334444", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o numero do cartao deve conter apenas numeros.");
		} catch ( NumeroCartaoInvalidoException e ) {
			Assert.assertEquals("O numero do cartao deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "37863877709", "4012888888881881", "", telefone, endereco);
			Assert.fail("Esperava excecao pois o e-mail do hospede esta vazio.");
		} catch ( EmailInvalidoException e ) {
			Assert.assertEquals("O campo do email nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "87288982904", "5105105105105100", null, telefone, endereco);
			Assert.fail("Esperava excecao pois o e-mail do hospede esta como null.");
		} catch ( EmailInvalidoException e ) {
			Assert.assertEquals("O campo do email nao pode ser vazio.", e.getMessage());
		}
		
		try{
			new Hospede ("Anisio", "45622704545", "5105105105105100", "jose.silvagmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o e-mail do hospede nao esta no formato correto.");
		} catch ( EmailInvalidoException e ){
			Assert.assertEquals("O campo do email deve ser preenchido no formato adequado com o @.", e.getMessage());
		}
		
	}

	@Test
	public void testaAdcHospede() {
		Assert.assertEquals(0, hotel.getMapaDeHospedes().size());
		hotel.addHospede(hospede);
		Assert.assertEquals(1, hotel.getMapaDeHospedes().size());
		hotel.addHospede(hospede2);
		Assert.assertEquals(2, hotel.getMapaDeHospedes().size());
	}
	
	@Test
	public void testaPesquisaHospede()throws Exception{
		try{
			hotel.pesquisaHospede("75265471855","Arnold Schwarzenegger");
			Assert.fail("Esperava excecao pois o hospede nao existe no hotel.");
		}
		catch(HospedeInvalidoException e){
			Assert.assertEquals("Hospede nao existente no hotel", e.getLocalizedMessage());
		}
		
		try{
			hotel.pesquisaHospede("","Arnold Schwarzenegger");
			Assert.fail("Esperava excecao pois o hospede nao existe no hotel.");
		}
		catch(HospedeInvalidoException e){
			Assert.assertEquals("Hospede nao existente no hotel", e.getLocalizedMessage());
		}
		
		try{
			hotel.pesquisaHospede("75265471855","");
			Assert.fail("Esperava excecao pois o hospede nao existe no hotel.");
		}
		catch(HospedeInvalidoException e){
			Assert.assertEquals("Hospede nao existente no hotel", e.getLocalizedMessage());
		}
		
		hotel.addHospede(hospede);
		try{
			hotel.pesquisaHospede("75265471855","Arnold Schwarzenegger");
			}
		catch(HospedeInvalidoException e){
			Assert.fail("Nao deveria ocorrer erros");

		}
		
		try{
			hotel.pesquisaHospede("","Arnold Schwarzenegger");
		}
		catch(HospedeInvalidoException e){
			Assert.fail("Nao deveria ocorrer erros");
		}
		
		try{
			hotel.pesquisaHospede("75265471855","");
		}
		catch(HospedeInvalidoException e){
			Assert.fail("Nao deveria ocorrer erros");
		}
		
	}
	
	@Test
	public void testaAtualizarHospede()throws Exception{
		try {
			hospede.setNome("");
			Assert.fail("Esperava excecao pois o nome do hospede esta vazio.");
		} catch ( NomeInvalidoException e ) {
			Assert.assertEquals("O nome do hospede nao pode ser vazio.", e.getMessage());
		}
				
		try {
			hospede.setNome(null);
			Assert.fail("Esperava excecao pois o nome do hospede esta como null.");
		} catch ( NomeInvalidoException e ) {
			Assert.assertEquals("O nome do hospede nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao("");
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta vazio.");
		} catch ( NumeroCartaoInvalidoException e ) {
			Assert.assertEquals("O campo NUMERO DO CARTAO nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao(null);
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta como null.");
		} catch ( NumeroCartaoInvalidoException e ) {
			Assert.assertEquals("O campo NUMERO DO CARTAO nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao("11112222333344445");
			Assert.fail("Esperava excecao pois o numero do cartao esta com a quantidade de digitos invalida.");
		} catch ( NumeroCartaoInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos do cartao invalida.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao("11112222333a4444");
			Assert.fail("Esperava excecao pois o numero do cartao so deve conter numero.");
		} catch ( NumeroCartaoInvalidoException e ) {
			Assert.assertEquals("O numero do cartao deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao("4111111111311311");
			Assert.fail("Esperava excecao pois o numero do cartao nao eh valido.");
		} catch ( NumeroCartaoInvalidoException e ) {
			Assert.assertEquals("Numero do cartao invalido.", e.getMessage());
		}
		
		try {
			hospede.setEmail("");
			Assert.fail("Esperava excecao pois ocampo do email do hospede esta vazio.");
		} catch ( EmailInvalidoException e ) {
			Assert.assertEquals("O campo do email nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setEmail(null);
			Assert.fail("Esperava excecao pois o campo do email do hospede esta como null.");
		} catch ( EmailInvalidoException e ) {
			Assert.assertEquals("O campo do email nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setEmail("ze.taboregmail.com");
			Assert.fail("Esperava excecao pois o e-mail do hospede nao esta no formato correto.");
		} catch ( EmailInvalidoException e ) {
			Assert.assertEquals("O campo do email deve ser preenchido no formato adequado com o @.", e.getMessage());
		}
	}

	public void testaTelefone()throws Exception{
		try {
			Telefone t = new Telefone("", "88888888");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o ddd do telefone esta vazio");
		} catch ( DddInvalidoException e ) {
			Assert.assertEquals("DDD nao pode ser vazio.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("-1", "88888888");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o ddd do telefone esta negativo");
		} catch ( DddInvalidoException e ) {
			Assert.assertEquals("DDD deve conter apenas digitos.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("344", "88888888");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o ddd do telefone tem quantidade de digitos invalida");
		} catch ( DddInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos do DDD invalida.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("3e", "88888888");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o ddd do telefone tem uma letra");
		} catch ( DddInvalidoException e ) {
			Assert.assertEquals("DDD deve conter apenas digitos.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("33", "");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o numero do telefone eh vazio");
		} catch ( NumeroTelefoneInvalidoException e ) {
			Assert.assertEquals("Numero de telefone nao pode ser vazio.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("33", null);
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o numero do telefone eh vazio");
		} catch ( NumeroTelefoneInvalidoException e ) {
			Assert.assertEquals("Numero de telefone nao pode ser vazio.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("33", "-2321232");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o numero do telefone eh vazio");
		} catch ( NumeroTelefoneInvalidoException e ) {
			Assert.assertEquals("O Numero do telefone deve conter apenas digitos.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("33", "432321232");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o numero do telefone eh vazio");
		} catch ( NumeroTelefoneInvalidoException e ) {
			Assert.assertEquals("Primeiro digito do telefone deve ser 9 (nove).", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("33", "4323212");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o numero do telefone eh vazio");
		} catch ( NumeroTelefoneInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos do telefone invalida.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("33", "4323212");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o numero do telefone eh vazio");
		} catch ( NumeroTelefoneInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos do telefone invalida.", e.getMessage());
		}
	}

	public void testaEndereco()throws Exception{
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "", "Paraiba", "Brasil", "32423424");
		} catch ( ComplementoInvalidoException e ) {
			Assert.assertEquals("Esse prompt nao deve ser mostrado se o construtor estiver correto", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "", "Paraiba", "Brasil", "57391234");
		} catch ( InputArgumentInvalidException e ) {
			Assert.assertEquals("Esse prompt nao deve ser mostrado pois o complemento esta correto", e.getMessage());
		}
		
		try {
			new Endereco("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "42452213");
		} catch ( InputArgumentInvalidException e ) {
			Assert.assertEquals("Esse prompt nao deve ser mostrado se o construtor estiver correto", e.getMessage());
		}
		
		try {
			new Endereco (null, "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "33445632");
			Assert.fail("Esperava excecao pois o campo de cidade esta como null.");
		} catch ( CidadeInvalidaException e ) {
			Assert.assertEquals("Nome da cidade invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("123456", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "33445632");
			Assert.fail("Esperava excecao pois o campo de cidade esta como null.");
		} catch ( CidadeInvalidaException e ) {
			Assert.assertEquals("Nome da cidade deve conter apenas letras.", e.getMessage());
		}
		
		try {
			new Endereco ("", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "23423423");
			Assert.fail("Esperava excecao pois o campo de cidade esta vazio.");
		} catch ( CidadeInvalidaException e ) {
			Assert.assertEquals("Nome da cidade invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "42333423");
			Assert.fail("Esperava excecao pois o campo de bairro esta vazio.");
		} catch ( BairroInvalidoException e ) {
			Assert.assertEquals("Nome do bairro invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", null, "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "42344213");
			Assert.fail("Esperava excecao pois o campo de bairro esta como null.");
		} catch ( BairroInvalidoException e ) {
			Assert.assertEquals("Nome do bairro invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "123456", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "Brasil", "42344213");
			Assert.fail("Esperava excecao pois o campo de bairro esta como null.");
		} catch ( BairroInvalidoException e ) {
			Assert.assertEquals("Nome do bairro deve conter apenas letras.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "", "7", "Perto da UFCG", "Paraiba", "Brasil", "42313412");
			Assert.fail("Esperava excecao pois o campo de rua esta vazio.");
		} catch ( NomeRuaInvalidaException e ) {
			Assert.assertEquals("Nome da rua invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", null, "7", "Perto da UFCG", "Paraiba", "Brasil", "32424252");
			Assert.fail("Esperava excecao pois o campo de rua como null.");
		} catch ( NomeRuaInvalidaException e ) {
			Assert.assertEquals("Nome da rua invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "123456", "7", "Perto da UFCG", "Paraiba", "Brasil", "32424252");
			Assert.fail("Esperava excecao pois o campo de rua como null.");
		} catch ( NomeRuaInvalidaException e ) {
			Assert.assertEquals("Nome da rua deve conter apenas letras.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "0", "Perto da UFCG", "Paraiba", "Brasil", "56745323");
			Assert.fail("Esperava excecao pois o campo de numero eh zero.");
		} catch ( NumeroDaResidenciaInvalidoException e ) {
			Assert.assertEquals("Numero da residencia deve ser um inteiro positivo.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "-5", "Perto da UFCG", "Paraiba", "Brasil", "56745323");
			Assert.fail("Esperava excecao pois o campo de numero eh zero.");
		} catch ( NumeroDaResidenciaInvalidoException e ) {
			Assert.assertEquals("Numero da residencia deve ser um inteiro positivo.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "", "Perto da UFCG", "Paraiba", "Brasil", "56745323");
			Assert.fail("Esperava excecao pois o numero da casa eh vazio.");
		} catch ( NumeroDaResidenciaInvalidoException e ) {
			Assert.assertEquals("Numero da residencia nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "-7", "Perto da UFCG", "Paraiba", "Brasil", "56609876");
			Assert.fail("Esperava excecao pois o campo de numero eh menor que zero.");
		} catch ( NumeroDaResidenciaInvalidoException e ) {
			Assert.assertEquals("Numero da residencia deve ser um inteiro positivo.", e.getMessage());
		}	
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "asas6ss", "Perto da UFCG", "Paraiba", "Brasil", "56609876");
			Assert.fail("Esperava excecao pois o campo de numero eh menor que zero.");
		} catch ( NumeroDaResidenciaInvalidoException e ) {
			Assert.assertEquals("Numero da residencia deve ser um inteiro positivo.", e.getMessage());
		}	
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", null, "Paraiba", "Brasil", "32423424");
			Assert.fail("Esperava excecao pois o campo de complemento esta como null");
		} catch ( ComplementoInvalidoException e ) {
			Assert.assertEquals("Complemento invalido.", e.getMessage());
		}
		
		
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "", "Brasil", "87651238");
			Assert.fail("Esperava excecao pois o campo de estado esta vazio");
		} catch (Exception e) {
			Assert.assertEquals("Nome do estado invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", null, "Brasil", "34212122");
			Assert.fail("Esperava excecao pois o campo de estado esta como null");
		} catch (Exception e) {
			Assert.assertEquals("Nome do estado invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "123456", "Brasil", "34212122");
			Assert.fail("Esperava excecao pois o campo de estado esta como null");
		} catch (Exception e) {
			Assert.assertEquals("Nome do estado deve conter apenas letras.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "", "87463273");
			Assert.fail("Esperava excecao pois o campo de pais esta vazio");
		} catch (Exception e) {
			Assert.assertEquals("Nome do pais invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", null, "98345678");
			Assert.fail("Esperava excecao pois o campo de pais esta vazio");
		} catch (Exception e) {
			Assert.assertEquals("Nome do pais invalido.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "Perto da UFCG", "Paraiba", "1234156", "98345678");
			Assert.fail("Esperava excecao pois o campo de pais esta vazio");
		} catch (Exception e) {
			Assert.assertEquals("Nome do pais deve conter apenas letras.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "", "Paraiba", "Brasil", null);
			Assert.fail("O construtor esta valido, nao deve lancar excecao");
		} catch ( CepInvalidoException e ) {
			Assert.assertEquals("Cep nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "", "Paraiba", "Brasil", "");
			Assert.fail("O construtor esta valido, nao deve lancar excecao");
		} catch ( CepInvalidoException e ) {
			Assert.assertEquals("Cep nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "", "Paraiba", "Brasil", "88dd99ss");
			Assert.fail("O construtor esta valido, nao deve lancar excecao");
		} catch ( CepInvalidoException e ) {
			Assert.assertEquals("Cep deve conter apenas digitos.", e.getMessage());
		}
		
		try {
			new Endereco ("Campina Grande", "Bodocongo", "Rua Rodrigues ALves", "7", "", "Paraiba", "Brasil", "88dd99ss");
			Assert.fail("O construtor esta valido, nao deve lancar excecao");
		} catch ( CepInvalidoException e ) {
			Assert.assertEquals("Cep deve conter apenas digitos.", e.getMessage());
		}	
	
		
	
	}

	
}
