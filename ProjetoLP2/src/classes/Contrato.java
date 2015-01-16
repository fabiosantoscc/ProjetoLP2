package classes;

import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;


/**
 * Classe que manipula os dados referentes ao contrato do hospede
 * @author Ravi Leite
 * @data 12/01/2015
 * Ultima alteracao: 16/01/2015 / Fabio Alexandre
 */

// falta o arraylist de servicos

public class Contrato {
	
	private GregorianCalendar inicioDoContrato, fimDoContrato;
	private List<Servicos> servicos = new ArrayList<Servicos>();
	private boolean fechado;
	private double valorTotal;
	
	/**
	 * Construtor de um contrato que não tem data de encerramento
	 * 
	 * @param hospede Contem todos os dados referentes ao hospede
	 * @param fechado Indica se o contrato ja foi ou nao pago, esta fechado ou aberto
	 * @param inicioDoContrato Data do inicio do contrato
	 * @param fimDoContrato Data do fim do contrato
	 */
	
	public Contrato( Hospede hospede, GregorianCalendar inicioDoContrato, GregorianCalendar fimDoContrato,
			double valorTotal ) {
		
		this.inicioDoContrato = inicioDoContrato;
		this.fimDoContrato = fimDoContrato;
		this.fechado = false;
		this.valorTotal = valorTotal;
	}	
	
	public void adicionaServico( Servicos servico ) {
		servicos.add(servico);
	}
	
	/**
	 * @return A data do inicio do contrato
	 */
	
	public GregorianCalendar getInicioDoContrato() {
		return inicioDoContrato;
	}
	
	/**
	 * @return A data do fim do contrato
	 */
	
	public GregorianCalendar getFimDoContrato() {
		return fimDoContrato;
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
	
	public double getValorTotal(){
		return valorTotal;
	}
	
	/**
	 * Retorna todos os dados referentes a classe em uma string
	 */
	
	@Override
	public String toString() {
		return "- Inicio do Contrato: " + inicioDoContrato + "\n" + " - Fim do Contrato: " + 
				fimDoContrato + "\n" + " - Contrato fechado: " + fechado + "\n"
				+ " - Valor Total: R$ " + valorTotal ;
	}
	
	/**
	 * Verifica se dois contratos sao iguais
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if (!(obj instanceof Contrato))
			return false;
		
		Contrato novoContrato = (Contrato)obj;
		
		return (inicioDoContrato.equals(novoContrato.getInicioDoContrato())
				&& fimDoContrato.equals(novoContrato.getFimDoContrato()));
	}
}

