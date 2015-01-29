package excecoes;

public class RuaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;

	public RuaInvalidaException( String comentario ) {
		super(comentario);
	}
}
