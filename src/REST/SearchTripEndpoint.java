package REST;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.json.JSONObject;

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
	public Response searchTrips(String body) {
		JSONObject obj = new JSONObject(body);
		String fromDate = obj.getString("fromDate");
		String toDate = obj.getString("toDate");
		int fromStationId = obj.getInt("fromStation");
		int toStationId = obj.getInt("toStation");
		List<Trip> resultList = tripService.searchTrips(fromDate, toDate, fromStationId, toStationId);
		return Response.ok(resultList).build();
	}
		
}
