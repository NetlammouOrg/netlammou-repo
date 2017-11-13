package tn.esprit.pidev.presentation.mbeans;

import java.util.Date;
import java.util.List;


import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Future;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RateEvent;

import tn.esprit.pidev.persistence.Action;
import tn.esprit.pidev.persistence.ActionType;
import tn.esprit.pidev.persistence.Localisation;
import tn.esprit.pidev.persistence.NGOs;
import tn.esprit.pidev.persistence.Participate;
import tn.esprit.pidev.persistence.Volenteer;
import tn.esprit.pidev.services.ActionService;
import tn.esprit.pidev.services.ParticipateService;


@ManagedBean
@ViewScoped
public class AjouterBean {
	
	
	private String name;
	@Future
	private Date date;
	private Localisation place;
	private String description;
	private boolean actif ;
	private int desiredVolenteers;
	private NGOs ngos;
	private ActionType type;
	private int actionIdToBeUpdate;
	
	private Action action;
	private Volenteer volenteer;
	
	
	
	private int number;
	 
    public int getNumber() {
        return number;
    }
 
    public void increment() {
        number++;
    }
	//rating
	 	private Integer rating1;
	    private Integer rating2;   
	    private Integer rating3;
	    private Integer rating4 = 3;
	     
	    
	    
	    
	    public Integer getRating1() {
			return rating1;
		}

		public void setRating1(Integer rating1) {
			this.rating1 = rating1;
		}

		public Integer getRating2() {
			return rating2;
		}

		public void setRating2(Integer rating2) {
			this.rating2 = rating2;
		}

		public Integer getRating3() {
			return rating3;
		}

		public void setRating3(Integer rating3) {
			this.rating3 = rating3;
		}

		public Integer getRating4() {
			return rating4;
		}

		public void setRating4(Integer rating4) {
			this.rating4 = rating4;
		}

		public void onrate(RateEvent rateEvent) {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Rate Event", "You rated:" + ((Integer) rateEvent.getRating()).intValue());
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	     
	    public void oncancel() {
	        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancel Event", "Rate Reset");
	        FacesContext.getCurrentInstance().addMessage(null, message);
	    }
	
	//rating
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getActionIdToBeUpdate() {
		return actionIdToBeUpdate;
	}
	public void setActionIdToBeUpdate(int actionIdToBeUpdate) {
		this.actionIdToBeUpdate = actionIdToBeUpdate;
	}
	
	
	
	
	
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Localisation getPlace() {
		return place;
	}
	public void setPlace(Localisation place) {
		this.place = place;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActif() {
		return actif;
	}
	public void setActif(boolean actif) {
		this.actif = actif;
	}
	public int getDesiredVolenteers() {
		return desiredVolenteers;
	}
	public void setDesiredVolenteers(int desiredVolenteers) {
		this.desiredVolenteers = desiredVolenteers;
	}
	public NGOs getNgos() {
		return ngos;
	}
	public void setNgos(NGOs ngos) {
		this.ngos = ngos;
	}
	public ActionType getType() {
		return type;
	}
	public void setType(ActionType type) {
		this.type = type;
	}
	
	@EJB
	ActionService actionService;
	
	@EJB
	ParticipateService participateService;
	
	public void addParticipate()
	{
		participateService.ajouterParticipate(new Participate(date, action, volenteer));
		System.out.println("done");
	}
	public void addAction()
	{
		actionService.ajouterAction(new Action(name, date, type, description, actif, desiredVolenteers));
		System.out.println("done");
	}
	public ActionService getActionService() {
		return actionService;
	}
	public void setActionService(ActionService actionService) {
		this.actionService = actionService;
	}

	private List<Action> actions;
	private List<Action> actionsP;
	private List<Action> actionsF;
	public List<Action> getActionsF() {
		return actionsF;
	}

	public void setActionsF(List<Action> actionsF) {
		this.actionsF = actionsF;
	}

	public List<Action> getActionsP() {
		return actionsP;
	}

	public void setActionsP(List<Action> actionsP) {
		this.actionsP = actionsP;
	}
	private Action a;


	public List<Action> getActions() {
		actions = actionService.findAll();
		actionsP = actionService.findAllPast();
		return actions;
	}
	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	public Action getA() {
		return a;
	}
	public void setA(Action a) {
		this.a = a;
	}
	/*
	public List<Action> getAllActions()
	{
		//actions = new ArrayList<>();
		actions = actionService.findAll();
		return actions;
		
}*/
	
	public void supprimer(int actionID)
	{
		actionService.deleteActionById(actionID);
	}
	
	public void modifier(Action action)
	{
		this.setName(action.getName());
		this.setDescription(action.getDescription());
		this.setActif(action.isActif());
		this.setType(action.getType());
		this.setDesiredVolenteers(action.getDesiredVolenteers());
		//this.setDate(action.getDate());
		this.setActionIdToBeUpdate(action.getId());
		
	}
		
	
		public void mettreAjourAction()
		{
			actionService.updateAction(new Action(name, date, type, description, actif, desiredVolenteers, actionIdToBeUpdate ));
		}
		
		
		//les messages
		public void info() {
	        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Ajout effectué."));
	    }
		private Action selectedAction;




		public Action getSelectedAction() {
			return selectedAction;
		}

		public void setSelectedAction(Action selectedAction) {
			this.selectedAction = selectedAction;
		} 
		 
		 
}
