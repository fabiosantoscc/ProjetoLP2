package InterfaceGrafica;

import classes.Hotel;

public class Run {
	public static Hotel hotel;
	
	public static void main(String[] args) {
		hotel = new Hotel();
		TelaLogin tela  = new TelaLogin();
		tela.main(args);
			
	}

}
