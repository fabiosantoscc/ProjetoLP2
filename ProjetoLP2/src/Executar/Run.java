package Executar;

import javax.swing.JOptionPane;

import InterfaceGrafica.TelaLogin;
import classes.Arquivos;
import classes.Hotel;

public class Run {
	
  public static Hotel hotel;

  public static void main(String[] args) {
	  try {
		  hotel = new Hotel("123");
		  hotel = Arquivos.lerHotel();
		  TelaLogin.main(args);
	  } catch ( Exception e ) {
		  JOptionPane.showMessageDialog(null, e.getMessage());
	  }
  }
}