package hei.devweb.projet.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.Part;

import hei.devweb.projet.dao.impl.ArticleDaoImpl;
import hei.devweb.projet.dao.impl.CategorieDaoImpl;
import hei.devweb.projet.dao.impl.CommentaireDaoImpl;
import hei.devweb.projet.dao.impl.NewsletterDaoImpl;
import hei.devweb.projet.entities.Article;
import hei.devweb.projet.entities.Categorie;
import hei.devweb.projet.entities.Commentaire;
import hei.devweb.projet.entities.Newsletter;

public class BlogService {
	
	private static final String PICTURE_MAIN_DIRECTORY = "C:/HEI/data/";

	public static class BlogHolder{
		private static BlogService instance = new BlogService();
	}
	
	public static BlogService getInstance(){
		return BlogHolder.instance;
	}
	
	private BlogService() {
	}
	
	private ArticleDaoImpl articleDao = new ArticleDaoImpl();
	private CategorieDaoImpl categorieDao = new CategorieDaoImpl();
	private CommentaireDaoImpl commentaireDao = new CommentaireDaoImpl();
	private NewsletterDaoImpl newsletterDao = new NewsletterDaoImpl();

	public List<Article> listArticles() {
		return articleDao.listArticles();
	}
	
	public List<Article> listArticlesParCategorie(Integer idCategorie) {
		return articleDao.listArticlesParCategorie(idCategorie);
	}

	public Article getArticle(Integer id) {
		return articleDao.getArticle(id);
	}

	public void addArticle(Article article, Part photo) throws IOException {
		Path photoPath = Paths.get(PICTURE_MAIN_DIRECTORY, photo.getSubmittedFileName());
		articleDao.addArticle(article, photoPath.toString());
		Files.copy(photo.getInputStream(), photoPath);
	}
	
	public void updateArticle(Integer id, Float prix, String marque, String lien) throws IOException {
		articleDao.updateArticle(id, prix, marque, lien);
	}
	
	public void deleteArticle(Integer idArticle){
		articleDao.deleteArticle(idArticle);
	}
	
	public List<Categorie> listCategories() {
		return categorieDao.listCategories();
	}
	
	public Categorie getCategorie(Integer id) {
		return categorieDao.getCategorie(id);
	}

	public void addCategorie(String nom, String description) {
		categorieDao.addCategorie(nom, description);
	}
	
	public Path getPhotoPath(Integer idArticle){
		String photoPathString = articleDao.getPhotoPath(idArticle);
		if(photoPathString==null){
			return getDefaultPhotoPath();
		}else{
			Path photoPath = Paths.get(articleDao.getPhotoPath(idArticle));
			if(Files.exists(photoPath)){
				return photoPath;
			}else{
				return getDefaultPhotoPath();
			}
		}
		
	}
	
	private Path getDefaultPhotoPath(){
		try{
			return Paths.get(this.getClass().getClassLoader().getResource("photo-no-article.jpg").toURI());
		} catch(URISyntaxException e){
			return null;
		}
	}
	
	public List<Commentaire> listCommentaires(Integer idArticle) {
		return commentaireDao.listCommentaires(idArticle);
	}
	
	public Commentaire getCommentaire(Integer id) {
		return commentaireDao.getCommentaire(id);
	}
	
	public void addCommentaire(Commentaire commentaire) {
		commentaireDao.addCommentaire(commentaire);
	}

	public List<Newsletter> listNewsletters() {
		return newsletterDao.listNewsletters();
	}

	public Newsletter getNewsletter(Integer id) {
		return newsletterDao.getNewsletter(id);
	}
	
	public void addNewsletter(String mail) {
		newsletterDao.addNewsletter(mail);
	}

}
