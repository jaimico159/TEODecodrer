package examen;

import java.text.DecimalFormat;
import java.util.Date;

public class GPSMessage {
	
	private int id;
	private Date datetime;
	private String latitude;
	private String longitude;
	private String altitude;
	private String speed;
	private String bearing;
	private String accuracy;
	private String provider;
	private Date created_at;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		DecimalFormat format = new DecimalFormat("00.000000");
		this.latitude = format.format(latitude);
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		DecimalFormat format = new DecimalFormat("000.000000");
		this.longitude = format.format(longitude);
	}
	public String getAltitude() {
		return altitude;
	}
	public void setAltitude(double altitude) {
		DecimalFormat format = new DecimalFormat("0000.00");
		this.altitude = format.format(altitude);
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		DecimalFormat format = new DecimalFormat("000.00");
		this.speed = format.format(speed);
	}
	public String getBearing() {
		return bearing;
	}
	public void setBearing(double bearing) {
		DecimalFormat format = new DecimalFormat("000.00");
		this.bearing = format.format(bearing);
	}
	public String getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(double accuracy) {
		DecimalFormat format = new DecimalFormat("00.00");
		this.accuracy = format.format(accuracy);
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public Date getTimestamp() {
		return created_at;
	}
	public void setTimestamp(Date created_at) {
		this.created_at = created_at;
	}
}
