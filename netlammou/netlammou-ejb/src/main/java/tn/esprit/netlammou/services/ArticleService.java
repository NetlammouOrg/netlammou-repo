package tn.esprit.pidev.services;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


import tn.esprit.pidev.persistence.Article;

@Stateless
@LocalBean
public class ArticleService implements ArticleServiceRemote {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public int addArticle(Article article) {
		em.persist(article);
		em.flush();
		return article.getId();
	}

	@Override
	public void updateArticle(Article article,int id) {

		Article a= em.find(Article.class, id);
		a.setBody(article.getBody());
		a.setImage(article.getImage());
		a.setName(article.getName());
		
		System.out.println("Localisation updated with success");
		
	}

	@Override
	public List<Article> getAllArticls() {
		TypedQuery<Article> query = em.createQuery(
				"SELECT a from Article a  ",Article.class);
	    return query.getResultList();}

	@Override
	public void deleteArticle(int id) {

		Article article = em.find(Article.class, id);	
		em.remove(article);
	}

	@Override
	public List<Article> getArticlsByDate(Date d) {
		// TODO Auto-generated method stub
		return null;
	}

}
