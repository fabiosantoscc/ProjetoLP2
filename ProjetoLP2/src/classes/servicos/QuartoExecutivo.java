package classes.servicos;

import classes.Hotel;

import enums.SubtipoDeQuartoExecutivo;
import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;

import java.io.Serializable;

/**
 * Classe que representa um quarto executivo.
 * 
 * @author Fabio Alexandre
 * @since 02/03/2015
 */

public class QuartoExecutivo extends Quarto implements Serializable {

  private static final long serialVersionUID = 1L;
  private SubtipoDeQuartoExecutivo tipo;

  /**
   * Construtor de um Quarto Executivo.
   * 
   * @param quantidadeDePessoas - Quantidade de pessoas no quarto.
   * @param tipo - Tipo do quarto.
   * @throws QuantidadeDePessoasInvalidaException - Pode lancar excecao
   *         Quantidade de pessoas invalida.
   *         
   * @throws QuartoEsgotadoNoHotelException - Pode lancar excecao de quarto esgotado.
   */
  
  public QuartoExecutivo( int quantidadeDePessoas, SubtipoDeQuartoExecutivo tipo)
      throws QuantidadeDePessoasInvalidaException, QuartoEsgotadoNoHotelException {
    super(quantidadeDePessoas);
    
    if ( quantidadeDePessoas > 3 ) {
      throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas nao pode ser "
            + "maior que 3 neste tipo de quarto");
    }

    this.tipo = tipo;
    checaTipoDoQuarto();
  }

  /**
   * Recupera o tipo do Quarto.
   * 
   * @return SubtipoDeQuartoExecutivo - Tipo do quarto. 
   */
  
  public SubtipoDeQuartoExecutivo getTipo() {
    return tipo;
  }

  private void checaTipoDoQuarto() throws QuartoEsgotadoNoHotelException {
    if ( getTipo().name().equals("SIMPLES") ) {
      if ( Hotel.getQuartoExecutivoSimples() == 0 ) {
        throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
      }
      int cont = Hotel.getMapaDeQuartos().get("Quarto Executivo Simples");
      Hotel.getMapaDeQuartos().put("Quarto Executivo Simples", cont++);
      Hotel.setQuartoExecutivoSimples(Hotel.getQuartoExecutivoSimples() - 1);
    }

    if ( getTipo().name().equals("DUPLO") ) {
      if ( Hotel.getQuartoExecutivoDuplo() == 0 ) {
        throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
      }
      int cont = Hotel.getMapaDeQuartos().get("Quarto Executivo Duplo");
      Hotel.getMapaDeQuartos().put("Quarto Executivo Duplo", cont++);
      Hotel.setQuartoExecutivoDuplo(Hotel.getQuartoExecutivoDuplo() - 1);
    }

    if ( getTipo().name().equals("TRIPLO") ) {
      if ( Hotel.getQuartoExecutivoTriplo() == 0 ) {
        throw new QuartoEsgotadoNoHotelException("Nao ha mais quartos livres");
      }
      int cont = Hotel.getMapaDeQuartos().get("Quarto Executivo Triplo");
      Hotel.getMapaDeQuartos().put("Quarto Executivo Triplo", cont++);
      Hotel.setQuartoExecutivoTriplo(Hotel.getQuartoExecutivoTriplo() - 1);
    }
  }
  
  /**
   * Metodo que atribui uma quantidade de pessoas do quarto,
   * ele sobrescreve o metodo da sua super classe porque,
   * outros quartos podem ter quantidade de pessoas maximas
   * diferentes.
   *
   * @param pessoas - Quantidade de pessoas a modificar.
   */
  
  @Override
  public void setQuantidadeDePessoas(int pessoas) throws QuantidadeDePessoasInvalidaException {
    if ( pessoas > 3 ) {
      throw new QuantidadeDePessoasInvalidaException("Quantidade de pessoas invalida.");
    }
    super.setQuantidadeDePessoas(pessoas);
  }
  
  /**
   * Representa um quarto executivo como string.
   * 
   * @return String - Representacao do quarto.
   * 
   */
  
  @Override
  public String toString() {
    return "QuartoExecutivo - Tipo = " + getTipo().name().toLowerCase()
    		+ ", Valor da diaria = " + tipo.getValorDiaria() + ", " + super.toString();
  }

  /**
   * Compara se dois quartos executivos sao iguais.
   * 
   * @return boolean - True se os quartos forem iguais.
   *                   false, caso contratio.
   */
  
  @Override
  public boolean equals( Object obj ) {
    if ( !(obj instanceof SubtipoDeQuartoExecutivo) ) {
      return false;
    }
    
    QuartoExecutivo quartoExe = (QuartoExecutivo) obj;
    
    return super.equals(quartoExe) && tipo.equals(quartoExe.getTipo());
  }
}