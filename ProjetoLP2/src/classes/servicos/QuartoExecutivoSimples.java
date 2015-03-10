package classes.servicos;
//package classes;
//
//import excecoes.*;
//
///**
// * Classe que representa um Quarto executivo simples com capacidade para ate 3 pessoas
// * com cama extra.
// * 
// * @author Fabio Alexandre Santos Silva Junior
// * Ultima atualizacao: 14/01/2015 / Fabio Alexandre
// */
//
//public class QuartoExecutivoSimples extends QuartoComCamaExtra {
//
//	private static final long serialVersionUID = 1L;
//	private final double VALOR_DIARIA = 360.0;
//	
//	/**
//	 * Construtor de um quarto executivo simples.
//	 * 
//	 * @param quantidadeDePessoas - Quantidade de pessoas hospedadas no quarto, maximo de 3.
//	 * @param camaExtra - Quantidade de camas extras no quarto, depende da disponibilidade.
//	 * @throws Exception
//	 */
//	
//	public QuartoExecutivoSimples( int quantidadeDePessoas, int camaExtra ) throws Exception {
//		
//		super(quantidadeDePessoas, camaExtra);
//		
//		verificaQuantidadeDePessoas(quantidadeDePessoas);
//		
//		if ( Hotel.getQuartoExecutivoSimples() - 1 < 0 ) {
//			throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
//		}
//
//		Hotel.setQuartoExecutivoSimples(Hotel.getQuartoExecutivoSimples() - 1);
//	}
//	
//	/**
//	 * Metodo que compara se dois objetos do tipo quarto executivo simples sao iguais.
//	 * 
//	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
//	 */
//	
//	@Override
//	public String toString() {
//		return "Quarto Executivo Simples [ Valor diaria = R$ " + VALOR_DIARIA + ", " 
//				+ super.toString() + ", Camas Extras = " + getCamaExtra() + " ]";
//	}
//	
//	/**
//	 * Metodo que compara se dois objetos do tipo quarto de luxo simples sao iguais.
//	 * 
//	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
//	 */
//	
//	@Override
//	public boolean equals( Object obj ) {
//		if ( !(obj instanceof QuartoExecutivoSimples))
//			return false;
//		
//		QuartoExecutivoSimples qes = (QuartoExecutivoSimples) obj;
//		
//		return super.equals(qes) && qes.getCamaExtra() == getCamaExtra();
//	}
//}
