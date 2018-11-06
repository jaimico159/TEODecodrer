package examen;

import java.util.Date;
import java.util.Scanner;

public class BD {
	private GPSMessage[] GPSMESSAGES;
	int index;
	boolean connected;
	
	public BD() {
		this.GPSMESSAGES = new GPSMessage[1000];
		this.index = 0;
		this.connected = false;
	}
	
	public boolean save(GPSValidator message) {
		try {
			if(this.connected) {
				GPSMESSAGES[index] = new GPSMessage();
				GPSMESSAGES[index].setId(index);
				GPSMESSAGES[index].setDatetime(message.getDatetime2());
				GPSMESSAGES[index].setLatitude(message.getLatitude());
				GPSMESSAGES[index].setLongitude(message.getLongitude());
				GPSMESSAGES[index].setAltitude(message.getAltitude());
				GPSMESSAGES[index].setSpeed(message.getSpeed());
				GPSMESSAGES[index].setBearing(message.getBearing());
				GPSMESSAGES[index].setAccuracy(message.getAccuracy());
				GPSMESSAGES[index].setProvider(message.getProvider());
				GPSMESSAGES[index].setTimestamp(new Date());
				this.index++;
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			System.out.println("Hubo un error"+e.getMessage());
			return false;
		}
	}
	public GPSMessage get(int index) {
		if(this.connected) {
			return this.GPSMESSAGES[index];
		}
		return null;
	}
	public boolean connect() {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()) {
			System.out.println("INGRESE USER");
			String user = sc.nextLine();
			System.out.println("INGRESE PASSWORD");
			String pass = sc.nextLine();
			if("admin".equals(user) && "admin".equals(pass)) {
				System.out.println("CONEXION ESTABLECIDA");
				this.connected = true;
				return true;
			}
			else {
				System.out.println("INTENTE OTRA VEZ");
			}
		}
		return false;
		
	}
	public boolean disconnect() {
		this.connected = false;
		return true;
	}
}
