package excecoes;

public class ComentarioInvalidoException extends InputArgumentInvalidException {

  public ComentarioInvalidoException(String comentario) {
    super(comentario);
  }
}