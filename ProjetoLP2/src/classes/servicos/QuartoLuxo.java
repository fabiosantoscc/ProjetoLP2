package classes.servicos;

import classes.Hotel;
import enums.SubtipoDeQuartoLuxo;
import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;

public class QuartoLuxo extends Quarto {

  private static final long serialVersionUID = 1L;
  private SubtipoDeQuartoLuxo tipo;

  public QuartoLuxo(int quantidadeDePessoas, SubtipoDeQuartoLuxo tipo)
      throws QuantidadeDePessoasInvalidaException, QuartoEsgotadoNoHotelException {
    super(quantidadeDePessoas);
    checaTipoDoQuarto();

    if ( quantidadeDePessoas > 3 ) {
      throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas nao pode ser maior que 3 neste tipo de quarto.");
    }

    this.tipo = tipo;
  }

  public SubtipoDeQuartoLuxo getTipo() {
    return tipo;
  }

  private void checaTipoDoQuarto() throws QuartoEsgotadoNoHotelException {
    if ( getTipo().name().equals("SIMPLES") ) {
      if ( Hotel.getQuartoLuxoSimples() == 0 ) {
        throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
      }

	  Hotel.setQuartoLuxoSimples(Hotel.getQuartoLuxoSimples() - 1);
    }

    if ( getTipo().name().equals("DUPLO") ) {
      if ( Hotel.getQuartoLuxoDuplo() == 0 ) {
        throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
      }

      Hotel.setQuartoLuxoDuplo(Hotel.getQuartoLuxoDuplo() - 1);
    }

    if ( getTipo().name().equals("TRIPLO") ) {
      if ( Hotel.getQuartoLuxoTriplo() == 0 ) {
        throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
      }

      Hotel.setQuartoLuxoTriplo(Hotel.getQuartoLuxoTriplo() - 1);
    }
  }
  
  @Override
  public String toString() {
    return "QuartoLuxo - Tipo = " + getTipo().name().toLowerCase()
	      + ", Valor da diaria = R$ " + tipo.getValorDiaria() + ", " + super.toString();
  }

  @Override
  public boolean equals( Object obj ) {
    if ( !(obj instanceof SubtipoDeQuartoLuxo) ) {
    	return false;
    }
    
    QuartoLuxo q = (QuartoLuxo) obj;
    
    return super.equals(q) && tipo.equals(q.getTipo());
  }
}
