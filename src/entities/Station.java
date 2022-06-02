package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Station implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@NotNull
	private String name;
	@NotNull
	private String longitude;
	@NotNull
	private String latitude;
	
	public Station() {}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public void setName(String name) {
		this.name = name;
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
	
	public String getName() {
		return name;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public String getLatitude() {
		return latitude;
	}
}
