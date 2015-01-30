package excecoes;

public class ComentarioInvalidoException extends InputArgumentInvalidException {
	
	private static final long serialVersionUID = 1L;

	public ComentarioInvalidoException(String comentario) {
		super(comentario);
	}
}