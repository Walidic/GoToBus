package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Station;
import entities.Trip;

@Stateful
public class TripServices{
	
	@PersistenceContext(unitName = "gotobus")
	private EntityManager entityManager;
	
	public void createTrip(String from, String to, int availableSeats, String arrival, String departure) {
		Trip trip = new Trip();
		List<Station> result;
		TypedQuery<Station> query = entityManager.createQuery("Select c from Station C", Station.class);
		result = query.getResultList();
		for(Station station : result) {
			if(station.getName().equals(from)) {
				trip.setFromStation(station);
			}
		}
		for(Station station : result) {
			if(station.getName().equals(to)) {
				trip.setToStation(station);
			}
		}
		trip.setAvailableSeats(availableSeats);
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date arrivalTime;
		try {
			arrivalTime = formatter.parse(arrival);
			trip.setArrivalTime(arrivalTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date departureTime;
		try {
			departureTime = formatter.parse(departure);
			trip.setDepartureTime(departureTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entityManager.persist(trip);
	}

}
