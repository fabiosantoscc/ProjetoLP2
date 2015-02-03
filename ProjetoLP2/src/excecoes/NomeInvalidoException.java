package excecoes;

public class NomeInvalidoException extends InputArgumentInvalidException {

	public NomeInvalidoException(String comentario) {
		super(comentario);
	}
}
