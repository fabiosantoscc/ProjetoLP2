package InterfaceGrafica;

import classes.Endereco;
import classes.Hospede;
import classes.Hotel;
import classes.Telefone;
import excecoes.InputArgumentInvalidException;

public class Run {
	public static Hotel hotel;
	public static Telefone tel = null;
	public static Endereco end = null;
	public static Hospede h = null;
	
	
	public static void main(String[] args) throws Exception {
		hotel = new Hotel();
		TelaLogin.main(args);
		
		String t = "5";
		int f = Integer.parseInt(t);
		System.out.println(f);
		
		tel = new Telefone("83","33811111");
		end = new Endereco("a", "b", "c", "123", 
		"", "a", "a", "12345678");
		h = new Hospede("Ronan", "48058960942","4539361222510693", "aaaa@aa.com", tel, end);
		hotel.addHospede(h);
		
	}
}
