package tn.esprit.pidev.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import tn.esprit.pidev.persistence.Action;
import tn.esprit.pidev.util.ActionServiceRemote;


@Stateless
@LocalBean
public class ActionService implements ActionServiceRemote {

	@PersistenceContext(unitName = "pidev-ejb")
	EntityManager em;


	@Override
	public int ajouterAction(Action action) {
		// TODO Auto-generated method stub
		em.persist(action);
		return action.getId();
	}
	
	@Override
	public List<Action> findAll()
	{	
		  List<Action> query = em.createQuery("Select a from Action a where a.actif = '1' ", Action.class).getResultList();
		  return query;
	}
	
	@Override
	public List<Action> findAllPast()
	{	
		  List<Action> query = em.createQuery("Select a from Action a where a.actif = '0'", Action.class).getResultList();
		  return query;
	}
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Override
	public void deleteActionById(int actionId)
	{
		Action action = em.find(Action.class, actionId);
		
		em.remove(action);
	}
	

	@Override
	public void updateAction(Action action)
	{
		em.merge(action);
	}

	
	
	//stat
	

	@Override
	public Map<String, Long> getActionByTypes() {
		Map<String, Long> result= new HashMap<String, Long>();
		String jpql = "SELECT DISTINCT name from Action";
		Query query = em.createQuery(jpql);
		ArrayList<String> names= (ArrayList<String>) query.getResultList();
		Iterator<String> it = names.iterator();
		while (it.hasNext()){
			String name= (String)it.next();
			String jpql2= "SELECT Count(*) from Action u where u.name=:name";
			Query q2 = em.createQuery(jpql2);
			q2.setParameter("name", name);
			result.put(name, (Long)q2.getSingleResult());
			
		}
		return result;
	}
}
