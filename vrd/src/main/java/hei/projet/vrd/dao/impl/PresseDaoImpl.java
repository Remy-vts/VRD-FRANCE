package hei.projet.vrd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.vrd.dao.PresseDao;
import hei.projet.vrd.entities.Presse;

public class PresseDaoImpl implements PresseDao {

	@Override
	public List<Presse> listPresse() {
		String query = "SELECT * FROM presse";
		List<Presse> presses = new ArrayList<>();
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(query)){
					while(resultSet.next()){
						
						Presse presse = new Presse(
								resultSet.getInt("ID_presse"), 
								resultSet.getString("nom_media"),
								resultSet.getString("date_publication"), 
								resultSet.getString("lien"),
								resultSet.getString("titre"), 
								resultSet.getString("description")
								);
								
								presses.add(presse);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return presses;
	}

	@Override
	public Presse getPresse(Integer id) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM presse WHERE ID_presse= ?", Statement.RETURN_GENERATED_KEYS)){
				statement.setInt(1,id);
				try(ResultSet resultSet = statement.executeQuery()){
					if(resultSet.next()){				
						return new Presse(
								resultSet.getInt("ID_presse"), 
								resultSet.getString("nom_media"),
								resultSet.getString("date_publication"), 
								resultSet.getString("lien"),
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
	public Presse addPresse(Presse presse) {
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `presse`(`nom_media`,`date_publication`,`lien`,`titre`,`description`)VALUES(?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, presse.getNom_media());
			stmt.setString(2, presse.getDate_publication());
			stmt.setString(3, presse.getLien());
			stmt.setString(4, presse.getTitre());
			stmt.setString(5, presse.getDescription());
			
			stmt.executeUpdate();
			
			ResultSet ids = stmt.getGeneratedKeys();
			if(ids.next()) {
				presse.setID_presse(ids.getInt(1));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return presse;
	}

	

	@Override
	public String getPhotoPath(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePresse(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePresse(Integer ID_presse, String nom_media, String date_publication, String lien, String titre,
			String description) {
		// TODO Auto-generated method stub
		
	}
	


	



	
	
	
	
}

