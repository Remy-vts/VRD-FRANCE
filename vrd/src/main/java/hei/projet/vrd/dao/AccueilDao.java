package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Accueil;

public interface AccueilDao {
	
	public List<Accueil>  listPhoto();
	
	public Accueil getPhoto(Integer id);
	
	public void updatePhoto(Integer id, String photo);
	
	


}
