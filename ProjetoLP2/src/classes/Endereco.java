package classes;

import excecoes.*;

/**
 * Classe que manipula dados referentes ao endereco do cliente.
 * @author Ravi Leite
 * @data 23/12/2014
 * Alteracoes: 29/01/2015 / Fabio Alexandre
 */

public class Endereco {
	
	private String cidade;
	private String bairro;
	private String nomeDaRua;
	private int numeroDaCasa;
	private String complemento;
	private String estado;
	private String pais;
	
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
	
	public Endereco(String cidade, String bairro, String rua, int numero, String complemento, String estado, String pais) 
			throws Exception{
		
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
	
	private void checaRua( String rua ) throws RuaInvalidaException {
		if ( rua == null || rua.equals("") )
			throw new RuaInvalidaException("Nome da rua invalido");
	}
	
	private void checaComplemento( String complemento ) throws ComplementoInvalidoException {
		if ( complemento == null )
			throw new ComplementoInvalidoException("Complemento invalido");
	}
	
	private void checaNumero( int numero ) throws NumeroDaResidenciaInvalidoException {
		if ( numero <= 0 ) {
			throw new NumeroDaResidenciaInvalidoException ("Numero da residencia invalido");
		}
	}
	
	private void checaEstado( String estado ) throws EstadoInvalidoException {
		if ( estado == null || estado.equals("")) {
			throw new EstadoInvalidoException("Nome do estado invalido");
		}
	}
	
	private void checaPais( String pais ) throws PaisInvalidoException {
		if ( pais == null || pais.equals(""))
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
		if (cidade == null || cidade.equals("")){
			throw new Exception("Cidade nao pode ser null ou vazio!");
		}
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
		if (bairro == null || bairro.equals(""))
			throw new Exception ("Bairro nao pode ser null ou vazio!");
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
		if (nomeDaRua == null || nomeDaRua.equals(""))
			throw new Exception ("Nome da rua nao pode ser null ou vazio");
		this.nomeDaRua = nomeDaRua;
	}
	
	/**
	 * @return O numero da residencia do cliente.
	 */
	
	public int getNumeroDaCasa() {
		return numeroDaCasa;
	}
	
	/**
	 * Recebe o numero da residencia do cliente.
	 * @param numeroDaCasa Numero da residencia.
	 * @throws Exception
	 */
	
	public void setNumeroDaCasa(int numeroDaCasa) throws Exception {
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
		if (complemento == null || complemento.equals(""))
			throw new Exception ("O complemento nao pode ser null ou vazio");
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
		return "";
	}
	
	/**
	 * Verifica se dois enderecos sao iguais. Para isso a cidade, o bairro, a rua e o numero da residencia
	 * precisam ser os mesmos.
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if (!(obj instanceof Endereco)) return false;
		
		Endereco novoEndereco = (Endereco)obj;
		
		if (cidade.equals(novoEndereco.getCidade()) && bairro.equals(novoEndereco.getBairro()) 
				&& nomeDaRua.equals(novoEndereco.getNomeDaRua()) 
				&& numeroDaCasa == novoEndereco.getNumeroDaCasa()) 
			return true;
		return false;
	}
}