package hei.projet.vrd.dao;
//
import java.util.List;

import hei.projet.vrd.entities.Metier;

public interface MetierDao {

	public List<Metier>  listMetier();

	public Metier getMetier(Integer idMetier);
	
	public void updateMetier(Integer idMetier, String titreMetier, String photo, String Descriptif);
	
	public String getPhotoPath(Integer idMetier);
	
}
