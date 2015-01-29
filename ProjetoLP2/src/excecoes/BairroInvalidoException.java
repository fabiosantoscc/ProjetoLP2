package excecoes;

public class BairroInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
    public BairroInvalidoException( String comentario ) {
    	super(comentario);
    }
}
