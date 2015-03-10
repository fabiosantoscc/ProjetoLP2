package classes.servicos;

import classes.estrategias.CalendarioDeEstrategias;
import classes.estrategias.EstrategiaDeCalculoDaMontante;
import classes.servicos.Quarto;
import excecoes.QuantidadeDePessoasInvalidaException;

import java.io.Serializable;
import java.util.Calendar;

/**
 *     Classe que representa um quarto.
 * 
 *     @author Fabio Alexandre Santos Silva Junior
 *     Ultima atualizacao 09/03/2015 / Fabio Alexandre
 */

public abstract class Quarto implements Servico, Serializable  {
  
  private static final long serialVersionUID = 1L;
  private EstrategiaDeCalculoDaMontante estrategia;
  private CalendarioDeEstrategias calendario;
  private double valorDiaria;
  private Calendar data;
  private int quantidadeDePessoas;
  private double despesaTotal;
  private int diaInicial;
  private int mesInicial;
  private int anoInicial;

  /**
  * construtor de um quarto.
  * 
  * @param quantidadeDePessoas - Quantidade De Pessoas a se hospedarem no quarto.
  * @throws QuantidadeDePessoasInvalidaException - Pode lancar excecao de
  *         quantidade de pessoas diferente do especificado.
  */

  public Quarto( int quantidadeDePessoas ) throws QuantidadeDePessoasInvalidaException {
    verificaQuantidadeDePessoas(quantidadeDePessoas);
    Calendar date = Calendar.getInstance();
    calendario = new CalendarioDeEstrategias();
    data = date;
    diaInicial = date.get(Calendar.DAY_OF_MONTH);
    mesInicial = date.get(Calendar.MONTH) + 1;
    anoInicial = date.get(Calendar.YEAR);
    this.quantidadeDePessoas = quantidadeDePessoas;
  }
  
  /**
   * Metodo que calcula a despesa do quarto.
   * 
   * @param diaEntrada
   * @param mesEntrada
   * @param diaSaida
   * @param mesSaida
   * @param anoEntrada
   * @param anoSaida
   * @throws Exception
   */
  
  public void calculaDespesaTotal(int diaEntrada, int mesEntrada, int diaSaida, int mesSaida,
      int anoEntrada, int anoSaida) throws Exception {
    if (!calendario.verificaDataValida(diaEntrada, mesEntrada)) {
      throw new Exception("O mes e o dia tem que ser valido.");
    }
    
    if (!calendario.verificaDataValida(diaSaida, mesSaida)) {
      throw new Exception("O mes e o dia tem que ser valido.");
    }
    
    boolean dataValida = true;
    while (dataValida) {
      if (diaEntrada > diaSaida && mesEntrada == mesSaida && anoEntrada == anoSaida) {
        break;
      }
      if (!(calendario.verificaDataValida(diaEntrada, mesEntrada))) {
        diaEntrada = 1;
        if (mesEntrada == 12) {
          anoEntrada++;
          mesEntrada = 1;
		} else {
          mesEntrada++;
        }
      }
      estrategia = calendario.verificaEstrategia(diaEntrada, mesEntrada);
      despesaTotal += estrategia.calculaMontante(valorDiaria);
      diaEntrada++;
    }
  }

  /**
   * 
   * @param diaria
   */
 
  public void setValorDiario(double diaria) {
    valorDiaria = diaria;
  }

  /**
   * 
   * @return
   */
  
  public double getValorDiaria() {
    return valorDiaria;
  }

  /**
   * 
   * @return
   */
  
  public int getDiaInicial() {
    return diaInicial;
  }

  /**
  * Recupera o mes inicial.
  * 
  * @return - Mes inicial.
  */

  public int getMesInicial() {
    return mesInicial;
  }

  /**
  * 
  * @return
  */

  public int getAnoInicial() {
    return anoInicial;
  }

  /**
  * 
  * @return Quantidade total da despesa durante o contrato por um quarto especifico
  */

  public double getDespesaTotal() {
    return despesaTotal;
  }

  /**
  * @return A quantidade de pessoas hospedadas no quarto.
  */

  public int getQuantidadeDePessoas() {
    return quantidadeDePessoas;
  }

  public void setQuantidadeDePessoas(int pessoas) throws QuantidadeDePessoasInvalidaException {
    verificaQuantidadeDePessoas(pessoas);
    this.quantidadeDePessoas = pessoas;
  }
  
  /**
   * 
   * @param quantidadeDePessoas
   * @throws QuantidadeDePessoasInvalidaException
   */
  
  private void verificaQuantidadeDePessoas(int quantidadeDePessoas) 
      throws QuantidadeDePessoasInvalidaException {
    if ( quantidadeDePessoas <= 0 ) {
      throw new QuantidadeDePessoasInvalidaException("A quantidade de pessoas deve ser maior que zero.");
    }
  }  
  
  /**
  * Metodo que retorna uma string para representacao de um quarto.
  * 
  * @return A string de representacao do quarto.
  */

  @Override
  public String toString() {
    return "Quantidade De Pessoas = " + quantidadeDePessoas + ", Data de inicio: " + getDiaInicial()
        + "/" + getMesInicial() + "/" + getAnoInicial() + " " + data.get(Calendar.HOUR_OF_DAY)
        + ":" + data.get(Calendar.MINUTE) + ":" + data.get(Calendar.SECOND);
  }

  /**
  * Metodo que compara se dois objetos do tipo quarto sao iguais.
  * 
  * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
  */

  @Override
  public boolean equals( Object obj ) {
    if (!(obj instanceof Quarto)) {
      return false;
    }

    Quarto quarto = (Quarto) obj;

    return getQuantidadeDePessoas() == quarto.getQuantidadeDePessoas();
  }
}