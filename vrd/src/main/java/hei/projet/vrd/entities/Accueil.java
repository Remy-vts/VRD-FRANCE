package hei.projet.vrd.entities;

public class Accueil {
	Integer id;
	String photo;
	
	public Accueil(Integer id, String photo) {
		super();
		this.id = id;
		this.photo = photo;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	

}
