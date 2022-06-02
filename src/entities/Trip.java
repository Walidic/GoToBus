package entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


@Entity
public class Trip implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@NotNull
	private Station fromStation;
	@NotNull
	private Station toStation;
	@NotNull
	private int availableSeats;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date arrivalTime;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date departureTime;
	
	public Trip() {}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public void setFromStation(Station fromStation) {
		this.fromStation = fromStation;
	}
	
	public void setToStation(Station toStation) {
		this.toStation = toStation;
	}
	
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	
	public int getId() {
		return Id;
	}
	
	public Station getFromStation() {
		return fromStation;
	}
	
	public Station getToStation() {
		return toStation;
	}
	
	public int getAvailableSeats() {
		return availableSeats;
	}
	
	public Date getArrivalTime() {
		return arrivalTime;
	}
	
	public Date getDepartureTime() {
		return departureTime;
	}
}
