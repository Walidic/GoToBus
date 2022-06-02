package services;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Booking;
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
		bookingUser.addTrip(bookingTrip);
		bookingTrip.addUser(bookingUser);
		System.out.println(bookingUser.getUsername());
		System.out.println(bookingTrip.getAvailableSeats());
		Booking booking = new Booking();
		booking.setTrip_id(bookingTrip.getId());
		booking.setUser_id(bookingUser.getId());
		entityManager.persist(booking);
		return true;
	}
	
}
