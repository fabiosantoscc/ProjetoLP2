package classes.servicos;
//package classes;
//
//import excecoes.QuartoEsgotadoNoHotelException;
//
///**
// * 
// * Classe que representa um Quarto executivo duplo com capacidade para at� 3 pessoas
// * com cama extra, se necessario e disponivel.
// * 
// * @author Fabio Alexandre Santos Silva Junior
// * Ultima atualizacao: 14/01/2015 / Fabio Alexandre
// */
//
//public class QuartoExecutivoDuplo extends QuartoComCamaExtra {
//	
//	private static final long serialVersionUID = 1L;
//	private final double VALOR_DIARIA = 385.0;
//	
//	/**
//	 * Construtor de um quarto executivo duplo.
//	 * 
//	 * @param quantidadeDePessoas - Quantidade de pessoas hospedadas no quarto, maximo de 3.
//	 * @param camaExtra - Quantidade de camas extras, se necessario de disponivel.
//	 * @throws Exception
//	 */
//	
//	public QuartoExecutivoDuplo( int quantidadeDePessoas, int camaExtra  ) throws Exception {
//		
//		super(quantidadeDePessoas, camaExtra);
//		
//		if ( Hotel.getQuartoExecutivoDuplo() == 0 ) {
//			throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
//		}
//		
//		Hotel.setQuartoExecutivoDuplo(Hotel.getQuartoExecutivoDuplo() - 1);
//	}
//	
//	/**
//	 * Metodo que compara se dois objetos do tipo quarto executivo duplo sao iguais.
//	 * 
//	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
//	 */
//	
//	@Override
//	public String toString() {
//		return "Quarto Executivo Duplo [ Valor diaria = R$ " + VALOR_DIARIA + ", " 
//				+ super.toString() + ", Camas Extras = " + getCamaExtra() + " ]";
//	}
//	
//	/**
//	 * Metodo que compara se dois objetos do tipo quarto executivo duplo sao iguais.
//	 * 
//	 * @return Um boolean (true) se os objetos forem iguais, (false) caso contrario.
//	 */
//	
//	@Override
//	public boolean equals( Object obj ) {
//		if ( !(obj instanceof QuartoExecutivoDuplo))
//			return false;
//		
//		QuartoExecutivoDuplo qed = (QuartoExecutivoDuplo) obj;
//		
//		return super.equals(qed) && qed.getCamaExtra() == getCamaExtra();
//	}
//}