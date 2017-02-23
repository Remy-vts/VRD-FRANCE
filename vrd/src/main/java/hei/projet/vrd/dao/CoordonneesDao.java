package hei.projet.vrd.dao;

import hei.projet.vrd.entities.Coordonnees;

public interface CoordonneesDao {

	public Coordonnees getCoordonnees(Integer id);
	
	public void updateCoordonnees(String mail, String telephone);

}
