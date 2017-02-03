package hei.devweb.projet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.projet.dao.ArticleDao;
import hei.devweb.projet.entities.Article;
import hei.devweb.projet.entities.Categorie;

public class ArticleDaoImpl implements ArticleDao{
	
	@Override
	public List<Article> listArticles() {
		List<Article> listArticles = new ArrayList<>();
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt
					.executeQuery("SELECT * FROM article JOIN categorie ON article.idcategorie = categorie.id_categorie "
							+ "WHERE deleted='0' "
							+ "ORDER BY date_publication DESC");
			while (resultSet.next()) {
				listArticles.add(new Article(
						resultSet.getInt("id_article"), 
						resultSet.getString("date_publication"),
						resultSet.getString("marque"),
						resultSet.getFloat("prix"),
						resultSet.getString("site"),
						resultSet.getString("lien"),
						new Categorie(
								resultSet.getInt("id_categorie"),
								resultSet.getString("nom_categorie"), 
								resultSet.getString("description_categorie"))));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticles;
	}

	@Override
	public Article getArticle(Integer id) {
		Article article = null;
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM article JOIN categorie ON article.idcategorie = categorie.id_categorie "
					+ "WHERE id_article=? AND deleted='0'");
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				article = new Article(
						resultSet.getInt("id_article"), 
						resultSet.getString("date_publication"),
						resultSet.getString("marque"),
						resultSet.getFloat("prix"),
						resultSet.getString("site"),
						resultSet.getString("lien"),
						new Categorie(
								resultSet.getInt("id_categorie"),
								resultSet.getString("nom_categorie"), 
								resultSet.getString("description_categorie")));
			}			
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}

	@Override
	public Article addArticle(Article article, String photoPath) {
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `article`(`date_publication`,`marque`,`prix`,`site`,`lien`,`idcategorie`,`photo`)VALUES(?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, article.getDatePublication());
			stmt.setString(2, article.getMarque());
			stmt.setFloat(3, article.getPrix());
			stmt.setString(4, article.getSite());
			stmt.setString(5, article.getLien());
			stmt.setInt(6, article.getCategorie().getIdCategorie());
			stmt.setString(7, photoPath);
			stmt.executeUpdate();
			
			ResultSet ids = stmt.getGeneratedKeys();
			if(ids.next()) {
				article.setIdArticle(ids.getInt(1));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return article;
	}
	
	public void updateArticle(Integer idArticle, Float prix, String marque, String lien) {
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE article SET prix='"+prix+"', marque='"+marque+"', lien='"+lien+"' WHERE id_article="+idArticle)){
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getPhotoPath(Integer id){
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT photo FROM article JOIN categorie ON article.idcategorie = categorie.id_categorie "
					+ "WHERE id_article=? AND deleted='0'");
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				return resultSet.getString("photo");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void deleteArticle(Integer idArticle) {
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE article SET deleted=1 WHERE id_article=?")){
		statement.setInt(1,idArticle);
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Article> listArticlesParCategorie(Integer idCategorie) {
		List<Article> listArticlesCategories = new ArrayList<>();
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt
					.executeQuery("SELECT * FROM article JOIN categorie ON article.idcategorie = categorie.id_categorie "
							+ "WHERE deleted='0' "
							+ "AND idcategorie='"+idCategorie+"' "
									+ "ORDER BY date_publication DESC");
			while (resultSet.next()) {
				listArticlesCategories.add(new Article(
						resultSet.getInt("id_article"), 
						resultSet.getString("date_publication"),
						resultSet.getString("marque"),
						resultSet.getFloat("prix"),
						resultSet.getString("site"),
						resultSet.getString("lien"),
						new Categorie(
								resultSet.getInt("id_categorie"),
								resultSet.getString("nom_categorie"), 
								resultSet.getString("description_categorie"))));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listArticlesCategories;
	}

}
