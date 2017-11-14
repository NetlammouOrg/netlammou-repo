package tn.esprit.pidev.services;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import tn.esprit.pidev.entities.PlainPassword;
import tn.esprit.pidev.entities.User;


import tn.esprit.pidev.util.UserServiceRemote;
@LocalBean
@Stateless
public class UserService implements UserServiceRemote {

	@PersistenceContext
	private EntityManager em;

	@Override
	public int addUser(User user) {
	//	user.setRole(Role.volunteer);
		em.persist(user);
	
		return user.getId();
	
		
	}
	


	@Override
	public List<User> listUser() {

		TypedQuery<User> query = em.createQuery("SELECT u FROM User u ",User.class);	
		 List<User> users = query.getResultList();
		 return users;
	}


	@Override
	public boolean login(String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String findUserRole(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getIdByUsername(String username) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteUser(int id) {
		User user =em.find(User.class, id);
		em.remove(user);
		
	}

	
	
	
	
	
	@Override
	public User getUserByEmailAndPassword(String mailAdress, String password) {
		System.out.println("user:");
		User user = null;

		TypedQuery<User> query = em.createQuery("select u from User u where u.mailAdress= :mailAdress and u.password= :password " ,User.class);
				query.setParameter("mailAdress",mailAdress);
				query.setParameter("password", password);
				System.out.println("user:");

				user=query.getSingleResult();
				System.out.println("user:"+user.getId());
				return user;
	}

	@Override
	public List<User> listVolunteer() {
		
		
		TypedQuery<User> query = em.createQuery("select u from User u where u.role='volunteer'",User.class);	
		 List<User> user = query.getResultList();
		 return user;
	}

	@Override
	public List<User> listAssociation() {
	
		TypedQuery<User> query = em.createQuery("select u from User u where u.role='ngos'",User.class);	
		 List<User> user = query.getResultList();
		 return user;
	}

	@Override
	public void updateUser(User user) {
		em.merge(user);
		
	
	}



	@Override
	public boolean deactiveUser(User user) {
		user=em.find(User.class,user.getId());
		if (user!=null){
		String jpql = "update User s set etat=0 WHERE s.id = :param1";
		Query query = em.createQuery(jpql);
		
		query.setParameter("param1", user.getId());
		query.executeUpdate();
		return true;}
		return false;
	}



	



	@Override
	public User findByUsername(String firstName) {
		try {
			TypedQuery<User> q = em.createQuery("SELECT u FROM User u where u.firstName =:firstName", User.class);
			q.setParameter("firstName",firstName);
			User user = q.getSingleResult();
			return user;
		} catch (javax.persistence.NoResultException  e) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO,
					"User with firstName = " + firstName + " not found");
			return null;
		}
	}



	@Override
	public PlainPassword getPlainPasswordByUsername(String mailAdress) {
		try {
			TypedQuery<PlainPassword> q = em
					.createQuery("SELECT PP FROM PlainPassword PP where PP.mailAdress =:usn ", PlainPassword.class);
			q.setParameter("usn",mailAdress);
			PlainPassword PP = q.getSingleResult();
			return PP;
		} catch (javax.persistence.NoResultException E) {
			Logger.getLogger(this.getClass().getName()).log(Level.INFO,
					"no user found with username = " + mailAdress);
			return null;
		}
		
	}



	




	
	

}
