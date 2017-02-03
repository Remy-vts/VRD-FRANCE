package hei.devweb.projet.entities;

public class Article {
	
		private Integer idArticle;
		private String datePublication;
		private String marque;
		private Float prix;
		private String site;
		private String lien;
		private Categorie categorie;

		public Article(Integer idArticle, String datePublication, String marque, Float prix, String site, 
				String lien, Categorie categorie) {
			super();
			this.idArticle = idArticle;
			this.datePublication = datePublication;
			this.marque = marque;
			this.prix = prix;
			this.site = site;
			this.lien = lien;
			this.categorie = categorie;
		}

		public Integer getIdArticle() {
			return idArticle;
		}

		public void setIdArticle(Integer idArticle) {
			this.idArticle = idArticle;
		}
		
		public String getDatePublication() {
			return datePublication;
		}

		public void setDatePublication(String datePublication) {
			this.datePublication = datePublication;
		}
		
		public String getMarque() {
			return marque;
		}

		public void setMarque(String marque) {
			this.marque = marque;
		}

		public Float getPrix() {
			return prix;
		}

		public void setPrix(Float prix) {
			this.prix = prix;
		}

		public String getSite() {
			return site;
		}

		public void setSite(String site) {
			this.site = site;
		}

		public String getLien() {
			return lien;
		}

		public void setLien(String lien) {
			this.lien = lien;
		}

		public Categorie getCategorie() {
			return categorie;
		}

		public void setCategorie(Categorie categorie) {
			this.categorie = categorie;
		}

	}