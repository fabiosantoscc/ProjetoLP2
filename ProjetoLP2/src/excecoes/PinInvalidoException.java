package excecoes;

public class PinInvalidoException extends InputArgumentInvalidException {

	private static final long serialVersionUID = 1L;

	public PinInvalidoException(String comentario) {
		super(comentario);
	}
}
