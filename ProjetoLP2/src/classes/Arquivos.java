package classes;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Arquivos {
	
	private final static String DIR = "hotel";

	//	static {
//		try {
//			new File(DIR).mkdir();
//			new File(DIR).mkdir();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
	public static void salvaHotel(Hotel hotel) throws Exception{
		File file = new File("hotel");
		ObjectOutputStream out = null;
		try {
			if ( file.canRead() == true ) {
				out = new ObjectOutputStream(new BufferedOutputStream(
					new FileOutputStream("hotel")));
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
	
	public static Hotel lerHotel() throws Exception {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new BufferedInputStream(
					new FileInputStream("hotel")));

			Hotel h = (Hotel) in.readObject();
			return h;
		} catch (EOFException e) {
		} finally {
			in.close();
		}
		return null;
	}
	
	public static boolean existeHotel() {
		File file = new File(DIR);
		return file.exists();
	}
}