package hei.devweb.projet.dao;

import java.util.List;
import hei.devweb.projet.entities.Article;

public interface ArticleDao {

	public List<Article> listArticles();
	
	public List<Article> listArticlesParCategorie(Integer idCategorie);

	public Article getArticle(Integer id);

	public Article addArticle(Article article, String photoPath);
	
	public void updateArticle(Integer idArticle, Float prix, String marque, String lien);
	
	public String getPhotoPath(Integer id);
	
}