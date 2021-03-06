package classes.estrategias;

import java.io.Serializable;

public class CalendarioDeEstrategias implements Serializable {

  private static final long serialVersionUID = 1L;
  private EstrategiaDeCalculoDaMontante estrategia;

  /**
  * Verifica a estrategia de calculo para determinado dia.
  * 
  * @param dia - Dia a ser verificado.
  * @param mes - Mes a ser verificado.
  * @return EstrategiaDeCalculoDaMontante - Estrategia de calculo daquele dia.
  */
  
  public EstrategiaDeCalculoDaMontante verificaEstrategia(int dia, int mes) {

    if (mes == 1) {
      if (dia == 1) {
        estrategia = new EstrategiaNatalPlusReveillon();
      } else if (dia > 1 && dia <= 31) {
        estrategia = new EstrategiaFeriasDeJaneiro();
      }
    } else if (mes == 6) {
      if (dia == 23 || dia == 24 || dia == 25 || dia == 28 || dia == 29) {
        estrategia = new EstrategiaSaoJoaoEspecial();
        return estrategia;
      } else if (dia >= 6 && dia <= 30) {
        estrategia = new EstrategiaSaoJoao();
      }
    } else if (mes == 7) {
      if (dia >= 1 && dia <= 6) {
        estrategia = new EstrategiaSaoJoao();
      }
    } else if (mes == 12) {
      if (dia >= 24) {
        estrategia = new  EstrategiaNatalPlusReveillon();
      }
    } else {
      estrategia = new EstrategiaSimples();
    }
    return estrategia;
  }

  /**
   * Metodo que verifica se aquele dia a ser verificado
   * eh existente no calendario. 
   * 
   * @param dia - Dia a ser verificado.
   * @param mes - Mes a ser verificado.
   * @return boolean - Se o dia eh valido ou nao.
   */
  
  public boolean verificaDataValida(int dia, int mes) {
    if (mes == 1 && dia > 31) {
      return false;
    } else if (mes == 2 && dia > 28) {
      return false;
    } else if (mes == 3 && dia > 31) {
      return false;
    } else if (mes == 4 && dia > 30) {
      return false;
    } else if (mes == 5 && dia > 31) {
      return false;
    } else if (mes == 6 && dia > 30) {
      return false;
    } else if (mes == 7 && dia > 31) {
      return false;
    } else if (mes == 8 && dia > 31) {
      return false;
    } else if (mes == 9 && dia > 30) {
      return false;
    } else if (mes == 10 && dia > 31) {
      return false;
    } else if (mes == 11 && dia > 30) {
      return false;
    } else if (mes == 12 && dia > 31) {
      return false;
    }
    return true;
  }
}