package classes;

import excecoes.*;

/**
 * Classe que manipula dados referentes ao endereco do cliente.
 * @author Ravi Leite
 * @data 23/12/2014
 * Alteracoes: 03/02/2015 / Jaaziel Levi
 */

public class Endereco {
	
	private String cidade;
	private String bairro;
	private String nomeDaRua;
	private String numeroDaCasa;
	private String complemento;
	private String estado;
	private String pais;
	private String cep;
	
	/**
	 * 
	 * @param cidade
	 * @param bairro
	 * @param rua
	 * @param numero
	 * @param complemento
	 * @param estado
	 * @param pais
	 * @throws Exception
	 */
	
	public Endereco(String cidade, String bairro, String rua, String numero, String complemento, String estado, String pais, String cep) 
			throws Exception {
		
		checaCidade(cidade);
		checaBairro(bairro);
		checaRua(rua);
		checaNumero(numero);
		checaComplemento(complemento);
		checaEstado(estado);
		checaPais(pais);
		
		this.bairro = bairro;
		this.cidade = cidade;
		nomeDaRua = rua;
		numeroDaCasa = numero;
		this.complemento = complemento;
		this.estado = estado;
		this.pais = pais;
		this.cep = cep;
	}
	
	private void checaCidade( String cidade ) throws CidadeInvalidaException {
		if ( cidade == null || cidade.equals("") ) {
			throw new CidadeInvalidaException("Nome da cidade invalido");
		}
	}
	
	private void checaBairro( String bairro ) throws BairroInvalidoException {
		if ( bairro == null || bairro.equals("") )
			throw new BairroInvalidoException("Nome do bairro invalido");
	}
	
	private void checaRua( String rua ) throws NomeRuaInvalidaException {
		if ( rua == null || rua.equals("") )
			throw new NomeRuaInvalidaException("Nome da rua invalido");
	}
	
	private void checaComplemento( String complemento ) throws ComplementoInvalidoException {
		if (complemento == null)
			throw new ComplementoInvalidoException("Complemento invalido");
	}
	
	private void checaNumero( String numero ) throws NumeroDaResidenciaInvalidoException {
		// falta adicionar nos testes
		for ( int i = 0; i < numero.length(); i++) {
			if ( ! (Character.isDigit(numero.charAt(i))) ) {
				throw new NumeroDaResidenciaInvalidoException("Numero da residencia deve ser um inteiro positivo");
			}
		}
		
		if ( Integer.parseInt(numero) <= 0 ) {
			throw new NumeroDaResidenciaInvalidoException("Numero da residencia invalido");
		}
	}
	
	private void checaEstado( String estado ) throws EstadoInvalidoException {
		if ( estado == null || estado.equals("")) {
			throw new EstadoInvalidoException("Nome do estado invalido");
		}
	}
	
	private void checaPais( String meuPais ) throws PaisInvalidoException {
		if ( meuPais == null || meuPais.equals(""))
			throw new PaisInvalidoException("Nome do pais invalido");
	}
	
	/**
	 * @return O nome da cidade do cliente.
	 */
	
	public String getCidade() {
		return cidade;
	}
	
	/**
	 * Recebe a cidade onde reside o cliente.
	 * @param cidade Cidade onde reside o cliente.
	 * @throws Exception
	 */
	
	public void setCidade(String cidade) throws Exception{
		checaCidade(cidade);
		this.cidade = cidade;
	}

	/**
	 * @return O bairro onde reside o cliente.
	 */
	
	public String getBairro() {
		return bairro;
	}

	/**
	 * Recebe o bairro onde reside o cliente.
	 * @param bairro Bairro de localizacao da rua do cliente.
	 * @throws Exception
	 */
	
	public void setBairro(String bairro) throws Exception{
		checaBairro(bairro);
		this.bairro = bairro;
	}
	
	/**
	 * @return O nome da rua do cliente.
	 */
	
	public String getNomeDaRua() {
		return nomeDaRua;
	}
	
	/**
	 * Recebe  o nome da rua do cliente.
	 * @param nomeDaRua Nome da rua onde se localiza a residencia do cliente.
	 * @throws Exception
	 */
	
	public void setNomeDaRua(String nomeDaRua)throws Exception {
		checaRua(nomeDaRua);
		this.nomeDaRua = nomeDaRua;
	}
	
	/**
	 * @return O numero da residencia do cliente.
	 */
	
	public String getNumeroDaCasa() {
		return numeroDaCasa;
	}
	
	public String getCep(){
		return cep;
	}
	
	public void setCep(String cep){
		this.cep = cep;		
	}
	
	/**
	 * Recebe o numero da residencia do cliente.
	 * @param numeroDaCasa Numero da residencia.
	 * @throws Exception
	 */
	
	public void setNumeroDaCasa(String numeroDaCasa) throws NumeroDaResidenciaInvalidoException {
		checaNumero(numeroDaCasa);
		this.numeroDaCasa = numeroDaCasa;
	}
	
	/**
	 * @return Retorna o complemento do endereco do cliente.
	 */
	
	public String getComplemento() {
		return complemento;
	}
	
	/**
	 * Recebe o complemento adicional para o endereco do cliente.
	 * @param complemento Complemento para facilitar a localizacao do endereco.
	 * @throws Exception
	 */
	
	public void setComplemento(String complemento)throws Exception {
		checaComplemento(complemento);
		this.complemento = complemento;
	}
	
	/**
	 * 
	 * @return
	 */
	
	public String getEstado() {
		return estado;
	}

	/**
	 * 
	 * @param estado
	 * @throws EstadoInvalidoException 
	 */
	
	public void setEstado(String estado) throws EstadoInvalidoException {
		checaEstado(estado);
		this.estado = estado;
	}

	/**
	 * 
	 * @return
	 */
	
	public String getPais() {
		return pais;
	}

	/**
	 * 
	 * @param pais
	 * @throws PaisInvalidoException 
	 */
	
	public void setPais(String pais) throws PaisInvalidoException {
		checaPais(pais);
		this.pais = pais;
	}

	/**
	 * Retorna uma String com os atributos de toda a classe.
	 */
	
	@Override
	public String toString() {
		return "- Cidade: " + cidade + "\n- Bairro: " + bairro + "\n- Rua: " + nomeDaRua + "\n- Numero: " + numeroDaCasa
				+ "\n- Complemento: " + complemento + "\n- Estado: " + estado + "\n- Pais: " + pais;
	}
	
	/**
	 * Verifica se dois enderecos sao iguais. Para isso a cidade, o bairro, a rua e o numero da residencia
	 * precisam ser os mesmos.
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if (! (obj instanceof Endereco) ) {
			return false;
		}
		
		Endereco novoEndereco = (Endereco)obj;
	
		return (cidade.equals(novoEndereco.getCidade()) && bairro.equals(novoEndereco.getBairro()) 
				&& nomeDaRua.equals(novoEndereco.getNomeDaRua()) 
				&& numeroDaCasa == novoEndereco.getNumeroDaCasa());
	}
}