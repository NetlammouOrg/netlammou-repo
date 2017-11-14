package tn.esprit.pidev.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String lastName;
	private String firstName;
	@Temporal(TemporalType.DATE)
	private Date birthdate;
    private String adress;
	private String mailAdress;
	private int phoneNumber;
	private String password;
	@Enumerated(EnumType.STRING)
    private Role role;
	private boolean potential;
	@Enumerated(EnumType.STRING)
	private State state;
	private String nameAssociation;
	private String Description;
	
	private String picture;
//les listes 
	 @OneToMany(mappedBy="users")
	 private List<Rate> rates;
	
	@OneToMany(mappedBy="user")
	 private List<Feedback> feedbacks;
	 
	 @ManyToMany(mappedBy="users")
	 private List<Preference> preferences ;
	 @OneToMany
		private List<Notification> notifications;
	 
	 @OneToMany(mappedBy="action")
	 private List<Participate> participates;

	@OneToMany(mappedBy="user")
	private List<Message>messages;
	
	@OneToMany(mappedBy="user")
	private List<Topic> topics;

	@OneToOne(mappedBy="user")
	private Localisation localisation;
	



	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getMailAdress() {
		return mailAdress;
	}
	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public boolean isPotential() {
		return potential;
	}
	public void setPotential(boolean potential) {
		this.potential = potential;
	}
	public String getNameAssociation() {
		return nameAssociation;
	}
	public void setNameAssociation(String nameAssociation) {
		this.nameAssociation = nameAssociation;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public List<Rate> getRates() {
		return rates;
	}
	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}
	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}
	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
	public List<Preference> getPreferences() {
		return preferences;
	}
	public void setPreferences(List<Preference> preferences) {
		this.preferences = preferences;
	}
	public List<Notification> getNotifications() {
		return notifications;
	}
	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}
	public List<Participate> getParticipates() {
		return participates;
	}
	public void setParticipates(List<Participate> participates) {
		this.participates = participates;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	public Localisation getLocalisation() {
		return localisation;
	}
	public void setLocalisation(Localisation localisation) {
		this.localisation = localisation;
	}

	public User() {
		super();
}
	
	
//association
	
	
	public User(String nameAssociation,String description,String mailAdress, int phoneNumber, String password, Role role
			) {
		super();
		this.mailAdress = mailAdress;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
		this.nameAssociation = nameAssociation;
		Description = description;
	}
	//volunteer
	
		
	public User(String lastName, String firstName, String adress, String mailAdress, int phoneNumber, String password,
			Role role) {
		super();

		this.lastName = lastName;
		this.firstName = firstName;
		this.adress = adress;
		this.mailAdress = mailAdress;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
	}


	
	public User(int id, String lastName, String firstName, String adress, int phoneNumber, String password, Role role) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.adress = adress;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
	}
	public User(String lastName, String firstName, Date birthdate, String adress, String mailAdress, int phoneNumber,
			String password, Role role, boolean potential, String nameAssociation, String description) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthdate = birthdate;
		this.adress = adress;
		this.mailAdress = mailAdress;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
		this.potential = potential;
		this.nameAssociation = nameAssociation;
		Description = description;
	}

	public User(String adress, String mailAdress, int phoneNumber, String password, Role role, State state,
			String nameAssociation, String description) {
		super();
		this.adress = adress;
		this.mailAdress = mailAdress;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
		this.state = state;
		this.nameAssociation = nameAssociation;
		Description = description;
	}
	public User(String path,String lastName, String firstName, String adress, String mailAdress, int phoneNumber, String password,
			Role role, State state) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.adress = adress;
		this.mailAdress = mailAdress;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
		this.state = state;
	}
	public User(String path,String lastName, String firstName, Date birthdate, String adress, String mailAdress, int phoneNumber,
			String password, Role role) {
		super();
		picture=path;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthdate = birthdate;
		this.adress = adress;
		this.mailAdress = mailAdress;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.role = role;
	}
	public User(String lastName, String firstName, String adress, String mailAdress, Role role, int id) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.adress = adress;
		this.mailAdress = mailAdress;
		this.role = role;
		this.id=id;
	}
	
	
	

	}
	
	
	
	

	
	
	
	
	


