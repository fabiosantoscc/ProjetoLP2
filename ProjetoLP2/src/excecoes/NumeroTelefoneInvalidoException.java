package excecoes;

public class NumeroTelefoneInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NumeroTelefoneInvalidoException( String comentario ) {
		super(comentario);
	}
}
