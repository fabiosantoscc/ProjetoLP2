package exce��es;

public class NotaInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public NotaInvalidaException( String mensagemDeErro ) {
		super(mensagemDeErro);
	}
}
