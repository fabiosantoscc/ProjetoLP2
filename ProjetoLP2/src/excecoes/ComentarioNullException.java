package excecoes;

public class ComentarioNullException extends InputArgumentInvalidException {

	private static final long serialVersionUID = 1L;
	
	public ComentarioNullException(String comentario) {
		super(comentario);
	}
}
