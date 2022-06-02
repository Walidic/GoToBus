package services;

import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import entities.User;
@Stateful
public class UserServices {
	
	@PersistenceContext(unitName = "gotobus")
	private EntityManager entityManager;
	public void createUser(User user) {
		entityManager.persist(user);
	}
	
	public boolean login(String username, String password) {
		List<User> result;
		TypedQuery<User> query = entityManager.createQuery("Select c from User C", User.class);
		result = query.getResultList();
		for(User user:result) {
			if(user.getUsername().equals(username)) {
				if(user.getPassword().equals(password)) {
					return true;
				}
			}
		}
		return false;
	}
	
}
