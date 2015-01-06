package classes;

import exceções.NotaInvalidaException;

/**
 * Classe criada para representar uma opiniao.
 * 
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * @version 1.0
 * @data 04/01/2015
 * ultima revisao: 04/01/2015 / Fabio Alexandre
 * 
 */

public class Opiniao {

	private String comentario;
	private double nota;
	
	/**
	 * Construtor da classe Opiniao
	 * 
	 * @param comentario - Comentario feito por alguem.
	 * @param nota - nota dada a determinada coisa. (depende da aplicacao)
	 * @throws Exception
	 */
	
	public Opiniao( String comentario, double nota ) throws Exception {
		if ( nota < 0.0 || nota > 10.0 ) {
			throw new NotaInvalidaException("Nota invalida");
		}
		
		if ( comentario.length() > 100 || comentario == null || comentario.equals("")) {
			throw new Exception("Comentario invalido");
		}
	}

	/**
	 * 
	 * @return O comentario contido na opiniao.
	 * 
	 */
	
	public String getComentario() {
		return comentario;
	}

	/**
	 * 
	 * @return A nota contida na Opiniao.
	 * 
	 */
	
	public double getNota() {
		return nota;
	}

	/**
	 * @return Uma String da representacao da opiniao.
	 */
	
	
	
	@Override
	public String toString() {
		return "Opiniao [ comentario = " + comentario + ", nota = " + nota + "]";
	}
	
	/**
	 * @return Um inteiro representando a opiniao.
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comentario == null) ? 0 : comentario.hashCode());
		long temp;
		temp = Double.doubleToLongBits(nota);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	
	/**
	 * 
	 * @return Verifica se duas opinioes sao iguais, para isso a nota e o comentario têm que ser iguais.
	 * E retorna um valor valor booleano se as opinioes forem iguais ou nao.
	 * 
	 */
	
	@Override
	public boolean equals( Object obj ) {
		if ( ! ( obj instanceof Opiniao ) ) {
			return false;
		}
		
		Opiniao opiniao = (Opiniao) obj;
		
		return opiniao.getNota() == getNota() && opiniao.getComentario().equals(getComentario());
	}
}