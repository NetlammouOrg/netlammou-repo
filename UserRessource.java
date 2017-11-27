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


import tn.esprit.pidev.entities.User;

import tn.esprit.pidev.util.UserServiceRemote;


@Path("userss")
@RequestScoped
public class UserRessource {
	
	@EJB
	private UserServiceRemote usermetier;


	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
public Response listAssociation(){
	
	
	return Response.ok(usermetier.listAssociation()).build();
}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)

	public Response addUser(User user){
		boolean i = usermetier.addUser(user); 
		if(i) {
			return Response.status(Status.CREATED).entity(user).build();
			
		}
		return Response.status(Status.NOT_ACCEPTABLE).entity("not added").build();

}
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	

	public Response update(User user,@PathParam("id") Integer id) {
		usermetier.updateUser(user);		
			return Response.status(Status.ACCEPTED).entity(user).build();
		} 
			//return Response.status(Status.NOT_MODIFIED).entity("User not updated").build();
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response deleteUser(@PathParam("id") int id) {
	
		if(usermetier.deleteUser(id)){
			return Response.status(Status.OK).entity("User deleted").build();
		} 
			return Response.status(Status.NOT_ACCEPTABLE).entity("User not deleted").build();
				
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	@Path("login/{username}/{pwd}")
	public Response Login(User user ,@PathParam("username") String email, @PathParam("pwd")String password)
	{
//return usermetier.getUserByEmailAndPassword(email, password);
	
	
	return Response.status(Status.OK).entity(usermetier.getUserByEmailAndPassword(email, password)).build();


		//return Response.status(Status.NOT_ACCEPTABLE).entity("Something's not right").build();
	
				
	}


	
				
	}
	

