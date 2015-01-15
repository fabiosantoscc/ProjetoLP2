package lp2.projeto;

import java.util.GregorianCalendar;

/**
 * Classe que manipula os dados referentes ao contrato do hospede
 * @author Ravi Leite
 * @data 12/01/2015
 */

public class Contrato {
	private GregorianCalendar inicioDoContrato, fimDoContrato;
	private Hospede hospede;
	private boolean fechado;
	private double valorTotal;
	
	/**
	 * Construtor de um contrato que não tem data de encerramento
	 * @param hospede Contem todos os dados referentes ao hospede
	 * @param fechado Indica se o contrato ja foi ou nao pago, esta fechado ou aberto
	 * @param inicioDoContrato Data do inicio do contrato
	 * @param fimDoContrato Data do fim do contrato
	 */
	
	public Contrato(Hospede hospede, boolean fechado, GregorianCalendar inicioDoContrato, GregorianCalendar fimDoContrato,
			double valorTotal){
		this.inicioDoContrato = inicioDoContrato;
		this.fimDoContrato = fimDoContrato;
		this.fechado = fechado;
		this.hospede = hospede;
		this.valorTotal = valorTotal;
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
	 * @return O objeto referente ao hospede
	 */
	
	public Hospede getHospede() {
		return hospede;
	}
	
	/**
	 * @return Todo o valor gasto durante o período
	 */
	
	public double getValorTotal(){
		return valorTotal;
	}
	
	/**
	 * Retorna todos os dados referentes a classe em uma string
	 */
	
	@Override
	public String toString() {
		return " - Hospede: " + hospede.getNome() + "\n" + " - Inicio do Contrato: " + inicioDoContrato + "\n" +
				" - Fim do Contrato: " + fimDoContrato + "\n" + " - Contrato fechado: " + fechado + "\n"
				+ " - Valor Total: R$" + valorTotal ;
	}
	
	/**
	 * Verifica se dois contratos são iguais
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if (!(obj instanceof Contrato)) return false;
		Contrato novoContrato = (Contrato)obj;
		if (hospede.equals(novoContrato.getHospede()) && inicioDoContrato.equals(novoContrato.getInicioDoContrato())
				&& fimDoContrato.equals(novoContrato.getFimDoContrato())) return true;
		return false;
	}
}

