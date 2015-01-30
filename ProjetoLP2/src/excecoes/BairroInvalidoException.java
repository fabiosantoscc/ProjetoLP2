package excecoes;

public class BairroInvalidoException extends InputArgumentInvalidException {
	
	private static final long serialVersionUID = 1L;

	public BairroInvalidoException( String comentario ) {
    	super(comentario);
    }
}
