package excecoes;

public class DataDeNascimentoInvalidaException extends Exception {

  private static final long serialVersionUID = 287618677768147925L;

  public DataDeNascimentoInvalidaException(String comentario) {
    super(comentario);
  }
}
