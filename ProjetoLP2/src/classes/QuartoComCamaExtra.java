//package classes;
//
//import excecoes.CamaExtraEsgotadaException;
//import excecoes.QuantidadeDePessoasInvalidaException;
//
//public class QuartoComCamaExtra extends Quarto {
//	public CalendarioDeEstrategias calendario;
//	public EstrategiaDeCalculoDaMontante estrategia;
//	public double despesaTotal;
//	public double valorDiaria;
//	private int camaExtra;
//    private static final long serialVersionUID = 1L;
//  
// 
//  public QuartoComCamaExtra(int quantidadeDePessoas, int camaExtra) throws CamaExtraEsgotadaException, QuantidadeDePessoasInvalidaException {
//	  super(quantidadeDePessoas);
//	  verificaCamaExtra(camaExtra);
//	  this.camaExtra = camaExtra;
//      Hotel.setCamaExtra(Hotel.getCamaExtra() - this.camaExtra);
//  }
//  
//	private void verificaCamaExtra(int camaExtra) throws CamaExtraEsgotadaException {
//		if ( camaExtra < 0 || camaExtra > Hotel.getCamaExtra()) {
//			throw new CamaExtraEsgotadaException("Quantidade de camas extras invalida");
//		}
//	}
//  
//	/**
//	 * @return - A quantidade de camas extras do quarto.
//	 */
//	
//	public int getCamaExtra() {
//		return camaExtra;
//	}
//	
//	/**
//	 * 
//	 * @param cama
//	 * @throws CamaExtraEsgotadaException 
//	 */
//	
//	public void setCamaExtra( int cama) throws CamaExtraEsgotadaException {
//		verificaCamaExtra(cama);
//		Hotel.setCamaExtra(Hotel.getCamaExtra() + camaExtra);
//		Hotel.setCamaExtra(Hotel.getCamaExtra() - cama);
//		this.camaExtra = cama;
//	}
//	
//  @Override
//  public void calculaDespesaTotal(int diaEntrada, int mesEntrada, int diaSaida, int mesSaida, int anoEntrada,
//			int anoSaida)throws Exception{
//		if (!calendario.verificaDataValida(diaEntrada, mesEntrada)) throw new Exception ("O mes e o dia tem que ser valido.");
//		if (!calendario.verificaDataValida(diaSaida, mesSaida)) throw new Exception ("O mes e o dia tem que ser valido.");
//		boolean dataValida = true;
//		while (dataValida){
//			if (diaEntrada > diaSaida && mesEntrada == mesSaida && anoEntrada == anoSaida) break;
//			if (!(calendario.verificaDataValida(diaEntrada, mesEntrada))){
//				diaEntrada = 1;
//				if (mesEntrada == 12){
//					anoEntrada++;
//					mesEntrada = 1;
//				}
//				else mesEntrada++;
//			}
//			estrategia = calendario.verificaEstrategia(diaEntrada, mesEntrada);
//			despesaTotal += estrategia.calculaMontante(valorDiaria);
//			despesaTotal += estrategia.calculaMontante(camaExtra*40.0);
//			System.out.println(despesaTotal);
//			diaEntrada++;
//		}
//	}
//} 