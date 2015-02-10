package classes;

import java.util.Calendar;

import classes.BabySitter;

/**
 * Classe que recebe a quantidade de horas contratadas da Baby Sitter e faz um balanço
 * geral da despesa com esse servico
 * @author Ravi Leite and Ronan Souza
 * @data 02/01/2015
 * 
 * Atualizacao 10/02/2015
 */

public class BabySitter implements Servicos {
	
	private CalendarioDeEstrategias calendario;
	private  EstrategiaDeCalculoDaMontante estrategia;
	private double despesaDiaria, despesaTotal;
	private int quantidadeHoras;
	private int quantidadeHorasDobradas;
	private int horaInicial;
	Calendar data;
	
	/**
	 * Construtor da classe Baby Sitter para agendamento do serviço
	 * @param quantidadedeHoras Horas normais (entre as 7h da manhã ate as 18h)
	 * @param quantidadedeHorasDobradas Horas dobradas (entre as 18h e 7h da manhã)
	 */
	
	public BabySitter(int quantidadeHoras, int horaInicial)throws Exception{
		data = Calendar.getInstance();
		calendario = new CalendarioDeEstrategias(); 
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
	
	public BabySitter()throws Exception{
		calendario = new CalendarioDeEstrategias(); 
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
	
	/**
	 * Metodo que calcula a despesa total deste servico
	 * @param diaEntrada Dia inicial da solicitacao do servico
	 * @param mesEntrada Mes inicial da solicitacao do servico
	 * @param diaSaida Dia final da solicitacao do servico
	 * @param mesSaida Dia final da solicitacao do servico
	 */
	
	public void calculaDespesaTotal(int diaEntrada, int mesEntrada, int diaSaida, int mesSaida)throws Exception{
		if (!calendario.verificaDataValida(diaEntrada, mesEntrada)) throw new Exception ("O mes e o dia tem que ser valido.");
		if (!calendario.verificaDataValida(diaSaida, mesSaida)) throw new Exception ("O mes e o dia tem que ser valido.");
		checaHorasDobradas(this.quantidadeHoras, this.horaInicial);
		despesaDiaria = calculaTarifa(this.quantidadeHoras, this.quantidadeHorasDobradas);
		for (int i = mesEntrada;i <= mesSaida;i++){
			for (int j = diaEntrada; j <= diaSaida; j++){
				boolean dataValida = calendario.verificaDataValida(j,i);
				if (! dataValida){
					i = 1;
					if (j == 12) {
						j = 1;
					}
					else j++;
					break;
				}
				
				estrategia = calendario.verificaEstrategia(j, i);
				despesaTotal += estrategia.calculaMontante(despesaDiaria);
			}
		}
	}
	
	/**
	 * Metodo que calcula horas extras 
	 * @param quantidadeHoras Quantidade de hroas no dia 
	 * @param horaInicial Horas em que foi iniciado o servico
	 * @param dia Dia da solicitacao
	 * @param mes Mes da solicitacao
	 */
	
	public void horaExtra(int qntHoras, int hrInicial, int dia, int mes) throws Exception{
		if (!calendario.verificaDataValida(dia, mes)) throw new Exception ("O mes e o dia tem que ser valido.");
		checaHorasDobradas(qntHoras, hrInicial);
		estrategia = calendario.verificaEstrategia(dia, mes);
		despesaTotal += estrategia.calculaMontante(calculaTarifa(qntHoras, quantidadeHorasDobradas));
	}
	
	/**
	 * Verifica a quantidade de horas simples e dobradas em cada dia agendado ou de hora extra
	 */
	
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
	
	private double calculaTarifa(int qntHoras, int horasDobradas) {
		double despesa = 0;
		despesa += (qntHoras - horasDobradas) * 25.00;
		despesa += horasDobradas * 50.00;
		return despesa;
	}
	
	/**
	 * Metodo que retorna uma String com os atributos da classe
	 */

	@Override
	public String toString() {
		return "Baby Sitter \n"
				+ "Horario de inicio do serviço: "+horaInicial
				+"\nQuantidade de Horas Normais: " + quantidadeHoras + "\n"
				+ "Quantidade de Horas Dobradas: " + quantidadeHorasDobradas
				+ "Data: " + data.get(Calendar.DAY_OF_WEEK) + "/" + data.get(Calendar.MONTH + 1)+ "/"
				+ data.get(Calendar.YEAR) + " " + data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE) + ":" + data.get(Calendar.SECOND);
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
