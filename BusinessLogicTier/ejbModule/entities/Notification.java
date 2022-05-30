package entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Notification{
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int Id;
	@NotNull
	private String message;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private java.sql.Date notification_datetime;
	public void setMessage(String msg) {
		message=msg;
	}
	public void setNotificationDate(java.sql.Date dateTime) {
		notification_datetime=(@NotNull Date) dateTime;
	}
	public String getMsg() {
		return message;
	}
	public  java.sql.Date getTime() {
		return notification_datetime;
	}
	
}