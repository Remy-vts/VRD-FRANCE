package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Dirigeant;



public interface DirigeantDao {
	
	public List<Dirigeant>  listDirigeant();

	public Dirigeant getDirigeant(Integer ID_individu);
	
	public void updateDirigeant(Dirigeant dir);
		
	public Dirigeant addDirigeant(String nom, String fonction, String presentation);
	
	public void deleteDirigeant(Integer id);

}
