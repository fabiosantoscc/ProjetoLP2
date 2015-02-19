package excecoes;

public class NomeRuaInvalidaException extends InputArgumentInvalidException {

  public NomeRuaInvalidaException(String comentario) {
    super(comentario);
  }
}
