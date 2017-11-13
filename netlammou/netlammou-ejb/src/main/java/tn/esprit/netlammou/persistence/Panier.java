package tn.esprit.pidev.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity

public class Panier implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToMany(mappedBy="panier")
	private List<Produit> prdt;
	@ManyToOne
	private Volenteer volenteer;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Produit> getPrdt() {
		return prdt;
	}
	public void setPrdt(List<Produit> prdt) {
		this.prdt = prdt;
	}
	public Volenteer getVolenteer() {
		return volenteer;
	}
	public void setVolenteer(Volenteer volenteer) {
		this.volenteer = volenteer;
	}
	
	
	
	
}
