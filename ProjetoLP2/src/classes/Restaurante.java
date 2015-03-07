package classes;

import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que representa um restaurante
 * 
 * @author Ronan Souza
 * Ultima atualizacao 14/01/2015 / Fabio Alexandre
 */
 
public class Restaurante implements Servico, Serializable {
	
	private static final long serialVersionUID = 1L;
	private CalendarioDeEstrategias calendario;
	private EstrategiaDeCalculoDaMontante estrategia;
	private double consumoRefeicao, consumoUnidade1, consumoUnidade2, consumoGeral;
	private int quantUsoUnidade1, quantUsoUnidade2;
	private Calendar dataConsumo;
	
	public Restaurante(){
		dataConsumo = Calendar.getInstance();
		Hotel.maisRestaurante++;
		calendario = new CalendarioDeEstrategias();
	}
	
	public  double getConsumoUnidade1(){
		return consumoUnidade1;
	}

	public double getConsumoUnidade2() {
		return consumoUnidade2;
	}
	 

	/**
	 * Adiciona ao valor diario e ao determinado tipo de unidade um valor de consumo
	 * @param unidade Tipo da unidade onde foi feito o consumo
	 * @param valor Gasto nessa unidade
	 */
	
	public void AdicionaNovoConsumo(String unidade, double valor) throws Exception{
		if (valor <= 0){
			throw new Exception("Valor invalido!!");
		}
		if (!((unidade.equals("Terreo")) || unidade.equals("Cobertura"))){
			throw new Exception("Unidade do restaurante invalida!!");
		}
		
		consumoRefeicao = valor;
		adicionaAoConsumoGeral();
		
		if (unidade.equals("Terreo")){
			quantUsoUnidade1++; 
			consumoUnidade1 += valor;
		}
		else if (unidade.equals("Cobertura")){
			quantUsoUnidade2++;
			consumoUnidade2 += valor;
		}
	}
	
	/**
	 * Adiciona ao valor geral o consumo diario de acordo com a estrategia usada naquele dia
	 * @param dia Dia do consumo
	 * @param mes Mes do consumo
	 */
	
	private void adicionaAoConsumoGeral(){
		Calendar data = Calendar.getInstance(); 
		estrategia = calendario.verificaEstrategia(data.get(Calendar.DAY_OF_MONTH), data.get(Calendar.MONTH) + 1);
		consumoGeral += estrategia.calculaMontante(consumoRefeicao);
	}
	
	@Override
	public double getDespesaTotal() {
		return consumoGeral;
	}
	
	@Override
	public String toString() {
		return "Restaurante:"
				+ Arquivos.FIM_LINHA + "Unidade 1 (Terreo)"
				+ Arquivos.FIM_LINHA + "      Quantidade de usos: "+quantUsoUnidade1
				+ Arquivos.FIM_LINHA + "      Valor consumido: "+ consumoUnidade1
				+ Arquivos.FIM_LINHA + "Unidade 2 (Cobertura)"
				+ Arquivos.FIM_LINHA + "      Quantidade de usos: "+quantUsoUnidade2
				+ Arquivos.FIM_LINHA + "      Valor consumido: "+ consumoUnidade2
				+ Arquivos.FIM_LINHA +Arquivos.FIM_LINHA+"\n\nValor total: "+ consumoGeral;
	} 
	
	@Override
	public boolean equals( Object obj ) {
		if (! (obj instanceof Restaurante)) {
			return false;
		}
		
		Restaurante restaurante = (Restaurante) obj;
		
		return restaurante.getConsumoUnidade1() == consumoUnidade1
		    && restaurante.getConsumoUnidade2() == consumoUnidade2
		    && restaurante.getDespesaTotal() == consumoGeral;
	}
}