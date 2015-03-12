package classes.servicos;

public enum SubtipoDeQuartoLuxo {

  SIMPLES(520), DUPLO(570), TRIPLO(620);

  private double valorDiaria;

  SubtipoDeQuartoLuxo( double valorDiaria ) {
    this.valorDiaria = valorDiaria;
  }

  public double getValorDiaria() {
    return valorDiaria;
  }
}