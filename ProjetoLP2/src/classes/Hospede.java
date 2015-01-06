package classes;

/**
 * Classe que manipula todos os dados referentes ao hospede
 * @author Ravi Leite
 * @data 23/12/2014
 * �ltima revisao: 04/01/2015 / Fabio Alexandre
 */

public class Hospede {

	private Endereco endereco;
	private String nome;
	private String cpf;
	private String rg;
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
	
	public Hospede( Endereco endereco, String nome, String cpf, String rg, Telefone telefone, String
			cartao, String email ) throws Exception {
		
		verificaNome(nome);
		
		if ( cpf == null || cpf.equals("") )
			throw new IllegalArgumentException("O campo do cpf nao pode ser null ou vazio.");
		
		for (int i = 0; i < cpf.length(); i++){
			if(!(Character.isDigit(cpf.charAt(i))))
				throw new IllegalArgumentException("O cpf deve conter apenas numeros.");
		}
		
		if (cpf.length() != 11)
			throw new IllegalArgumentException("Quantidade de digitos do cpf invalida.");
		
		if ( ! (isCPF(cpf) ) )
			throw new IllegalArgumentException("cpf invalido");
		
		verificaRG(rg);
		
		if ( cartao == null || cartao.equals("") )
			throw new IllegalArgumentException("O campo do numero do cartao nao pode ser null ou vazio.");
		
		if ( cartao.length() != 16 )
			throw new IllegalArgumentException("Quantidade de digitos do cartao invalida.");
		
		for ( int i = 0; i < 16; i++ ) {
			if ( !(Character.isDigit(cartao.charAt(i))) )
				throw new IllegalArgumentException("O numero do cartao deve conter apenas numeros.");
		}
		
		if ( ! (isCartao(cartao)) ) {
			throw new IllegalArgumentException("cartao invalido");
		}
		
		verificaEmail(email);
		this.endereco = endereco;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.numeroDoCartao = cartao;
		this.email = email;
	}
	
	private boolean isCPF( String cpf ) {
		
		int digito10, digito11;
		
		digito10 = calculaDigito10(cpf);
		digito11 = calculaDigito11(cpf);
		
		if ( digito10 != Integer.parseInt(cpf.charAt(9) + "") || digito11 != Integer.parseInt(cpf.charAt(10) + ""))
			return false;
		
		return true;
		
	}

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

	private void verificaNome( String nome ) throws Exception {
		if ( nome == null || nome.equals("") ) {
			throw new Exception ("O nome do hospede nao pode ser null ou vazio.");
		}
	}
	
	private void verificaRG( String rg ) throws Exception {
		if ( rg == null || rg.equals("") )
			throw new Exception ("O campo do rg nao pode ser null ou vazio.");
		
		for ( int i = 0; i < rg.length(); i++ ){
			if ( !(Character.isDigit(rg.charAt(i))) )
					throw new Exception ("O rg deve conter apenas numeros.");
		}
		
		if ( rg.length() < 7 || rg.length() > 9 )
			throw new Exception("Quantidade de digitos do rg invalida.");
	}
	
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
	
	private void verificaEmail( String email ) throws Exception {
		if ( email == null || email.equals("") )
			throw new IllegalArgumentException ("O campo do email nao pode ser null ou vazio.");
		
		if ( email.indexOf("@") == -1 )
			throw new IllegalArgumentException ("O campo do email deve ser preenchido no formato adequado com o @.");
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
	 * @throws Exception
	 */
	
	public void setNumeroDoCartao( String numeroDoCartao ) throws Exception {
		if ( !(isCartao(numeroDoCartao)) ) {
			throw new Exception("Cartao invalido");
		}
		
		this.numeroDoCartao = numeroDoCartao;
	}
	
	/**
	 * @return O numero do RG do hospede
	 */
	
	public String getRg() {
		return rg;
	}
	
	/**
	 * Recebe o numero do rg do hospede
	 * @param rg Numero do rg do hospede
	 * @throws Exception
	 */
	
	public void setRg( String rg ) throws Exception {
		verificaRG(rg);
		this.rg = rg;
	}
	
	/**
	 * @return O telefone do hospede com o dd e o numero
	 */
	
	public Telefone getTelefone() {
		return telefone;
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
	 * @throws Exception
	 */
	
	public void setEmail( String email ) throws Exception {
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
	 * Recebe o objeto refente ao endereco do hospede
	 * @param endereco Objeto contendo todas as informações do endereco do hospede
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
	 * @throws Exception
	 */
	
	public void setNome( String nome ) throws Exception {
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
	 * @throws Exception
	 */
	
	public void setCpf( String cpf ) throws Exception {
		if ( ! (isCPF(cpf)) ) {
			throw new Exception ("cpf invalido");
		}
		
		this.cpf = cpf;
	}
	
	/**
	 * Retorna uma String com todos os atributos referentes ao hospede em formato de listagem
	 * para ser usado no contrato se necessario
	 */
	
	@Override
	public String toString() {
		return " - Nome: " + nome + "\n" + "- Endereço: \n" + endereco.toString() + "\n"  + "- CPF: " + cpf +
				"\n" + "- RG: " + rg + "\n- Telefone: \n" + telefone + "\n" +
				"- Numero do Cartao: " + numeroDoCartao + "\n" + "- E-Mail: " + email;
	}
	
	/**
	 * @return Um inteiro representando o hospede.
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
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