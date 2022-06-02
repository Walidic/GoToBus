package REST;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Station;
import services.StationServices;

@Stateful
@Path("station")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StationIdEndpoint {
	@EJB
	StationServices stationService;
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response findById(@PathParam("id")int id) {
		Station station = stationService.findById(id);
		if(station ==null) {
			return Response.serverError().build();
		}
		
		return Response.ok(station).build();
	}
}
