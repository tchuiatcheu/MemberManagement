package org.MemberManagement.ejb;


import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.MemberManagement.model.User;

@Stateless
@RolesAllowed({"utilisateur","admin"})
public class UserEJB {

	@PersistenceContext(unitName = "MemberManagement-persistence-unit")
	private EntityManager em;

	public List<User> findUsers() {
		TypedQuery<User> query = em.createQuery("SELECT u FROM User u ORDER BY u.id", User.class);
		return query.getResultList();
	}

	public User findUserById(Long id) {
		return em.find(User.class, id);
	}

	public User createUser(User user) {
		em.persist(user);
		return user;
	}
	
	@RolesAllowed("admin")
	public void deleteUser(User user) {
		em.remove(em.merge(user));	

	}
	public User updateMember(User user) {
		return em.merge(user);
	}
}
