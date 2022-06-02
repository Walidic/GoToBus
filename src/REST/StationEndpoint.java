package REST;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import entities.Station;
import services.StationServices;

@Stateful
@Path("station")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StationEndpoint {
	
	@EJB
	StationServices stationService;
	
	@POST
	public Response creatStation(Station station) {
		
		stationService.createStation(station);
		return Response.ok().build();
	}
}
