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
  
  //Esse metodo funciona da mesma maneira como o contido na classe AluguelDeQuartos
  
  public void calculaDespesaTotal() {
		Calendar dataSaida = Calendar.getInstance();
		int diaEntrada = data.get(Calendar.DAY_OF_MONTH);
		int mesEntrada = data.get(Calendar.MONTH);
		int anoEntrada = data.get(Calendar.YEAR);
	    while (diaEntrada >dataSaida.get(Calendar.DAY_OF_MONTH) && mesEntrada == dataSaida.get(Calendar.MONTH) && anoEntrada == dataSaida.get(Calendar.YEAR)) {
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
   * Recebe o valor da diaria do quarto
   * @param diaria Valor da diaria
   */
 
  public void setValorDiario(double diaria) {
    valorDiaria = diaria;
  }

  /**
   * @return O valor da diaria do quarto
   */
  
  public double getValorDiaria() {
    return valorDiaria;
  }

  /**
   * @return O dia inicial do contrato de um determinado quarto
   */
  
  public int getDiaInicial() {
    return diaInicial;
  }

  /**
  * Recupera o mes inicial. 
  * @return - Mes inicial.
  */

  public int getMesInicial() {
    return mesInicial;
  }

  /**
  * @return O ano em que o servico foi contratado
  */

  public int getAnoInicial() {
    return anoInicial;
  }

  /**
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

  /**
   * Recebe a quantidade de pessoas que ficarão no quarto
   * @param pessoas Quantidade de pessoas
   * @throws QuantidadeDePessoasInvalidaException
   */
  
  public void setQuantidadeDePessoas(int pessoas) throws QuantidadeDePessoasInvalidaException {
	verificaQuantidadeDePessoas(pessoas);
    this.quantidadeDePessoas = pessoas;
  }
  
  /**
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