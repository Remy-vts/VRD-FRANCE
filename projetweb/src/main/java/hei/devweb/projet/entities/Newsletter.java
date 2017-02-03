package hei.devweb.projet.entities;

public class Newsletter {

	private Integer idInscription;
	private String mail;
	
	public Newsletter(Integer idInscription, String mail) {
		super();
		this.idInscription = idInscription;
		this.mail = mail;
	}

	public Integer getIdInscription() {
		return idInscription;
	}

	public void setIdInscription(Integer idInscription) {
		this.idInscription = idInscription;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
}
