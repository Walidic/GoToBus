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
public class Notification implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@NotNull
	private String message;
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Date notificationDateTime;
	
	public Notification() {}
	
	public void setId(int Id) {
		this.Id = Id;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setNotificationDateTime(Date notificationDateTime) {
		this.notificationDateTime = notificationDateTime;
	}
	
	public int getId() {
		return Id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public Date getNotificationDateTime() {
		return notificationDateTime;
	}
}
