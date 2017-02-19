package hei.projet.vrd.entities;

public class Chantier {
	private Integer id;
	private String ville;
	private int code_postal;
	private String date;
	private String maitre_ouvrage;
	private String client;
	private String titre;
	private String description;
	
	public Chantier(Integer id, String ville, int code_postal, String date, String maitre_ouvrage, String client,
			String titre, String description) {
		super();
		this.id = id;
		this.ville = ville;
		this.code_postal = code_postal;
		this.date = date;
		this.maitre_ouvrage = maitre_ouvrage;
		this.client = client;
		this.titre = titre;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public int getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(int code_postal) {
		this.code_postal = code_postal;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMaitre_ouvrage() {
		return maitre_ouvrage;
	}

	public void setMaitre_ouvrage(String maitre_ouvrage) {
		this.maitre_ouvrage = maitre_ouvrage;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
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
	
	
	