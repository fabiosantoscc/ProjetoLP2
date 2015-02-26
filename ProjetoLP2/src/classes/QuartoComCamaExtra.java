package classes;

public class QuartoComCamaExtra extends Quarto {
	public CalendarioDeEstrategias calendario;
	public EstrategiaDeCalculoDaMontante estrategia;
	public double despesaTotal;
	public double valorDiaria;
	private int camaExtra;
    private static final long serialVersionUID = 1L;
  
 
  public QuartoComCamaExtra(int quantidadeDePessoas, int camaExtra) {
	  super(quantidadeDePessoas);
	  this.camaExtra = camaExtra;
  }
  
  @Override
  public int calculaDespesaTotal(int diaEntrada, int mesEntrada, int diaSaida, int mesSaida, int anoEntrada,
			int anoSaida)throws Exception{
		if (!calendario.verificaDataValida(diaEntrada, mesEntrada)) throw new Exception ("O mes e o dia tem que ser valido.");
		if (!calendario.verificaDataValida(diaSaida, mesSaida)) throw new Exception ("O mes e o dia tem que ser valido.");
		boolean dataValida = true;
		int contador = 0;
		while (dataValida){
			if (diaEntrada > diaSaida && mesEntrada == mesSaida && anoEntrada == anoSaida) break;
			if (!(calendario.verificaDataValida(diaEntrada, mesEntrada))){
				diaEntrada = 1;
				if (mesEntrada == 12){
					anoEntrada++;
					mesEntrada = 1;
				}
				else mesEntrada++;
			}
			contador++;
			estrategia = calendario.verificaEstrategia(diaEntrada, mesEntrada);
			despesaTotal += estrategia.calculaMontante(valorDiaria);
			despesaTotal += estrategia.calculaMontante(camaExtra*40.0);
			System.out.println(despesaTotal);
			diaEntrada++;
		}
		return contador; 
	}
} 