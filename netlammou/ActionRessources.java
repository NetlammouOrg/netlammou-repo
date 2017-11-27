package tn.esprit.pi.ressources;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import javax.ws.rs.core.Response.Status;

import tn.esprit.pidev.persistence.Action;

import tn.esprit.pidev.util.ActionServiceRemote;

@Path("actions")
@RequestScoped
public class ActionRessources {
	
	
	@EJB
	private ActionServiceRemote actionmetier;

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listActions(){
	
	return Response.ok(actionmetier.findAll()).build();
}
	/*
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAction(Action action){
		
		
		return Response.ok(actionmetier.ajouterAction(action)).build();

}*/
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(Action action,@PathParam("id") Integer id) {
		actionmetier.updateAction(action);		
			return Response.status(Status.ACCEPTED).entity("updated !").build();
		} 
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response deleteAction(@PathParam("id") int id) {
	
		if(actionmetier.deleteActionById(id)){
			return Response.status(Status.OK).entity("action deleted").build();
		} 
			return Response.status(Status.NOT_ACCEPTABLE).entity("action not deleted").build();
				
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addAction(Action action){
		boolean i = actionmetier.ajouterAction(action) ;
		if(i) {
			return Response.status(Status.CREATED).entity("done").build();
			
		}
		return Response.status(Status.NOT_ACCEPTABLE).entity("not").build();

}
}
