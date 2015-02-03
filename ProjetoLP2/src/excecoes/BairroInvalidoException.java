package excecoes;

public class BairroInvalidoException extends InputArgumentInvalidException {
	
	public BairroInvalidoException( String comentario ) {
    	super(comentario);
    }
}
