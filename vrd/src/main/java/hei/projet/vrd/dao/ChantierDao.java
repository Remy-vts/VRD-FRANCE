package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Chantier;


public interface ChantierDao {

	public List<Chantier>  listChantier();
	
	public List<Chantier>  listChantierAccueil();

	public Chantier getChantier(Integer id);
	
	public void updateChantier(Chantier ch);
	
	public Chantier addChantier(Chantier chantier, String photo);

	public void deleteChantier(Integer id);
	
}