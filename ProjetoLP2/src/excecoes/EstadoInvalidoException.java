package excecoes;

public class EstadoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	public EstadoInvalidoException( String comentario ) {
		super(comentario);
	}
}
