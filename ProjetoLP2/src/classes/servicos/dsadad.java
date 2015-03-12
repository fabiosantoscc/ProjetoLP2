package classes.servicos;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.Days;

import excecoes.QuantidadeDePessoasInvalidaException;
import excecoes.QuartoEsgotadoNoHotelException;

public class dsadad {

	public static void main(String[] args) throws QuantidadeDePessoasInvalidaException, QuartoEsgotadoNoHotelException {
//		List<Quarto> q = new ArrayList<Quarto>();
//		Quarto c = new QuartoPresidencial(2);
//		q.add(c);
//		System.out.println(q.size());
//		q.remove(c);
//		System.out.println(q.size());
		Calendar e = Calendar.getInstance();
		Calendar e2 = Calendar.getInstance();
		e2.set(Calendar.DAY_OF_MONTH, 15);
		DateTime dataInicial1 = new DateTime(e);
		DateTime dataFinal1 = new DateTime(e2);
		
		int s = Days.daysBetween(dataInicial1, dataFinal1).getDays();

		System.out.println(s);
	}
}