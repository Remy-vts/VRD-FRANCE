package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Chantier;


public interface ChantierDao {

	public List<Chantier>  listChantier();

	public Chantier getChantier(Integer id);
	
	public void updateChantier(Integer id, String ville, int code_postal, String date_chantier, String maitre_ouvrage, String client, String titre, String description, String url_photo);
	
	public Chantier addChantier(Chantier chantier, String photoPath);
	
	public String getPhotoPath(Integer id);

	public void deleteChantier(Integer id);
	
}