package hei.projet.vrd.entities;

public class Dirigeant {

	private Integer ID_individu;
	private String nom;
	private String fonction;
	private String description;
	private String url_photo;
	
	public Dirigeant(Integer iD_individu, String nom, String fonction, String description, String url_photo) {
		super();
		ID_individu = iD_individu;
		this.nom = nom;
		this.fonction = fonction;
		this.description = description;
		this.url_photo = url_photo;
	}

	public Integer getID_individu() {
		return ID_individu;
	}

	public void setID_individu(Integer iD_individu) {
		ID_individu = iD_individu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl_photo() {
		return url_photo;
	}

	public void setUrl_photo(String url_photo) {
		this.url_photo = url_photo;
	}
	
	
	
	
	
	
}
