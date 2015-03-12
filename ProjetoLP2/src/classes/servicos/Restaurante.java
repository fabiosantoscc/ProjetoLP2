package classes.servicos;

import java.io.Serializable;
import java.util.Calendar;

import classes.Hotel;
import classes.estrategias.CalendarioDeEstrategias;
import classes.estrategias.EstrategiaDeCalculoDaMontante;
import enums.UnidadesDoRestaurante;
import excecoes.NumberInvalidException;

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
	private double valorConsumido;
	
	/**
	 * Construtor de um servico Restaurante.
	 * 
	 * @param tipo - Tipo do restaurante.
	 * @param valorConsumido - Valor consumido pelo hospede.
	 * @throws NumberInvalidException - Pode lancar excecao de valor consumido invalido.
	 */
	
	public Restaurante(UnidadesDoRestaurante tipo, double valorConsumido) throws NumberInvalidException {
		checaValorConsumo(valorConsumido);
		this.valorConsumido = valorConsumido;
		calendario = new CalendarioDeEstrategias();
		data = Calendar.getInstance();
		this.unidadeRestaurante = tipo;
		calculaDespesaTotal();
	}
	
	private void checaValorConsumo(double valor) throws NumberInvalidException {
		if ( valor <= 0 ) {
			throw new NumberInvalidException("Valor invalido!");
		}	
	}
	
	public void calculaDespesaTotal(){
		estrategia = calendario.verificaEstrategia(data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH) + 1);
		consumoRefeicao = estrategia.calculaMontante(valorConsumido);
	}
	
	/**
	 * Recupera o valor consumido do hospede ja com a estrategia de calculo feita.
	 * (No construtor)
	 * 
	 * return double - Valor Consunmido.
	 */
	
	@Override
	public double getDespesaTotal() {
		return consumoRefeicao;
	}

	/**
	 * Recupera o tipo do restaurante.
	 * 
	 * @return UnidadesDoRestaurante - Tipo do restaurante.
	 */
	
	public UnidadesDoRestaurante getUnidadeRestaurante() {
		return unidadeRestaurante;
	}
	
	/**
	 * Recupera uma representação do restaurante em formato de string.
	 * 
	 * @return String - Repressentação do restaurante.
	 */
	
	@Override
	public String toString() {
		return "Restaurante: Valor Consumido: " + getDespesaTotal()
				+ ", Unidade do Restaurante: " + getUnidadeRestaurante().name().toLowerCase()
				+ ", Data do Consumo: " + data.get(Calendar.DAY_OF_MONTH)
				+ "/" + (data.get(Calendar.MONTH) + 1) + "/" + data.get(Calendar.YEAR);
	} 
	
	/**
	 * Compara dois objetos de restaurante e verifica sao iguais.
	 * 
	 * @return boolean - Valor booleano se os objetos forem iguais ou nao.
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