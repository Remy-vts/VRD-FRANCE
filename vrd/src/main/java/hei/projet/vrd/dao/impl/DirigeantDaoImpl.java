package hei.projet.vrd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.vrd.entities.Dirigeant;



public class DirigeantDaoImpl {

	public List<Dirigeant> listDirigeant() {
		String query = "SELECT * FROM dirigeant";
		List<Dirigeant> dirigeants = new ArrayList<>();
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(query)){
					while(resultSet.next()){
						
						Dirigeant dirigeant = new Dirigeant(
								resultSet.getInt("ID_individu"), 
								resultSet.getString("nom"), 
								resultSet.getString("fonction"), 
								resultSet.getString("presentation"),
								resultSet.getString("url_photo")
								);
								
								dirigeants.add(dirigeant);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dirigeants;
	}

	public Dirigeant getDirigeant(Integer id) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM dirigeant WHERE ID_infividu= ?", Statement.RETURN_GENERATED_KEYS)){
				statement.setInt(1,id);
				try(ResultSet resultSet = statement.executeQuery()){
					if(resultSet.next()){				
						return new Dirigeant(
								resultSet.getInt("ID_individu"), 
								resultSet.getString("nom"), 
								resultSet.getString("fonction"), 
								resultSet.getString("presentation"),
								resultSet.getString("url_photo")
								);
					}
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateDirigeant(Integer ID_individu, String nom, String fonction, String presentation, String url_photo) {
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE dirigeant SET nom='"+nom+"',fonction='"+fonction+"',presentation='"+presentation+"',url_photo='"+url_photo+"' WHERE ID_individu="+ID_individu)){
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getPhotoPath(Integer id){
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT url_photo FROM dirigeant"
					+ "WHERE ID_individu=?");
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

	
	
}
