package classes.estrategias;

import java.io.Serializable;


/**
 * Classe que implementa a estrategia principal, retorna o total gasto em um dia multiplicado
 * pelo valor da estrategia em uma referente data durante o periodo junino
 * 
 * @author Ravi Leite
 */

public class EstrategiaSimples implements EstrategiaDeCalculoDaMontante, Serializable {

	private static final long serialVersionUID = 1L;

/**
  * Calcula o montante naquele dia e mes, multiplicando o total por um valor
  * pre-determinado pelo hotel
  */

  @Override
  public double calculaMontante(double total) {
    return total;
  }
}