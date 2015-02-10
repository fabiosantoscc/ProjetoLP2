package testes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import classes.Endereco;
import classes.Telefone;
import classes.Hospede;
import excecoes.*;

/**
 * Classe de testes da classe hospede
 * 
 * Author: Ravi Lopes
 * 
 * Ultima revisao: 08/02/2015 / Fabio Alexandre
 *
 */

public class HospedeTest {
	Endereco endereco; 
	Telefone telefone;
	Hospede hospede;
		
	@Before
	public void criaObjetos() throws InputArgumentInvalidException {
		endereco = new Endereco("Campina Grande", "Bodocongo", "Rodrigues Alves", "500", "-", "Paraiba", "Brasil", "54232323");
		telefone = new Telefone ("83", "99999999");
		hospede = new Hospede ("Anisio", "75265471855", "4012888888881881", "moral.legal@gmail.com", telefone, endereco);
	}
	
	@Test
	public void testaConstrutor() throws InputArgumentInvalidException {
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
	public void testaSettersEGetters() throws InputArgumentInvalidException {
		
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
			hospede.setCpf("");
			Assert.fail("Esperava excecao pois o cpf do hospede esta vazio.");
		} catch ( CpfInvalidoException e ) {
			Assert.assertEquals("O campo do cpf nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setCpf(null);
			Assert.fail("Esperava excecao pois o cpf do hospede esta como null.");
		} catch ( CpfInvalidoException e ) {
			Assert.assertEquals("O campo do cpf nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setCpf("123456789123");
			Assert.fail("Esperava excecao pois o cpf esta com a quantidade de digitos invalida.");
		} catch ( CpfInvalidoException e ) {
			Assert.assertEquals("Quantidade de digitos do cpf invalida.", e.getMessage());
		}
		
		try {
			hospede.setCpf("1234567a912");
			Assert.fail("Esperava excecao pois o cpf so deve conter numero.");
		} catch ( CpfInvalidoException e ) {
			Assert.assertEquals("O cpf deve conter apenas numeros.", e.getMessage());
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
		

	@Test
	public void testToString() {
		Assert.assertEquals(hospede.toString(), "- Nome: Anisio\n- Endereco: \n- Cidade: Campina Grande"
				+ "\n- Bairro: Bodocongo\n- Rua: Rodrigues Alves\n- Numero: 500\n- Complemento: "
				+ "-\n- Estado: Paraiba\n- Pais: Brasil\n- Cep: 54232323\n- CPF: 75265471855\n"
				+ "- Telefone: (83) 99999999\n- Numero do Cartao: 4012888888881881\n- E-Mail: "
				+ "moral.legal@gmail.com");
	}
	
	@Test
	public void testaEquals() throws InputArgumentInvalidException {
		Hospede novoHospede = new Hospede ("Anisio", "65673434197", "4012888888881881", 
				"moral.legal@gmail.com", telefone, endereco);
		Assert.assertFalse(hospede.equals(novoHospede));
		novoHospede.setCpf("75265471855");
		Assert.assertTrue(hospede.equals(novoHospede));
	}
}