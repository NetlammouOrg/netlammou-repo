package tn.esprit.netlammou.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.netlammou.persistence.Todo;

@Local
public interface TodoServiceLocal {
	
	void create(Todo todo);
	List<Todo> findAll();

}
