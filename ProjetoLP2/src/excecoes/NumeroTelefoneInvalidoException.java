package excecoes;

public class NumeroTelefoneInvalidoException extends InputArgumentInvalidException {

	private static final long serialVersionUID = 1L;
	
	public NumeroTelefoneInvalidoException( String comentario ) {
		super(comentario);
	}
}
