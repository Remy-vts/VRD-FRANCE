package hei.projet.vrd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.vrd.dao.ChantierDao;
import hei.projet.vrd.entities.Chantier;


public class ChantierDaoImpl implements ChantierDao {

	@Override
	public List<Chantier> listChantier() {
		String query = "SELECT * FROM chantier WHERE deleted='0'";
		List<Chantier> chantiers = new ArrayList<>();
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(query)){
					while(resultSet.next()){
						
						Chantier chantier = new Chantier(
								resultSet.getInt("ID_chantier"), 
								resultSet.getString("ville"),
								resultSet.getInt("code_postal"), 
								resultSet.getString("date_chantier"), 
								resultSet.getString("maitre_ouvrage"), 
								resultSet.getString("client"),
								resultSet.getString("titre"), 
								resultSet.getString("description")
								);
								
								chantiers.add(chantier);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chantiers;
	}
	
	@Override
	public List<Chantier> listChantierAccueil() {
		String query = "SELECT * FROM chantier WHERE deleted='0' LIMIT 3";
		List<Chantier> chantiers = new ArrayList<>();
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(query)){
					while(resultSet.next()){
						
						Chantier chantier = new Chantier(
								resultSet.getInt("ID_chantier"), 
								resultSet.getString("ville"),
								resultSet.getInt("code_postal"), 
								resultSet.getString("date_chantier"), 
								resultSet.getString("maitre_ouvrage"), 
								resultSet.getString("client"),
								resultSet.getString("titre"), 
								resultSet.getString("description")
								);
								
								chantiers.add(chantier);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chantiers;
	}

	@Override
	public Chantier getChantier(Integer id) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM chantier WHERE ID_chantier= ?", Statement.RETURN_GENERATED_KEYS)){
				statement.setInt(1,id);
				try(ResultSet resultSet = statement.executeQuery()){
					if(resultSet.next()){				
						return new Chantier(
								resultSet.getInt("ID_chantier"), 
								resultSet.getString("ville"),
								resultSet.getInt("code_postal"), 
								resultSet.getString("date_chantier"), 
								resultSet.getString("maitre_ouvrage"),
								resultSet.getString("client"),
								resultSet.getString("titre"), 
								resultSet.getString("description")
								);
					}
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Chantier addChantier(Chantier chantier) {
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `chantier`(`ville`,`code_postal`,`date_chantier`,`maitre_ouvrage`,`client`,`titre`,`description`)VALUES(?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, chantier.getVille());
			stmt.setInt(2, chantier.getCode_postal());
			stmt.setString(3, chantier.getDate());
			stmt.setString(4, chantier.getMaitre_ouvrage());
			stmt.setString(5, chantier.getClient());
			stmt.setString(6, chantier.getTitre());
			stmt.setString(7, chantier.getDescription());
			
			stmt.executeUpdate();
			
			ResultSet ids = stmt.getGeneratedKeys();
			if(ids.next()) {
				chantier.setId(ids.getInt(1));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chantier;
	}
	
	public void updateChantier(Integer id, String titre, String ville, Integer code_postal, String maitre_ouvrage, String client, String description) {
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE chantier SET  titre='"+titre+"',ville='"+ville+"',code_postal='"+code_postal+"',maitre_ouvrage='"+maitre_ouvrage+"', client='"+client+"', titre='"+titre+"', description='"+description+"' WHERE ID_chantier="+id)){
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getPhotoPath(Integer id){
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT url_photo FROM chantier"
					+ "WHERE id_chantier=? AND deleted='0'");
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				return resultSet.getString("url_photo");
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public void deleteChantier(Integer id) {
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE chantier SET deleted=1 WHERE ID_chantier=?")){
		statement.setInt(1,id);
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

