package org.MemberManagement.ejb;



import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.MemberManagement.model.Member;

@Stateless
@RolesAllowed({"utilisateur","admin"})
public class MemberEJB {

	@PersistenceContext(unitName = "MemberManagement-persistence-unit")
	private EntityManager em;

	public List<Member> findMembers() {
		TypedQuery<Member> query = em.createQuery("SELECT m FROM Member m ORDER BY m.id", Member.class);
		return query.getResultList();
	}

	public Member findMemberById(Long id) {
		return em.find(Member.class, id);
	}

	public Member createMember(Member member) {
		em.persist(member);
		return member;
	}
	
	@RolesAllowed("admin")
	public void deleteMember(Member member) {
		em.remove(em.merge(member));	

	}
	public Member updateMember(Member member) {
		return em.merge(member);
	}

}
