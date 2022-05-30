package goToBusServices;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import entities.User;



@EJB
@Stateful
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserServices {

	
	@Path("/user")
	@POST
	public void createUser() {
		User user = new User();
	}
	
	
	@Path("/login")
	@POST
	public void Login() {
		
	}
}
