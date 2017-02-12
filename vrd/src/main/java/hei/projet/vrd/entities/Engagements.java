package hei.projet.vrd.entities;

public class Engagements {
	
	private Integer idEngagements;
	private String titreEngagements;
	private String descriptifEngagements;
	
	public Engagements(Integer idEngagements, String titreEngagements, String descriptifEngagements) {
		super();
		this.setIdEngagements(idEngagements);
		this.setTitreEngagements(titreEngagements);
		this.setDescriptifEngagements(descriptifEngagements);
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

	public String getDescriptifEngagements() {
		return descriptifEngagements;
	}

	public void setDescriptifEngagements(String descriptifEngagements) {
		this.descriptifEngagements = descriptifEngagements;
	}

}
