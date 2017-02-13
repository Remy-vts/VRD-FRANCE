package hei.projet.vrd.entities;

public class Engagements {
	
	private Integer idEngagements;
	private String titreEngagements;
	private String descriptionEngagements;
	
	public Engagements(Integer idEngagements, String titreEngagements, String descriptionEngagements) {
		super();
		this.setIdEngagements(idEngagements);
		this.setTitreEngagements(titreEngagements);
		this.setDescriptionEngagements(descriptionEngagements);
	}

	public Integer getIdEngagements() {
		return idEngagements;
	}

	public void setIdEngagements(Integer idEngagements) {
		this.idEngagements = idEngagements;
	}

	public String getTitreEngagements() {
		return titreEngagements;
	}

	public void setTitreEngagements(String titreEngagements) {
		this.titreEngagements = titreEngagements;
	}

	public String getDescriptionEngagements() {
		return descriptionEngagements;
	}

	public void setDescriptionEngagements(String descriptionEngagements) {
		this.descriptionEngagements = descriptionEngagements;
	}

}
