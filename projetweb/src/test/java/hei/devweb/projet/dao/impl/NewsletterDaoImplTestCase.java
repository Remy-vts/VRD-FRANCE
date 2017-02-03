package hei.devweb.projet.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Test;

import org.assertj.core.api.Assertions;

import hei.devweb.projet.entities.Newsletter;

public class NewsletterDaoImplTestCase extends AbstractDaoTestCase{
	
	private NewsletterDaoImpl newsletterDao = new NewsletterDaoImpl();
	
	@Override
	public void insertDataSet(Statement statement) throws Exception {
			statement.executeUpdate("DELETE FROM newsletter");
			statement.executeUpdate("INSERT INTO `newsletter`(`id_inscription`,`mail`) VALUES (1,'remy.vitse@hei.fr')");
			statement.executeUpdate("INSERT INTO `newsletter`(`id_inscription`,`mail`) VALUES (2,'remy.vitse@hei.yncrea.fr')");
			statement.executeUpdate("INSERT INTO `newsletter`(`id_inscription`,`mail`) VALUES (3,'contact@baskets.fr')");
	}
	
	@Test
	public void shouldListNewsletters() {
		//WHEN
		List<Newsletter> newsletters = newsletterDao.listNewsletters();
		//THEN
		Assertions.assertThat(newsletters).hasSize(3);
		Assertions.assertThat(newsletters).extracting("idInscription","mail").containsOnly(
				Assertions.tuple(1,"remy.vitse@hei.fr"),
				Assertions.tuple(2,"remy.vitse@hei.yncrea.fr"),
				Assertions.tuple(3,"contact@baskets.fr"));
	}

	@Test
	public void shouldGetNewsletter() {
		// WHEN
		Newsletter newsletter = newsletterDao.getNewsletter(1);
		// THEN
		assertThat(newsletter).isNotNull();
		assertThat(newsletter.getIdInscription()).isEqualTo(1);
		assertThat(newsletter.getMail()).isEqualTo("remy.vitse@hei.fr");
	}
	
	@Test
	public void shouldAddNewsletter() throws Exception {
		// WHEN
		Newsletter newsletter = newsletterDao.addNewsletter("contact@test.fr");
		// THEN
		assertThat(newsletter.getIdInscription()).isNotNull();
		assertThat(newsletter.getMail()).isEqualTo("contact@test.fr");

		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM newsletter WHERE id_inscription = ?")) {
			stmt.setInt(1, newsletter.getIdInscription());
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isTrue();
				assertThat(rs.getInt("id_inscription")).isEqualTo(newsletter.getIdInscription());
				assertThat(rs.getString("mail")).isEqualTo("contact@test.fr");
				assertThat(rs.next()).isFalse();
			}
		}
	}

}
