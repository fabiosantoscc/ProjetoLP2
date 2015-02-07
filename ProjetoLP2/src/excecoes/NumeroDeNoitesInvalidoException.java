package excecoes;

public class NumeroDeNoitesInvalidoException  extends InputArgumentInvalidException {

	private static final long serialVersionUID = 1L;

	public NumeroDeNoitesInvalidoException(String comentario) {
		super(comentario);
	}
}
