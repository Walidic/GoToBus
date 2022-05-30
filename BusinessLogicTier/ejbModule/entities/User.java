package entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	@NotNull	
	@Size(min = 5, max = 25)
	private String username;
	@NotNull
	@Size(min = 8, max = 255)
	private String password;
	@NotNull
	@Size(min = 5, max = 50)
	private String fullName;
	@NotNull
	@Size(min = 5, max = 6)
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
	
	public String getFullname() {
		return fullName;
	}
	
	public String getRole() {
		return role;
	}
}
