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
								resultSet.getInt("idaccueil"), 
								resultSet.getString("url_deconstruction"),
								resultSet.getString("url_desamiantage"),
								resultSet.getString("url_recyclage"),
								resultSet.getString("url_sciage"),
								resultSet.getString("url_terrassement"),
								resultSet.getString("url_vrd"),
								resultSet.getString("url_equipe"),
								resultSet.getString("url_bandeau")
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
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM accueil WHERE idaccueil= ?", Statement.RETURN_GENERATED_KEYS)){
				statement.setInt(1,id);
				try(ResultSet resultSet = statement.executeQuery()){
					if(resultSet.next()){				
						return new Accueil(
								resultSet.getInt("idaccueil"), 
								resultSet.getString("url_deconstruction"),
								resultSet.getString("url_desamiantage"),
								resultSet.getString("url_recyclage"),
								resultSet.getString("url_sciage"),
								resultSet.getString("url_terrassement"),
								resultSet.getString("url_vrd"),
								resultSet.getString("url_equipe"),
								resultSet.getString("url_bandeau")
								);
					}
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Accueil addPhoto(Accueil accueil, String photo1, String photo2, String photo3, String photo4, String photo5, String photo6, String photo7, String photo8) {
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `accueil`(`url_deconstruction`,`url_desamiantage`,`url_recyclage`,`url_sciage`,`url_terrassement`,`url_vrd`,`url_equipe`,`url_bandeau`)VALUES(?,?,?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, photo1);
			stmt.setString(2, photo2);
			stmt.setString(3, photo3);
			stmt.setString(4, photo4);
			stmt.setString(5, photo5);
			stmt.setString(6, photo6);
			stmt.setString(7, photo7);
			stmt.setString(8, photo8);
			
			stmt.executeUpdate();
			
			ResultSet ids = stmt.getGeneratedKeys();
			if(ids.next()) {
				accueil.setId(ids.getInt(1));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return accueil;
	}
	
	
	public void updatePhoto(Integer id, String photo1, String photo2, String photo3, String photo4, String photo5, String photo6, String photo7, String photo8) {
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE accueil SET  url_deconstruction='"+photo1+"',url_desamiantage='"+photo2+"',url_recyclage='"+photo3+"',url_sciage='"+photo4+"',url_terrassement='"+photo5+"',url_vrd='"+photo6+"',url_equipe='"+photo7+"',url_bandeau='"+photo8+"' WHERE idaccueil="+id)){
				statement.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}

}
