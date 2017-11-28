package tn.esprit.pidev.services;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.pidev.persistence.NGOs;
import tn.esprit.pidev.persistence.Product;

@Local
public interface ProductLocal {
	public boolean addProduit(Product product);
	boolean delete(int prodID);
	public void ModifierProduit(Product prod);
	public Product findProductById(int id);
	//public NGOs getConnectedVolenteer();
	List<Product> getByName(String name);
	List<Product> findAll();
	List<Product> afficher();
List<Product> getProductRecherche();

}
