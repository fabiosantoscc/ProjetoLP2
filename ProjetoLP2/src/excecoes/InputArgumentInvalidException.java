package excecoes;

public class InputArgumentInvalidException extends Exception {

  public InputArgumentInvalidException( String comentario ) {
    super(comentario);
  }
}
