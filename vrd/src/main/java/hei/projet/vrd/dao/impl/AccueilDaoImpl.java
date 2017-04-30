package hei.projet.vrd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import hei.projet.vrd.entities.Accueil;

public class AccueilDaoImpl {
	
	public List<Accueil> listPhoto() {
		String query = "SELECT * FROM acceuil WHERE deleted='0'";
		List<Accueil> accueils = new ArrayList<>();
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(query)){
					while(resultSet.next()){
						
						Accueil accueil = new Accueil(
								resultSet.getInt("idphoto"), 
								resultSet.getString("url_photo")
								
								);
								
								accueils.add(accueil);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accueils;
	}
	
	public Accueil getPhoto(Integer id) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM accueil WHERE idphoto= ?", Statement.RETURN_GENERATED_KEYS)){
				statement.setInt(1,id);
				try(ResultSet resultSet = statement.executeQuery()){
					if(resultSet.next()){				
						return new Accueil(
								resultSet.getInt("idphoto"), 
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
	
	
	
	
	public void updatePhoto(Integer id, String photo) {
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE accueil SET  url_photo='"+photo+"' WHERE idphoto="+id)){
				statement.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

}
