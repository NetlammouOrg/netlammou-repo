package tn.esprit.pi.ressources;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.pidev.util.ActionServiceRemote;
@Path("actionspast")
@RequestScoped
public class PastRessource {
	@EJB
	private ActionServiceRemote actionmetierP;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listActionsP(){
	
	return Response.ok(actionmetierP.findAllPast()).build();
	}

}
