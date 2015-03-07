package excecoes;

public class InputArgumentInvalidException extends Exception {

  private static final long serialVersionUID = 1L;

  public InputArgumentInvalidException() {
  }

  public InputArgumentInvalidException( String comentario ) {
    super(comentario);
  }
}
