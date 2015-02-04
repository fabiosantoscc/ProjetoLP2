package classes;

import excecoes.*;

/**
 * Classe que representa um Quarto executivo simples com capacidade para ate 3 pessoas
 * com cama extra.
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * Ultima atualizacao: 14/01/2015 / Fabio Alexandre
 */

public class QuartoExecutivoSimples extends Quarto {
	
	private final double VALOR_DIARIA = 360.0;
	private int camaExtra;
	
	/**
	 * Construtor de um quarto executivo simples.
	 * 
	 * @param quantidadeDePessoas - Quantidade de pessoas hospedadas no quarto, maximo de 3.
	 * @param camaExtra - Quantidade de camas extras no quarto, depende da disponibilidade.
	 * @throws Exception
	 */
	
	public QuartoExecutivoSimples( int quantidadeDePessoas, int camaExtra ) throws Exception {
		
		super(quantidadeDePessoas);
		
		verificaQuantidadeDePessoas(quantidadeDePessoas);
		verificaCamaExtra(camaExtra);
		
		if ( Hotel.getQuartoExecutivoSimples() - 1 < 0 ) {
			throw new QuartoEsgotadoException("Nao ha mais quartos livres");
		}
		
		this.camaExtra = camaExtra;
		Hotel.setCamaExtra(Hotel.getCamaExtra() - this.camaExtra);
		Hotel.setQuartoExecutivoSimples(Hotel.getQuartoExecutivoSimples() - 1);
	}
	
	/**
	 * @return - A quantidade de camas extras do quarto.
	 */
	
	public int getCamaExtra() {
		return camaExtra;
	}
	
	/**
	 * 
	 * @param cama
	 * @throws CamaExtraEsgotadaException 
	 */
	
	public void setCamaExtra( int cama) throws CamaExtraEsgotadaException {
		verificaCamaExtra(cama);
		
		Hotel.setCamaExtra(Hotel.getCamaExtra() + camaExtra);
		Hotel.setCamaExtra(Hotel.getCamaExtra() - cama);
		this.camaExtra = cama;
	}
	
	/**
	 * 
	 * @return
	 */
	
	@Override
	public double getPreco() {
		return VALOR_DIARIA;
	}
	
	public void setQuantidadeDePessoas(int pessoas) throws QuantidadeDePessoasInvalidaException {
		verificaQuantidadeDePessoas(pessoas);
		super.setQuantidadeDePessoas(pessoas);
	}
	
	private void verificaQuantidadeDePessoas(int quantidadeDePessoas) throws QuantidadeDePessoasInvalidaException {
		if ( quantidadeDePessoas <= 0 || quantidadeDePessoas > 3 ) {
			throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas do quarto invalida");
		}
	}

	private void verificaCamaExtra(int camaExtra) throws CamaExtraEsgotadaException {
		if ( camaExtra < 0 || camaExtra > Hotel.getCamaExtra()) {
			throw new CamaExtraEsgotadaException("Quantidade de camas extras invalida");
		}
	}
	
	/**
	 * Metodo que compara se dois objetos do tipo quarto executivo simples sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public String toString() {
		return "Quarto Executivo Simples [ Valor diaria = R$ " + VALOR_DIARIA + ", " 
				+ super.toString() + ", Camas Extras = " + getCamaExtra() + " ]";
	}
	
	/**
	 * Metodo que compara se dois objetos do tipo quarto de luxo simples sao iguais.
	 * 
	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if ( !(obj instanceof QuartoExecutivoSimples))
			return false;
		
		QuartoExecutivoSimples qes = (QuartoExecutivoSimples) obj;
		
		return super.equals(qes) && qes.getPreco() == VALOR_DIARIA &&
			   qes.getCamaExtra() == getCamaExtra();
	}
}
