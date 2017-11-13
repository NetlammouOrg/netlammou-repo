package tn.esprit.pidev.services;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.pidev.persistence.Participate;
import tn.esprit.pidev.util.ParticipateServiceRemote;

@Stateless
@LocalBean
public class ParticipateService implements ParticipateServiceRemote {
	
	
	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;

	@Override
	public void ajouterParticipate(Participate participate) {
		em.persist(participate);
	
	}




}