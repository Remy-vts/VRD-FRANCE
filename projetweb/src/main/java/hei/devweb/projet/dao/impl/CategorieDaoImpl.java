package hei.devweb.projet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.projet.dao.CategorieDao;
import hei.devweb.projet.entities.Categorie;

public class CategorieDaoImpl implements CategorieDao{

	public List<Categorie> listCategories() {
		String query = "SELECT * FROM categorie";
		List<Categorie> categories = new ArrayList<>();
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(query)){
					while(resultSet.next()) {
						Categorie categorie = new Categorie(
								resultSet.getInt("id_categorie"),
								resultSet.getString("nom_categorie"),
								resultSet.getString("description_categorie"));
						categories.add(categorie);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return categories;
	}
	
	@Override
	public Categorie getCategorie(Integer id) {
		Categorie categorie = null;
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM categorie WHERE id_categorie = ?");
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				categorie = new Categorie(
						resultSet.getInt("id_categorie"), 
						resultSet.getString("nom_categorie"),
						resultSet.getString("description_categorie"));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorie;
	}

	public Categorie addCategorie(String nom, String description) {
		Categorie categorie = null;
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO categorie(nom_categorie, description_categorie) VALUES(?, ?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, nom);
			stmt.setString(2, description);
			stmt.executeUpdate();
			
			ResultSet ids = stmt.getGeneratedKeys();
			if(ids.next()) {
				categorie = new Categorie(ids.getInt(1), nom, description);
			}
			
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categorie;
	}

}

