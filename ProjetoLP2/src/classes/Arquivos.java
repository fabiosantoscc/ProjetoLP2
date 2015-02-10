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
	
	private final static String DIR = "hotel";

	/**
	 * Metodo que salva um onjeto do tipo hotel.
	 * 
	 * @param hotel
	 * @throws Exception
	 */
	
	public static void salvaHotel(Hotel hotel) throws Exception {
		File file = new File(DIR);
		ObjectOutputStream out = null;
		try {
			if ( file.canRead() == true ) {
				out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream(DIR)));
				 out.writeObject(hotel);
			}  else {
				file.createNewFile();
				out = new ObjectOutputStream(new FileOutputStream(file));
				out.writeObject(hotel);
			}
		} finally {
        out.close();
        }
	}
	
	/**
	 * Metodo que ler um onjeto do tipo hotel.
	 * 
	 * @return Hotel - O HOtel lido.
	 * @throws Exception
	 */
	
	public static Hotel lerHotel() throws Exception {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream(DIR)));

			Hotel h = (Hotel) in.readObject();
			return h;
		} catch (EOFException e) {
		} finally {
			in.close();
		}
		return null;
	}
	
	/**
	 * Metodo que verifica se existe um hotel salvo.
	 * 
	 * @return
	 */
	
	public static boolean existeHotel() {
		File file = new File(DIR);
		return file.exists();
	}
}