package entities;


import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_Id;
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String fullName;
	@NotNull
	private String role;
	
	//private boolean logged_in = false;
	
	@ManyToMany
	@JoinTable(
		name="USERXTRIP",
		joinColumns=@JoinColumn(name="user_id"),
		inverseJoinColumns=@JoinColumn(name="trip_id"))
	private Set<Trip> trips;
	
	@OneToMany(mappedBy="user")
	private Set<Notification> notifications;
	
	public User() {}
	
	public void setId(int Id) {
		this.user_Id = Id;
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
	
	public void addTrip(Trip trip) {
		trips.add(trip);
	}
	
	public void addNotification(Notification notification) {
		notifications.add(notification);
		System.out.println(notification);
	}
	
	public int getId() {
		return user_Id;
	}
	public Set<Trip> getTrips(){
		return trips;
	}
	
	public Set<Notification> getNotifications(){
		return notifications;
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

	//public boolean isLogged_in() {
	//	return logged_in;
	//}

	//public void setLogged_in(boolean logged_in) {
	//	this.logged_in = logged_in;
	//}

}
