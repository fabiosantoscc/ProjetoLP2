package excecoes;

public class DddInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public DddInvalidoException( String comentario ) {
		super(comentario);
	}
}
