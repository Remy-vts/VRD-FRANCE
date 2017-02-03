package hei.devweb.projet.entities;

public class Commentaire {

	private Integer idCommentaire;
	private String dateCommentaire;
	private String commentaire;
	private String nomCommentaire;
	private Article article;
	
	public Commentaire(
			Integer idCommentaire, 
			String dateCommentaire, 
			String commentaire,
			String nomCommentaire, 
			Article article) {
		super();
		this.idCommentaire = idCommentaire;
		this.dateCommentaire = dateCommentaire;
		this.commentaire = commentaire;
		this.nomCommentaire = nomCommentaire;
		this.article = article;
	}

	public Integer getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(Integer idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getDateCommentaire() {
		return dateCommentaire;
	}

	public void setDateCommentaire(String dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getNomCommentaire() {
		return nomCommentaire;
	}

	public void setNomCommentaire(String nomCommentaire) {
		this.nomCommentaire = nomCommentaire;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
	
}
