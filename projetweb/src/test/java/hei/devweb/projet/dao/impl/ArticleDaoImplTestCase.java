package hei.devweb.projet.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import hei.devweb.projet.entities.Article;
import hei.devweb.projet.entities.Categorie;

public class ArticleDaoImplTestCase extends AbstractDaoTestCase{
	
	private ArticleDaoImpl articleDao = new ArticleDaoImpl();

	@Override
	public void insertDataSet(Statement stmt) throws Exception {
			stmt.executeUpdate("DELETE FROM article");
			stmt.executeUpdate("DELETE FROM commentaire");
			
			stmt.executeUpdate("INSERT INTO `article`(`id_article`,`date_publication`,`marque`,`prix`,`site`,`photo`,`lien`,`id_categorie`) VALUES (1,'2016-10-11','Kaporal','129.00','Zalando','C:/HEI/data/boots1.jpg','http://zalando.fr',1)");
			stmt.executeUpdate("INSERT INTO `article`(`id_article`,`date_publication`,`marque`,`prix`,`site`,`photo`,`lien`,`id_categorie`) VALUES (2,'2016-11-11','Pepe Jeans','110.00','Zalando','C:/HEI/data/mocassins1.jpg','http://zalando.fr',1)");
	}
	
	@Test
	public void shouldListArticles() {
		//WHEN
		List<Article> articles = articleDao.listArticles();
		//THEN
		Assertions.assertThat(articles).hasSize(2);
		Assertions.assertThat(articles).extracting("idArticle","datePublication","marque","prix","site","photo","lien","idCategorie").containsOnly(
				Assertions.tuple(1,"2016-10-11","Kaporal","129.00","Zalando","C:/HEI/data/boots1.jpg","http://zalando.fr",1),
				Assertions.tuple(2,"2016-11-11","Pepe Jeans","110.00","Zalando","C:/HEI/data/mocassins1.jpg","http://zalando.fr",1));
	}
	
	@Test
	public void shouldGetArticle() {
		// WHEN
		Article article = articleDao.getArticle(1);
		String photoPath = articleDao.getPhotoPath(1);
		// THEN
		assertThat(article).isNotNull();
		assertThat(article.getIdArticle()).isEqualTo(1);
		assertThat(article.getDatePublication()).isEqualTo("2016-10-11");
		assertThat(article.getMarque()).isEqualTo("Kaporal");
		assertThat(article.getPrix()).isEqualTo("129.00");
		assertThat(article.getSite()).isEqualTo("Zalando");
		assertThat(photoPath).isEqualTo("C:/HEI/data/boots1.jpg");
		assertThat(article.getLien()).isEqualTo("http://www.zalando.fr");
		assertThat(article.getCategorie()).isEqualTo(1);
	}
	
	@Test
	public void shouldGetPhotoPath() throws Exception{
		//WHEN
		String photoPath = articleDao.getPhotoPath(1);
		//THEN
		Assertions.assertThat(photoPath).isEqualTo("C:/HEI/data/boots1.jpg");
	}
	
	@Test
	public void shouldNotGetDeletedArticle() {
		// WHEN
		Article article = articleDao.getArticle(2);
		// THEN
		assertThat(article).isNull();
	}
	
	@Test
	public void shouldAddArticle() throws Exception {
		// WHEN
		String date ="2016-12-11";
		String marque="Pepe Jeans";
		Float prix= Float.parseFloat("119.00");
		String site = "La redoute";
		String lien = "http://www.laredoute.com/";
		Categorie categorie = new Categorie(1,"Boots","presentation boots");
		
		String photoPath = articleDao.getPhotoPath(3);
		Article newArticle = new Article(
				null,
				date,
				marque, 
				prix,
				site,
				lien,
				categorie);
		Article article = articleDao.addArticle(newArticle, photoPath);
		// THEN
		assertThat(article.getIdArticle()).isEqualTo(3);
		assertThat(article.getDatePublication()).isEqualTo("2016-12-11");
		assertThat(article.getMarque()).isEqualTo("Pepe Jeans");
		assertThat(article.getPrix()).isEqualTo("119.00");
		assertThat(article.getSite()).isEqualTo("La Redoute");
		assertThat(photoPath).isEqualTo("C:/HEI/data/desert1.jpg");
		assertThat(article.getLien()).isEqualTo("http://www.laredoute.com/");
		assertThat(article.getCategorie()).isEqualTo(2);

		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM article WHERE id_article = ?")) {
			stmt.setInt(1, article.getIdArticle());
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isTrue();
				assertThat(rs.getInt("id_article")).isEqualTo(article.getIdArticle());
				assertThat(rs.getDate("date_publication")).isEqualTo("10/12/2016 14:00:00");
				assertThat(rs.getString("marque")).isEqualTo("Pepe Jeans");
				assertThat(rs.getFloat("prix")).isEqualTo("119.00");
				assertThat(rs.getString("site")).isEqualTo("La Redoute");
				assertThat(rs.getString("photo")).isEqualTo("C:/HEI/data/desert1.jpg");
				assertThat(rs.getString("lien")).isEqualTo("http://www.laredoute.com/");
				assertThat(rs.getInt("id_categorie")).isEqualTo(2);
				assertThat(rs.next()).isFalse();
			}
		}
	}
	
	@Test
	public void shouldDeleteArticle() throws Exception {
		//WHEN
		articleDao.deleteArticle(1);
		//THEN
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM article WHERE id_article=1")){
				assertThat(rs.next()).isTrue();
				assertThat(rs.getInt("id_article")).isEqualTo(1);
				assertThat(rs.getDate("date_publication")).isEqualTo("2016-12-13");
				assertThat(rs.getString("marque")).isEqualTo("Pepe Jeans");
				assertThat(rs.getFloat("prix")).isEqualTo("119.00");
				assertThat(rs.getString("site")).isEqualTo("La Redoute");
				assertThat(rs.getString("photo")).isEqualTo("photo");
				assertThat(rs.getString("lien")).isEqualTo("http://www.laredoute.com/");
				assertThat(rs.getInt("id_categorie")).isEqualTo(2);
				assertThat(rs.getInt("deleted")).isEqualTo(1);
				assertThat(rs.next()).isFalse();
		}
	}
	
}
