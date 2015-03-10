package classes;

import excecoes.QuantidadeDePessoasInvalidaException;

public class QuartoLuxo extends Quarto {

  private static final long serialVersionUID = 1L;
  private SubtipoDeQuartoLuxo tipo;

  public QuartoLuxo(int quantidadeDePessoas, SubtipoDeQuartoLuxo tipo)
      throws QuantidadeDePessoasInvalidaException {
    super(quantidadeDePessoas);
    this.tipo = tipo;
  }

  public SubtipoDeQuartoLuxo getTipo() {
	  return tipo;
  }
  
  @Override
  public String toString() {
    return "QuartoLuxo [ Tipo = " + getTipo().name().toLowerCase() + super.toString();
  }

  @Override
  public boolean equals( Object obj ) {
    return false;
  }
}
