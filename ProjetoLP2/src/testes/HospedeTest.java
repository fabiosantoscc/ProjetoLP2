package testes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import classes.Endereco;
import classes.Telefone;
import classes.Hospede;
import excecoes.InputArgumentInvalidException;

/**
 * Classe de testes da classe hospede
 * 
 * Author: Ravi Lopes
 * 
 * Ultima revisao: 03/02/2015 / Jaaziel Moura
 *
 */

public class HospedeTest {
	Endereco endereco; 
	Telefone telefone;
	Hospede hospede;
		
	
	@Before
	public void criaObjetos() throws Exception {
		endereco = new Endereco("Campina Grande", "Bodocongo", "Rodrigues Alves", "500", "-", "Paraiba", "Brasil");
		telefone = new Telefone ("83", "99999999");
		hospede = new Hospede ("Anisio", "75265471855", "4012888888881881", "moral.legal@gmail.com", telefone, endereco);
	}
	
	@Test
	public void testaConstrutor() throws Exception {
		try {
			new Hospede("Anisio", "75265471855", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
		}catch(Exception e) {
			Assert.assertEquals("Esse prompt nao deve aparecer caso o construtor esteja correto.", e.getMessage());
		}
		
		try {
			new Hospede ("", "75265471855", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o nome do hospede esta vazio.");
		} catch (Exception e) {
			Assert.assertEquals("O nome do hospede nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede (null, "75265471855", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o nome do hospede esta como null.");
		} catch (Exception e) {
			Assert.assertEquals("O nome do hospede nao pode ser vazio.", e.getMessage());
		}
		
		try{
			new Hospede ("Anisio", "", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o cpf do hospede esta vazio.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O campo do cpf nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", null, "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o cpf do hospede esta como null.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O campo do cpf nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "123456789", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o cpf esta com a quantidade de digitos invalida.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("Quantidade de digitos do cpf invalida.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "abc12345678", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o cpf deve conter apenas numeros.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O cpf deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "75265471856", "4012888888881881", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o cpf nao possui digitos validados");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("cpf invalido", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "54797034807", "", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta vazio.");
		} catch (Exception e) {
			Assert.assertEquals("O campo NUMERO DO CARTAO nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "11651145261", null, "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta como null.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O campo NUMERO DO CARTAO nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "35764553709", "1234567890", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o numero do cartao esta com a quantidade de digitos invalida.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("Quantidade de digitos do cartao invalida.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "37863877709", "11112222a3334444", "seu.email@gmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o numero do cartao deve conter apenas numeros.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O numero do cartao deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "37863877709", "4012888888881881", "", telefone, endereco);
			Assert.fail("Esperava excecao pois o e-mail do hospede esta vazio.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O campo do email nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "87288982904", "5105105105105100", null, telefone, endereco);
			Assert.fail("Esperava excecao pois o e-mail do hospede esta como null.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O campo do email nao pode ser vazio.", e.getMessage());
		}
		
		try{
			new Hospede ("Anisio", "45622704545", "5105105105105100", "jose.silvagmail.com", telefone, endereco);
			Assert.fail("Esperava excecao pois o e-mail do hospede nao esta no formato correto.");
		} catch (Exception e){
			Assert.assertEquals("O campo do email deve ser preenchido no formato adequado com o @.", e.getMessage());
			}
		}
	
	@Test
	public void testaSettersEGetters() throws Exception {
		
		hospede.setTelefone(telefone);
		Assert.assertEquals("Numero: (83) 99999999", hospede.getTelefone());
		
		hospede.setNome("Fabio");
		Assert.assertEquals("Fabio", hospede.getNome());

		try {
			hospede.setNome("");
			Assert.fail("Esperava excecao pois o nome do hospede esta vazio.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O nome do hospede nao pode ser vazio.", e.getMessage());
		}
				
		try {
			hospede.setNome(null);
			Assert.fail("Esperava excecao pois o nome do hospede esta como null.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O nome do hospede nao pode ser vazio.", e.getMessage());
		}
		
		hospede.setCpf("23714131272");
		Assert.assertEquals("23714131272", hospede.getCpf());
		
		try {
			hospede.setCpf("");
			Assert.fail("Esperava excecao pois o cpf do hospede esta vazio.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O campo do cpf nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			hospede.setCpf(null);
			Assert.fail("Esperava excecao pois o cpf do hospede esta como null.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O campo do cpf nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			hospede.setCpf("123456789123");
			Assert.fail("Esperava excecao pois o cpf esta com a quantidade de digitos invalida.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("Quantidade de digitos do cpf invalida.", e.getMessage());
		}
		
		try {
			hospede.setCpf("1234567a912");
			Assert.fail("Esperava excecao pois o cpf so deve conter numero.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O cpf deve conter apenas numeros.", e.getMessage());
		}
		
		hospede.setNumeroDoCartao("5105105105105100");
		Assert.assertEquals("5105105105105100", hospede.getNumeroDoCartao());
		
		try {
			hospede.setNumeroDoCartao("");
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta vazio.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O campo do numero do cartao nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao(null);
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta como null.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O campo do numero do cartao nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao("11112222333344445");
			Assert.fail("Esperava excecao pois o numero do cartao esta com a quantidade de digitos invalida.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("Quantidade de digitos do cartao invalida.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao("11112222333a4444");
			Assert.fail("Esperava excecao pois o numero do cartao so deve conter numero.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O numero do cartao deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao("4111111111311311");
			Assert.fail("Esperava excecao pois o numero do cartao nao eh valido.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("Cartao invalido", e.getMessage());
		}
		
		
		try {
			hospede.setEmail("");
			Assert.fail("Esperava excecao pois ocampo do email do hospede esta vazio.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O campo do email nao pode ser vazio.", e.getMessage());
		}
		
		hospede.setEmail("fabio.junior@ccc.ufcg.edu.br");
		Assert.assertEquals("fabio.junior@ccc.ufcg.edu.br", hospede.getEmail());
		
		try {
			hospede.setEmail(null);
			Assert.fail("Esperava excecao pois o campo do email do hospede esta como null.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O campo do email nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setEmail("ze.taboregmail.com");
			Assert.fail("Esperava excecao pois o e-mail do hospede nao esta no formato correto.");
		} catch (InputArgumentInvalidException e) {
			Assert.assertEquals("O campo do email deve ser preenchido no formato adequado com o @.", e.getMessage());
		}
		
	}
		

	@Test
	public void testToString() {
		Assert.assertEquals(hospede.toString(), "- Nome: Anisio\n- Endereco: \n- Cidade: Campina Grande"
				+ "\n- Bairro: Bodocongo\n- Rua: Rodrigues Alves\n- Numero: 500\n- Complemento: "
				+ "-\n- Estado: Paraiba\n- Pais: Brasil\n- CPF: 75265471855\n- Telefone: \n"
				+ "Numero: (83) 99999999\n- Numero do Cartao: 4012888888881881\n- E-Mail: "
				+ "moral.legal@gmail.com");
	}
	
	@Test
	public void testaEquals() throws Exception {
		Hospede novoHospede = new Hospede ("Anisio", "65673434197", "4012888888881881", 
				"moral.legal@gmail.com", telefone, endereco);
		Assert.assertFalse(hospede.equals(novoHospede));
		novoHospede.setCpf("75265471855");
		Assert.assertTrue(hospede.equals(novoHospede));
	}
}