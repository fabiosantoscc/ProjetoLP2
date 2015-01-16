package classes;

/**
 * Classe que representa um restaurante
 * 
 * @author Ronan Souza
 * Ultima atualizacao 14/01/2015 / Fabio Alexandre
 */

public class Restaurante implements Servicos {
	
	private double consumoGeral, consumoUnidade1, consumoUnidade2;
	private int quantUsoUnidade1, quantUsoUnidade2;
	

	public  double getConsumoUnidade1(){
		return consumoUnidade1;
	}

	public double getConsumoUnidade2() {
		return consumoUnidade2;
	}
	
	public void AdicionaNovoConsumo(String unidade, double valor) throws Exception{
		if (valor <= 0){
			throw new Exception("Valor inválido!!");
		}
		if (!((unidade.equals("Térreo")) || unidade.equals("Cobertura"))){
			throw new Exception("Unidade do restaurante inválida!!");
		}
		consumoGeral += valor;
		if (unidade.equals("Térreo")){
			quantUsoUnidade1++;
			consumoUnidade1 += valor;
		}else if(unidade.equals("Cobertura")){
			quantUsoUnidade2++;
			consumoUnidade2 += valor;
		}
		
		/*switch (unidade) {
		case "Térreo":
			quantUsoUnidade1++;
			consumoUnidade1 += valor;
			break;
		case "Cobertura":
			quantUsoUnidade2++;
			consumoUnidade2 += valor;
			break;
		}*/
		
	}
	@Override
	public double getPreco() {
		return consumoGeral;
	}
	
	@Override
	public String toString() {
		return "Restaurante:"
				+ "\nUnidade 1 (Térreo)"
				+ "     \n Quantidade de usos: "+quantUsoUnidade1
				+ "     \n Valor consumido: "+ consumoUnidade1
				+ "\nUnidade 2 (Cobertura)"
				+ "     \n Quantidade de usos: "+quantUsoUnidade2
				+ "     \n Valor consumido: "+ consumoUnidade2
				+ "\n\nValor total: "+consumoGeral;
	}
	
	@Override
	public boolean equals( Object obj ) {
		if (! (obj instanceof Restaurante)){
			return false;
		}
		Restaurante novo = (Restaurante) obj;
		
		if (novo.getConsumoUnidade1() == consumoUnidade1 &&
				novo.getConsumoUnidade2() == consumoUnidade2 && novo.getPreco() == consumoGeral){
			return true;
		}
		return false;
	}
}
