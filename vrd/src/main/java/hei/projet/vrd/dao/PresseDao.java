package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Presse;


public interface PresseDao {

	public List<Presse>  listPresse();

	public Presse getPresse(Integer id);
	
	public void updatePresse(Integer ID_presse, String nom_media, String date_publication, String lien, String titre, String description);
	
	public Presse addPresse(Presse presse, String photoPath);
	
	public String getPhotoPath(Integer id);

	public void deletePresse(Integer id);
	
}