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
		String query = "SELECT * FROM dirigeant WHERE deleted=0";
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
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM dirigeant WHERE ID_individu= ?", Statement.RETURN_GENERATED_KEYS)){
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
	
		
	
	
	
	public Dirigeant addDirigeant(Dirigeant dirigeant, String picture) {
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `dirigeant`(`nom`,`fonction`,`presentation`)VALUES(?,?,?);", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, dirigeant.getNom());
			stmt.setString(2, dirigeant.getFonction());
			stmt.setString(3, dirigeant.getDescription());
			
			
			stmt.executeUpdate();
			
			ResultSet ids = stmt.getGeneratedKeys();
			if(ids.next()) {
				dirigeant.setID_individu(ids.getInt(1));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dirigeant;
	}
	
	public void updateDirigeant(Dirigeant dir) {
		try{
		
				Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement stmt = connection.prepareStatement("UPDATE dirigeant SET  nom=?,fonction=?,presentation=?,url_photo=? WHERE ID_individu=?");
				stmt.setString(1, dir.getNom());
				stmt.setString(2, dir.getFonction());
				stmt.setString(3, dir.getDescription());
				stmt.setString(4, dir.getUrl_photo());
				stmt.setInt(5, dir.getID_individu());	
			    stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void deleteDirigeant(Integer id) {
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE dirigeant SET deleted=1 WHERE ID_individu=?")){
		statement.setInt(1,id);
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	
	
}
