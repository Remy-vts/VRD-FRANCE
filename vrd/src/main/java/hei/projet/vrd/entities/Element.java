package hei.projet.vrd.entities;

public class Element {
	private Integer id;
	private String url;
	private String titre;
	private String description;	
	private Integer id_offre;
	private Integer id_chantier;
	private Integer id_presse;
	
	public Element(Integer id, String url, String titre, String description, Integer id_offre, Integer id_chantier,
			Integer id_presse) {
		super();
		this.id = id;
		this.url = url;
		this.titre = titre;
		this.description = description;
		this.id_offre = id_offre;
		this.id_chantier = id_chantier;
		this.id_presse = id_presse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public Integer getId_offre() {
		return id_offre;
	}

	public void setId_offre(Integer id_offre) {
		this.id_offre = id_offre;
	}

	public Integer getId_chantier() {
		return id_chantier;
	}

	public void setId_chantier(Integer id_chantier) {
		this.id_chantier = id_chantier;
	}

	public Integer getId_presse() {
		return id_presse;
	}

	public void setId_presse(Integer id_presse) {
		this.id_presse = id_presse;
	}
	
	
	
}