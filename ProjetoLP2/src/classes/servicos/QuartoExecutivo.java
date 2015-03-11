package classes.servicos;

import classes.Hotel;
import enums.SubtipoDeQuartoExecutivo;
import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;

/**
 * 
 * @author Fabio
 *
 */

public class QuartoExecutivo extends Quarto {

  private static final long serialVersionUID = 1L;
  private SubtipoDeQuartoExecutivo tipo;

  /**
   * 
   * @param quantidadeDePessoas
   * @param tipo
   * @throws QuantidadeDePessoasInvalidaException
   * @throws QuartoEsgotadoNoHotelException
   */
  
  public QuartoExecutivo( int quantidadeDePessoas, SubtipoDeQuartoExecutivo tipo)
      throws QuantidadeDePessoasInvalidaException, QuartoEsgotadoNoHotelException {
    super(quantidadeDePessoas);
    
    if ( quantidadeDePessoas > 3 ) {
    	throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas nao pode ser maior que 3 neste tipo de quarto");
    }

    this.tipo = tipo;
    checaTipoDoQuarto();
  }

  /**
   * 
   * @return
   */
  
  public SubtipoDeQuartoExecutivo getTipo() {
    return tipo;
  }

  private void checaTipoDoQuarto() throws QuartoEsgotadoNoHotelException {
    if ( getTipo().name().equals("SIMPLES") ) {
      if ( Hotel.getQuartoExecutivoSimples() == 0 ) {
        throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
      }

      Hotel.setQuartoExecutivoSimples(Hotel.getQuartoExecutivoSimples() - 1);
    }

    if ( getTipo().name().equals("DUPLO") ) {
      if ( Hotel.getQuartoExecutivoDuplo() == 0 ) {
        throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
      }

      Hotel.setQuartoExecutivoDuplo(Hotel.getQuartoExecutivoDuplo() - 1);
    }

    if ( getTipo().name().equals("TRIPLO") ) {
      if ( Hotel.getQuartoExecutivoTriplo() == 0 ) {
        throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
      }

      Hotel.setQuartoExecutivoTriplo(Hotel.getQuartoExecutivoTriplo() - 1);
    }
  }
  
  /**
   * 
   */
  
  @Override
  public String toString() {
    return "QuartoExecutivo - Tipo = " + getTipo().name().toLowerCase()
    		+ ", Valor da diaria = " + tipo.getValorDiaria() + ", " + super.toString();
  }

  /**
   * 
   */
  
  @Override
  public boolean equals( Object obj ) {
    if ( !(obj instanceof SubtipoDeQuartoExecutivo) ) {
    	return false;
    }
    
    QuartoExecutivo q = (QuartoExecutivo) obj;
    
    return super.equals(q) && tipo.equals(q.getTipo());
  }
}