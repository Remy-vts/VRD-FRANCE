package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Dirigeant;



public interface DirigeantDao {
	
	public List<Dirigeant>  listDirigeant();

	public Dirigeant getDirigeant(Integer ID_individu);
	
	public void updateDirigeant(Integer ID_individu, String nom, String fonction, String presentation, String photo);
	
	public String getPhotoPath(Integer ID_individu);

}
