package hei.devweb.projet.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import hei.devweb.projet.entities.Categorie;

public class CategorieDaoImplTestCase extends AbstractDaoTestCase{

private CategorieDaoImpl categorieDao = new CategorieDaoImpl();
	
	@Override
	public void insertDataSet(Statement stmt) throws Exception {
			stmt.executeUpdate("DELETE FROM commentaire");
			stmt.executeUpdate("DELETE FROM article");
			stmt.executeUpdate("DELETE FROM categorie");
			stmt.executeUpdate("INSERT INTO `categorie`(`id_categorie`,`nom_categorie`,`description_categorie`) VALUES (1,'Boots','presentation boots')");
			stmt.executeUpdate("INSERT INTO `categorie`(`id_categorie`,`nom_categorie`,`description_categorie`) VALUES (2,'Richelieu','presentation richelieu')");
			stmt.executeUpdate("INSERT INTO `categorie`(`id_categorie`,`nom_categorie`,`description_categorie`) VALUES (3,'Derbies','presentation derbies')");
			stmt.executeUpdate("INSERT INTO `categorie`(`id_categorie`,`nom_categorie`,`description_categorie`) VALUES (4,'Mocassins','presentation mocassins')");
			stmt.executeUpdate("INSERT INTO `categorie`(`id_categorie`,`nom_categorie`,`description_categorie`) VALUES (5,'Desert Boots','presentation desert boots')");
			stmt.executeUpdate("INSERT INTO `categorie`(`id_categorie`,`nom_categorie`,`description_categorie`) VALUES (6,'Baskets','presentation baskets')");
	}
	
	@Test
	public void shouldListCategories() {
		//WHEN
		List<Categorie> categories = categorieDao.listCategories();
		//THEN
		Assertions.assertThat(categories).hasSize(6);
		Assertions.assertThat(categories).extracting("idCategorie","nomCategorie","descriptionCategorie").containsOnly(
				Assertions.tuple(1,"Boots","presentation boots"),
				Assertions.tuple(2,"Richelieu","presentation richelieu"),
				Assertions.tuple(3,"Derbies","presentation derbies"),
				Assertions.tuple(4,"Mocassins","presentation mocassins"),
				Assertions.tuple(5,"Desert Boots","presentation desert boots"),
				Assertions.tuple(6,"Baskets","presentation baskets"));
	}
	
	@Test
	public void shouldGetCategorie() {
		// WHEN
		Categorie categorie = categorieDao.getCategorie(1);
		// THEN
		assertThat(categorie).isNotNull();
		assertThat(categorie.getIdCategorie()).isEqualTo(1);
		assertThat(categorie.getNomCategorie()).isEqualTo("Boots");
		assertThat(categorie.getDescriptionCategorie()).isEqualTo("presentation boots");
		
	}

	@Test
	public void shouldAddCategorie() throws Exception {
		// WHEN
		Categorie categorie = categorieDao.addCategorie("NouvelleCategorie", "Description");
		// THEN
		assertThat(categorie.getIdCategorie()).isNotNull();
		assertThat(categorie.getNomCategorie()).isEqualTo("NouvelleCategorie");
		assertThat(categorie.getDescriptionCategorie()).isEqualTo("Description");

		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM categorie WHERE id_categorie = ?")) {
			stmt.setInt(1, categorie.getIdCategorie());
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isTrue();
				assertThat(rs.getInt("id_categorie")).isEqualTo(categorie.getIdCategorie());
				assertThat(rs.getString("nom_categorie")).isEqualTo("NouvelleCategorie");
				assertThat(rs.getString("description_categorie")).isEqualTo("Description");
				assertThat(rs.next()).isFalse();
			}
		}
	}
}
