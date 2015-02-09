package classes;

import java.io.Serializable;

import excecoes.*;

/**
 * Classe que manipula todos os dados referentes ao hospede
 * @author Ravi Leite
 * @data 23/12/2014
 * Ãºltima revisao: 30/01/2015 / Jaaziel Moura
 */

public class Hospede implements Serializable {

	private static final long serialVersionUID = 1L;
	private Endereco endereco;
	private String nome;
	private String cpf;
	private Telefone telefone;
	private String numeroDoCartao;
	private String email;
	
	/**
	 * Construtor da classe Hospede
	 * @param endereco Objeto com todos os dados do endereco
	 * @param nome Nome do hospede
	 * @param cpf Cpf do hospede
	 * @param rg Registro Geral do hospede
	 * @param telefone Objeto com ddd e numero do telefone de contato do hospede
	 * @param cartao Numero de cartao de Credito do hospede
	 * @param email E mail para contato do hospede
	 * @throws Exception
	 */

	public Hospede( String nome, String cpf, String
			cartao, String email, Telefone telefone, Endereco endereco ) throws InputArgumentInvalidException {
		
		verificaNome(nome);
		verificaCpf(cpf);
		verificaCartao(cartao);
		verificaEmail(email);
		
		this.endereco = endereco;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.numeroDoCartao = cartao;
		this.email = email;
	}
	
	/**
	 * Metodo para verificação do CPF
	 * @param cpf do cliente
	 * @throws Exception
	 */
	private void verificaCpf(String cpf) throws InputArgumentInvalidException{
		if (cpf == null || cpf.equals(""))
			throw new CpfInvalidoException("O campo do cpf nao pode ser vazio.");
		
		for (int i = 0; i < cpf.length(); i++){
			if(!(Character.isDigit(cpf.charAt(i))))
				throw new CpfInvalidoException("O cpf deve conter apenas numeros.");
		}
		
		if (cpf.length() != 11)
			throw new CpfInvalidoException("Quantidade de digitos do cpf invalida.");
		
		if ( ! (isCPF(cpf) ) )
			throw new CpfInvalidoException("cpf invalido");
	}
	
	/**
	 * Metodo para testar se é um CPF válido
	 * @param cpf do cliente
	 * @return verdadeiro caso seja um CPF válido
	 */
	private boolean isCPF( String cpf ) {
		
		int digito10, digito11;
		
		digito10 = calculaDigito10(cpf);
		digito11 = calculaDigito11(cpf);
		
		if ( digito10 != Integer.parseInt(cpf.charAt(9) + "") || digito11 != Integer.parseInt(cpf.charAt(10) + ""))
			return false;
		
		return true;
	}

	/**
	 * Metodo para calcular o 11° digito do CPF
	 * @param cpf do cliente
	 * @return o 11° digito do CPF
	 */
	
	private int calculaDigito11( String cpf ) {
		int digito11, soma = 0, j = 0;
		
		for ( int i = 11; i > 1; i-- ) {
			soma += Integer.parseInt(cpf.charAt(j) + "") * i;
			j++;
		}
		
		if ( 11 - ( soma % 11 ) == 10 || 11 - ( soma % 11 ) == 11 ) {
			digito11 = 0;
		} else {
			digito11 = 11 - ( soma % 11 );
		}
		
		return digito11;
	}
	
	/**
	 * Metodo para calcular o 10° digito do CPF
	 * @param cpf do cliente
	 * @return o 10° digito do CPF
	 */
	
	private int calculaDigito10( String cpf ) {
		int digito10, soma = 0, j = 0;
		
		for ( int i = 10; i > 1; i-- ) {
			soma += Integer.parseInt(cpf.charAt(j) + "") * i;
			j++;
		}
		
		if ( 11 - ( soma % 11 ) == 10 || 11 - ( soma % 11 ) == 11 ) {
			digito10 = 0;
		} else {
			digito10 = 11 - ( soma % 11 );
		}
		
		return digito10;
	}
	
	/**
	 * Metodo para verificação do nome do cliente
	 * @param nome do cliente
	 * @throws InputArgumentInvalidException
	 */
	
	private void verificaNome( String nome ) throws InputArgumentInvalidException {
		
		if ( nome == null || nome.equals("") ) {
			throw new NomeInvalidoException("O nome do hospede nao pode ser vazio.");
		}
		
		// falta testar isso em hotel test
		for ( int i = 0; i < nome.length(); i++) {
			if ((Character.isDigit(nome.charAt(i))))
				throw new NomeInvalidoException("O nome do hospede deve conter apenas letras.");
		}
	}
	
	/**
	 * Metodo para verificação do cartão de credito do cliente
	 * @param cartao numero do cartão de credito do cliente
	 * @throws InputArgumentInvalidException  
	 * @throws InputArgumentInvalidException
	 */
	
