package tn.esprit.pidev.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PlainPassword  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPlain;
	private String Password;
	private String mailAdress;
	private static final long serialVersionUID = 1L;
	public PlainPassword() {
		super();
	}
	public int getIdPlain() {
		return idPlain;
	}
	public void setIdPlain(int idPlain) {
		this.idPlain = idPlain;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getMailAdress() {
		return mailAdress;
	}
	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}

	
	
	
}
