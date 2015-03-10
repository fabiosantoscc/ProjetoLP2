package classes;

import excecoes.QuantidadeDePessoasInvalidaException;

public class QuartoExecutivo extends Quarto {

  private static final long serialVersionUID = 1L;
  private SubtipoDeQuartoExecutivo tipo;

  public QuartoExecutivo( int quantidadeDePessoas, SubtipoDeQuartoExecutivo tipo)
      throws QuantidadeDePessoasInvalidaException {
    super(quantidadeDePessoas);
    this.tipo = tipo;
  }

  public SubtipoDeQuartoExecutivo getTipo() {
    return tipo;
  }

  @Override
  public String toString() {
    return "Quartoexecutivo [ Tipo = " + getTipo().name().toLowerCase() + super.toString();
  }

  @Override
  public boolean equals( Object obj ) {
    return false;
  }
}