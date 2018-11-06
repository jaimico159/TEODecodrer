package examen;

import java.text.ParseException;
import java.time.DateTimeException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		InputValidator validator = new InputValidator();
		BD database = new BD();
		database.connect();
		System.out.println("CONETANDO");
		Scanner sc = new Scanner(System.in);
		//System.out.println("ABRIENDO SUSTEM");
		GPSValidator gpsval;
		while(sc.hasNextLine()) {
			//System.out.println("ENTRADO EN LOOP");
			try {
				String line = sc.nextLine();
				validator.validate(line);
				gpsval = new GPSValidator(validator.getData());
				if(database.save(gpsval)) {
					System.out.println("Guardado satisfactoriamente");
				}
				else {
					System.out.println("Hubo un problema");
				}
			}
			catch(ParseException par) {
				System.out.println(par.getMessage());
			}
			catch(ProviderException pro) {
				System.out.println(pro.getMessage());
			}
			catch(ArrayIndexOutOfBoundsException bounds) {
				System.out.println("Mala entrada de datos, intente otra vez: ");
			}
			catch(NumberFormatException num) {
				System.out.println("Hubo un error en el formato de un número del dato");
			}
			catch(DateTimeException da) {
				System.out.println(da.getMessage());
			}
			catch(Exception e) {
				System.out.println("Hubo un problema, intente otra vez: ");
			}
		}
		database.disconnect();
		sc.close();
	}
}