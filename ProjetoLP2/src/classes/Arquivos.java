package classes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe que serve para salvar, ler e verificar se existe um arquivo salvo.
 * 
 * @author Fabio Alexandre Santos Silva Júnior
 *
 */

public class Arquivos {

  private final static String DESTINO = "hotel";

  /**
  * Metodo que salva um onjeto do tipo hotel.
  * 
  * @param hotel
  * @throws Exception
  */

  public static void salvaHotel(Hotel hotel) throws Exception {
    
    File file = new File(DESTINO);
    ObjectOutputStream output = null;
    
    try {
      if ( file.canRead() == true ) {
        output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(DESTINO)));
        output.writeObject(hotel);
      
      } else {
        file.createNewFile();
        output = new ObjectOutputStream(new FileOutputStream(file));
        output.writeObject(hotel);
      }
    } finally {
      output.close();
    }
  }

  /**
  * Metodo que ler um onjeto do tipo hotel.
  * 
  * @return Hotel - O HOtel lido.
  * @throws Exception
  */

  public static Hotel lerHotel() throws Exception {
    
    ObjectInputStream input = null;
    
    try {
      input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(DESTINO)));

      Hotel h = (Hotel) input.readObject();
      return h;
    } catch (EOFException e) {
      e.getMessage();
    } finally {
      input.close();
    }
    
    return null;
    
  }

  /**
  * Metodo que verifica se existe um hotel salvo.
  * 
  * @return
  */

  public static boolean existeHotel() {
    File file = new File(DESTINO);
    return file.exists();
  }
}