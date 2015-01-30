package excecoes;

public class PaisInvalidoException extends InputArgumentInvalidException {

	private static final long serialVersionUID = 1L;
	
	public PaisInvalidoException( String comentario ) {
		super(comentario);
	}
}
