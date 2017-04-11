package hei.projet.vrd.entities;

public class Presse {
	private Integer ID_presse;
	private String nom_media;	
	private String date_publication;
	private String lien;
	private String titre;
	private String description;
	private String url_photo;
	
	public Presse(Integer iD_presse, String nom_media, String date_publication, String lien, String titre, String description, String url_photo) {
		super();
		this.ID_presse = iD_presse;
		this.nom_media = nom_media;
		this.date_publication = date_publication;
		this.lien = lien;
		this.titre = titre;
		this.description = description;
		this.url_photo = url_photo;
		
	}
	

	public String getUrl_photo() {
		return url_photo;
	}


	public void setUrl_photo(String url_photo) {
		this.url_photo = url_photo;
	}


	public Integer getID_presse() {
		return ID_presse;
	}

	public void setID_presse(Integer iD_presse) {
		ID_presse = iD_presse;
	}

	public String getNom_media() {
		return nom_media;
	}

	public void setNom_media(String nom_media) {
		this.nom_media = nom_media;
	}

	public String getDate_publication() {
		return date_publication;
	}

	public void setDate_publication(String date_publication) {
		this.date_publication = date_publication;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	
	
	
}
