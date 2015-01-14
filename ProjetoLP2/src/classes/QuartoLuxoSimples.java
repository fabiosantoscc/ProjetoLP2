package classes;

/**
 * 
 * Classe que representa um Quarto de luxo triplo com capacidade para até 3 pessoas
 * com cama extra se disponivel e necessario.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima atualizacao: 10/01/2015 / Fabio Alexandre
 */

public class QuartoLuxoSimples extends Quarto {

	private final double VALOR_DIARIA = 520;
	private int camaExtra;
	
	/**
	 * Construtor de um quarto de luxo simples.
	 * 
	 * @param quantidadeDePessoas - Quantidade de pessoas a serem hospedadas.
	 * @param camaExtra
	 * @throws Exception
	 */
	
	public QuartoLuxoSimples( int quantidadeDePessoas, int camaExtra ) throws Exception {

		super(quantidadeDePessoas);
		
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 3 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}
		
		if ( camaExtra < 0 || camaExtra > Hotel.getCamaExtra()) {
			throw new IllegalArgumentException("Quantidade de camas extras invalida");
		}
		
		if ( Hotel.getQuartoLuxoSimples() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		this.camaExtra = camaExtra;
		Hotel.setCamaExtra(Hotel.getCamaExtra() - this.camaExtra);
		Hotel.setQuartoLuxoSimples(Hotel.getQuartoLuxoSimples() - 1);
	}
	
	/**
	 * @return - A quantidade de camas extras do quarto.
	 */
	
	public int getCamaExtra() {
		return camaExtra;
	}
	
	/**
	 * 
	 */
	
	@Override
	public double calculaTarifa() {
		return VALOR_DIARIA;
	}
	
	/**
	 * Metodo que retorna uma string para representacao de um quarto de luxo simples.
	 * 
	 * @return A string de representacao do quarto de luxo simples.
	 */
	
	@Override
	public String toString() {
		return "Quarto Luxo Simples [ Quantidade de quartos diponiveis = " + Hotel.getQuartoLuxoSimples() 
				+ ", Valor diaria = " + VALOR_DIARIA + ", " + super.toString() + " ]";
	}

	/**
	 * Metodo que compara se dois objetos do tipo quarto de luxo simples sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if ( !(obj instanceof QuartoLuxoSimples))
			return false;
		
		QuartoLuxoSimples qls = (QuartoLuxoSimples) obj;
		
		return super.equals(qls) && qls.calculaTarifa() == VALOR_DIARIA &&
				qls.getCamaExtra() == getCamaExtra();
	}
}