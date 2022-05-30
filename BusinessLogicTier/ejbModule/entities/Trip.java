package entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Trip {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	@NotNull
	private String from_station;
	@NotNull
	private String to_station;
	private int availlable_seats;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private java.sql.Date departure_time;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private java.sql.Date arrival_time;
	public Trip() {}
	
	public void setFromStation(String fromStation) {
		from_station=fromStation;
	}
	
	public void setToStation(String toStation) {
		to_station=toStation;
	}
	public void setAvaillableSeats(int seats) {
		availlable_seats=seats;
	}
	public void setDepartureTime(java.sql.Date deptTime) {
		departure_time=(@NotNull Date) deptTime;
	}
	
	public void setArrivalTime(java.sql.Date arrivalTime) {
		arrival_time=(@NotNull Date) arrivalTime;
	}
	
	public String getFromStation() {
		return from_station;
	}
	public String getToStation() {
		return to_station;
	}
	public int getAvaillableSeats() {
		return availlable_seats;
	}
	public java.sql.Date getDeptTime() {
		return departure_time;
	}
	public java.sql.Date getArrivalTime() {
		return arrival_time;
	}
}
