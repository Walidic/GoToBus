package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String fullName;
	@NotNull
	private String role;
	
	@ManyToMany
	@JoinTable(
		name="USERXTRIP",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns=@JoinColumn(name="trip_id"))
	private Set<Trip> trips;
	
	public User() {}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	public void setRole(String role) {
		this.role = role;
	}
	
	public int getId() {
		return Id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public String getRole() {
		return role;
	}
	
	public void addTrip(Trip trip) {
		trips.add(trip);
	}

}
