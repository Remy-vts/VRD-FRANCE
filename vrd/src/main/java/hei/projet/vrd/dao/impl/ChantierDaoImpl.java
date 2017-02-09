package hei.projet.vrd.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projet.vrd.dao.ElementDao;
import hei.projet.vrd.entities.Element;


public class ElementDaoImpl implements ElementDao {

	@Override
	public List<Element> listElement() {
		String query = "SELECT * FROM element";
		List<Element> elements = new ArrayList<>();
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()){
			try(Statement statement = connection.createStatement()){
				try(ResultSet resultSet = statement.executeQuery(query)){
					while(resultSet.next()){
						
						Element element = new Element(
								resultSet.getInt("ID_element"), 
								resultSet.getString("url_photo"),
								resultSet.getString("titre"), 
								resultSet.getString("description"), 
								resultSet.getInt("ID_offre"), 
								resultSet.getInt("ID_chantier"), 
								resultSet.getInt("ID_presse")
								
								);
								
								elements.add(element);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return elements;
	}

	@Override
	public Element getElement(Integer id) {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection()){
			try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM element WHERE ID_element= ?", Statement.RETURN_GENERATED_KEYS)){
				statement.setInt(1,id);
				try(ResultSet resultSet = statement.executeQuery()){
					if(resultSet.next()){
												
						return new Element(
								resultSet.getInt("ID_element"), 
								resultSet.getString("url_photo"),
								resultSet.getString("titre"), 
								resultSet.getString("description"), 
								resultSet.getInt("ID_offre"), 
								resultSet.getInt("ID_chantier"), 
								resultSet.getInt("ID_presse")
								
								);
					}
				}
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Element addElement(Element element, String photoPath) {
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO `element`(`url_photo`,`titre`,`description`)VALUES(?,?,?);", Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, photoPath);
			stmt.setString(2, element.getTitre());
			stmt.setString(3, element.getDescription());
			
			stmt.executeUpdate();
			
			ResultSet ids = stmt.getGeneratedKeys();
			if(ids.next()) {
				element.setId(ids.getInt(1));
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return element;
	}
	
	public void updateElement(Integer id, String url, String titre, String description) {
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE element SET titre='"+titre+"', url_photo='"+url+"', desciption='"+description+"' WHERE ID_offre="+id)){
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

	public void deleteElement(Integer id) {
		try(Connection connection = DataSourceProvider.getDataSource().getConnection();
		PreparedStatement statement = connection.prepareStatement("UPDATE element SET deleted=1 WHERE ID_element=?")){
		statement.setInt(1,id);
		statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	
}

