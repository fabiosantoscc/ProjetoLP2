import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.Days;

public class Test {

 public static void main(String[] args) {
	 Calendar data1 = Calendar.getInstance();
	 data1.set(Calendar.DAY_OF_MONTH, 15);
	 System.out.println(data1.get(Calendar.DAY_OF_MONTH)+ "/" + data1.get(Calendar.MONTH) + "/" + data1.get(Calendar.YEAR));
	 
	 Calendar data2 = Calendar.getInstance();
	 System.out.println(data2.get(Calendar.DAY_OF_MONTH)+ "/" + data2.get(Calendar.MONTH) + "/" + data2.get(Calendar.YEAR));
	 
	 DateTime data = new DateTime(data1);
	 DateTime dat = new DateTime(data2);
	 
	 int numeroDeNoites = 2;
	 int dias = Days.daysBetween(dat, data).getDays() + 1;
	 int diasMulta = dias - numeroDeNoites + 1;
	 System.out.println(dias);
 }
}