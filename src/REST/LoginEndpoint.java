package REST;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import entities.User;
import services.UserServices;
@Stateful
@Path("login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LoginEndpoint {
	@EJB
	UserServices userService;
	
	@POST
	public Response login(User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		if(userService.login(username, password)) {
			return Response.ok().build();
		}
		return Response.status(Status.BAD_REQUEST).build();
	}
}
