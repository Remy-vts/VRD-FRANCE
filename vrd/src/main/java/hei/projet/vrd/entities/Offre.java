package hei.projet.vrd.entities;

public class Offre {

	private Integer idOffre;
	private String referenceOffre;
	private String dateOffre;
	private String titreOffre;
	private String missionOffre;
	
	public Offre(Integer idOffre, String referenceOffre, String dateOffre, String titreOffre, String missionOffre) {
		super();
		this.setIdOffre(idOffre);
		this.setReferenceOffre(referenceOffre);
		this.setDateOffre(dateOffre);
		this.setTitreOffre(titreOffre);
		this.setMissionOffre(missionOffre);
	}

	public Integer getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(Integer idOffre) {
		this.idOffre = idOffre;
	}

	public String getReferenceOffre() {
		return referenceOffre;
	}

	public void setReferenceOffre(String referenceOffre) {
		this.referenceOffre = referenceOffre;
	}

	public String getDateOffre() {
		return dateOffre;
	}

	public void setDateOffre(String dateOffre) {
		this.dateOffre = dateOffre;
	}

	public String getTitreOffre() {
		return titreOffre;
	}

	public void setTitreOffre(String titreOffre) {
		this.titreOffre = titreOffre;
	}

	public String getMissionOffre() {
		return missionOffre;
	}

	public void setMissionOffre(String missionOffre) {
		this.missionOffre = missionOffre;
	}
}
