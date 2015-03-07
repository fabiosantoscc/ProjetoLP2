package excecoes;

public class StringInvalidaException extends InputArgumentInvalidException {

  private static final long serialVersionUID = 1L;

  public StringInvalidaException() {
    super();
  }

  public StringInvalidaException(String comentario) {
    super(comentario);
  }
}
