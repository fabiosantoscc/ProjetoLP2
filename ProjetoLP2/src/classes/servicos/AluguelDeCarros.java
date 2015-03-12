package classes.servicos;

import classes.Hotel;
import classes.estrategias.CalendarioDeEstrategias;
import classes.estrategias.EstrategiaDeCalculoDaMontante;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que recebe informações a cerca do aluguel de automoveis para clientes do Hotel e faz o gerenciamento desses dados.
 * 
 * @author Ronan Souza
 * @date 12/01/2014
 * Ultima Alteracao / Fabio Alexandre 10/02/2015
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
	 * Construtor da classe AluguelDeCarros
	 * 
	 * @param tipoCarro Modelo do Automovel desejado ( "Luxo" ou "Executivo")
	 * @param tanqueCheio Veiculo ja com tanque cheio
	 * @param seguroAutomovel Seguro do automovel no periodo do aluguel 
	 * @param quantidadeDias Quantidade de dias em que o automovel estará em uso do cliente
	 */
	
	public AluguelDeCarros(ModelosDoCarro carro, boolean tanqueCheio, boolean seguroAutomovel) throws Exception {
		checaTipoCarro(carro);
		data = Calendar.getInstance();		
		this.modeloCarro = carro;
		this.tanqueCheio = tanqueCheio;
		this.seguroDeAutomovel = seguroAutomovel;
	}	
	
	private void checaTipoCarro(ModelosDoCarro carro) throws Exception {
		if (!( carro.equals(ModelosDoCarro.EXECUTIVO)||  carro.equals(ModelosDoCarro.LUXO))) {
			throw new Exception("Modelo de Automóvel Invalido");
		}
	}
	
	/**
	 * 
	 * @return Modelo do Automovel desejado ( "Luxo" ou "Executivo")
	 */
	
	public ModelosDoCarro getModeloCarro() {
		return this.modeloCarro;
	}
	
	/**
	 * 
	 * @return Se o veículo já sai para o aluguel com o tanque de combustível cheio
	 */
	
	public boolean isTanqueCheio() {
		return tanqueCheio;
	}
	
	/**
	 * @return O valor da diaria dependendo do tipo
	 */
	
	public double getValorDiaria() {
		return valorDiaria;
	}

	/**
	 * 
	 * @return Se o veículo será assegurado no periodo que estiver com o cliente
	 */
	
	public boolean isSeguroDeAutomovel() {
		return seguroDeAutomovel;
	}

	/**
	 * Vetifica o modelo do carro(Luxo ou Executivo)
	 */
	
	public void verificaTipo() {
		if (this.modeloCarro.equals(ModelosDoCarro.LUXO)) {
			valorDiaria = 100;
		}
		
		else if (this.modeloCarro.equals(ModelosDoCarro.EXECUTIVO)) {
			valorDiaria = 60;
		}
	}
	
	/**
	 * Verifica quais os servicos adicionais
	 * @param dia Dia do acesso aos servicos adicionais
	 * @param mes Mes dos servicos adicionais
	 */
	
	public void acrescentaAdicionais() throws Exception {
		if (tanqueCheio)
			tarifaTotal += 150;
		if (seguroDeAutomovel)
			tarifaTotal += 100;
	}
	
	/**
	 * Metodo que calcula a diaria do aluguel de acordo com a estrategia de cada dia
	 * @param diaDeEntrada Dia de inicio do aluguel
	 * @param mesDeEntrada Mes de inicio aluguel
	 * @param diaDeSaida Dia de inicio do aluguel 
	 * @param mesDeSaida Mes de saida do aluguel
	 */

	  public void calculaDespesaTotal() {
			Calendar dataSaida = Calendar.getInstance();
			int diaEntrada = data.get(Calendar.DAY_OF_MONTH);
			int mesEntrada = data.get(Calendar.MONTH);
			int anoEntrada = data.get(Calendar.YEAR);
		    while (diaEntrada > dataSaida.get(Calendar.DAY_OF_MONTH) && mesEntrada == dataSaida.get(Calendar.MONTH) && anoEntrada == dataSaida.get(Calendar.YEAR)) {
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
		      tarifaTotal += estrategia.calculaMontante(valorDiaria);
		      diaEntrada++;
		    }
		  }
		
  /** 
  * Metodo que retorna uma String com os atributos da classe
  */

  @Override
  public String toString() {
    String string;
    string = "Aluguel de Carro - Modelo: " + getModeloCarro().name().toLowerCase()		
        + "  Data: " + data.get(Calendar.DAY_OF_WEEK) + "/" + data.get(Calendar.MONTH + 1) + "/"
        + data.get(Calendar.YEAR) + " às " + data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE) + ":" + data.get(Calendar.SECOND);

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
   * @return O valor final, que deve ser pago pelo cliente referente a esse servico 
   */
  
  @Override
  public double getDespesaTotal() {
    return tarifaTotal;
  }
	
  /**
  *
  * 
  * @return
  */

  @Override
  public boolean equals( Object obj ) {
    if (! (obj instanceof AluguelDeCarros) ) {
      return false;
    }

    AluguelDeCarros novoAluguel = (AluguelDeCarros)obj;

    return modeloCarro.equals(novoAluguel.getModeloCarro()) &&
        tanqueCheio == novoAluguel.isTanqueCheio()
        && seguroDeAutomovel == novoAluguel.isSeguroDeAutomovel();
  }
}
