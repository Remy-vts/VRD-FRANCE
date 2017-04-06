package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Chantier;


public interface ChantierDao {

	public List<Chantier>  listChantier();
	
	public List<Chantier>  listChantierAccueil();

	public Chantier getChantier(Integer id);
	
	public void updateChantier(Integer id, String titre, String ville, Integer code_postal, String maitre_ouvrage, String client, String description);
	
	public Chantier addChantier(Chantier chantier, String photo);
	
	public String getPhotoPath(Integer id);

	public void deleteChantier(Integer id);
	
}