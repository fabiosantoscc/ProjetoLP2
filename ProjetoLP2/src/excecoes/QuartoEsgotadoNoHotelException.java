package excecoes;

public class QuartoEsgotadoNoHotelException extends Exception {

  private static final long serialVersionUID = 1L;

  public QuartoEsgotadoNoHotelException(String comentario) {
    super(comentario);
  }
}
