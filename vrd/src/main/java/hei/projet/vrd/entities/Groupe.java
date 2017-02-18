package hei.projet.vrd.entities;

public class Groupe {
	
	private Integer ID_element;
	private String description;
	
	public Groupe(Integer iD_element, String description) {
		super();
		ID_element = iD_element;
		this.description = description;
	}

	public Integer getID_element() {
		return ID_element;
	}

	public void setID_element(Integer iD_element) {
		ID_element = iD_element;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
