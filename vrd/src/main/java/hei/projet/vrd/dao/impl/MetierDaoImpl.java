package hei.projet.vrd.dao.impl;
//
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.vrd.entities.Metier;

public class MetierDaoImpl {
	
	public List<Metier> listMetier() {
		String query = "SELECT * FROM metiers";
		List<Metier> metiers = new ArrayList<>();
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(query)){
					while(resultSet.next()){
						
						Metier metier = new Metier(
								resultSet.getInt("idmetiers"), 
								resultSet.getString("titre"), 
								resultSet.getString("photo"), 
								resultSet.getString("descriptif")
								);
								
								metiers.add(metier);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return metiers;
	}

	public Metier getMetier(Integer id) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM metiers WHERE idmetiers= ?", Statement.RETURN_GENERATED_KEYS)){
				statement.setInt(1,id);
				try(ResultSet resultSet = statement.executeQuery()){
					if(resultSet.next()){				
						return new Metier(
								resultSet.getInt("idmetiers"),
								resultSet.getString("titre"), 
								resultSet.getString("photo"), 
								resultSet.getString("descriptif")
								);
					}
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateMetier(Integer idmetiers, String titre, String photo, String descriptif) {
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE metiers SET titre='"+titre+"',photo='"+photo+"',descriptif='"+descriptif+"' WHERE idmetiers="+idmetiers)){
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getPhotoPath(Integer id){
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT photo FROM metiers"
					+ "WHERE idmetiers=?");
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

}