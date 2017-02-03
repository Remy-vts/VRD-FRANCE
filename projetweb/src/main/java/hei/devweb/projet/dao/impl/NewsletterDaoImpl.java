package hei.devweb.projet.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.devweb.projet.dao.NewsletterDao;
import hei.devweb.projet.dao.impl.DataSourceProvider;
import hei.devweb.projet.entities.Newsletter;

public class NewsletterDaoImpl implements NewsletterDao {
	
	public List<Newsletter> listNewsletters() {
		String query = "SELECT * FROM newsletter";
		List<Newsletter> newsletters = new ArrayList<>();
		try(Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection()){
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(query)){
					while(resultSet.next()) {
						Newsletter newsletter = new Newsletter(
								resultSet.getInt("id_inscription"),
								resultSet.getString("mail"));
						newsletters.add(newsletter);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return newsletters;
	}
	
	@Override
	public Newsletter getNewsletter(Integer id) {
		Newsletter newsletter = null;
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM newsletter WHERE id_inscription = ?");
			stmt.setInt(1, id);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()) {
				newsletter = new Newsletter(
						resultSet.getInt("id_inscription"), 
						resultSet.getString("mail"));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsletter;
	}
	
	public Newsletter addNewsletter(String mail) {
		Newsletter newsletter = null;
		try {
			Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO newsletter(mail) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, mail);
			stmt.executeUpdate();
			
			ResultSet ids = stmt.getGeneratedKeys();
			if(ids.next()) {
				newsletter = new Newsletter(ids.getInt(1), mail);
			}
			
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newsletter;
	}

}
