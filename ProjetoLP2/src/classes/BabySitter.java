package classes;

import java.io.Serializable;

import classes.BabySitter;

/**
 * Classe que recebe a quantidade de horas contratadas da Baby Sitter e faz um balanço
 * geral da despesa com esse servico
 * @author Ravi Leite and Ronan Souza
 * @data 02/01/2015
 * 
 * Atualizacao 01/02/2015 Ravi Leite
 */

public class BabySitter implements Servicos, Serializable {

	private static final long serialVersionUID = 1L;
	private double despesaDiaria, despesaTotal;
	private int quantidadeHoras;
	private int quantidadeHorasDobradas;
	private int horaInicial;
	
	/**
	 * Construtor da classe Baby Sitter para agendamento do servico
	 * 
	 * @param quantidadedeHoras Horas normais (entre as 7h da manha ate as 18h)
	 * @param quantidadedeHorasDobradas Horas dobradas (entre as 18h e 7h da manha)
	 */
	
	public BabySitter(int quantidadeHoras, int horaInicial) throws Exception { 
		checaHoras(quantidadeHoras);
		checaHoraInicial(horaInicial);
		this.horaInicial = horaInicial;
		this.quantidadeHoras = quantidadeHoras;
		quantidadeHorasDobradas = 0;
		despesaTotal = 0;
		despesaDiaria = 0;
	}
	
	/**
	 * Construtor da classe Baby Sitter sem agendamento de servico
	 */
	
	public BabySitter() throws Exception {
		despesaTotal = 0;
		this.horaInicial = 0;
		this.quantidadeHoras = 0;
		quantidadeHorasDobradas = 0;
	}
	
	
	private void checaHoras(int quantidadeHoras)throws Exception{
		if (quantidadeHoras <= 0){
			throw new Exception ("O numero de horas tem que ser maior que zero.");
		}
	}
	
	private void checaHoraInicial(int horaInicial) throws Exception{
		if (horaInicial < 0 || horaInicial > 23){
			throw new Exception("Hora inicial do serviço inválida.");
		}
	}
	
	public void checaHorasDobradas(int quantidadeHoras, int horaInicial){
		int horas = horaInicial;
		for (int i = 0; i < quantidadeHoras; i++){
			if (horas == 24) horas = 0;
			if ((horas >= 18 && horas <= 23) || (horas >= 0 && horas < 7)){
				quantidadeHorasDobradas++;
			}
			horas++;
		}
	}
	
	/**
	 * 
	 * @return Valor da despesa diaria
	 */
	
	public double getDespesaDiaria() {
		return despesaDiaria;
	}
	
	/**
	 * 
	 * @return Valor da despesa total no final do contrato
	 */
	public double getDespesaTotal() {
		return despesaTotal;
	}
	
	/**
	 * 
	 * @return Quantidade de horas contratadas
	 */
	
	public int getQuantidadeHoras() {
		return quantidadeHoras;
	}
	
	/**
	 * @return
	 */
	
	public int getHoraInicial(){
		return horaInicial;
	}
	
	/**
	 * 
	 * @return Quantidade de horas que o valor cobrado será o dobro do normal
	 */
	
	public int getQuantidadeHorasDobradas() {
		return quantidadeHorasDobradas;
	}
	
	/**
	 * @return A despesa total da baby sitter em um determinado periodo
	 */
	
	public double getPreco(){
		return despesaTotal;
	}
	
	/**
	 * Calcula a tarifa total utilizada por esse servico, metodo que pertence a interface servicos
	 */
	/*
	private double calculaTarifa(int qntHoras, int horasDobradas) {
		double despesa = 0;
		despesa += (qntHoras - horasDobradas) * 25.00;
		despesa += horasDobradas * 50.00;
		return despesa;
	}
	*/
	/**
	 * Metodo que retorna uma String com os atributos da classe
	 */

	@Override
	public String toString() {
		return "Baby Sitter \n"
				+ "Horario de inicio do serviço: "+horaInicial
				+"\nQuantidade de Horas Normais: " + quantidadeHoras + "\n"
				+ "Quantidade de Horas Dobradas: " + quantidadeHorasDobradas;
	}
	
	/**
	 * Metodo que compara se duas Baby Sitters são iguais
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if (!(obj instanceof BabySitter)) return false;
		BabySitter novaBabySitter = (BabySitter)obj;
		if (quantidadeHoras == novaBabySitter.getQuantidadeHoras() &&
				quantidadeHorasDobradas == novaBabySitter.getQuantidadeHorasDobradas())
			return true;
		return false;
	}
}