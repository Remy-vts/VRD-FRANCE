package hei.devweb.projet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.projet.dao.CommentaireDao;
import hei.devweb.projet.entities.Article;
import hei.devweb.projet.entities.Categorie;
import hei.devweb.projet.entities.Commentaire;

public class CommentaireDaoImpl implements CommentaireDao {

	@Override
	public List<Commentaire> listCommentaires(Integer idArticle) {
		List<Commentaire> listCommentaires = new ArrayList<>();
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt
					.executeQuery("SELECT * FROM commentaire JOIN (article JOIN categorie ON article.idcategorie = categorie.id_categorie) ON commentaire.idarticle = article.id_article"
							+ " WHERE idarticle = "+idArticle+" "
									+ "ORDER BY date_commentaire DESC "
									+ "LIMIT 5");
			while (resultSet.next()) {
				listCommentaires.add(new Commentaire(
						resultSet.getInt("id_commentaire"), 
						resultSet.getString("date_commentaire"),
						resultSet.getString("commentaire"),
						resultSet.getString("nom_commentaire"),
						new Article(
								resultSet.getInt("id_article"), 
								resultSet.getString("date_publication"),
								resultSet.getString("marque"), 
								resultSet.getFloat("prix"),
								resultSet.getString("site"), 
								resultSet.getString("lien"), 
								new Categorie(
										resultSet.getInt("id_categorie"),
										resultSet.getString("nom_categorie"),
										resultSet.getString("description_categorie")))));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listCommentaires;
	}
	
	@Override
	public Commentaire getCommentaire(Integer id) {
		Commentaire commentaire = null;
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM commentaire JOIN article ON commentaire.id_article = article.id_article WHERE idfilm = ?");
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				commentaire = new Commentaire(
						resultSet.getInt("id_commentaire"), 
						resultSet.getString("date_commentaire"),
						resultSet.getString("commentaire"),
						resultSet.getString("nom_commentaire"),
						new Article(
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
		return commentaire;
	}

	@Override
	public Commentaire addCommentaire(Commentaire commentaire) {
		
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `commentaire`(`date_commentaire`,`commentaire`,`nom_commentaire`,`idarticle`)VALUES(?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, commentaire.getDateCommentaire());
			stmt.setString(2, commentaire.getCommentaire());
			stmt.setString(3, commentaire.getNomCommentaire());
			stmt.setInt(4, commentaire.getArticle().getIdArticle());
			stmt.executeUpdate();
			
			ResultSet ids = stmt.getGeneratedKeys();
			if(ids.next()) {
				commentaire.setIdCommentaire(ids.getInt(1));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentaire;
	}

}
