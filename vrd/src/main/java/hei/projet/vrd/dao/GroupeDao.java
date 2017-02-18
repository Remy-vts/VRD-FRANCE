package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Groupe;



public interface GroupeDao {
	
	public List<Groupe>  listGroupe();

	public Groupe getGroupe(Integer idGroupe);
	
	public void updateGroupe(Integer idGroupe, String description);
	
	public String getPhotoPath(Integer idGroupe);

}
