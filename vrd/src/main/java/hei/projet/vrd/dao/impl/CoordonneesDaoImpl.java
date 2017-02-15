package hei.projet.vrd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import hei.projet.vrd.entities.Coordonnees;

public class CoordonneesDaoImpl {
	
	public Coordonnees getCoordonnees(Integer id){
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM coordonnees WHERE ID_coordonnees='"+id, Statement.RETURN_GENERATED_KEYS)){
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
	
	public void updateCoordonnees(Integer id, String mail, String telephone, String adresse, String ville, String codepostal){
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE coordonnees SET  mail='"+mail+"',telephone='"+telephone+"',adresse='"+adresse+"',ville='"+ville+"', code_postal='"+codepostal+"' WHERE ID_coordonnees="+id)){
				statement.executeUpdate();
				} catch (SQLException e) {
					e.printStackTrace();
				}
	}


}
