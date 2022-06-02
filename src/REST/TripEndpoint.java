package REST;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import services.TripServices;
@Stateful
@Path("trip")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TripEndpoint {
	@EJB
	TripServices tripService;
	
	@POST
	public Response createTrip(String body) {
		System.out.println("here");	
		JSONObject obj = new JSONObject(body);
		System.out.println("here");	
		String fromStation = obj.getString("fromStation");
		String toStation = obj.getString("toStation");
		int availableSeats = obj.getInt("availableSeats");
		String arrivalTime = obj.getString("arrivalTime");
		String departureTime = obj.getString("departureTime");
		tripService.createTrip(fromStation, toStation, availableSeats, arrivalTime, departureTime);	
		return Response.ok().build();
	}
}
