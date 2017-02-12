package hei.projet.vrd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.vrd.entities.Engagements;

public class EngagementsDaoImpl {
	
	public List<Engagements> listEngagements() {
		List<Engagements> listEngagements = new ArrayList<>();
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt
					.executeQuery("SELECT * FROM engagements");
			while (resultSet.next()) {
				listEngagements.add(new Engagements(
						resultSet.getInt("idengagements"), 
						resultSet.getString("titre"),
						resultSet.getString("description")
						));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listEngagements;
	}
	
	public Engagements getEngagements(Integer id) {
		Engagements engagements = null;
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM engagements WHERE idengagements = ?");
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				engagements = new Engagements(
						resultSet.getInt("idengagements"), 
						resultSet.getString("titre"),
						resultSet.getString("description"));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return engagements;
	}

	public void updateEngagements(Integer idengagements, String description) {
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE engagements SET description='"+description+"' WHERE idengagements="+idengagements)){
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
