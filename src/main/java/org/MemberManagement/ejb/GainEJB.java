package org.MemberManagement.ejb;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.MemberManagement.model.Gain;



@Stateless
@RolesAllowed({"utilisateur","admin"})
public class GainEJB {

	@PersistenceContext(unitName = "MemberManagement-persistence-unit")
	private EntityManager em;

	public List<Gain> findUsers() {
		TypedQuery<Gain> query = em.createQuery("SELECT g FROM Gain g ORDER BY g.id", Gain.class);
		return query.getResultList();
	}

	public Gain findGainById(Long id) {
		return em.find(Gain.class, id);
	}

	public Gain createGain(Gain gain) {
		em.persist(gain);
		return gain;
	}
	
	@RolesAllowed("admin")
	public void deleteGain(Gain gain) {
		em.remove(em.merge(gain));	

	}
	public Gain updateGain(Gain gain) {
		return em.merge(gain);
	}

}
