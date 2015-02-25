package classes;


import java.io.Serializable;
import java.util.Calendar;

/**
 * Classe que recebe informações a cerca do aluguel de automoveis para clientes do Hotel e faz o gerenciamento desses dados.
 * 
 * @author Ronan Souza
 * @date 12/01/2014
 * Ultima Alteracao : FAbio Alexandre 10/02/2015
 */

public class AluguelDeCarros implements Servicos, Serializable {

	private static final long serialVersionUID = 1L;
	
	private String tipoCarro;
	private boolean tanqueCheio;
	private boolean seguroDeAutomovel;
	private int valorDiaria;
	private int tarifaTotal = 0;
	private Calendar data;
	private int diaInicial, mesInicial, anoInicial;
	
	/**
	 * Construtor da classe AluguelDeCarros
	 * 
	 * @param tipoCarro Modelo do Automovel desejado ( "Luxo" ou "Executivo")
	 * @param tanqueCheio Veiculo ja com tanque cheio
	 * @param seguroAutomovel Seguro do automovel no periodo do aluguel 
	 * @param quantidadeDias Quantidade de dias em que o automovel estará em uso do cliente
	 */
	
	public AluguelDeCarros(String tipoCarro, boolean tanqueCheio, boolean seguroAutomovel) throws Exception {
		checaTipoCarro(tipoCarro);
		data = Calendar.getInstance();
		diaInicial = data.get(Calendar.DAY_OF_MONTH);
		mesInicial = data.get(Calendar.MONTH) + 1;
		anoInicial = data.get(Calendar.YEAR);
		
		this.tipoCarro = tipoCarro;
		this.tanqueCheio = tanqueCheio;
		this.seguroDeAutomovel = seguroAutomovel;
	}	
	
	private void checaTipoCarro(String tipo) throws Exception {
		if (!( tipo.equals("Executivo") ||  tipo.equals("Luxo"))) {
			throw new Exception("Modelo de Automóvel Invalido");
		}
	}
	
	/**
	 * 
	 * @return Modelo do Automovel desejado ( "Luxo" ou "Executivo")
	 */
	
	public String getTipoCarro() {
		return tipoCarro;
	}
	
	public double getPreco() { 
		return tarifaTotal;
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
	
	public double getValorDiaria(){
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
	 * Vetifica o tipo do carro
	 */
	
	public void verificaTipo() {
		if (tipoCarro.equals("Luxo")) valorDiaria = 100;
		else if (tipoCarro.equals("Executivo")) valorDiaria = 60;
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
/*
	public void calculaGastoTotal(int diaDeEntrada, int mesDeEntrada, int diaDeSaida, int mesDeSaida)throws Exception{
		if (!(calendario.verificaDataValida(diaDeEntrada, mesDeEntrada))) throw new Exception ("Data invalida.");
		if (!(calendario.verificaDataValida(diaDeSaida, mesDeSaida))) throw new Exception ("Data invalida.");
		for (int i = mesDeEntrada;i <= mesDeSaida;i++){
			for (int j = diaDeEntrada; j <= diaDeSaida; j++){
				boolean dataValida = calendario.verificaDataValida(j,i);
				if (! dataValida){
					i = 1;
					if (j == 12) {
						j = 1;
					}
					else j++;
					break;
				}
				estrategia = calendario.verificaEstrategia(j, i);
				tarifaTotal += estrategia.calculaMontante(valorDiaria);
				}
			}
		}
	*/
		
	/**
	 * Metodo que retorna uma String com os atributos da classe
	 */
	
	@Override
	public String toString() {
		String string;
		string = "AluguelDeCarros - "+ "Data: " + data.get(Calendar.DAY_OF_WEEK) + "/" + data.get(Calendar.MONTH + 1)+ "/"
				+ data.get(Calendar.YEAR) + " " + data.get(Calendar.HOUR_OF_DAY) + ":" + data.get(Calendar.MINUTE) + ":" + data.get(Calendar.SECOND);
		
		if ( tanqueCheio ) {
			string += ", Tanque cheio";
		} else {
			string += ", Tanque nao cheio";
		}
		
		if ( seguroDeAutomovel ) {
			string += ", Carro com seguro.";
		} else {
			string += ", Carro sem seguro.";
		}
		
		return string;
	}

	@Override
	public boolean equals( Object obj ) {
		if (!(obj instanceof AluguelDeCarros))
			return false;
		
		AluguelDeCarros novoAluguel = (AluguelDeCarros)obj;
		
		return (tipoCarro.equals(novoAluguel.getTipoCarro()) && tanqueCheio == novoAluguel.isTanqueCheio() &&
				seguroDeAutomovel == novoAluguel.isSeguroDeAutomovel());
		}

	@Override
	public double getDespesaTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
}