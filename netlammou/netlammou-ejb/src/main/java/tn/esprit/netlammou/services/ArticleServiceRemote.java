package tn.esprit.pidev.services;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.pidev.persistence.Article;

@Remote
public interface ArticleServiceRemote {

	public int addArticle(Article article);
	public void updateArticle(Article article,int id);
	public List<Article> getAllArticls();
	public void deleteArticle(int id);
	public List<Article> getArticlsByDate(Date d);
}
