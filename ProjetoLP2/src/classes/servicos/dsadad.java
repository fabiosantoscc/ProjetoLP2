package classes.servicos;

import java.util.ArrayList;
import java.util.List;

import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;

public class dsadad {

	public static void main(String[] args) throws QuantidadeDePessoasInvalidaException, QuartoEsgotadoNoHotelException {
		List<Quarto> q = new ArrayList<Quarto>();
		Quarto c = new QuartoPresidencial(2);
		q.add(c);
		System.out.println(q.size());
		q.remove(c);
		System.out.println(q.size());
	}
}