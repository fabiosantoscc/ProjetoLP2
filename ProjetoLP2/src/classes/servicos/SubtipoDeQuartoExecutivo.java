package classes.servicos;

public enum SubtipoDeQuartoExecutivo {

  SIMPLES(360), DUPLO(385), TRIPLO(440);

  private double valorDiaria;

  SubtipoDeQuartoExecutivo( double valorDiaria ) {
    this.valorDiaria = valorDiaria;
  }

  public double getValorDiaria() {
    return valorDiaria;
  }
}