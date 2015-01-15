package classes;

import java.util.Date;

/**
 * Classe que recebe a quantidade de horas contratadas da Baby Sitter e faz um balanço
 * geral da despesa com esse servico
 * @author Ravi Leite and Ronan Souza
 * @data 02/01/2015
 */

public class BabySitter implements Servicos {
	
	private int despesaTotal = 0;
	private Date horaAtual;
	private int quantidadeHoras;
	private int quantidadeHorasDobradas;
	private int horaInicial;

	
	/**
	 * Construtor da classe Baby Sitter para agendamento do serviço
	 * @param quantidadedeHoras Horas normais (entre as 7h da manhã ate as 18h)
	 * @param quantidadedeHorasDobradas Horas dobradas (entre as 18h e 7h da manhã)
	 */
	
	public BabySitter(int quantidadeHoras, int horaInicial)throws Exception{
		this.horaInicial = horaInicial;
		this.quantidadeHoras = quantidadeHoras;
		checaHoras(quantidadeHoras);
		checaHorasDobradas();
		checaHoraInicial(horaInicial);
		calculaTarifa();
	}
	
	/**
	 * Construtor da classe Baby Sitter para uso imediato do serviço
	 * @param quantidadedeHoras Horas normais (entre as 7h da manhã ate as 18h)
	 * @param horaAtual Horario no momento do pedido
	 * @throws Exception Quantidades de horas inválidas
	 */
	public BabySitter(int quantidadedeHoras, Date horaAtual )throws Exception{
		this.horaAtual = horaAtual;
		this.horaInicial = horaAtual.getHours();
		this.quantidadeHoras = quantidadedeHoras;
		checaHoras(quantidadedeHoras);
		checaHorasDobradas();
		calculaTarifa();
	}
	
	/**
	 * Checa se há valores válidos para a quantidade de horas
	 * @param quantidadeHoras
	 * @throws Exception Quantidades de horas inválidas
	 */
	private void checaHoras(int quantidadeHoras)throws Exception{
		if (quantidadeHoras <= 0){
			throw new Exception ("O numero de horas tem que ser maior que zero.");
		}
	}
	
	/**
	 * Checa se o horário inicial do atendimento é válido
	 * @param horaInicial Horário que o serviço agendade deve iniciar
	 * @throws Exception Hora inválida (Menor que 0 ou maior que 23)
	 */
	private void checaHoraInicial(int horaInicial) throws Exception{
		if (horaInicial < 0 || horaInicial > 23){
			throw new Exception("Hora inicial do serviço inválida.");
		}
	}
	
	
	
	private void checaHorasDobradas(){
		int horas = horaInicial;
		for (int i = 0; i < quantidadeHoras; i++){
			if (horas == 24){ horas = 0;}
			if ((horas >= 18 && horas <= 23) || (horas >= 0 && horas < 7)){
				quantidadeHorasDobradas++;
			}
			horas++;
		}
		
	}
	/**
	 * 
	 * @return Quantidade de horas contratadas
	 */
	public int getQuantidadeHoras() {
		return quantidadeHoras;
	}
	
	/**
	 * 
	 * @return Quantidade de horas que o valor cobrado será o dobro do normal
	 */
	public int getQuantidadeHorasDobradas() {
		return quantidadeHorasDobradas;
	}
	
	public double getPreco(){
		return despesaTotal;
	}
	
	
	/**
	 * Calcula a tarifa total utilizada por esse servico, metodo que pertence a interface servicos
	 */
	
	private void calculaTarifa() {
		despesaTotal += quantidadeHoras * 25.00;
		despesaTotal += quantidadeHorasDobradas * 50.00;
	}
	
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