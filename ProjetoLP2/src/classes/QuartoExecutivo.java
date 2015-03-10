package classes;

import excecoes.QuantidadeDePessoasInvalidaException;

public class QuartoExecutivo extends Quarto {

  private static final long serialVersionUID = 1L;
  private SubtipoDeQuartoExecutivo tipo;

  public QuartoExecutivo( int quantidadeDePessoas, SubtipoDeQuartoExecutivo tipo)
      throws QuantidadeDePessoasInvalidaException {
    super(quantidadeDePessoas);
    checaTipoDoQuarto();
    
    if ( quantidadeDePessoas > 3 ) {
    	throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas nao pode ser maior que 3 neste tipo de quarto");
    }

    this.tipo = tipo;
  }

  public SubtipoDeQuartoExecutivo getTipo() {
    return tipo;
  }

  private void checaTipoDoQuarto() {
	  if ( getTipo().name().equals("SIMPLES") ) {
		  Hotel.setQuartoExecutivoSimples(Hotel.getQuartoExecutivoSimples() - 1);
	  }
	  
	  if ( getTipo().name().equals("DUPLO") ) {
		  Hotel.setQuartoExecutivoDuplo(Hotel.getQuartoExecutivoDuplo() - 1);
	  }
	  
	  if ( getTipo().name().equals("TRIPLO") ) {
		  Hotel.setQuartoExecutivoTriplo(Hotel.getQuartoExecutivoTriplo() - 1);
	  }
  }
  
  @Override
  public String toString() {
    return "QuartoExecutivo - Tipo = " + getTipo().name().toLowerCase()
    		+ ", Valor da diaria = " + tipo.getValorDiaria() + ", " + super.toString();
  }

  @Override
  public boolean equals( Object obj ) {
    if ( !(obj instanceof SubtipoDeQuartoExecutivo) ) {
    	return false;
    }
    
    QuartoExecutivo q = (QuartoExecutivo) obj;
    
    return super.equals(q) && tipo.equals(q.getTipo());
  }
}