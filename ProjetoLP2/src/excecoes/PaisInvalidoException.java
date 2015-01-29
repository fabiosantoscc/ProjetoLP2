package excecoes;

public class PaisInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PaisInvalidoException( String comentario ) {
		super(comentario);
	}
}
