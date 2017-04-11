package hei.projet.vrd.dao;
//
import java.util.List;

import hei.projet.vrd.entities.Metier;

public interface MetierDao {

	public List<Metier>  listMetier();

	public Metier getMetier(Integer idMetier);
	
	public void updateMetier(Integer idMetier, String Descriptif, String photo);
	
	public String getPhotoPath(Integer idMetier);
	
	public Metier addMetier(Metier metier);
	
	public Metier deleteMetier(Integer id);
	
}
