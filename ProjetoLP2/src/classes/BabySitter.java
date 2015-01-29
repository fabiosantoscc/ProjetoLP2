package classes;

/**
 * Classe que recebe a quantidade de horas contratadas da Baby Sitter e faz um balanço
 * geral da despesa com esse servico
 * @author Ravi Leite and Ronan Souza
 * @data 02/01/2015
 */

public class BabySitter implements Servicos {
	private CalendarioDeEstrategias calendario = new CalendarioDeEstrategias(); 
	private  EstrategiaDeCalculoDaMontante estrategia;
	private double despesaTotal;
	private double despesaDiaria;
	private int quantidadeHoras;
	private int quantidadeHorasDobradas;
	private int horaInicial;

	
	/**
	 * Construtor da classe Baby Sitter para agendamento do serviço
	 * @param quantidadedeHoras Horas normais (entre as 7h da manhã ate as 18h)
	 * @param quantidadedeHorasDobradas Horas dobradas (entre as 18h e 7h da manhã)
	 */
	
	public BabySitter(int quantidadeHoras, int horaInicial)throws Exception{
		checaHoras(quantidadeHoras);
		checaHoraInicial(horaInicial);
		checaHorasDobradas();
		this.horaInicial = horaInicial;
		this.quantidadeHoras = quantidadeHoras;
		despesaTotal = 0;
		despesaDiaria = 0;
		calculaTarifa();
	}
	
	/**
	 * Construtor da classe Baby Sitter sem agendamento de servico
	 */
	
	public BabySitter()throws Exception{
		despesaTotal = 0;
		this.horaInicial = 0;
		this.quantidadeHoras = 0;
		despesaDiaria = 0;
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
	
	/**
	 * Metodo que calcula a despesa total deste servico
	 * @param diaEntrada Dia inicial da solicitacao do servico
	 * @param mesEntrada Mes inicial da solicitacao do servico
	 * @param diaSaida Dia final da solicitacao do servico
	 * @param mesSaida Dia final da solicitacao do servico
	 */
	
	public void calculaDespesaTotal(int diaEntrada, int mesEntrada, int diaSaida, int mesSaida){
		for (int i = mesEntrada;i <= mesSaida;i++){
			for (int j = diaEntrada; j <= diaEntrada; j++){
				boolean dataValida = calendario.verificaDataValida(diaEntrada, mesEntrada);
				if (! dataValida){
					i = 1;
					if (j == 12) {
						j = 1;
					}
					else j++;
					break;
				}
			estrategia = calendario.verificaEstrategia(diaEntrada, mesEntrada);
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
	
	public void horaExtra(int quantidadeHoras, int horaInicial, int dia, int mes) throws Exception{
		calculaTarifa();
		if (!calendario.verificaDataValida(dia, mes)) throw new Exception ("O mes e o dia tem que ser valido.");
		checaHoras(quantidadeHoras);
		checaHoraInicial(horaInicial);
		checaHorasDobradas();
		estrategia = calendario.verificaEstrategia(dia, mes);
		despesaTotal += estrategia.calculaMontante(despesaDiaria);
	}
	
	/**
	 * Verifica a quantidade de horas simples e dobradas em cada dia agendado ou de hora extra
	 */
	
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
		despesaDiaria += quantidadeHoras * 25.00;
		despesaDiaria += quantidadeHorasDobradas * 50.00;
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