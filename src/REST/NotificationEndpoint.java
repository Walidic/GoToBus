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

import entities.Notification;
import entities.Trip;
import services.UserServices;

@Stateful
@Path("notifications")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class NotificationEndpoint {
	
	@EJB
	UserServices userService;
	
	@GET
	@Path("/{id:[0-9][0-9]*}")
	public Response getUserNotifications(@PathParam("id")int id) {
		Set<Notification> notificationSet = userService.getNotifications(id);
		if(notificationSet == null) {
			return Response.serverError().build();
		}
		List<Notification> notifications =new ArrayList<Notification>();
		for(Notification notification:notificationSet) {
			notifications.add(notification);
		}
		return Response.ok(notifications).build();
	}
}
