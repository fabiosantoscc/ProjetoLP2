package excecoes;

public class ComplementoInvalidoException extends InputArgumentInvalidException {
	
	public ComplementoInvalidoException( String comentario ) {
		super(comentario);
	}
}
