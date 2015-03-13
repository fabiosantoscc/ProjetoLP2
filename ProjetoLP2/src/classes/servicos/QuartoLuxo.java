package classes.servicos;

import classes.Hotel;
import enums.SubtipoDeQuartoLuxo;
import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;

/**
 * Classe que representa um quarto de luxo.
 * 
 * @author Fabio Alexandre.
 *
 */

public class QuartoLuxo extends Quarto {

  private static final long serialVersionUID = 1L;
  private SubtipoDeQuartoLuxo tipo;

  /**
  * Construto de um quarto de luxo.
  * 
  * @param quantidadeDePessoas - Quantidade de pessoas.
  * @param tipo - tipo do quarto.
  * @throws QuantidadeDePessoasInvalidaException - Quantidade de pessoas
  *                                                invalida.
  * @throws QuartoEsgotadoNoHotelException - Quartos esgotados.
  */
  
  public QuartoLuxo(int quantidadeDePessoas, SubtipoDeQuartoLuxo tipo)
      throws QuantidadeDePessoasInvalidaException, QuartoEsgotadoNoHotelException {
    super(quantidadeDePessoas);

    if ( quantidadeDePessoas > 3 ) {
      throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas"
          + "nao pode ser maior que 3 neste tipo de quarto.");
    }

    this.tipo = tipo;
    checaTipoDoQuarto();
  }
  
  /**
  * Recupera o tipo do quarto.
  * 
  * @return SubtipoDeQuartoLuxo - tipo do quarto.
  */
  
  public SubtipoDeQuartoLuxo getTipo() {
    return tipo;
  }

  private void checaTipoDoQuarto() throws QuartoEsgotadoNoHotelException {
    if ( getTipo().name().equals("SIMPLES") ) {
      if ( Hotel.getQuartoLuxoSimples() == 0 ) {
        throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
      }
      int cont = Hotel.getMapaDeQuartos().get("Quarto Luxo Simples");
      Hotel.getMapaDeQuartos().put("Quarto Luxo Simples", cont++);
      Hotel.setQuartoLuxoSimples(Hotel.getQuartoLuxoSimples() - 1);
    }

    if ( getTipo().name().equals("DUPLO") ) {
      if ( Hotel.getQuartoLuxoDuplo() == 0 ) {
        throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
      }
      
      int cont = Hotel.getMapaDeQuartos().get("Quarto Luxo Duplo");
      Hotel.getMapaDeQuartos().put("Quarto Luxo Duplo", cont++);
      Hotel.setQuartoLuxoDuplo(Hotel.getQuartoLuxoDuplo() - 1);
    }

    if ( getTipo().name().equals("TRIPLO") ) {
      if ( Hotel.getQuartoLuxoTriplo() == 0 ) {
        throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
      }
      int cont = Hotel.getMapaDeQuartos().get("Quarto Luxo Triplo");
      Hotel.getMapaDeQuartos().put("Quarto Luxo Triplo", cont++);
      Hotel.setQuartoLuxoTriplo(Hotel.getQuartoLuxoTriplo() - 1);
    }
  }

  @Override
  public void setQuantidadeDePessoas(int pessoas) throws QuantidadeDePessoasInvalidaException {
    if ( pessoas > 3 ) {
      throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas invalida.");
    }
    super.setQuantidadeDePessoas(pessoas);
  }
  
  /**
  * Representacao do Quarto em string.
  * 
  * @return String - Representacao do quarto.
  */
 
  @Override
  public String toString() {
    return "QuartoLuxo - Tipo = " + getTipo().name().toLowerCase()
        + ", Valor da diaria = R$ " + tipo.getValorDiaria()
        + ", " + super.toString();
  }

  /**
  * Metodo que compara dois quartos de luxo.
  * 
  * @return boolean - Se os quartos sao iguais ou nao.
  */
  
  @Override
  public boolean equals( Object obj ) {
    if ( !(obj instanceof SubtipoDeQuartoLuxo) ) {
      return false;
    }
    
    QuartoLuxo quarto = (QuartoLuxo) obj;
    
    return super.equals(quarto) && tipo.equals(quarto.getTipo());
  }
}
