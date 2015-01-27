package excecoes;

public class ComentarioInvalidoException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ComentarioInvalidoException(String comentario) {
		super(comentario);
	}
}
