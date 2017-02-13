package hei.projet.vrd.entities;
//
public class Metier {
	
	private Integer idMetier;
	private String titreMetier;
	private String photoMetier;
	private String descriptifMetier;
	
	public Metier(Integer idMetier, String titreMetier, String photoMetier, String descriptifMetier) {
		super();
		this.setIdMetier(idMetier);
		this.setTitreMetier(titreMetier);
		this.setPhotoMetier(photoMetier);
		this.setDescriptifMetier(descriptifMetier);
	}

	public Integer getIdMetier() {
		return idMetier;
	}

	public void setIdMetier(Integer idMetier) {
		this.idMetier = idMetier;
	}

	public String getTitreMetier() {
		return titreMetier;
	}

	public void setTitreMetier(String titreMetier) {
		this.titreMetier = titreMetier;
	}

	public String getPhotoMetier() {
		return photoMetier;
	}

	public void setPhotoMetier(String photoMetier) {
		this.photoMetier = photoMetier;
	}

	public String getDescriptifMetier() {
		return descriptifMetier;
	}

	public void setDescriptifMetier(String descriptifMetier) {
		this.descriptifMetier = descriptifMetier;
	}

}
