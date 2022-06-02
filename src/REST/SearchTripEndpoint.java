package REST;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entities.Trip;
import entities.Station;

import services.TripServices;
@Stateful
@Path("searchtrips")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class SearchTripEndpoint {
	@EJB
	TripServices tripService;
	
	@POST
	public Response searchTrips(Trip trip) {
		Date arrivalTime = trip.getArrivalTime();
		Date departureTime = trip.getDepartureTime();
		Station fromStation = trip.getFromStation();
		Station toStation = trip.getToStation();
		return Response.ok().build();
	}
		
}
