package excecoes;

public class NotaInvalidaException extends InputArgumentInvalidException {
	
	public NotaInvalidaException(String comentario) {
		super(comentario);
	}
}
