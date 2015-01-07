package classes;

/**
 * Classe que contem os dados referentes ao numedo do telefone do hospede
 * @author Ravi Leite
 * @data 23/12/2014
 * Ultima alteracao: 07/01/2015 / Fabio Alexandre
 */

public class Telefone {
	
	long numero;
	int ddd;
	
	/**
	 * Contrutor da classe Telefone
	 * @param numero Numero do telefone
	 * @param ddd DDD do telefone
	 * @throws Exception
	 */
	
	public Telefone(long numero, int ddd) throws Exception {
		verificaNumero(numero);
		verificaDDD(ddd);
		this.numero = numero;
		this.ddd = ddd;
	}
	
	private void verificaNumero(long numero) throws Exception {
		String numeroString = "" + numero;
		if ( numeroString.length() > 9 || numeroString.length() < 8 )
			throw new IllegalArgumentException ("Quantidade de digitos invalida.");
	}
	
	private void verificaDDD(int ddd) throws Exception {
		String dddString = "" + ddd;
		if ( dddString.length() != 2 )
			throw new IllegalArgumentException ("Quantidade de digitos invalida.");
	}
	
	/**
	 * @return Retorna o numero do telefone do hospede
	 */
	
	public long getNumero() {
		return numero;
	}
	
	/**
	 * Recebe o numero do telefone do hospede
	 * @param numero Numero do telefone
	 * @throws Exception
	 */
	
	public void setNumero(long numero) throws Exception {
		verificaNumero(numero);
		this.numero = numero;
	}
	
	/**
	 * @return Retorna o ddd do telefone
	 */
	
	public int getDdd() {
		return ddd;
	}
	
	/**
	 * Recebe o DDD to telefone
	 * @param ddd DDD do numero do telefone
	 * @throws Exception
	 */
	
	public void setDdd(int ddd) throws Exception {
		verificaDDD(ddd);
		this.ddd = ddd;
	}
	
	/**
	 * Retorna os atributos da classe telefone como uma string  em formato de lista
	 */
	
	@Override
	public String toString() {
		return "Numero: " + getDdd() + "-" + getNumero();
	}
	
	/**
	 * Verifica se dois telefone sao iguais, para isso o numero e o ddd precisam ser iguais
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Telefone))
			return false;
		
		Telefone novoTelefone = (Telefone) obj;
		
		return (ddd == novoTelefone.getDdd() && numero == novoTelefone.getNumero());
	}
}
