package excecoes;

public class ComplementoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ComplementoInvalidoException( String comentario ) {
		super(comentario);
	}
}
