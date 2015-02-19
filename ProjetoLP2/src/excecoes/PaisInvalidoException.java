package excecoes;

public class PaisInvalidoException extends InputArgumentInvalidException {

  public PaisInvalidoException( String comentario ) {
    super(comentario);
  }
}
