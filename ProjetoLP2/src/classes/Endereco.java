package classes;

/**
 * Classe que manipula dados referentes ao endereco do cliente.
 * @author Ravi Leite
 * @data 23/12/2014
 * Alteracoes: 25/12/2014
 */

public class Endereco {
	
	private String cidade;
	private String bairro;
	private String nomeDaRua;
	private int numeroDaCasa;
	private String complemento;
	
	/**
	 * Construtor da classe.
	 * @param cidade Cidade onde reside o cliente.
	 * @param bairro Bairo onde se localiza a rua do cliente.
	 * @param rua Rua onde se localiza a residencia do cliente.
	 * @param numero Numero de identificacao da residencia .
	 * @param complemento Complemento adicional e opcional.
	 * @throws Exception
	 */
	
	public Endereco(String cidade, String bairro, String rua, int numero, String complemento) throws Exception{
		checaNomes(cidade, bairro, rua, complemento);
		checaNumero(numero);
		this.bairro = bairro;
		this.cidade = cidade;
		nomeDaRua = rua;
		numeroDaCasa = numero;
		this.complemento = complemento;
	}
	
	private void checaNomes(String cidade, String bairro, String rua, String complemento) throws Exception{
		if (cidade == null || cidade.equals("") || bairro == null || bairro.equals("") ||
				rua == null || rua.equals("") || complemento == null || complemento.equals(""))
			throw new Exception ("Cidade, bairro, rua e complemento nao pode ser null ou vazio");
	}
	
	private void checaNumero(int numero) throws Exception{
		if (numero <= 0){
			throw new Exception ("Insira um numero de residência valido!");
		}
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
	 * Retorna uma String com os atributos de toda a classe.
	 */
	
	@Override
	public String toString() {
		return "- Cidade: " + cidade + "\n" + "- Bairro: " + bairro + "\n" + "- Rua: " + 
				nomeDaRua + "\n" + "- Numero: " + 
				numeroDaCasa + "\n" + "- Complemento: " + complemento;
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