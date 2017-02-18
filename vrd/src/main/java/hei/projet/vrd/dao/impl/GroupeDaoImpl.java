package hei.projet.vrd.dao.impl;
//
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.vrd.entities.Groupe;

public class GroupeDaoImpl {
	
	public List<Groupe> listGroupe() {
		String query = "SELECT * FROM element";
		List<Groupe> groupes = new ArrayList<>();
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(query)){
					while(resultSet.next()){
						
						Groupe groupe = new Groupe(
								resultSet.getInt("ID_element"), 
								resultSet.getString("description")
								);
								
								groupes.add(groupe);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return groupes;
	}

	public Groupe getGroupe(Integer id) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM element WHERE ID_element= ?", Statement.RETURN_GENERATED_KEYS)){
				statement.setInt(1,id);
				try(ResultSet resultSet = statement.executeQuery()){
					if(resultSet.next()){				
						return new Groupe(
								resultSet.getInt("ID_element"), 
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
	
	public void updateGroupe(Integer ID_element, String description) {
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE element SET description='"+description+"'' WHERE ID_element="+ID_element)){
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getPhotoPath(Integer id){
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT photo FROM element"
					+ "WHERE ID_element=?");
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
