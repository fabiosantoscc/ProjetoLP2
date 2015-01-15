package classes;

/**
 * 
 * Classe que representa um Quarto executivo duplo com capacidade para até 3 pessoas
 * com cama extra, se necessario e disponivel.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima atualizacao: 14/01/2015 / Fabio Alexandre
 */

public class QuartoExecutivoDuplo extends Quarto {
	
	private final double VALOR_DIARIA = 385;
	private int camaExtra;
	
	/**
	 * Construtor de um quarto executivo duplo.
	 * 
	 * @param quantidadeDePessoas - Quantidade de pessoas hospedadas no quarto, maximo de 3.
	 * @param camaExtra - Quantidade de camas extras, se necessario de disponivel.
	 * @throws Exception
	 */
	
	public QuartoExecutivoDuplo( int quantidadeDePessoas, int camaExtra  ) throws Exception {
		
		super(quantidadeDePessoas);
		
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 3 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}
		
		if ( camaExtra < 0 || camaExtra > Hotel.getCamaExtra()) {
			throw new IllegalArgumentException("Quantidade de camas extras invalida");
		}
		
		
		if ( Hotel.getQuartoExecutivoDuplo() - 1 < 0 ) {
			throw new IllegalArgumentException("Nao ha mais quartos livres");
		}
		
		this.camaExtra = camaExtra;
		Hotel.setCamaExtra(Hotel.getCamaExtra() - this.camaExtra);
		Hotel.setQuartoExecutivoDuplo(Hotel.getQuartoExecutivoDuplo() - 1);
	}
	
	/**
	 *  @return - Quantidade de camas extras do quarto.
	 */
	
	public int getCamaExtra() {
		return camaExtra;
	}
	
	/**
	 * 
	 */
	
	@Override
	public double getPreco() {
		return VALOR_DIARIA;
	}

	public void setQuantidadeDePessoas(int pessoas) {
		if ( pessoas <= 0 || pessoas > 3 ) {
			throw new IllegalArgumentException("Quantidade de pessoas do quarto invalida");
		}
		
		super.setQuantidadeDePessoas(pessoas);
	}
	
	/**
	 * Metodo que compara se dois objetos do tipo quarto executivo duplo sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public String toString() {
		return "Quarto Executivo Duplo [ Quantidade de quartos diponiveis = " + Hotel.getQuartoExecutivoDuplo() 
				+ ", Valor diaria = " + VALOR_DIARIA + ", " + super.toString() + " ]";
	}
	
	/**
	 * Metodo que compara se dois objetos do tipo quarto executivo duplo sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if ( !(obj instanceof QuartoExecutivoDuplo))
			return false;
		
		QuartoExecutivoDuplo qed = (QuartoExecutivoDuplo) obj;
		
		return super.equals(qed) && qed.getPreco() == VALOR_DIARIA &&
			   qed.getCamaExtra() == getCamaExtra();
	}
}