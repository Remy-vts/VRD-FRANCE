package hei.devweb.projet.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import hei.devweb.projet.entities.Article;
import hei.devweb.projet.entities.Categorie;
import hei.devweb.projet.entities.Commentaire;

public class CommentaireDaoImplTestCase extends AbstractDaoTestCase{
	
	private CommentaireDaoImpl commentaireDao = new CommentaireDaoImpl();

	@Override
	public void insertDataSet(Statement stmt) throws Exception {
			stmt.executeUpdate("DELETE FROM categorie");
			stmt.executeUpdate("DELETE FROM article");
			stmt.executeUpdate("DELETE FROM commentaire");
			stmt.executeUpdate("INSERT INTO `commentaire`(`id_commentaire`,`date_commentaire`,`commentaire`,`nom_commentaire`,`id_article`) VALUES (1,'2016-12-12','GENIAL','remy',1)");
			stmt.executeUpdate("INSERT INTO `commentaire`(`id_commentaire`,`date_commentaire`,`commentaire`,`nom_commentaire`,`id_article`) VALUES (2,'2016-10-10','Je les conseille','guillaume',1)");
	}
	
	@Test
	public void shouldListCommentaires() {
		//WHEN
		List<Commentaire> commentaires = commentaireDao.listCommentaires(1);
		//THEN
		Assertions.assertThat(commentaires).hasSize(2);
		Assertions.assertThat(commentaires).extracting("idCommentaire","dateCommentaire","commentaire","nomCommentaire","idArticle").containsOnly(
				Assertions.tuple(1,"2016-12-12","GENIAL","remy",1),
				Assertions.tuple(2,"2016-10-10","Je les conseille","guillaume",1));
	}
	
	@Test
	public void shouldGetCommentaire() {
		// WHEN
		
		Commentaire commentaire = commentaireDao.getCommentaire(1);
		// THEN
		assertThat(commentaire).isNotNull();
		assertThat(commentaire.getIdCommentaire()).isEqualTo(1);
		assertThat(commentaire.getDateCommentaire()).isEqualTo("2016-12-12");
		assertThat(commentaire.getCommentaire()).isEqualTo("GENIAL");
		assertThat(commentaire.getNomCommentaire()).isEqualTo("remy");
		assertThat(commentaire.getArticle()).isEqualTo(1);
	}
	
	@Test
	public void shouldAddCommentaire() throws Exception {
		// WHEN
		Categorie categorie = new Categorie(1,"Boots","presentation boots");
		Float prix= Float.parseFloat("119.00");
		Article article = new Article(1,"2016-10-11","Kaporal",prix,"Zalando","http://zalando.fr",categorie);
		Commentaire newCommentaire = new Commentaire(null, "2016-12-12", "mon commentaire", "mon nom", article);
		Commentaire commentaire = commentaireDao.addCommentaire(newCommentaire);
		// THEN
		assertThat(commentaire.getIdCommentaire()).isNotNull();
		assertThat(commentaire.getDateCommentaire()).isEqualTo("2016-12-12");
		assertThat(commentaire.getCommentaire()).isEqualTo("mon commentaire");
		assertThat(commentaire.getNomCommentaire()).isEqualTo("mon nom");
		assertThat(commentaire.getArticle()).isEqualTo("1");

		try (Connection connection = DataSourceProvider.getInstance().getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM newsletter WHERE id_inscription = ?")) {
			stmt.setInt(1, commentaire.getIdCommentaire());
			try (ResultSet rs = stmt.executeQuery()) {
				assertThat(rs.next()).isTrue();
				assertThat(rs.getInt("id_commentaire")).isEqualTo(commentaire.getIdCommentaire());
				assertThat(rs.getString("date_commentaire")).isEqualTo("2016-12-12");
				assertThat(rs.getString("commentaire")).isEqualTo("mon commentaire");
				assertThat(rs.getString("nom_commentaire")).isEqualTo("mon nom");
				assertThat(rs.getInt("id_article")).isEqualTo(1);
				assertThat(rs.next()).isFalse();
			}
		}
	}
	
	
}
