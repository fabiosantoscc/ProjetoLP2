package testes;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import classes.Arquivos;
import classes.Endereco;
import classes.Telefone;
import classes.Hospede;
import excecoes.DataDeNascimentoInvalidaException;
import excecoes.InputArgumentInvalidException;
import excecoes.StringInvalidaException;

/**
 * Classe de testes da classe hospede
 * Author: Ravi Lopes
 * Ultima revisao: 07/03/2015 / Fabio Alexandre
 *
 */

public class HospedeTest {
	Endereco endereco; 
	Telefone telefone;
	Hospede hospede;
	Calendar dataNascimento;
		
	@Before
	public void criaObjetos() throws InputArgumentInvalidException, DataDeNascimentoInvalidaException {
		endereco = new Endereco("Campina Grande", "Bodocongo", "Rodrigues Alves", "500", "-", "Paraiba", "Brasil", "54232323");
		telefone = new Telefone ("83", "99999999");
		dataNascimento = Calendar.getInstance();
		dataNascimento.set(1950, 10, 2);
		hospede = new Hospede ("Anisio", "75265471855", "4012888888881881", "moral.legal@gmail.com", telefone, endereco, dataNascimento);
	}
	
	@Test
	public void testaConstrutor() throws InputArgumentInvalidException, DataDeNascimentoInvalidaException {
		try {
			new Hospede("Anisio", "75265471855", "4012888888881881", "seu.email@gmail.com", telefone, endereco, dataNascimento);
		} catch( StringInvalidaException e ) {
			Assert.assertEquals("Esse prompt nao deve aparecer caso o construtor esteja correto.", e.getMessage());
		}
		
		try {
			new Hospede ("", "75265471855", "4012888888881881", "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o nome do hospede esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O nome do hospede nao pode ser vazio.", e.getMessage());
		}

		try {
			new Hospede (null, "75265471855", "4012888888881881", "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o nome do hospede esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O nome do hospede nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("An1s1o", "75265471855", "4012888888881881", "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o nome do hospede esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O nome do hospede deve conter apenas letras.", e.getMessage());
		}
		
		try{
			new Hospede ("Anisio", "", "4012888888881881", "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o cpf do hospede esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo do cpf nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", null, "4012888888881881", "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o cpf do hospede esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo do cpf nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "123456789", "4012888888881881", "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o cpf esta com a quantidade de digitos invalida.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Quantidade de digitos do cpf invalida.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "abc12345678", "4012888888881881", "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o cpf deve conter apenas numeros.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O cpf deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "75265471856", "4012888888881881", "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o cpf nao possui digitos validados");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("cpf invalido", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "54797034807", "", "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo NUMERO DO CARTAO nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "11651145261", null, "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo NUMERO DO CARTAO nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "35764553709", "1234567890", "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o numero do cartao esta com a quantidade de digitos invalida.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Quantidade de digitos do cartao invalida.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "37863877709", "1111111111111111", "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o numero do cartao deve conter apenas numeros.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Numero do cartao invalido.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "37863877709", "11112222a3334444", "seu.email@gmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o numero do cartao deve conter apenas numeros.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O numero do cartao deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "37863877709", "4012888888881881", "", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o e-mail do hospede esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo do email nao pode ser vazio.", e.getMessage());
		}
		
		try {
			new Hospede ("Anisio", "87288982904", "5105105105105100", null, telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o e-mail do hospede esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo do email nao pode ser vazio.", e.getMessage());
		}
		
		try{
			new Hospede ("Anisio", "45622704545", "5105105105105100", "jose.silvagmail.com", telefone, endereco, dataNascimento);
			Assert.fail("Esperava excecao pois o e-mail do hospede nao esta no formato correto.");
		} catch ( StringInvalidaException e ){
			Assert.assertEquals("O campo do email deve ser preenchido no formato adequado com o @.", e.getMessage());
			}
		}
	
	@Test
	public void testaSetters() throws InputArgumentInvalidException, DataDeNascimentoInvalidaException {
		
		try {
			hospede.setNome("Fabio");
		} catch ( StringInvalidaException e ) {
			Assert.fail("Nao lanca excecao, pois o nome eh valido.");
		}
		
		try {
			hospede.setNome("");
			Assert.fail("Esperava excecao pois o nome do hospede esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O nome do hospede nao pode ser vazio.", e.getMessage());
		}
				
		try {
			hospede.setNome(null);
			Assert.fail("Esperava excecao pois o nome do hospede esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O nome do hospede nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setCpf("");
			Assert.fail("Esperava excecao pois o cpf do hospede esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo do cpf nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setCpf(null);
			Assert.fail("Esperava excecao pois o cpf do hospede esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo do cpf nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setCpf("123456789123");
			Assert.fail("Esperava excecao pois o cpf esta com a quantidade de digitos invalida.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Quantidade de digitos do cpf invalida.", e.getMessage());
		}
		
		try {
			hospede.setCpf("1234567a912");
			Assert.fail("Esperava excecao pois o cpf so deve conter numero.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O cpf deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao("5480459784786499");
		} catch ( StringInvalidaException e ) {
			Assert.fail("Nao lanca excecao, pois o numero do cartao eh valido.");
		}
		
		try {
			hospede.setNumeroDoCartao("");
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo NUMERO DO CARTAO nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao(null);
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo NUMERO DO CARTAO nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao("11112222333344445");
			Assert.fail("Esperava excecao pois o numero do cartao esta com a quantidade de digitos invalida.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Quantidade de digitos do cartao invalida.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao("11112222333a4444");
			Assert.fail("Esperava excecao pois o numero do cartao so deve conter numero.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O numero do cartao deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			hospede.setNumeroDoCartao("4111111111311311");
			Assert.fail("Esperava excecao pois o numero do cartao nao eh valido.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Numero do cartao invalido.", e.getMessage());
		}

		try {
			hospede.setEmail("fabio@gmail.com");
		} catch ( StringInvalidaException e ) {
			Assert.fail("Nao deve lancar excecao, pois o e-mail eh valido.");
		}

		try {
			hospede.setEmail("");
			Assert.fail("Esperava excecao pois ocampo do email do hospede esta vazio.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo do email nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setEmail(null);
			Assert.fail("Esperava excecao pois o campo do email do hospede esta como null.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo do email nao pode ser vazio.", e.getMessage());
		}
		
		try {
			hospede.setEmail("ze.taboregmail.com");
			Assert.fail("Esperava excecao pois o e-mail do hospede nao esta no formato correto.");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O campo do email deve ser preenchido no formato adequado com o @.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("85", "88888888");
			hospede.setTelefone(t);
		} catch ( StringInvalidaException e ) {
			Assert.fail("Nao deve lancar excecao, o telefone setado eh valido.");
		}
		
		try {
			Telefone t = new Telefone("", "88888888");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o ddd do telefone esta vazio");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("DDD nao pode ser vazio.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("-1", "88888888");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o ddd do telefone esta negativo");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("DDD deve conter apenas digitos.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("344", "88888888");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o ddd do telefone tem quantidade de digitos invalida");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Quantidade de digitos do DDD invalida.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("3e", "88888888");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o ddd do telefone tem uma letra");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("DDD deve conter apenas digitos.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("33", "");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o numero do telefone eh vazio");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Numero de telefone nao pode ser vazio.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("33", null);
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o numero do telefone eh vazio");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Numero de telefone nao pode ser vazio.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("33", "-2321232");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o numero do telefone eh vazio");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("O Numero do telefone deve conter apenas digitos.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("33", "432321232");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o numero do telefone eh vazio");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Primeiro digito do telefone deve ser 9 (nove).", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("33", "4323212");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o numero do telefone eh vazio");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Quantidade de digitos do telefone invalida.", e.getMessage());
		}
		
		try {
			Telefone t = new Telefone("33", "4323212");
			hospede.setTelefone(t);
			Assert.fail("Esperava excecao pois o numero do telefone eh vazio");
		} catch ( StringInvalidaException e ) {
			Assert.assertEquals("Quantidade de digitos do telefone invalida.", e.getMessage());
		}
		
		try {
			Endereco endereco2 = new Endereco("Campina Grande", "Malvinas", "Rodrigues Alves", "500", "-", "Paraiba", "Brasil", "54232323");
			hospede.setEndereco(endereco2);
		} catch ( StringInvalidaException e ) {
			Assert.fail("Nao deve lancar excecao, pois o endereco eh valido.");
		}
		
		try {
			Calendar data = null;
			hospede.setDataDeNascimento(data);
			Assert.fail("Deve lancar excecao pois a data de nascimento eh null.");
		} catch ( DataDeNascimentoInvalidaException e ) {
			Assert.assertEquals("Data de nascimento nao pode ser vazia.", e.getMessage());
		}
		
		try {
			Calendar data = Calendar.getInstance();
			hospede.setDataDeNascimento(data);
		} catch ( DataDeNascimentoInvalidaException e ) {
			Assert.fail("Nao deve lancar excecao pois a data de nascimento eh valida.");
		}
	}

	@Test
	public void testGetters() {
		Assert.assertTrue(hospede.getTelefone().getDdd().equals("83"));
		Assert.assertTrue(hospede.getNumeroDoCartao().equals("4012888888881881"));
		Assert.assertTrue(hospede.getEmail().equals("moral.legal@gmail.com"));
		Assert.assertTrue(hospede.getEndereco().getBairro().equals("Bodocongo"));
		Assert.assertTrue(hospede.getNome().equals("Anisio"));
		Assert.assertTrue(hospede.getDataDeNascimento().get(Calendar.DAY_OF_MONTH) == 2);
		Assert.assertTrue(hospede.getDataDeNascimento().get(Calendar.MONTH) == 10);
		Assert.assertTrue(hospede.getDataDeNascimento().get(Calendar.YEAR) == 1950);
	}
	
	@Test
	public void testToString() {
		Assert.assertEquals(hospede.toString(), "- Nome: Anisio" + Arquivos.FIM_LINHA
				+ "- Endereco: " + Arquivos.FIM_LINHA + "- Cidade: Campina Grande"
				+ Arquivos.FIM_LINHA + "- Bairro: Bodocongo" + Arquivos.FIM_LINHA
				+ "- Rua: Rodrigues Alves" + Arquivos.FIM_LINHA + "- Numero: 500" 
				+ Arquivos.FIM_LINHA + "- Complemento: -" + Arquivos.FIM_LINHA
				+ "- Estado: Paraiba" + Arquivos.FIM_LINHA + "- Pais: Brasil"
				+ Arquivos.FIM_LINHA + "- Cep: 54232323" + Arquivos.FIM_LINHA
				+ "- CPF: 75265471855" + Arquivos.FIM_LINHA + "- Telefone: (83) 99999999"
      			+ Arquivos.FIM_LINHA + "- Numero do Cartao: 4012888888881881" + Arquivos.FIM_LINHA
      			+ "- E-Mail: moral.legal@gmail.com");
	}

	@Test
	public void TestaHashCode() {
		
	}
	
	@Test
	public void testaEquals() throws DataDeNascimentoInvalidaException, InputArgumentInvalidException {
		Hospede novoHospede = new Hospede ("Anisio", "65673434197", "4012888888881881", 
				"moral.legal@gmail.com", telefone, endereco, dataNascimento);
		Assert.assertFalse(hospede.equals(novoHospede));
		novoHospede.setCpf("75265471855");
		Assert.assertTrue(hospede.equals(novoHospede));
	}
}