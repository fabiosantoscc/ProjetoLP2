package classes;

import excecoes.NumeroDeNoitesInvalidoException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 *     Classe que representa um contrato.
 * 
 *     @author Fabio Alexandre Santos Silva Júnior
 *     @date 02/02/2015
 *     Ultima alteracao: 08/03/2015 / Fabio Alexandre
 */

public class Contrato implements Serializable {

  private static final long serialVersionUID = 1L;
  private List<Servico> servicos = new ArrayList<Servico>();
  private boolean aberto;
  private double valorAPagar;
  private double despesaParcial;
  private int numeroDeNoites;
  private Calendar dataInicial;
  private CalendarioDeEstrategias calendario;

  /**
   * Construtor de um Contrato.
   * 
   * @param numeroDeNoites - Numero de noites que o hospede vai ficar no hotel.
   * @throws NumeroDeNoitesInvalidoException - Numero de noites invalido.
   */
  
  public Contrato( int numeroDeNoites ) throws NumeroDeNoitesInvalidoException {
    
	  Calendar dataInicial = Calendar.getInstance();
    this.dataInicial = dataInicial;

    if ( numeroDeNoites <= 0) {
      throw new NumeroDeNoitesInvalidoException("Numero de noites deve ser maior que zero.");
    } 

    this.numeroDeNoites = numeroDeNoites;
    this.aberto = true;
  }
  
  /**
  * Calcula a despesa total dos servicos contrados pelo hospede
  */
  
  public void calculaDespesaTotal() {
    for (Servico s : servicos) {
      despesaParcial += s.getDespesaTotal();
    }

    this.valorAPagar = despesaParcial + calculaMulta();
  }
   
  private int diasDeMulta() {
	 Calendar dataSaida = Calendar.getInstance();
	 int diaEntrada = dataInicial.get(Calendar.DAY_OF_MONTH);
	 int mesEntrada =  dataInicial.get(Calendar.MONTH);
	 int anoEntrada = dataInicial.get(Calendar.YEAR);
	 int contaDias = 0;
	 while (true) {
		 if (diaEntrada > dataSaida.get(Calendar.DAY_OF_MONTH) && mesEntrada == dataSaida.get(Calendar.MONTH)
				 && anoEntrada == dataSaida.get(Calendar.YEAR)) break;
		 contaDias++;
		 if (!(calendario.verificaDataValida(diaEntrada, mesEntrada))){
			 diaEntrada = 1;
			 if (mesEntrada == 12){
					anoEntrada++;
					mesEntrada = 1;
			}
				else mesEntrada++;
		}
	 }

	 return contaDias - numeroDeNoites;
  }
  
  /**
   * Calcula valor da multa se houver atraso
   */
  
  private double calculaMulta() {
    return (0.025 * despesaParcial) * diasDeMulta();
  }
  
  /**
  * Adiciona varios servicos no Contrato.
  * 
  * @param meusServicos - Servicos a serem adicionados.
  */
  
  //metodo parecido em hotel.
  public void servicosContrato( List<Servico> meusServicos ) {
    servicos.addAll(meusServicos);
  }

  /**
  * Adiciona um servico no Contrato.
  * 
  * @param servico - Servico a ser adicionado.
  */

  public void adicionaServico( Servico servico ) {
    servicos.add(servico);
  }

  public void removeServico( Servico servico ) {
	  servicos.remove(servico);
  }
  
  /**
  * Recupera o dia inicial do Contrato.
  * 
  * @return int - Dia inicial do Contrato.
  */

  public int getDiaInicial() {
    return dataInicial.get(Calendar.DAY_OF_MONTH);
  }

  /**
  * Recupera o mes inicial do Contrato.
  * 
  * @return int - Mes inicial do Contrato.
  */

  public int getMesInicial() {
    return dataInicial.get(Calendar.MONTH) + 1;
  }

  /**
  * Recupera o ano inicial do Contrato.
  * 
  * @return int - Ano inicial do Contrato.
  */

  public int getAnoInicial() {
    return dataInicial.get(Calendar.YEAR);
  }

  /**
   * Recupera a lista de servicos do contrato.
   * 
   * @return List<> - Todos os servicos do Contrato.
   */
  
  public List<Servico> getServicos() {
    return servicos;
  }

  /**
  * Recupera o estado do Contrato, se eh aberto ou fechado.
  * 
  * @return boolean - True se o Contrato estiver aberto, false caso contrario.
  */

  public boolean isAberto() {
    return aberto;
  }

  /**
  * Atribui um novo estado ao Contrato.
  * 
  * @param estadoContrato - Novo estado do Contrato.
  */

  public void setAberto(boolean estadoContrato) {
    this.aberto = estadoContrato;
  }

  /**
  * Recupera o numero de noites do Contrato.
  * 
  * @return int - Numero de noites do Contrato.
  */

  public int getNumeroDeNoites() {
    return numeroDeNoites;
  }

  /**
  * Recupera o valor a ser pago pelo Contrato ja com a multa(se houver).
  * 
  * @return double - O valor gasto no geral durante o periodo do Contrato.
  */

  public double getValorAPagar() {
    return valorAPagar;
  }

  /**
  * Representacao do Contrato em uma String.
  * 
  * return String - representacao do Contrato em uma String.
  */

  @Override
  public String toString() {
    String representacao = "Contrato - Criado em " + getDiaInicial() + "/" + getMesInicial() + "/"
        + getAnoInicial() + " as " + dataInicial.get(Calendar.HOUR_OF_DAY) + ":" 
        + dataInicial.get(Calendar.MINUTE) + ":" + dataInicial.get(Calendar.SECOND);

    if ( isAberto() ) {
      representacao += ", Contrato aberto";
    }  else {
      representacao += ", Contrato fechado";
    }

    representacao += ", Noites de hospedagem: " + getNumeroDeNoites();

    return representacao;
  }

  /**
  * Verifica se dois contratos sao iguais.
  *
  * @return boolean - True se os Contratos forem iguais, false caso contratio.
  */

  @Override
  public boolean equals( Object obj ) {
    if (!(obj instanceof Contrato)) {
      return false;
    }

    Contrato contrato = (Contrato) obj;

    return getNumeroDeNoites() == contrato.getNumeroDeNoites()
        && getDiaInicial() == contrato.getDiaInicial()
        && getMesInicial() == contrato.getMesInicial()
        && getAnoInicial() == contrato.getAnoInicial()
        && getValorAPagar() == contrato.getValorAPagar()
        && isAberto() == contrato.isAberto();
  }
}