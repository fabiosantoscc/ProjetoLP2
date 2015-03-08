package classes;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Classe que representa um restaurante
 * 
 * @author Ronan Souza
 * Ultima atualizacao 14/01/2015 / Fabio Alexandre
 */


public class Restaurante implements Servico, Serializable {
	private CalendarioDeEstrategias calendario;
	private static final long serialVersionUID = 1L;
	private EstrategiaDeCalculoDaMontante estrategia;
	private double consumoRefeicao;
	private UnidadesDoRestaurante unidadeRestaurante;
	private Calendar data;
	
	public Restaurante(UnidadesDoRestaurante tipo, double valorConsumido) throws Exception{
		testaUnidadeRestaurante(tipo);
		testaValorConsumo(valorConsumido);
		Hotel.maisRestaurante++;
		unidadeRestaurante = tipo;
		calendario = new CalendarioDeEstrategias();
		data = Calendar.getInstance(); 
		estrategia = calendario.verificaEstrategia(data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH) + 1);
		consumoRefeicao = estrategia.calculaMontante(valorConsumido);
	}
	

	
	/**
	 * Adiciona ao valor geral o consumo diario de acordo com a estrategia usada naquele dia
	 * @param dia Dia do consumo
	 * @param mes Mes do consumo
	 */
	
	private void testaValorConsumo(double valor) throws Exception{
		if (valor <= 0){
			throw new Exception("Valor invalido!!");
		}	
	}
	
	private void testaUnidadeRestaurante(UnidadesDoRestaurante tipo) throws Exception{
		if (!(tipo == UnidadesDoRestaurante.TERREO || tipo == UnidadesDoRestaurante.COBERTURA)){
			throw new Exception("Unidade do restaurante invalida!!");
		}
	}
	
	@Override
	public double getDespesaTotal() {
		return consumoRefeicao;
	}

	public UnidadesDoRestaurante getUnidadeRestaurante(){ return this.unidadeRestaurante;}
	@Override
	public String toString() {
		return "Restaurante:"+Arquivos.FIM_LINHA+
				"  Valor Consumido: "+ consumoRefeicao+Arquivos.FIM_LINHA+
				"  Unidade do Restaurante: "+unidadeRestaurante+Arquivos.FIM_LINHA+
				"  Data do Consumo: "+data.get(Calendar.DAY_OF_MONTH)+"/"+(data.get(Calendar.MONTH) + 1)+"/"+data.get(Calendar.YEAR);
	} 
	
	@Override
	public boolean equals( Object obj ) {
		if (! (obj instanceof Restaurante)){
			return false;
		}
		Restaurante novo = (Restaurante) obj;
		
		if (novo.getDespesaTotal() == consumoRefeicao && novo.getUnidadeRestaurante() == this.unidadeRestaurante){
			return true;
		}
		return false;
	}
}