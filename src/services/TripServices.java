package services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	
	
	public List<Trip> searchTrips(String start, String end, int fromStationId, int toStationId) {
		List<Trip> result;
		TypedQuery<Trip> query = entityManager.createQuery("select c from Trip C", Trip.class);
		result = query.getResultList();
		
		List<Trip> matchingTrips = new ArrayList<Trip> ();
		
		System.out.println(start);
		System.out.println(end);
		System.out.println(fromStationId);
		System.out.println(toStationId);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		Date startDate = null;
		try {
			startDate = formatter.parse(start);
			System.out.println(startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date endDate = null;
		try {
			endDate = formatter.parse(end);
			System.out.println(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		for(Trip trip:result) {
			System.out.println(trip.getDepartureTime());
			System.out.println(trip.getFromStation().getId());
			System.out.println(trip.getToStation().getId());
			if(trip.getFromStation().getId() == fromStationId) {
				if (trip.getToStation().getId() == toStationId) {
					if (startDate.compareTo(trip.getDepartureTime()) < 1) {
						if(endDate.compareTo(trip.getDepartureTime()) >= 0) {
						matchingTrips.add(trip);
						}
					}
				}
			}
		}
		return matchingTrips;
	}
}
