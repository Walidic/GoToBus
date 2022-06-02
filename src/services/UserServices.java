package services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Booking;
import entities.Notification;
import entities.Trip;
import entities.User;
@Stateful
public class UserServices {
	
	@PersistenceContext(unitName = "gotobus")
	private EntityManager entityManager;
	public void createUser(User user) {
		entityManager.persist(user);
	}
	
	public boolean login(String username, String password) {
		List<User> result;
		TypedQuery<User> query = entityManager.createQuery("Select c from User C", User.class);
		result = query.getResultList();
		for(User user:result) {
			if(user.getUsername().equals(username)) {
				if(user.getPassword().equals(password)) {
					//user.setLogged_in(true);
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean bookSeat(int userId, int tripId) {
		List<User> userResult;
		TypedQuery<User> query = entityManager.createQuery("Select c from User C", User.class);
		userResult = query.getResultList();
		User bookingUser = null;
		for(User user:userResult) {
			if(userId==user.getId()) {
				bookingUser = user;
			}
		}
		List<Trip> result;
		TypedQuery<Trip> tripQuery = entityManager.createQuery("select c from Trip C", Trip.class);
		result = tripQuery.getResultList();
		Trip bookingTrip = null;
		for(Trip trip:result) {
			if(tripId==trip.getId()) {
				bookingTrip = trip;
			}
		}
		if ((bookingUser==null) || (bookingTrip==null)) {
			return false;
		}
		
		//if(!bookingUser.isLogged_in()) {
			//return false;
		//}
		
		if(!bookingTrip.addUser(bookingUser)) {
			return false;
		}		
		
		bookingUser.addTrip(bookingTrip);
		Booking booking = new Booking();
		booking.setTrip_id(bookingTrip.getId());
		booking.setUser_id(bookingUser.getId());
		entityManager.persist(booking);
		Notification notification = new Notification();
		notification.setMessage("You have booked a trip form "+ bookingTrip.getFromStation().getName() + " to " + bookingTrip.getToStation().getName() + "successfully");
		Date notifDate = new Date();
		notification.setNotificationDateTime(notifDate);
		System.out.println(notification.getMessage());
		entityManager.persist(notification);
		bookingUser.addNotification(notification);
		return true;
	}
	public Set<Trip> getUserTrips(int id){
		List<User> result;
		TypedQuery<User> query = entityManager.createQuery("Select c from User C", User.class);
		result = query.getResultList();
		for(User user:result) {
			if(user.getId()==id) {
				return user.getTrips();
			}
		}
		return null;
	}
	
	public Set<Notification> getNotifications(int id){
		List<User> result;
		TypedQuery<User> query = entityManager.createQuery("Select c from User C", User.class);
		result = query.getResultList();
		for(User user:result) {
			if(user.getId()==id) {
				return user.getNotifications();
			}
		}
		return null;
	}
	
}
