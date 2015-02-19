package excecoes;

public class CpfInvalidoException extends InputArgumentInvalidException {

  public CpfInvalidoException(String comentario) {
    super(comentario);
  }
}
