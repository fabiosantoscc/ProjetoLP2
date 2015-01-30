package excecoes;

public class CidadeInvalidaException extends InputArgumentInvalidException {

	private static final long serialVersionUID = 1L;

	public CidadeInvalidaException( String comentario ) {
		super(comentario);
	}
}
