package excecoes;

public class EstadoInvalidoException extends InputArgumentInvalidException {

	private static final long serialVersionUID = 1L;

	public EstadoInvalidoException( String comentario ) {
		super(comentario);
	}
}
