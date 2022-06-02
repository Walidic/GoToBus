package services;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.Station;
@Stateful
public class StationServices {
	@PersistenceContext(unitName = "gotobus")
	private EntityManager entityManager;
	
	public void createStation(Station station) {
		entityManager.persist(station);
	}
	
	public Station findById(int Id) {
		List<Station> result;
		TypedQuery<Station> query = entityManager.createQuery("Select c from Station C", Station.class);
		result = query.getResultList();
		for(Station station:result) {
			if (station.getId()==Id) {
				return station;
			}
		}
		return null;
		
	}
}
