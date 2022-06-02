package REST;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Trip;
import services.UserServices;

@Stateful
@Path("viewtrips")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserTripsEndpoint {

	@EJB
	UserServices userService;
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response getUserTrips(@PathParam("id")int id) {
		Set<Trip> resultSet;
		resultSet = userService.getUserTrips(id);
		if(resultSet == null) {
			return Response.serverError().build();
		}
		List<Trip> trips =new ArrayList<Trip>();
		for(Trip trip:resultSet) {
			trips.add(trip);
		}
		return Response.ok(trips).build();
	}
	
}
