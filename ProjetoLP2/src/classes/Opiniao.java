package classes;

import excecoes.NotaInvalidaException;
import excecoes.ComentarioInvalidoException;
import excecoes.InputArgumentInvalidException;

/**
 * Classe criada para representar uma opiniao.
 * 
 * 
 * @author Fabio Alexandre Santos Silva Junior
 * @version 1.0
 * @data 04/01/2015
 * ultima revisao: 03/02/2015 / Fabio Alexandre
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
	
	public Opiniao( String comentario, double nota ) throws InputArgumentInvalidException {
		
		if ( comentario == null || comentario.length() > 100 || comentario.equals("") ) {
			throw new ComentarioInvalidoException("Comentario invalido");
		}
		
		if ( nota < 0.0 || nota > 10.0 ) {
			throw new NotaInvalidaException("Nota invalida");
		}
		
		this.comentario = comentario;
		this.nota = nota;
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
		return "Opiniao [ comentario = " + comentario + ", nota = " + nota + " ]";
	}
		
	/**
	 * 
	 * @return Verifica se duas opinioes sao iguais, para isso a nota e o comentario t�m que ser iguais.
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