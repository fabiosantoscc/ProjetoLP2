package classes.servicos;

import classes.Arquivos;
import classes.Hotel;
import classes.estrategias.CalendarioDeEstrategias;
import classes.estrategias.EstrategiaDeCalculoDaMontante;
import classes.servicos.Servico;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que recebe a quantidade de horas contratadas da Baby Sitter e faz um balanço
 * geral da despesa com essa informacao. 
 * 
 * @author Ravi Leite and Ronan Souza
 * @data 02/01/2015
 * 
 * Ultima atualizacao 10/02/2015 / Fabio Alexandre
 */
  
public class BabySitter implements Servico, Serializable {
	   
	private static final long serialVersionUID = 1L;
	private CalendarioDeEstrategias calendario;
	private  EstrategiaDeCalculoDaMontante estrategia;
	private double despesaTotal;
	private int quantidadeHoras;
	private int quantidadeHorasDobradas;
	private int horaInicial;
	Calendar data;
	
	/**
	 * Construtor da classe Baby Sitter
	 * 
	 * @param quantidadedeHoras - Horas normais (entre as 7h da manha ate as 18h)
	 * @param quantidadedeHorasDobradas - Horas dobradas (entre as 18h e 7h da manha)
	 */
	
	public BabySitter(int quantidadeHoras, int horaInicial) throws Exception {
		data = Calendar.getInstance();
		calendario = new CalendarioDeEstrategias(); 
		checaHoras(quantidadeHoras);
		checaHoraInicial(horaInicial);
		this.horaInicial = horaInicial;
		this.quantidadeHoras = quantidadeHoras;
		quantidadeHorasDobradas = 0;
		despesaTotal = 0;
		//Esse metodo eh chamado no contrutor, pois a despesa total eh calculada ja no momento em que o servico eh contratado
		calculaDespesaTotal();
	}
	
	/**
	 * Verifica se a quantidade de horas do servico passado no construtor é válida
	 * @param quantidadeHoras Quantidade de horas que deseja-se contratar o servico
	 * @throws Exception Se a quantidade de horas for menor que 1
	 */
	
	private void checaHoras(int quantidadeHoras) throws Exception {
		if (quantidadeHoras <= 0) {
			throw new Exception ("O numero de horas tem que ser maior que zero.");
		}
	}
	
	/**
	 * Verifica se o horario inicial do servico é valido
	 * @param horaInicial Horario de inicio do servico
	 * @throws Exception Se o horário for diferente do intervalo (00, 24)
	 */
	 
	private void checaHoraInicial(int horaInicial) throws Exception {
		if (horaInicial < 0 || horaInicial > 23) {
			throw new Exception("Hora inicial do servico invalida.");
		}
	}
	 
	/**
	 * Metodo que calcula horas extras 
	 * @param quantidadeHoras Quantidade de hroas no dia 
	 * @param horaInicial Horas em que foi iniciado o servico
	 * @param dia Dia da solicitacao
	 * @param mes Mes da solicitacao
	 */
	
	public void calculaDespesaTotal() {
		//Esse metodo verifica primeiro a quantidade de horas dobradas
		checaHorasDobradas(quantidadeHoras, horaInicial);
		//Busca a estrategia a ser usada referente a data em que o servico foi contratado
		estrategia = calendario.verificaEstrategia(Calendar.DAY_OF_MONTH, Calendar.MONTH);
		//Adiciona esse gasto a despesaTotal
		despesaTotal += estrategia.calculaMontante(calculaTarifa(quantidadeHoras, quantidadeHorasDobradas));
	}
	
	/**
	 * Verifica a quantidade de horas simples e dobradas em cada dia agendado ou de hora extra
	 */
	
	private void checaHorasDobradas(int quantidadeHoras, int horaInicial) {
		//Verifica a quantidade de horas dobradas dependendo da hora inicial e quantidade de horas
		int horas = horaInicial;
		for (int i = 0; i < quantidadeHoras; i++) {
			if (horas == 24)
				horas = 0;
			
			if ((horas >= 18 && horas <= 23) || (horas >= 0 && horas < 7)) {
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
	 * @return A hora inicial que o servico foi contratado
	 */
	
	public int getHoraInicial() {
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
	
	public double getDespesaTotal() {
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
  * Recupera uma String que representa uma babysitter.
  * 
  * @return String - A representação da Babysitter.
  */

  @Override
  public String toString() {
    return "Baby Sitter " + Arquivos.FIM_LINHA
        + "Horario de inicio do serviço: "+horaInicial + Arquivos.FIM_LINHA
        +"Quantidade de Horas Normais: " + quantidadeHoras + Arquivos.FIM_LINHA
        + "Quantidade de Horas Dobradas: " + quantidadeHorasDobradas
        + "Data: " + data.get(Calendar.DAY_OF_WEEK) + "/" + data.get(Calendar.MONTH + 1)+ "/"
        + data.get(Calendar.YEAR) + " " + data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE) + ":" + data.get(Calendar.SECOND);
	}

  /**
  * Compara se duas Baby Sitters são iguais.
  * 
  * @return boolean - Valor booleano dependendo se os objetos forem iguais.
  */
	
  @Override
  public boolean equals( Object obj ) {
    if ( !(obj instanceof BabySitter) ) {
      return false;
    }

    BabySitter novaBabySitter = (BabySitter)obj;

    return quantidadeHoras == novaBabySitter.getQuantidadeHoras()
        && quantidadeHorasDobradas == novaBabySitter.getQuantidadeHorasDobradas();
	}
}
