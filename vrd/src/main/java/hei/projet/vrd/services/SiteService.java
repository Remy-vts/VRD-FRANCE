package hei.projet.vrd.services;
//
import java.util.List;

import hei.projet.vrd.dao.impl.ChantierDaoImpl;
import hei.projet.vrd.dao.impl.CoordonneesDaoImpl;
import hei.projet.vrd.dao.impl.EngagementsDaoImpl;
import hei.projet.vrd.dao.impl.MetierDaoImpl;
import hei.projet.vrd.dao.impl.OffreDaoImpl;
import hei.projet.vrd.entities.Chantier;
import hei.projet.vrd.entities.Coordonnees;
import hei.projet.vrd.entities.Engagements;
import hei.projet.vrd.entities.Metier;
import hei.projet.vrd.entities.Offre;

public class SiteService {

	public static class SiteHolder{
		private static SiteService instance = new SiteService();
	}
	
	public static SiteService getInstance(){
		return SiteHolder.instance;
	}
	
	private SiteService() {
	}

	private ChantierDaoImpl chantierDao = new ChantierDaoImpl();
	private EngagementsDaoImpl engagementsDao = new EngagementsDaoImpl();
	private MetierDaoImpl metierDao = new MetierDaoImpl();
	private OffreDaoImpl offreDao = new OffreDaoImpl();
	private CoordonneesDaoImpl coordonneesDao = new CoordonneesDaoImpl();
	
	public List<Engagements> listEngagements(){
		return engagementsDao.listEngagements();
	}
	
	public Engagements getEngagements(Integer id){
		return engagementsDao.getEngagements(id);
	}
	
	public void updateEngagements(Integer idengagements, String description){
		engagementsDao.updateEngagements(idengagements, description);
	}
	
	public List<Chantier>  listChantier(){
		return chantierDao.listChantier();
	}

	public Chantier getChantier(Integer id){
		return chantierDao.getChantier(id);
	}
	
	public void updateChantier(Integer id, String ville, int code_postal, String date_chantier, String maitre_ouvrage, String client, String titre, String description, String url_photo){
		chantierDao.updateChantier(id, ville, code_postal, date_chantier, maitre_ouvrage, client, titre, description, url_photo);
	}
	
	public Chantier addChantier(Chantier chantier, String photoPath){
		return chantierDao.addChantier(chantier, photoPath);
	}

	public void deleteChantier(Integer id){
		chantierDao.deleteChantier(id);
	}
	
	public List<Presse>  listPresse(){
		return presseDao.listPresse();
	}

	public Presse getPresse(Integer id){
		return presseDao.getPresse(id);
	}
	
	public void updatePresse(Integer ID_presse, String nom_media, String date_publication, String lien, String titre, String description){
		presseDao.updatePresse(ID_presse, nom_media, date_publication, lien, titre, description);
	}
	
	public Presse addPresse(Presse presse, String photoPath){
		return presseDao.addPresse(presse, photoPath);
	}

	public void deletePresse(Integer id){
		presseDao.deletePresse(id);
	}
	
	public List<Metier>  listMetier(){
		return metierDao.listMetier();
	}

	public Metier getMetier(Integer idMetier){
		return metierDao.getMetier(idMetier);
	}
	
	public void updateMetier(Integer idMetier, String titreMetier, String photo, String descriptif){
		metierDao.updateMetier(idMetier, titreMetier, photo, descriptif);
	}
	
	public List<Offre>  listOffre(){
		return offreDao.listOffre();
	}

	public Offre getOffre(Integer id){
		return offreDao.getOffre(id);
	}
	
	public void updateOffre(Integer idOffre, String referenceOffre, String dateOffre, String titreOffre, String missionOffre){
		offreDao.updateOffre(idOffre, referenceOffre, dateOffre, titreOffre, missionOffre);
	}
	
	public Offre addOffre(Offre offre){
		return offreDao.addOffre(offre);
	}
	
	public void deleteOffre(Integer id){
		offreDao.deleteOffre(id);
	}
	
	public Coordonnees getCoordonnees(Integer id){
		return coordonneesDao.getCoordonnees(id);
	}
	
	public void updateCoordonnees(Integer id, String mail, String telephone, String adresse, String ville, String codepostal){
		coordonneesDao.updateCoordonnees(id, mail, telephone, adresse, ville, codepostal);
	}
	
}
