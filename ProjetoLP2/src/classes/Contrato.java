package classes;

import java.util.List;
import java.util.ArrayList;


/**
 * Classe que manipula os dados referentes ao contrato do hospede
 * @author Ravi Leite
 * @data 12/01/2015
 * Ultima alteracao: 16/01/2015 / Fabio Alexandre
 */

public class Contrato {
	
	private List<Servicos> servicos = new ArrayList<Servicos>();
	private boolean fechado;
	private double valorAPagar;
	
	/**
	 * Construtor de um contrato que nao tem data de encerramento
	 * 
	 * @param fechado Indica se o contrato ja foi ou nao pago, esta fechado ou aberto
	 * @param inicioDoContrato Data do inicio do contrato
	 * @param fimDoContrato Data do fim do contrato
	 */
	
	public Contrato( Hospede hospede ) {
		
		this.fechado = false;
	}	
	
	/**
	 * 
	 */
	
	public void adicionaServico( Servicos servico ) {
		servicos.add(servico);
	}

	/**
	 * @return Verdadeiro ou falso dependendo do contrato se estiver aberto ou fechado
	 */
	
	public boolean isfechado() {
		return fechado;
	}
	
	/**
	 *
	 */
	
	public void SetFechado(boolean fechado) {
		this.fechado = fechado;
	}
	
	/**
	 * @return Todo o valor gasto durante o periodo
	 */
	
	public double getValorAPagarl(){
		return valorAPagar;
	}
	
	/**
	 * Retorna todos os dados referentes a classe em uma string
	 */
	
	@Override
	public String toString() {
		return "";
	}
	
	/**
	 * Verifica se dois contratos sao iguais
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if (!(obj instanceof Contrato))
			return false;
		
		Contrato novoContrato = (Contrato)obj;
		
		return true;
	}
}

