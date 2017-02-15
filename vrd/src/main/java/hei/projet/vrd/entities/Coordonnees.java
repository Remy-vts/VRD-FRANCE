package hei.projet.vrd.entities;

public class Coordonnees {
	
	private Integer id;
	private String mail;
	private String telephone;
	private String adresse;
	private String ville;
	private String codepostal;

	public Coordonnees(Integer id, String mail, String telephone, String adresse, String ville, String codepostal) {
		super();
		this.id = id;
		this.mail = mail;
		this.telephone = telephone;
		this.adresse = adresse;
		this.ville = ville;
		this.codepostal = codepostal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodepostal() {
		return codepostal;
	}

	public void setCodepostal(String codepostal) {
		this.codepostal = codepostal;
	}
}
