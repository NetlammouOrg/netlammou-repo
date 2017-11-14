package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Preference implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Enumerated(EnumType.STRING)
	private Prefenence type ;
	
/** Relations **/
	
	@ManyToMany
	List<User> users;
	
/************/
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Prefenence getType() {
		return type;
	}

	public void setType(Prefenence type) {
		this.type = type;
	}

	public Preference(Prefenence type) {
		super();
		this.type = type;
	}

	public Preference() {
		super();
	}



	public Preference(Prefenence type, List<User> users) {
		super();
		this.type = type;
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


	
	
}
