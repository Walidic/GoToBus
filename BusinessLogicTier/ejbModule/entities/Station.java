package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Station {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	@NotNull
	private String stationName;
	@NotNull
	private String longitude;
	@NotNull
	private String latitude;
	
	public Station() {}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public int getId() {
		return Id;
	}
	
	public String getStationName() {
		return stationName;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}
}
