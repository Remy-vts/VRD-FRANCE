package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Accueil;

public interface AccueilDao {
	
	public List<Accueil>  listPhoto();
	
	public Accueil getPhoto(Integer id);
	
	public void updatePhoto(Integer id, String photo1, String photo2, String photo3, String photo4, String photo5, String photo6, String photo7, String photo8);
	
	public Accueil addPhoto(Accueil accueil, String photo1, String photo2, String photo3, String photo4, String photo5, String photo6, String photo7, String photo8);


}
