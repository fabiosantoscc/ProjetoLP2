package Executar;

import InterfaceGrafica.TelaLogin;
import classes.Arquivos;
import classes.Hotel;

public class Run {
	
	public static Hotel hotel;
	
	public static void main(String[] args) throws Exception {
		
		hotel = new Hotel("123");
		hotel = Arquivos.lerHotel();
		TelaLogin.main(args);
	}
}