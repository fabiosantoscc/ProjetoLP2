package classes.servicos;

/**
 * Interface de um servico, que deve ter um preco e uma descricao.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima alteracao 14/01/2015
 *
 */

public interface Servico {

	public double getDespesaTotal();
	public void calculaDespesaTotal();
	public String toString();
}
 