package excecoes;

public class EmailInvalidoException extends InputArgumentInvalidException {

  public EmailInvalidoException(String comentario) {
    super(comentario);
  }
}
