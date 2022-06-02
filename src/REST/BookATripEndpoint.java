package REST;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import services.UserServices;

@Stateful
@Path("booktrip")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookATripEndpoint {
	@EJB
	UserServices userservice;
	
	
	@POST
	public Response book(String body) {
		JSONObject obj = new JSONObject(body);
		int user_id = obj.getInt("user_id");
		int trip_id = obj.getInt("trip_id");
		if(userservice.bookSeat(user_id, trip_id)) {
			return Response.ok().build();
		}
		return Response.serverError().build();
	}
	
}
