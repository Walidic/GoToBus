package entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class User implements Serializable{
	/**
	 * 
	 */
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

}
