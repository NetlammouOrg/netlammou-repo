package tn.esprit.pi.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.pidev.persistence.Action;
import tn.esprit.pidev.util.ActionServiceRemote;

@Path("actionsfind")
@RequestScoped
public class RessourceFind {
	@EJB
	private ActionServiceRemote actionmetierF;
	
	@GET
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Action action,@PathParam("id") Integer id) {
		
		//actionmetierF.getActionPrenomById(id);		
		return Response.ok(actionmetierF.getActionPrenomById(id)).build();
				
		
		} 
	}



