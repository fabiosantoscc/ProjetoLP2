package classes;

import excecoes.QuantidadeDePessoasInvalidaException;

public class QuartoExecutivo extends Quarto {

  private static final long serialVersionUID = 1L;
  private SubtipoDeQuartoExecutivo tipo;

  public QuartoExecutivo( int quantidadeDePessoas, SubtipoDeQuartoExecutivo tipo)
      throws QuantidadeDePessoasInvalidaException {
    super(quantidadeDePessoas);
    
    if ( quantidadeDePessoas > 3 ) {
    	throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas nao pode ser maior que 3 neste tipo de quarto");
    }

    this.tipo = tipo;
  }

  public SubtipoDeQuartoExecutivo getTipo() {
    return tipo;
  }

  @Override
  public String toString() {
    return "QuartoExecutivo - Tipo = " + getTipo().name().toLowerCase()
    		+ ", Valor da diaria = " + tipo.getValorDiaria() + ", " + super.toString();
  }

  @Override
  public boolean equals( Object obj ) {
    return false;
  }
}