package tn.esprit.pidev.presentation.mbeans;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import tn.esprit.pidev.persistence.Article;
import tn.esprit.pidev.services.ArticleService;

@ManagedBean
@RequestScoped
@Path("/article")
public class ArticleBean {
	
	@EJB
	ArticleService articleService ;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getArticle(){
		return Response.ok(articleService.getAllArticls()).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addArticle(Article article){
		int x= articleService.addArticle(article);
		return Response.status(Status.CREATED).entity("Well done :D").build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteArticle (@PathParam ("id")Integer id){
		articleService.deleteArticle(id);
		return Response.ok().build();
		}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response upadateArticle(Article article,@PathParam ("id")Integer id){
		articleService.updateArticle(article, id);
		return Response.status(Status.OK).entity("well done :D").build();
	}
	
}