	private void verificaCartao(String cartao) throws InputArgumentInvalidException {
		
		if (cartao == null || cartao.equals(""))
			throw new NumeroCartaoInvalidoException("O campo NUMERO DO CARTAO nao pode ser vazio.");
		
		if (cartao.length() != 16)
			throw new NumeroCartaoInvalidoException("Quantidade de digitos do cartao invalida.");
		
		for (int i = 0; i < 16; i++) {
			if (!(Character.isDigit(cartao.charAt(i))))
				throw new NumeroCartaoInvalidoException("O numero do cartao deve conter apenas numeros.");
		}
		
		if (!(isCartao(cartao)))
			throw new NumeroCartaoInvalidoException("Numero do cartao invalido.");
	}
	
	/**
	 * Metodo para testar se o numero do cartao informado e valido.
	 * 
	 * @param cartao Numero do cartao de credito do hospede.
	 * @return verdadeiro se for um cartao valido
	 */
	
	private boolean isCartao( String cartao ) {
				
		int somatorio = 0;
		for ( int i = 0; i < cartao.length(); i++) {
			if ( (i + 1) % 2 != 0 ) {
				if ( Integer.parseInt(cartao.charAt(i) + "") * 2 <= 9 ) {
					somatorio += Integer.parseInt(cartao.charAt(i) + "") * 2;
				} else {
					somatorio += (Integer.parseInt(cartao.charAt(i) + "") * 2) - 9;
				}
				
			} else {
				somatorio += Integer.parseInt(cartao.charAt(i) + "");
			}
		}
		
		if ( somatorio % 10 != 0 || somatorio > 150 ) {
			return false;
		}
			
		return true;
	}
	
	/**
	 * Metodo para verificar email
	 * @param email do cliente
	 * @throws InputArgumentInvalidException
	 */
	
	private void verificaEmail( String email ) throws InputArgumentInvalidException {
		if ( email == null || email.equals("") )
			throw new EmailInvalidoException("O campo do email nao pode ser vazio.");
		
		if ( email.indexOf("@") == -1 )
			throw new EmailInvalidoException("O campo do email deve ser preenchido no formato adequado com o @.");
	}
	

	
	public Telefone getTelefone(){
		return telefone;
	}
	  

	/**
	 * @return O numero do cartao de credito do hospede
	 */
	
	public String getNumeroDoCartao() {
		return numeroDoCartao;
	}
	
	/**
	 * Recebe o numero do cartao de credito
	 * @param numeroDoCartao Numero do cartao de credito
	 * @throws InputArgumentInvalidException
	 */
	
	public void setNumeroDoCartao( String numeroDoCartao ) throws InputArgumentInvalidException {
		verificaCartao(numeroDoCartao);
		this.numeroDoCartao = numeroDoCartao;
	}

	/**
	 * Recebe o objeto que contem o numero de telefone do hospede
	 * @param telefone Numero de telefone do hospede
	 */
	
	public void setTelefone( Telefone telefone ) {
		this.telefone = telefone;
	}
	
	/**
	 * @return O email do hospede
	 */
	
	public String getEmail() {
		return email;
	}
	
	/**
	 * Recebe o email do hospede
	 * @param email Email para contato
	 * @throws InputArgumentInvalidException
	 */
	
	public void setEmail( String email ) throws InputArgumentInvalidException {
		verificaEmail(email);
		this.email = email;
	}
	
	/**
	 * @return Um objeto com todos os dados referentes ao endereco do hospede
	 */
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	/**
	 * Atribui um novo endereco ao hospede.
	 * 
	 * @param endereco Todas as informacoes do endereco do hospede.
	 */
	
	public void setEndereco( Endereco endereco ) {
		this.endereco = endereco;
	}
	
	/**
	 * @return O nome do hospede
	 */
	
	public String getNome() {
		return nome;
	}
	
	/**
	 * Recebe o nome do hospede
	 * @param nome Nome do hospede
	 * @throws InputArgumentInvalidException
	 */
	
	public void setNome( String nome ) throws InputArgumentInvalidException {
		verificaNome(nome);
		this.nome = nome;
	}
	
	/**
	 * @return Retorna o cpf do hospede
	 */
	
	public String getCpf() {
		return cpf;
	}
	
	/**
	 * Recebe o cpf do hospede
	 * @param cpf Numero do Cpf do Hospede
	 * @throws InputArgumentInvalidException
	 */
	
	public void setCpf(String cpf) throws InputArgumentInvalidException {
		verificaCpf(cpf);
		this.cpf = cpf;
	}
	
	/**
	 * Retorna uma String com todos os atributos referentes ao hospede em formato de listagem
	 * para ser usado no contrato se necessario
	 */
	
	@Override
	public String toString() {
		return "- Nome: " + nome + "\n" + "- Endereco: \n" + endereco.toString() + "\n"  + "- CPF: " + cpf +
				"\n- Telefone: " + telefone + "\n" +
				"- Numero do Cartao: " + numeroDoCartao + "\n" + "- E-Mail: " + email;
	}
	
	/**
	 * Verifica se dois hospedes sao iguais, para isso o cpf e o nome devem ser iguais
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Hospede))
			return false;
		
		Hospede novoHospede = (Hospede)obj;
		
		return ( nome.equals(novoHospede.getNome()) && cpf == novoHospede.getCpf() );
	}
}