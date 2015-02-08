package classes;

/**
 * Classe que recebe informa��es a cerca do aluguel de automoveis para clientes do Hotel e faz o gerenciamento desses dados.
 * 
 * @author Ronan Souza
 * @date 12/01/2014
 */
public class AluguelDeCarros implements Servicos {
	private String tipoCarro;
	private boolean tanqueCheio;
	private boolean seguroDeAutomovel;
	private int valorDiaria;
	private int tarifaTotal = 0;
	
	/**
	 * Construtor da classe AluguelDeCarros
	 * 
	 * @param tipoCarro Modelo do Automovel desejado ( "Luxo" ou "Executivo")
	 * @param tanqueCheio Veiculo j� com tanque cheio
	 * @param seguroAutomovel Seguro do automovel no periodo do aluguel 
	 * @param quantidadeDias Quantidade de dias em que o automovel estar� em uso do cliente
	 */
	public AluguelDeCarros(String tipoCarro, boolean tanqueCheio, boolean seguroAutomovel) throws Exception{
		checaTipoCarro(tipoCarro);
		this.tipoCarro = tipoCarro;
		this.tanqueCheio = tanqueCheio;
		this.seguroDeAutomovel = seguroAutomovel;
		
	}	
	
	private void checaTipoCarro(String tipo)throws Exception{
		if (!( tipo.equals("Executivo") ||  tipo.equals("Luxo"))) {
			throw new Exception("Modelo de Autom�vel Inv�lido (\"Luxo\" ou \"Executivo\")");
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
	 * @return Se o ve�culo j� sai para o aluguel com o tanque de combust�vel cheio
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
	 * @return Se o ve�culo ser� assegurado no periodo que estiver com o cliente
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
	 * Metodo que retorna uma String com os atributos da classe
	 */
	@Override
	public String toString() {
		return "AluguelDeCarros\n"
				+ "Modelo do Autom�vel: "+tipoCarro 
				+ "\nTanque Cheio: " + tanqueCheio + 
						 "\nAutom�vel Assegurado: " + seguroDeAutomovel ;
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