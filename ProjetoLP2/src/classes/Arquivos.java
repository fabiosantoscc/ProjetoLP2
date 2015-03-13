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
 */

public class Arquivos {

  // Destino do hotel salvo no projeto
  private final static String DESTINO = "hotel";
  // Caracter de fim de linha.
  public static final String FIM_LINHA = System.getProperty("line.separator");

  /**
  * Metodo que salva um objeto do tipo hotel.
  * 
  * @param hotel - Hotel a ser salvo.
  * @throws Exception - pode lançar exceção de arquivo inexistente.
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
  * Metodo que ler um objeto do tipo hotel.
  * 
  * @return Hotel - O Hotel lido.
  * @throws Exception - Pode lancar excecao se o hotel nao existir.
  */

  public static Hotel lerHotel() throws Exception {
    
    ObjectInputStream input = null;
    
    try {
      input = new ObjectInputStream(new BufferedInputStream(new FileInputStream(DESTINO)));

      Hotel hotel = (Hotel) input.readObject();
      return hotel;
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
  * @return boolean - Se o hotel existe ou nao.
  */

  public static boolean existeHotel() {
    File file = new File(DESTINO);
    return file.exists();
  }
}