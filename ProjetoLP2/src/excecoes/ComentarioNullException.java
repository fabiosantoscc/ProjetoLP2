package excecoes;

public class ComentarioNullException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ComentarioNullException(String comentario) {
		super(comentario);
	}

}
