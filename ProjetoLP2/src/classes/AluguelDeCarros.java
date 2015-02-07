package classes;

/**
 * Classe que recebe informacoes sobre o aluguel de automoveis para clientes do Hotel e faz o gerenciamento desses dados.
 * 
 * @author Ronan Souza
 * @date 12/01/2014
 * Ultima revisao: 03/02/2015 / Fabio Alexandre
 */

public class AluguelDeCarros implements Servicos {
	
	private String tipoCarro;
	private boolean tanqueCheio;
	private boolean seguroDeAutomovel;
	private int quantidadeDias;
	private int valorDiaria;
	private int tarifaTotal = 0;
	
	/**
	 * Construtor da classe AluguelDeCarros
	 * 
	 * @param tipoCarro Modelo do Automovel desejado ( "Luxo" ou "Executivo")
	 * @param tanqueCheio Veiculo ja com tanque cheio
	 * @param seguroAutomovel Seguro do automovel no periodo do aluguel 
	 * @param quantidadeDias Quantidade de dias em que o automovel estara em uso do cliente
	 */
	public AluguelDeCarros(String tipoCarro, boolean tanqueCheio, boolean seguroAutomovel, int quantidadeDias) throws Exception {
		checaTipoCarro(tipoCarro);
		checaquantidadeDias(quantidadeDias);
		this.tipoCarro = tipoCarro;
		this.tanqueCheio = tanqueCheio;
		this.seguroDeAutomovel = seguroAutomovel;
		this.quantidadeDias = quantidadeDias;
		calculaTarifa();
		
	}	
	
	private void checaTipoCarro(String tipo) throws Exception {
		if (!( tipo.equals("Executivo") ||  tipo.equals("Luxo"))) {
			throw new Exception("Modelo de Automóvel Inválido (\"Luxo\" ou \"Executivo\")");
		}
	}
	
	private void checaquantidadeDias(int quant) throws Exception{
		if (quant <= 0){
			throw new Exception("O número de dias deve ser maior que zero");
		}
	}
	/**
	 * 
	 * @return Modelo do Automovel desejado ( "Luxo" ou "Executivo")
	 */
	public String getTipoCarro(){ return tipoCarro;}
	
	public double getPreco(){ 
		return tarifaTotal;
	}
	
	/**
	 * 
	 * @return Se o veiculo ja sai para o aluguel com o tanque de combustivel cheio
	 */
	public boolean isTanqueCheio() {
		return tanqueCheio;
	}

	/**
	 * 
	 * @return Se o veiculo sera assegurado no periodo que estiver com o cliente
	 */
	public boolean isSeguroDeAutomovel() {
		return seguroDeAutomovel;
	}

	/**
	 * Calcula o valor a ser pago pelo alugel do automovel.
	 * @return Valor a ser pago 
	 */
	private void calculaTarifa() {
		switch (tipoCarro) {
		case "Luxo":
			valorDiaria = 100;
			break;
		case "Executivo":
			valorDiaria = 60;
		}
		if (isSeguroDeAutomovel()){
			tarifaTotal += 100;
		}
		if (isTanqueCheio()){
			tarifaTotal += 150;
		}
		tarifaTotal += valorDiaria * quantidadeDias;
	}

	/**
	 * Metodo que retorna uma String com os atributos da classe
	 */
	@Override
	public String toString() {
		return "AluguelDeCarros\n"
				+ "Modelo do Automóvel: "+tipoCarro 
				+ "\nTanque Cheio: " + tanqueCheio + 
						 "\nAutomóvel Assegurado: " + seguroDeAutomovel 
						+ "\nQuantidade de dias do aluguel: " + quantidadeDias;
	}

	@Override
	public boolean equals( Object obj ) {
		if (!(obj instanceof AluguelDeCarros)) return false;
		AluguelDeCarros novoAluguel = (AluguelDeCarros)obj;
		if (tipoCarro.equals(novoAluguel.getTipoCarro()) && tanqueCheio == novoAluguel.isTanqueCheio() &&
				seguroDeAutomovel == novoAluguel.isSeguroDeAutomovel()){
			return true;
		}
		return false;
		}
}