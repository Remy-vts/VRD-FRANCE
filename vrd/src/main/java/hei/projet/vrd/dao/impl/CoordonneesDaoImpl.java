package hei.projet.vrd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hei.projet.vrd.dao.CoordonneesDao;
import hei.projet.vrd.entities.Coordonnees;

public class CoordonneesDaoImpl implements CoordonneesDao{
	
	public Coordonnees getCoordonnees(Integer id){
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM coordonnees WHERE ID_coordonnees= ?", Statement.RETURN_GENERATED_KEYS)){
				statement.setInt(1,id);
				try(ResultSet resultSet = statement.executeQuery()){
					if(resultSet.next()){				
						return new Coordonnees(
								resultSet.getInt("ID_coordonnees"), 
								resultSet.getString("mail"),
								resultSet.getString("telephone"), 
								resultSet.getString("adresse"), 
								resultSet.getString("ville"),
								resultSet.getString("code_postal")
								);
					}
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateCoordonnees(String mail, String telephone){
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE coordonnees SET  mail='"+mail+"',telephone='"+telephone+"' WHERE ID_coordonnees='1'")){
				statement.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}


}
