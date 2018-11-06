package examen;

import java.text.ParseException;
import java.time.DateTimeException;
import java.util.Date;
import java.util.GregorianCalendar;

public class GPSValidator {
	private Date datetime2;
	private double latitude;
	private double longitude;
	private double altitude;
	private double speed;
	private double bearing;
	private double accuracy;
	private String provider;
	
	public GPSValidator(String[] data) throws ParseException, ProviderException {
		dateValidator(data[0]);
		latitudeValidator(data[1]);
		longitudeValidator(data[2]);
		altitudeValidator(data[3]);
		speedValidator(data[4]);
		bearingValidator(data[5]);
		accuracyValidator(data[6]);
		providerValidator(data[7]);
	}
	
	private void dateValidator(String datetime) throws ParseException, DateTimeException {
		String[] part1 = datetime.split(" ");
		if(part1.length != 2 ) {
			throw new DateTimeException("Error en la fecha u hora");
		}
		String[] inputdate = part1[0].split("/");
		if(inputdate.length != 3) {
			throw new DateTimeException("Error en la fecha u hora");
		}
		String[] inputtime = part1[1].split(":");
		if(inputtime.length != 3) {
			throw new DateTimeException("Error en la fecha u hora");
		}
		int year = Integer.parseInt(inputdate[0]);
		int month = Integer.parseInt(inputdate[1]);
		int day = Integer.parseInt(inputdate[2]);
		int hours = Integer.parseInt(inputtime[0]);
		int minutes = Integer.parseInt(inputtime[1]);
		int seconds = Integer.parseInt(inputtime[2]);
		
		if(year <= 2000 || 
			month < 0 ||
			month > 12 ||
			day < 0 ||
			day > 31 ||
			hours < 0 ||
			hours > 23 ||
			minutes <= 0 ||
			minutes > 59 ||
			seconds <= 0 ||
			seconds > 59 ) {
			
			throw new DateTimeException("Error en la fecha u hora");
			
		}
		
		GregorianCalendar actual = new GregorianCalendar();
		actual.setTime(new Date());
		GregorianCalendar date = new GregorianCalendar();
		date.set(year, month, day, hours, minutes, seconds);
		//System.out.println(actual.getTime());
		//System.out.println(date.getTime());
		assert date.compareTo(actual) == -1;
		this.datetime2 = date.getTime();
		//System.out.println("TERMINA VALIDACION DE DATETIME2");
	}
	private void latitudeValidator(String latitude) throws NumberFormatException {
		double lat = Double.parseDouble(latitude);
		assert lat <= 90.0 && lat >= -90.0;
		this.latitude = lat;
		//System.out.println("TERMINA VALIDACION DE LATITUDE");
	}
	private void longitudeValidator(String longitude) throws NumberFormatException {
		double longi = Double.parseDouble(longitude);
		assert longi <= 180.0 && longi >= -180.0;
		this.longitude = longi;
		//System.out.println("TERMINA VALIDACION DE LONGITUDE");
	}
	private void altitudeValidator(String altitude) throws NumberFormatException {
		double alt = Double.parseDouble(altitude);
		assert alt <= 6500.0 && alt >= -37.0;
		this.altitude = alt;
		//System.out.println("TERMINA VALIDACION DE ALTITUDE");
	}
	private void speedValidator(String speed) throws NumberFormatException {
		double sp = Double.parseDouble(speed);
		assert sp >= 0.0 && sp <= 180.0;
		this.speed = sp;
		//System.out.println("TERMINA VALIDACION DE SPEED");
	}
	private void bearingValidator(String bearing) throws NumberFormatException {
		double bea = Double.parseDouble(bearing);
		assert bea >= 0.0 && bea <= 359.999999999;
		this.bearing = bea;
		//System.out.println("TERMINA VALIDACION DE BEARING");
	}
	private void accuracyValidator(String accuracy) throws NumberFormatException {
		double acc = Double.parseDouble(accuracy);
		assert acc >= 0.0 && acc <= 15.0;
		this.bearing = acc;
		//System.out.println("TERMINA VALIDACION DE ACCURACY");
	}
	private void providerValidator(String provider) throws ProviderException {
		assert provider != null;
		if("gps".equals(provider)) {
			this.provider = provider;
			//System.out.println("TERMINA VALIDACION DE PROVIDER");
		} else {
			throw new ProviderException("Error en Provider");
		}
	}

	public Date getDatetime2() {
		return datetime2;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getAltitude() {
		return altitude;
	}

	public double getSpeed() {
		return speed;
	}

	public double getBearing() {
		return bearing;
	}

	public double getAccuracy() {
		return accuracy;
	}

	public String getProvider() {
		return provider;
	}
	
	
}
