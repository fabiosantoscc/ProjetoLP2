package classes.servicos;

import classes.estrategias.CalendarioDeEstrategias;
import classes.estrategias.EstrategiaDeCalculoDaMontante;

import enums.ModelosDoCarro;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que recebe informações a cerca do aluguel de automoveis para clientes
 * do Hotel e faz o gerenciamento desses dados.
 * 
 * @author Ronan Souza
 * @date 12/01/2014
 *     Ultima Alteracao / Fabio Alexandre 10/02/2015
 */
   
public class AluguelDeCarros implements Servico, Serializable {
  private static final long serialVersionUID = 1L;
  private EstrategiaDeCalculoDaMontante estrategia;
  private CalendarioDeEstrategias calendario;
  private ModelosDoCarro modeloCarro;
  private boolean tanqueCheio;
  private boolean seguroDeAutomovel;
  private int valorDiaria;
  private int tarifaTotal;
  private Calendar data;
 
  /** 
  * Construtor da classe AluguelDeCarros.
  * 
  * @param carro - Modelo do Automovel desejado ( "Luxo" ou "Executivo")
  * @param tanqueCheio Veiculo ja com tanque cheio
  * @param seguroAutomovel Seguro do automovel no periodo do aluguel 
  */

  public AluguelDeCarros(ModelosDoCarro carro, boolean tanqueCheio,
      boolean seguroAutomovel) throws Exception {
    checaTipoCarro(carro);
    data = Calendar.getInstance();
    this.modeloCarro = carro;
    this.tanqueCheio = tanqueCheio;
    this.seguroDeAutomovel = seguroAutomovel;
  }

  private void checaTipoCarro(ModelosDoCarro carro) throws Exception {
    if (!( carro.equals(ModelosDoCarro.EXECUTIVO) || carro.equals(ModelosDoCarro.LUXO))) {
      throw new Exception("Modelo de Automóvel Invalido");
    }
  }

  /**
  * Recupera o modelo do carro.
  * 
  * @return ModelosDoCarro - Modelo do Automovel desejado
  *                        ( "Luxo" ou "Executivo")
  */

  public ModelosDoCarro getModeloCarro() {
    return this.modeloCarro;
  }

  /**
  * Verifica se o carro eh com tanque cheio ou nao.
  * 
  * @return boolean - Se o veículo ja sai para o aluguel com
  *                   o tanque de combustível cheio.
  */

  public boolean isTanqueCheio() {
    return tanqueCheio;
  }

  /**
  * Recupera o valor da diaria.
  * 
  * @return double - O valor da diaria dependendo do tipo.
  */

  public double getValorDiaria() {
    return valorDiaria;
  }

  /**
  * Verifica se o carro eh com seguro ou nao.
  * 
  * @return boolean - Se o veículo será assegurado no
  *                   periodo que estiver com o cliente.
 */

  public boolean isSeguroDeAutomovel() {
    return seguroDeAutomovel;
  }

  /**
  * Verifica o modelo do carro(Luxo ou Executivo).
  */

  public void verificaTipo() {
    if (this.modeloCarro.equals(ModelosDoCarro.LUXO)) {
      valorDiaria = 100;
    } else if (this.modeloCarro.equals(ModelosDoCarro.EXECUTIVO)) {
      valorDiaria = 60;
    }
  }

  /**
  * Verifica quais os servicos adicionais.
  */

  public void acrescentaAdicionais() throws Exception {
    if (tanqueCheio) {
      tarifaTotal += 150;
    }
    if (seguroDeAutomovel) {
      tarifaTotal += 100;
    }
  }

  /**
  * Metodo que calcula a diaria do aluguel de acordo com a estrategia de cada dia.
  */

  public void calculaDespesaTotal() {
    /*Obs.: Esse metodo de alguel de carros foi feito da mesma maneira 
    * que o metodo contido em Quarto, Ele percorre todos os dias que o servico
    * estava sendo usado e passa pela estrategia para que seja
    * adicionado a tarifaTotal de acordo com a estrategia daquela data.*/

    Calendar dataSaida = Calendar.getInstance();
    int diaEntrada = data.get(Calendar.DAY_OF_MONTH);
    int mesEntrada = data.get(Calendar.MONTH);
    int anoEntrada = data.get(Calendar.YEAR);
    //Esse loop so acaba quando a data de entrada for maior que a de saida,
    //ou seja, o alguel so conta a partir de um dia apos o aluguel.

    while (diaEntrada > dataSaida.get(Calendar.DAY_OF_MONTH)
        && mesEntrada == dataSaida.get(Calendar.MONTH)
        && anoEntrada == dataSaida.get(Calendar.YEAR)) {
      if (!(calendario.verificaDataValida(diaEntrada, mesEntrada))) {
        diaEntrada = 1;
        if (mesEntrada == 12) {
          anoEntrada++;
          mesEntrada = 1;
        } else {
          mesEntrada++;
        }
      }

      //Aqui, apos verificar a data, o dia e o mes sao passados como parametro,
      //procurando assim a estrategia a ser usada
      //para em seguida ser adicionado o valor a tarifaTotal
      estrategia = calendario.verificaEstrategia(diaEntrada, mesEntrada);
      tarifaTotal += estrategia.calculaMontante(valorDiaria);
      diaEntrada++;
    }
  }

  /** 
  * Metodo que retorna uma String que representa um aluguel de carros.
  * 
  * @return String - representacao do aluguel de carros.
  */

  @Override
  public String toString() {
    String string;
    string = "Aluguel de Carro - Modelo: " + getModeloCarro().name().toLowerCase()
        + "  Data: " + data.get(Calendar.DAY_OF_WEEK) + "/" + data.get(Calendar.MONTH + 1) + "/"
        + data.get(Calendar.YEAR) + " às " + data.get(Calendar.HOUR_OF_DAY) + ":"
        + data.get(Calendar.MINUTE) + ":" + data.get(Calendar.SECOND);

    if ( tanqueCheio ) {
      string += ", Tanque cheio";
    } else {
      string += ", Sem tanque cheio";
    }

    if ( seguroDeAutomovel ) {
      string += ", Carro com seguro.";
    } else {
      string += ", Carro sem seguro.";
    }

    return string;
  }

  /**
   * Recupera a despesa total do aluguel de carros.
   * 
   * @return double - O valor final, que deve ser pago pelo
   *                  cliente referente a esse servico. 
   */
  
  @Override
  public double getDespesaTotal() {
    return tarifaTotal;
  }

  /**
  * Verifica se dois alugueis sao iguais.
  * @return boolean - True se forem iguais, false se forem diferentes.
  */

  @Override
  public boolean equals( Object obj ) {
    if (! (obj instanceof AluguelDeCarros) ) {
      return false;
    }

    AluguelDeCarros novoAluguel = (AluguelDeCarros)obj;

    return modeloCarro.equals(novoAluguel.getModeloCarro())
        && tanqueCheio == novoAluguel.isTanqueCheio()
        && seguroDeAutomovel == novoAluguel.isSeguroDeAutomovel();
  }
}
