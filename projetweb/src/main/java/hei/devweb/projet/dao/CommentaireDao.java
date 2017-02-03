package hei.devweb.projet.dao;

import java.util.List;

import hei.devweb.projet.entities.Commentaire;

public interface CommentaireDao {
	
	public List<Commentaire> listCommentaires(Integer idArticle);
	
	public Commentaire getCommentaire(Integer idArticle);

	public Commentaire addCommentaire(Commentaire commentaire);
}
