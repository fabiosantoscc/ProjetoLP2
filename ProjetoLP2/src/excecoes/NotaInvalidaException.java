package excecoes;

public class NotaInvalidaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NotaInvalidaException(String comentario) {
		super(comentario);
	}

}