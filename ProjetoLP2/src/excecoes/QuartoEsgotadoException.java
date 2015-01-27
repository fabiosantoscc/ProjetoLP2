package excecoes;

public class QuartoEsgotadoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public QuartoEsgotadoException(String comentario) {
		super(comentario);
	}
}
