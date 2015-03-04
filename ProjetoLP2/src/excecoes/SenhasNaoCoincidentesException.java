package excecoes;

public class SenhasNaoCoincidentesException extends InputArgumentInvalidException {

	private static final long serialVersionUID = 1L;

	public SenhasNaoCoincidentesException(String comentario) {
		super(comentario);
	}
}
