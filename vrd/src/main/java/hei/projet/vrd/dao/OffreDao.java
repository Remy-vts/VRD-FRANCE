package hei.projet.vrd.dao;

import java.util.List;

import hei.projet.vrd.entities.Offre;


public interface OffreDao {

	public List<Offre>  listOffre();

	public Offre getOffre(Integer id);
	
	public void updateOffre(Integer idOffre, String referenceOffre, String dateOffre, String titreOffre, String missionOffre);
	
	public Offre addOffre(Offre offre);
	
	public void deleteOffre(Integer id);
	
}
