package tn.esprit.pidev.persistence;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Produit implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private float prix;
	private CategorieProduit cp;

	@ManyToOne
	private Panier panier;
	
	
	
	@ManyToOne
	private NGOs ngos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public CategorieProduit getCp() {
		return cp;
	}

	public void setCp(CategorieProduit cp) {
		this.cp = cp;
	}

	public NGOs getNgos() {
		return ngos;
	}

	public void setNgos(NGOs ngos) {
		this.ngos = ngos;
	}
	
	
	

}
