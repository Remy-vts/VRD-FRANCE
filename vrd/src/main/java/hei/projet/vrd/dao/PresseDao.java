package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Presse;


public interface PresseDao {

	public List<Presse>  listPresse();

	public Presse getPresse(Integer id);
	
	public void updatePresse(Presse pr);
	
	public Presse addPresse(Presse presse, String photo);
	
	public void deletePresse(Integer id);
	
}