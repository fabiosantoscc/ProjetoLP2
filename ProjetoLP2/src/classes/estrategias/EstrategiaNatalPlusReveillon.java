package classes.estrategias;


/**
  *     Classe que implementa a estrategia principal, retorna o total gasto em um dia multiplicado
  *     pelo valor da estrategia em uma referente data durante o periodo de natal e fim de ano
  * 
  *     @author Fabio Alexandre
  *     Atualizado em 01/02/2015 Ravi leite
  */

public class EstrategiaNatalPlusReveillon implements EstrategiaDeCalculoDaMontante {

  /**
  * Calcula o montante naquele dia e mes, multiplicando o total por um valor
  *  pre-determinado pelo hotel
  */

  @Override
  public double calculaMontante(double total) {
    return total *= 1.30;
  }
}