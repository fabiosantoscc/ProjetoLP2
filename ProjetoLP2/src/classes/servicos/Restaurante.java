package classes.servicos;

import classes.CalendarioDeEstrategias;
import classes.EstrategiaDeCalculoDaMontante;
import classes.Hotel;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que representa um restaurante.
 * 
 * @author Ronan Souza
 * Ultima atualizacao 10/03/2015 / Fabio Alexandre
 */


public class Restaurante implements Servico, Serializable {
	
	private static final long serialVersionUID = 1L;
	private CalendarioDeEstrategias calendario;
	private EstrategiaDeCalculoDaMontante estrategia;
	private double consumoRefeicao;
	private UnidadesDoRestaurante unidadeRestaurante;
	private Calendar data;
	
	/**
	 * 
	 * @param tipo
	 * @param valorConsumido
	 * @throws Exception
	 */
	
	public Restaurante(UnidadesDoRestaurante tipo, double valorConsumido) throws Exception {
		checaValorConsumo(valorConsumido);
		calendario = new CalendarioDeEstrategias();
		data = Calendar.getInstance();
		this.unidadeRestaurante = tipo;
		Hotel.maisRestaurante++;
		estrategia = calendario.verificaEstrategia(data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH) + 1);
		consumoRefeicao = estrategia.calculaMontante(valorConsumido);
	}

	/**
	 * Adiciona ao valor geral o consumo diario de acordo com a estrategia usada naquele dia
	 * @param dia Dia do consumo
	 * @param mes Mes do consumo
	 */
	
	private void checaValorConsumo(double valor) throws Exception {
		if ( valor <= 0 ) {
			throw new Exception("Valor invalido!");
		}	
	}
	
	/**
	 * 
	 */
	
	@Override
	public double getDespesaTotal() {
		return consumoRefeicao;
	}

	/**
	 * 
	 * @return
	 */
	
	public UnidadesDoRestaurante getUnidadeRestaurante() {
		return unidadeRestaurante;
	}
	
	/**
	 * 
	 */
	
	@Override
	public String toString() {
		return "Restaurante: Valor Consumido: " + getDespesaTotal()
				+ ", Unidade do Restaurante: " + getUnidadeRestaurante().name().toLowerCase()
				+ ", Data do Consumo: " + data.get(Calendar.DAY_OF_MONTH)
				+ "/" + (data.get(Calendar.MONTH) + 1) + "/" + data.get(Calendar.YEAR);
	} 
	
	/**
	 * 
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if (! (obj instanceof Restaurante)) {
			return false;
		}
		
		Restaurante novo = (Restaurante) obj;
		
		return novo.getDespesaTotal() == consumoRefeicao && novo.getUnidadeRestaurante() == unidadeRestaurante;
	}
}