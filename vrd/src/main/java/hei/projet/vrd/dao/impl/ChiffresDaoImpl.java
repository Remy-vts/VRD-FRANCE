package hei.projet.vrd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.vrd.dao.ChiffresDao;
import hei.projet.vrd.entities.Chantier;
import hei.projet.vrd.entities.Chiffres;


public class ChiffresDaoImpl implements ChiffresDao {

	@Override
	public List<Chiffres> listChiffres() {
		String query = "SELECT * FROM chiffres";
		List<Chiffres> chiffres = new ArrayList<>();
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(query)){
					while(resultSet.next()){
						
						Chiffres chiffre = new Chiffres(
								resultSet.getInt("idchiffres"), 
								resultSet.getString("titre"),
								resultSet.getInt("chiffre")
								);
								
								chiffres.add(chiffre);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chiffres;
	}
	
	@Override
	public Chiffres getChiffres(Integer id) {
		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM chiffres WHERE idchiffres= ?", Statement.RETURN_GENERATED_KEYS)){
				statement.setInt(1,id);
				try(ResultSet resultSet = statement.executeQuery()){
					if(resultSet.next()){				
						return new Chiffres(
								resultSet.getInt("idchiffres"), 
								resultSet.getString("titre"),
								resultSet.getInt("chiffre")															
								);
					}
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void updateChiffres(Integer id, String titre, Integer chiffres) {
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE chiffres SET  titre='"+titre+"',chiffre='"+chiffres+" WHERE idchiffresr="+id)){
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

