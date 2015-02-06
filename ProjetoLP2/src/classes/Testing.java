package classes;

import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoException;

public class Testing {

	public static void main(String[] args) throws Exception {
		Hotel h = new Hotel();
		Quarto n = new QuartoPresidencial(1);
		Quarto q = new QuartoExecutivoDuplo(2, 0);
		System.out.println(h.getQuartoPresidencial());
		System.out.println(h.getQuartoExecutivoDuplo());

	}

}
