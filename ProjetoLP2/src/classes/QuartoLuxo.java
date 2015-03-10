package classes;

import excecoes.QuantidadeDePessoasInvalidaException;

public class QuartoLuxo extends Quarto {

  private static final long serialVersionUID = 1L;
  private SubtipoDeQuartoLuxo tipo;

  public QuartoLuxo(int quantidadeDePessoas, SubtipoDeQuartoLuxo tipo)
      throws QuantidadeDePessoasInvalidaException {
    super(quantidadeDePessoas);
    
    if ( quantidadeDePessoas > 3 ) {
    	throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas nao pode ser maior que 3 neste tipo de quarto.");
    }
    
    this.tipo = tipo;
  }

  public SubtipoDeQuartoLuxo getTipo() {
	  return tipo;
  }
  
  @Override
  public String toString() {
    return "QuartoLuxo - Tipo = " + getTipo().name().toLowerCase()
	      + ", Valor da diaria = R$ " + tipo.getValorDiaria() + ", " + super.toString();
  }

  @Override
  public boolean equals( Object obj ) {
    return false;
  }
}
