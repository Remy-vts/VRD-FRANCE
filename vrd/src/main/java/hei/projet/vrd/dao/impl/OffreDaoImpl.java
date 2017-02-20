package hei.projet.vrd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.vrd.entities.Offre;

public class OffreDaoImpl {

	public List<Offre>  listOffre(){
		String query = "SELECT * FROM offre WHERE deleted='0'";
		List<Offre> offres = new ArrayList<>();
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(query)){
					while(resultSet.next()){
						
						Offre offre = new Offre(
								resultSet.getInt("ID_offre"), 
								resultSet.getString("reference"), 
								resultSet.getString("date_offre"), 
								resultSet.getString("titre"),
								resultSet.getString("mission")
								);
								
								offres.add(offre);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offres;
	}

	public Offre getOffre(Integer id) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM offre WHERE ID_offre= ?", Statement.RETURN_GENERATED_KEYS)){
				statement.setInt(1,id);
				try(ResultSet resultSet = statement.executeQuery()){
					if(resultSet.next()){				
						return new Offre(
								resultSet.getInt("ID_offre"), 
								resultSet.getString("reference"), 
								resultSet.getString("date_offre"), 
								resultSet.getString("titre"),
								resultSet.getString("mission")
								);
					}
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateOffre(Integer idOffre, String referenceOffre, String titreOffre, String missionOffre){
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE offre SET  reference='"+referenceOffre+"', titre='"+titreOffre+"',mission='"+missionOffre+"' WHERE ID_offre="+idOffre)){
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Offre addOffre(Offre offre){
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `offre`(`reference`,`date_offre`,`titre`,`mission`)VALUES(?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, offre.getReferenceOffre());
			stmt.setString(2, offre.getDateOffre());
			stmt.setString(3, offre.getTitreOffre());
			stmt.setString(4, offre.getMissionOffre());
			
			stmt.executeUpdate();
			
			ResultSet ids = stmt.getGeneratedKeys();
			if(ids.next()) {
				offre.setIdOffre(ids.getInt(1));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return offre;
	}
	
	public void deleteOffre(Integer id){
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE offre SET deleted=1 WHERE ID_offre=?")){
		statement.setInt(1,id);
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
