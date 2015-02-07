package excecoes;

public class NomeRuaInvalidaException extends InputArgumentInvalidException {
	
	private static final long serialVersionUID = 1L;
	
	public NomeRuaInvalidaException(String comentario) {
		super(comentario);
	}
}
