package testes;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import classes.Endereco;
import classes.Telefone;
import classes.Hospede;

public class HospedeTest {
	Endereco endereco; 
	Telefone telefone;
	Hospede hospede;
		
	
	@Before
	public void criaObjetos() throws Exception {
		endereco = new Endereco("Campina Grande", "Bodocongo", "Rua de Baixo", 500, "De frente do Bar");
		telefone = new Telefone (99999999, 87);
		hospede = new Hospede (endereco, "Anisio", "75265471855", "1334557", telefone, "4012888888881881", 
			"moral.legal@gmail.com");
	}
	
	@Test
	public void testaConstrutor() throws Exception {
		try {
			new Hospede(endereco, "Osorio", "75265471855", "123456789", telefone, "4012888888881881", 
					"seu.email@gmail.com");
		}
		
		catch(Exception e) {
			Assert.assertEquals("Esse prompt nao deve aparecer caso o construtor esteja correto.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "", "75265471855", "123456789", telefone, "4012888888881881", 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o nome do hospede esta vazio.");
		} catch (Exception e) {
			Assert.assertEquals("O nome do hospede nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, null, "75265471855", "123456789", telefone, "4012888888881881", 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o nome do hospede esta como null.");
		} catch (Exception e) {
			Assert.assertEquals("O nome do hospede nao pode ser null ou vazio.", e.getMessage());
		}
		
		try{
			new Hospede (endereco, "Osorio", "", "123456789", telefone, "4012888888881881", "seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o cpf do hospede esta vazio.");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("O campo do cpf nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", null, "123456789", telefone, "4012888888881881", 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o cpf do hospede esta como null.");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("O campo do cpf nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", "123456789123", "123456789", telefone, "4012888888881881", 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o cpf esta com a quantidade de digitos invalida.");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("Quantidade de digitos do cpf invalida.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", "123456789a2", "123456789", telefone, "4012888888881881", 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o cpf deve conter apenas numeros.");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("O cpf deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", "75265471856", "123456789", telefone, "4012888888881881", 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o cpf nao possui digitos validados");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("cpf invalido", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", "75265471855", "", telefone, "4012888888881881",
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o rg do hospede esta vazio.");
		} catch (Exception e) {
			Assert.assertEquals("O campo do rg nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osório", "83642733883", null, telefone, "4012888888881881", 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o rg do hospede esta como null.");
		} catch (Exception e) {
			Assert.assertEquals("O campo do rg nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", "27666574282", "123456", telefone, "4012888888881881", 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o rg esta com a quantidade de digitos invalida.");
		} catch (Exception e) {
			Assert.assertEquals("Quantidade de digitos do rg invalida.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", "40582557496", "123a56789", telefone, "4012888888881881", 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o rg deve conter apenas numeros.");
		} catch (Exception e) {
			Assert.assertEquals("O rg deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", "54797034807", "1234567", telefone, "", 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta vazio.");
		} catch (Exception e) {
			Assert.assertEquals("O campo do numero do cartao nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", "11651145261", "1234567", telefone, null, 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta como null.");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("O campo do numero do cartao nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", "35764553709", "1234567", telefone, "11112222333344446", 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o numero do cartao esta com a quantidade de digitos invalida.");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("Quantidade de digitos do cartao invalida.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", "37863877709", "1234567", telefone, "11112222a3334444", 
					"seu.email@gmail.com");
			Assert.fail("Esperava excecao pois o numero do cartao deve conter apenas numeros.");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("O numero do cartao deve conter apenas numeros.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", "37863877709", "1234567", telefone, "4012888888881881", 
					"");
			Assert.fail("Esperava excecao pois o e-mail do hospede esta vazio.");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("O campo do email nao pode ser null ou vazio.", e.getMessage());
		}
		
		try {
			new Hospede (endereco, "Osorio", "87288982904", "1234567", telefone, "5105105105105100", 
					null);
			Assert.fail("Esperava excecao pois o e-mail do hospede esta como null.");
		} catch (IllegalArgumentException e) {
			Assert.assertEquals("O campo do email nao pode ser null ou vazio.", e.getMessage());
		}
		
		try{
			new Hospede (endereco, "Osorio", "45622704545", "1234567", telefone, "5105105105105100", 
					"jose.silvagmail.com");
			Assert.fail("Esperava excecao pois o e-mail do hospede nao esta no formato correto.");
		} catch (Exception e){
			Assert.assertEquals("O campo do email deve ser preenchido no formato adequado com o @.", e.getMessage());
			}
		}
//	
//	@Test
//	public void testaSetters(){
//		try{
//			hospede.setNome("");
//			Assert.fail("Esperava excecao pois o nome do hospede esta vazio.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O nome do hospede nao pode ser null ou vazio.", e.getMessage());
//		}
//		
//		try{
//			hospede.setNome(null);
//			Assert.fail("Esperava excecao pois o nome do hospede esta como null.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O nome do hospede nao pode ser null ou vazio.", e.getMessage());
//		}
//		
//		try{
//			hospede.setCpf("");
//			Assert.fail("Esperava excecao pois o cpf do hospede esta vazio.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O campo do cpf nao pode ser null ou vazio.", e.getMessage());
//		}
//		
//		try{
//			hospede.setCpf(null);
//			Assert.fail("Esperava excecao pois o cpf do hospede esta como null.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O campo do cpf nao pode ser null ou vazio.", e.getMessage());
//		}
//		
//		try{
//			hospede.setCpf("123456789123");
//			Assert.fail("Esperava excecao pois o cpf esta com a quantidade de digitos invalida.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("Quantidade de digitos do cpf invalida.", e.getMessage());
//		}
//		
//		try{
//			hospede.setCpf("1234567a912");
//			Assert.fail("Esperava excecao pois o cpf so deve conter numero.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O cpf deve conter apenas numeros.", e.getMessage());
//		}
//		
//		try{
//			hospede.setRg("");
//			Assert.fail("Esperava excecao pois o rg do hospede esta vazio.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O campo do rg nao pode ser null ou vazio.", e.getMessage());
//		}
//		
//		try{
//			hospede.setRg(null);
//			Assert.fail("Esperava excecao pois o rg do hospede esta como null.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O campo do rg nao pode ser null ou vazio.", e.getMessage());
//		}
//		
//		try{
//			hospede.setRg("1234567891");
//			Assert.fail("Esperava excecao pois o rg esta com a quantidade de digitos invalida.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("Quantidade de digitos do rg invalida.", e.getMessage());
//		}
//		
//		try{
//			hospede.setRg("1234567a");
//			Assert.fail("Esperava excecao pois o rg so deve conter numero.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O rg deve conter apenas numeros.", e.getMessage());
//		}
//		
//		try{
//			hospede.setNumeroDoCartao("");
//			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta vazio.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O campo do numero do cartao nao pode ser null ou vazio.", e.getMessage());
//		}
//		
//		try{
//			hospede.setNumeroDoCartao(null);
//			Assert.fail("Esperava excecao pois o numero do cartao do hospede esta como null.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O campo do numero do cartao nao pode ser null ou vazio.", e.getMessage());
//		}
//		
//		try{
//			hospede.setNumeroDoCartao("11112222333344445");
//			Assert.fail("Esperava excecao pois o numero do cartao esta com a quantidade de digitos invalida.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("Quantidade de digitos do cartao invalida.", e.getMessage());
//		}
//		
//		try{
//			hospede.setNumeroDoCartao("11112222333a4444");
//			Assert.fail("Esperava excecao pois o numero do cartao so deve conter numero.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O numero do cartao deve conter apenas numeros.", e.getMessage());
//		}
//		
//		try{
//			hospede.setEmail("");
//			Assert.fail("Esperava excecao pois ocampo do email do hospede esta vazio.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O campo do email nao pode ser null ou vazio.", e.getMessage());
//		}
//		
//		try{
//			hospede.setEmail(null);
//			Assert.fail("Esperava excecao pois o campo do email do hospede esta como null.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O campo do email nao pode ser null ou vazio.", e.getMessage());
//		}
//		
//		try{
//			hospede.setEmail("ze.taboregmail.com");
//			Assert.fail("Esperava excecao pois o e-mail do hospede nao esta no formato correto.");
//		}
//		catch (Exception e){
//			Assert.assertEquals("O campo do email deve ser preenchido no formato adequado com o @.", e.getMessage());
//		}
//	}
//	@Test
//	public void testaToString(){
//		Assert.assertEquals(hospede.toString(), " - Nome: Anisio\n- Endereço: \n- Cidade: Campina Grande"
//				+ "\n- Bairro: Bodocongo\n- Rua: Rua de Baixo\n- Numero: 500\n- Complemento: "
//				+ "De frente do Bar\n- CPF: 12345687901\n- RG: 1334557\n- Telefone: \n- DDD: 87\n-"
//				+ " Numero: 99999999\n- Numero do Cartao: 1111222233334444\n- E-Mail: "
//				+ "moral.legal@gmail.com");
//	}
//	
//	@Test
//	public void testaEquals()throws Exception{
//		Hospede novoHospede = new Hospede (endereco, "Anisio", "12345687902", "1334557", telefone, "1111222233334444", 
//				"moral.legal@gmail.com");
//		Assert.assertFalse(hospede.equals(novoHospede));
//		novoHospede.setCpf("12345687901");
//		Assert.assertTrue(hospede.equals(novoHospede));
//	}
}