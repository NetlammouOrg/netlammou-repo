package tn.esprit.pidev.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.pidev.persistence.ActionType;



@ManagedBean
@ApplicationScoped
public class Data {
	public ActionType[] geTypes() {
		return ActionType.values();
	}

}
