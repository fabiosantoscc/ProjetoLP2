package excecoes;

public class NumeroDaResidenciaInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NumeroDaResidenciaInvalidoException( String comentario ) {
		super(comentario);
	}

}
