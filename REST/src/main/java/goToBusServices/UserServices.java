package goToBusServices;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Path("/user")
	@POST
	public void createUser(User u) {
		entityManager.persist(u);
	}
	
	
	@Path("/login")
	@POST
	public String login(String username, String password) {
		User user = entityManager.find(User.class, username);
		if (password.equals(user.getPassword())) {
			return "OK";
		}
		else {return "login failed";}
	}
}
